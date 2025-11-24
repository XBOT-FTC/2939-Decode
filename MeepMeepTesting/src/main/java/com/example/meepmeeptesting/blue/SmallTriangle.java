package com.example.meepmeeptesting.blue;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class SmallTriangle {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        Pose2d startingPose = new Pose2d(58, 0, Math.toRadians(-150));


        RoadRunnerBotEntity robot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(90), Math.toRadians(90), 15)
                .setStartPose(startingPose)
                .build();

        robot.runAction(
                robot.getDrive()
                        .actionBuilder(startingPose)
                        .waitSeconds(6)
                        .strafeToSplineHeading(new Vector2d(43,-29),Math.toRadians(-90))
                        .splineToConstantHeading(new Vector2d(36,-56),Math.toRadians(-90))
                        .waitSeconds(1)
                        .strafeToSplineHeading(new Vector2d(58.2,-25),Math.toRadians(-150))
                        .waitSeconds(1)
                        .strafeToSplineHeading(new Vector2d(16,-30), Math.toRadians(-90))
                        .splineToConstantHeading(new Vector2d(9,-56),Math.toRadians(-150))
                        .waitSeconds(1)
                        .strafeToSplineHeading(new Vector2d(-11,-21),Math.toRadians(-130))
                        .waitSeconds(6)
                        .strafeToSplineHeading(new Vector2d(-11,-56), Math.toRadians(-90))
                        .waitSeconds(1)
                        .strafeToSplineHeading(new Vector2d(-34,-38),Math.toRadians(-140))
                        .build()
        );


        meepMeep
                .setBackground(MeepMeep.Background.FIELD_DECODE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(robot)
                .start();
    }
}
