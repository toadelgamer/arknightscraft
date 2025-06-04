package net.akcraft.entity.ai;

import net.akcraft.entity.custom.LapplandEntity;
import net.akcraft.entity.projectile.LapplandProjectileEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;

public class LapplandAttackGoal extends MeleeAttackGoal {
    private final LapplandEntity entity;
    private int attackDelay = 0;
    private int ticksUntilNextAttack = 0;
    private boolean shouldCountTillNextAttack = false;

    // Rango para decidir el tipo de ataque
    private static final float MELEE_RANGE = 2f;
    private static final float RANGED_RANGE = 6f;
    private static final int RANGED_COOLDOWN_TICKS = 16;

    public LapplandAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        this.entity = (LapplandEntity) mob;
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 0;
        ticksUntilNextAttack = 16;
    }

    @Override
    protected void attack(LivingEntity target) {
        float distance = this.entity.distanceTo(target);
        shouldCountTillNextAttack = true;

        if (distance <= MELEE_RANGE) {
            if (isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }
            if (isTimeToAttack()) {
                this.mob.getLookControl().lookAt(target.getX(), target.getY(), target.getZ());
                performMeleeAttack(target);
            }
        } else if (distance <= RANGED_RANGE) {
            if (ticksUntilNextAttack <= 8) {
                this.mob.getLookControl().lookAt(target.getX(), target.getY(), target.getZ());
                performRangedAttack(target);
                ticksUntilNextAttack = RANGED_COOLDOWN_TICKS;
            }
        } else {
            resetAttackCooldown();
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.getTickCount(attackDelay);
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 8;
    }

    protected void performMeleeAttack(LivingEntity target) {
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(target);
    }

    protected void performRangedAttack(LivingEntity target) {
        LapplandProjectileEntity projectile = new LapplandProjectileEntity(entity.getWorld(), entity);
        projectile.setPosition(
                entity.getX(),
                entity.getY() + 1.1,
                entity.getZ()
        );

        Vec3d direction = target.getPos().subtract(entity.getPos()).normalize();
        projectile.setVelocity(direction.x, direction.y + 0.1, direction.z, 1.5F, 0.4F);
        entity.getWorld().spawnEntity(projectile);
    }

    @Override
    public void tick() {
        super.tick();
        if (shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}
