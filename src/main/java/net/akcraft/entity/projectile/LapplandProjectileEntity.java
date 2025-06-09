package net.akcraft.entity.projectile;

import net.akcraft.entity.ModEntities;
import net.akcraft.item.ModItems;
import net.akcraft.sound.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class LapplandProjectileEntity extends ThrownItemEntity {
    public LapplandProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public LapplandProjectileEntity(World world, LivingEntity owner) {
        super(ModEntities.LAPPLAND_PROJECTILE, owner, world);
    }

    public LapplandProjectileEntity(World world, double x, double y, double z) {
        super(ModEntities.LAPPLAND_PROJECTILE, x, y, z, world);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);

        Entity target = entityHitResult.getEntity();
        Entity owner = this.getOwner();

        if (target instanceof PlayerEntity || target instanceof TameableEntity) return;

        target.damage(this.getWorld().getDamageSources().thrown(this, owner), 3.0f);

        if (target instanceof LivingEntity livingTarget) {
            livingTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 60, 0));
        }

        this.getWorld().playSound(
                null,
                this.getX(), this.getY(), this.getZ(),
                ModSounds.LP_HIT,
                SoundCategory.NEUTRAL,
                0.5f,
                1.0f
        );
        this.discard();
    }


    @Override
    protected Item getDefaultItem() {
        return ModItems.LAPPLAND_P;
    }
}
