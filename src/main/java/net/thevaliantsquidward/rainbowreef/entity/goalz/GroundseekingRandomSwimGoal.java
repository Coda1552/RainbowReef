package net.thevaliantsquidward.rainbowreef.entity.goalz;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class GroundseekingRandomSwimGoal extends RandomStrollGoal {

    PathfinderMob fims;
    Vec3 wantedPos;

    int radius;
    int height;
    int prox;

    public GroundseekingRandomSwimGoal(PathfinderMob fi, double spdmultiplier, int interval, int radius, int height, int proximity) {
        super(fi, spdmultiplier, interval);
        this.fims = fi;
        this.radius = radius;
        this.height = height;
        this.prox = proximity;
        //radius = search width
        //height = search height
        //prox = how close the entity gets before cancelling the goal
    }

    @Override
    public boolean canUse() {
        boolean canUse =super.canUse() && fims.isInWater();
        return canUse;
    }

    @Override
    public boolean canContinueToUse() {
        wantedPos = new Vec3(this.wantedX, this.wantedY, this.wantedZ);

        return super.canContinueToUse() && fims.isInWater() && !(this.wantedPos.distanceTo(this.fims.position()) <= this.fims.getBbWidth() * prox);
        //second part cancels the goal if the animal gets close enough to the target but doesn't touch it
        //the distance is a multiplier of the animal's hitbox width, so if prox = 1: the animal will stop one body width ahead of its destination, prox = 2: two body width, etc
    }

    public void tick() {
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Nullable
    protected Vec3 getPosition() {
        Vec3 goalpos = GoalUtils.getRandomSwimmablePosWithSeabed(this.mob, radius, height);
        System.out.println(goalpos);

        return goalpos;
    }
}