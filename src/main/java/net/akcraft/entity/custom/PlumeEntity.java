package net.akcraft.entity.custom;

import net.akcraft.entity.ai.PlumeAttackGoal;
import net.akcraft.item.ModItems;
import net.akcraft.sound.ModSounds;
import net.minecraft.entity.*;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class PlumeEntity extends TameableEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(PlumeEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    private int abilityCooldown = 240;

    private void setupAnimationStates() {
        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 5;
            attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }
        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    public PlumeEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }
    public static DefaultAttributeContainer.Builder createPlumeAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 24.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.45)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 0.8f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32);
    }

    private void skillCooldown() {
        if (this.abilityCooldown <= 0) {
            this.abilityCooldown = 2400;
            this.applyPassiveEffect();
        } else {
            --this.abilityCooldown;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.getWorld().isClient()) {
            this.skillCooldown();
        } else {
            this.setupAnimationStates();
        }
    }

    private void applyPassiveEffect() {
        this.playSound(ModSounds.PLUME_SKILL, this.getSoundVolume(), 1.0f);
        this.playSound(ModSounds.ATK_BOOST, this.getSoundVolume(), 1.0f);
        addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1200, 0));
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new SitGoal(this));
        this.goalSelector.add(3, new FollowOwnerGoal(this, 1.0, 8.0F, 1.0F));
        this.goalSelector.add(4, new PlumeAttackGoal(this, 1.0, true));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 0.5));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(3, new AttackWithOwnerGoal(this));
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (this.isTamed()) {
            if (!this.getWorld().isClient) {
                if ((itemStack.isOf(ModItems.ORIGINITE_PRIME)) && this.getHealth() < this.getMaxHealth()) {
                    itemStack.decrementUnlessCreative(1, player);
                    this.heal(20.0F);
                    this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_VILLAGER_HAPPY_PARTICLES);
                    return ActionResult.SUCCESS;
                }

                ActionResult actionResult = super.interactMob(player, hand);
                if (!actionResult.isAccepted() && this.isOwner(player) && hand == Hand.MAIN_HAND) {
                    this.setSitting(!this.isSitting());
                    this.jumping = false;
                    this.navigation.stop();
                    this.setTarget(null);
                    return ActionResult.SUCCESS;
                }
            }
        }
        else if ((itemStack.isOf(ModItems.ORIGINITE_PRIME))) {
            if (!this.getWorld().isClient) {
                itemStack.decrementUnlessCreative(1, player);
                this.setOwner(player);
                this.updateAttributesForTamed();
                this.navigation.stop();
                this.setTarget(null);
                this.setSitting(true);
                this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_POSITIVE_PLAYER_REACTION_PARTICLES);
            }
            return ActionResult.SUCCESS;
        }
        return super.interactMob(player, hand);
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            if (!this.getWorld().isClient) {
                this.setSitting(false);
            }
        }
        if (source.getAttacker() instanceof PlayerEntity) {
            return false;
        }
            return super.damage(source, amount);
    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(ATTACKING, false);
    }

    @Override
    public boolean isInSittingPose() {
        return this.isSitting();
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return ModSounds.PLUME_IDLE;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return ModSounds.OP_DEAD;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this,
                "controller", 1, this::predicate));
    }

    private PlayState predicate(software.bernie.geckolib.animation.AnimationState<GeoAnimatable> geoAnimatableAnimationState) {
        if (this.isAttacking()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then
                    ("plume_attack", Animation.LoopType.PLAY_ONCE));
            return PlayState.CONTINUE;
        }

        if(geoAnimatableAnimationState.isMoving()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then
                    ("plume_walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then
                ("plume_idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
