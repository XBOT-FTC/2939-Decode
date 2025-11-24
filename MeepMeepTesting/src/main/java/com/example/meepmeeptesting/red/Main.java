package com.example.meepmeeptesting.red;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class Main {
    static double minYValue = 31;
    static double maxYValue = 54;

    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        double startPoseX = -56; //SmallTriangleAuto = 58
        double startPoseY = 45; //SmallTriangleAuto = 0

        Pose2d startingPose = new Pose2d(startPoseX, startPoseY, Math.toRadians(127));

        RoadRunnerBotEntity robot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(90), Math.toRadians(90), 15)
                .setStartPose(startingPose)
                .build();

        robot.runAction(
                robot.getDrive()
                        .actionBuilder(startingPose)
                        .waitSeconds(6) //Replace this with shoot code

                        .strafeToSplineHeading(new Vector2d(-20,minYValue), Math.toRadians(90))
                        //Start intake
                        .splineToConstantHeading(new Vector2d(-11,maxYValue),Math.toRadians(90))

                        .strafeToSplineHeading(new Vector2d(startPoseX,startPoseY),Math.toRadians(127))
                        //stop intake
                        .waitSeconds(6) //Replace this with the shoot code

                        .strafeToSplineHeading(new Vector2d(3,minYValue), Math.toRadians(90))
                        //Start intake
                        .splineToConstantHeading(new Vector2d(12,maxYValue),Math.toRadians(90))

                        .strafeToSplineHeading(new Vector2d(startPoseX,startPoseY),Math.toRadians(127))
                        //stop intake
                        .waitSeconds(6) //Replace this shooter code
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
