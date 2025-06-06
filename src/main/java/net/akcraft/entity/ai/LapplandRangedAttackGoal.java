package net.akcraft.entity.ai;

import net.akcraft.entity.custom.LapplandEntity;
import net.akcraft.entity.projectile.LapplandProjectileEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.Vec3d;

import java.util.EnumSet;

public class LapplandRangedAttackGoal extends Goal {
    private final LapplandEntity entity;
    private LivingEntity target;

    private int cooldownTicks = 0;
    private final int attackInterval = 20; // 1 segundo aprox
    private final float attackRange = 6.0f;

    public LapplandRangedAttackGoal(LapplandEntity entity) {
        this.entity = entity;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        LivingEntity potentialTarget = entity.getTarget();
        return potentialTarget != null && potentialTarget.isAlive() && entity.squaredDistanceTo(potentialTarget) <= attackRange * attackRange;
    }

    @Override
    public boolean shouldContinue() {
        return canStart();
    }

    @Override
    public void start() {
        target = entity.getTarget();
        cooldownTicks = 0;
    }

    @Override
    public void stop() {
        entity.setRangedAttacking(false);
        entity.rangedAttackAnimationTimeout = 0;
        target = null;
    }

    @Override
    public void tick() {
        if (target == null || !target.isAlive()) {
            stop();
            return;
        }

        entity.getLookControl().lookAt(target);

        double distanceSq = entity.squaredDistanceTo(target);
        if (distanceSq > attackRange * attackRange) {
            stop();
            return;
        }

        if (cooldownTicks <= 0) {
            // Iniciar animación si existe
            entity.setRangedAttacking(true);
            entity.rangedAttackAnimationTimeout = 10;

            // Lanzar proyectil
            launchProjectile(target);
            cooldownTicks = attackInterval;
        } else {
            cooldownTicks--;
            if (cooldownTicks == attackInterval - 2) {
                // Apagar la animación justo antes del próximo ataque
                entity.setRangedAttacking(false);
            }
        }
    }

    private void launchProjectile(LivingEntity target) {
        LapplandProjectileEntity projectile = new LapplandProjectileEntity(entity.getWorld(), entity);
        projectile.setPosition(
                entity.getX(),
                entity.getY() + 1.1,
                entity.getZ()
        );

        Vec3d direction = target.getPos().subtract(entity.getPos()).normalize();
        projectile.setVelocity(direction.x, direction.y + 0.1, direction.z, 1.5F, 0.4F);

        entity.getWorld().spawnEntity(projectile);
        entity.incrementSkillCharge();
    }
}