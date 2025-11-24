package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {

    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        int pause = 0;

        double redStartPoseX = 58; //SmallTriangleAuto = 58
        double redStartPoseY = 0; //SmallTriangleAuto = 0
        double redStartPoseZ = 0; // SmallTriangleAuto = 0

        double blueStartPoseX = -56;
        double blueStartPoseY = -45;
        double blueStartPoseZ = 0;

        double minYValue = 31;
        double maxYValue = 54;

        RoadRunnerBotEntity red = new DefaultBotBuilder(meepMeep)
            // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
            .setConstraints(60, 60, Math.toRadians(90), Math.toRadians(90), 15)
            .setStartPose(
                new Pose2d(redStartPoseX, redStartPoseY, Math.toRadians(127))
            )
            .build();

        RoadRunnerBotEntity blue = new DefaultBotBuilder(meepMeep)
            // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
            .setConstraints(60, 60, Math.toRadians(90), Math.toRadians(90), 15)
            .setStartPose(
                new Pose2d(blueStartPoseX, blueStartPoseY, Math.toRadians(127))
            )
            .build();

        red.runAction(
            red
                .getDrive()
                .actionBuilder(
                    new Pose2d(redStartPoseX, redStartPoseY, redStartPoseZ)
                )
                .turn(Math.toRadians(150))
                .waitSeconds(1)
                .splineTo(new Vector2d(35, 56), Math.toRadians(90))
                .waitSeconds(1)
                .strafeToLinearHeading(
                    new Vector2d(redStartPoseX, redStartPoseY),
                    Math.toRadians(150)
                )
                .waitSeconds(1)
                .splineTo(new Vector2d(12, 56), Math.toRadians(90))
                .waitSeconds(1)
                .strafeToSplineHeading(
                    new Vector2d(-11, 0),
                    Math.toRadians(135)
                )
                .waitSeconds(1)
                .turnTo(Math.toRadians(90))
                .strafeToSplineHeading(
                    new Vector2d(-11, 56),
                    Math.toRadians(90)
                )
                .waitSeconds(1)
                .strafeToSplineHeading(
                    new Vector2d(-34, 38),
                    Math.toRadians(140)
                )
                .build()
        );

        blue.runAction(
            blue
                .getDrive()
                .actionBuilder(
                    new Pose2d(blueStartPoseX, blueStartPoseY, blueStartPoseZ)
                )
                .splineTo(new Vector2d(35, -36), Math.toRadians(90))
                .waitSeconds(pause)
                .strafeToLinearHeading(new Vector2d(58, 0), Math.toRadians(150))
                .waitSeconds(pause)
                .splineTo(new Vector2d(12, -56), Math.toRadians(90))
                .waitSeconds(pause)
                .strafeToSplineHeading(
                    new Vector2d(-11, 0),
                    Math.toRadians(135)
                )
                .waitSeconds(pause)
                .setTangent(Math.toRadians(90))
                .waitSeconds(pause)
                .strafeToSplineHeading(
                    new Vector2d(-11, -56),
                    Math.toRadians(90)
                )
                .waitSeconds(pause)
                .strafeToSplineHeading(
                    new Vector2d(-34, -38),
                    Math.toRadians(140)
                )
                .build()
        );

        meepMeep
            .setBackground(MeepMeep.Background.FIELD_DECODE_JUICE_DARK)
            .setDarkMode(true)
            .setBackgroundAlpha(0.95f)
            .addEntity(red)
            .addEntity(blue)
            .start();
    }
}

/* Red SmallTriangleAuto right here:


                ..waitSeconds(1)
                .strafeToSplineHeading(new Vector2d(43,29),Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(36,56),Math.toRadians(90))
                .waitSeconds(1)
                .strafeToSplineHeading(new Vector2d(startPoseX,startPoseY),Math.toRadians(150))
                .waitSeconds(1)
                .strafeToSplineHeading(new Vector2d(16,30), Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(9,56),Math.toRadians(150))
                .waitSeconds(1)
                .strafeToSplineHeading(new Vector2d(-11,21),Math.toRadians(130))
                .waitSeconds(1)
                .turnTo(Math.toRadians(90))
                .strafeToSplineHeading(new Vector2d(-11,56), Math.toRadians(90))
                .waitSeconds(1)
                .strafeToSplineHeading(new Vector2d(-34,38),Math.toRadians(140))*/

//.splineToLinearHeading(new Pose2d(40, 40, Math.toRadians(90)), Math.toRadians(0))
//.splineTo(new Vector2d(-16,60),1)

/*.turn(Math.toRadians(90))
                .lineToY(30)
                .turn(Math.toRadians(90))
                .lineToX(0)
                .turn(Math.toRadians(90))
                .lineToY(0)
                .turn(Math.toRadians(90))


                Red main auto code here:
                                .turnTo(Math.toRadians(127))
                                .waitSeconds(6)
                                .strafeToSplineHeading(new Vector2d(-20,minYValue), Math.toRadians(90))
                                .splineToConstantHeading(new Vector2d(-11,maxYValue),Math.toRadians(90))
                                .strafeToSplineHeading(new Vector2d(startPoseX,startPoseY),Math.toRadians(127))
                                .waitSeconds(6)
                                .strafeToSplineHeading(new Vector2d(3,minYValue), Math.toRadians(90))
                                .splineToConstantHeading(new Vector2d(12,maxYValue),Math.toRadians(90))
                                .strafeToSplineHeading(new Vector2d(startPoseX,startPoseY),Math.toRadians(127))
                                .waitSeconds(6)

 /* The following gets the other 3 times but goes over 30 seconds

                                .strafeToSplineHeading(new Vector2d(26.5,minYValue), Math.toRadians(90))
                                .splineToConstantHeading(new Vector2d(35.5,maxYValue),Math.toRadians(90))
                                .strafeToSplineHeading(new Vector2d(startPoseX,startPoseY),Math.toRadians(127))*/
