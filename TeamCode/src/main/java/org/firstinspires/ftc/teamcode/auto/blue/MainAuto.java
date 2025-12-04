package org.firstinspires.ftc.teamcode.auto.blue;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous(name = "BlueMainAuto", group = "Autonomous")
public class MainAuto extends LinearOpMode {
    ;
    @Override
    public void runOpMode() {
        double minYValue = -31;
        double maxYValue = -54;

        double startPoseX = -56;
        double startPoseY = -45;

        Pose2d startingPose = new Pose2d(startPoseX, startPoseY, Math.toRadians(-127));

        MecanumDrive drive = new MecanumDrive(hardwareMap, startingPose);

        Action trajectoryAction = drive.actionBuilder(startingPose)
                .waitSeconds(6) //Replace this with shoot code

                .strafeToSplineHeading(new Vector2d(-20,minYValue), Math.toRadians(-90))
                //Start intake
                .splineToConstantHeading(new Vector2d(-11,maxYValue),Math.toRadians(-90))

                .strafeToSplineHeading(new Vector2d(startPoseX,startPoseY),Math.toRadians(-127))
                //stop intake
                .waitSeconds(6) //Replace this with the shoot code

                .strafeToSplineHeading(new Vector2d(3,minYValue), Math.toRadians(-90))
                //Start intake
                .splineToConstantHeading(new Vector2d(12,maxYValue),Math.toRadians(-90))

                .strafeToSplineHeading(new Vector2d(startPoseX,startPoseY),Math.toRadians(-127))
                //stop intake
                .waitSeconds(6)
                .build(); //Replace this shooter code
        
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
}
