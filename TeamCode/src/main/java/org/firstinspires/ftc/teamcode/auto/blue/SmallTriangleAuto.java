package org.firstinspires.ftc.teamcode.auto.blue;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous(name = "BlueSmallTriangleAuto", group = "Autonomous")
public class SmallTriangleAuto extends LinearOpMode {

    @Override
    public void runOpMode(){
        Pose2d startingPose = new Pose2d(58, 0, Math.toRadians(-150));

        MecanumDrive drive = new MecanumDrive(hardwareMap, startingPose);

        Action trajectoryAction = drive.actionBuilder(startingPose)
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
                .build();

        // Initialization
        while (!isStopRequested() && !opModeIsActive()) {
            telemetry.addData("Position during Init", 1);
            telemetry.update();
        }

        if (isStopRequested()) return;

        waitForStart();

        Actions.runBlocking(
                new SequentialAction(
                        trajectoryAction
                )
//                        Example
//                        trajectoryActionChosen,
//                        lift.liftUp(),
//                        claw.openClaw(),
//                        lift.liftDown(),
//                        trajectoryActionCloseOut
        );


    }

}
