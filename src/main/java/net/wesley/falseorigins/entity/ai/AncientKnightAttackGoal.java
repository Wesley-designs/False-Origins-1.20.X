package net.wesley.falseorigins.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.wesley.falseorigins.entity.custom.AncientKnightEntity;
import net.minecraft.util.Hand;
import net.minecraft.entity.mob.PathAwareEntity;

public class AncientKnightAttackGoal extends MeleeAttackGoal {
    private final AncientKnightEntity entity;
    private int atkDelay = 20;
    private int tickTillNextAtk = 20;
    private boolean shouldCountTillNextAtk = false;

    public AncientKnightAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((AncientKnightEntity) mob);
    }

    @Override
    public void start() {
        super.start();
        atkDelay = 20;
        tickTillNextAtk = 20;
    }

    protected void attack(LivingEntity pEnemy) {
        if (isEnemyWithinAttackDistance(pEnemy)) {
            shouldCountTillNextAtk = true;

            if(isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if(isTimeToAttack()) {
                this.mob.getLookControl().lookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAtk = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy) {
        return this.entity.distanceTo(pEnemy) <= 2f; // TODO
    }

    protected void resetAttackCooldown() {
        this.tickTillNextAtk = this.getTickCount(atkDelay * 2);
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.tickTillNextAtk <= atkDelay;
    }

    protected boolean isTimeToAttack() {
        return this.tickTillNextAtk <= 0;
    }

    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(pEnemy);
    }

    @Override
    public void tick() {
        super.tick();
        if (shouldCountTillNextAtk) {
            this.tickTillNextAtk = Math.max(this.tickTillNextAtk - 1, 0);
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}
