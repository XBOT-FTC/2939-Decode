package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name = "2025TeleOp2939", group="Linear OpMode")
public class MecanumTeleOp2939 extends LinearOpMode {

    private enum ButtonState {
        None,
        A,
        X,
        Y,
        B
    }

    ButtonState buttonState = ButtonState.None;

    @Override
    public void runOpMode() throws InterruptedException {
        DriveTrain driveTrain = new DriveTrain(hardwareMap, telemetry);
        Shooter shooter = new Shooter(hardwareMap, telemetry);
        // ColorSensing colorSensor = new ColorSensing(hardwareMap, telemetry);
        Intake intake = new Intake(hardwareMap);
        Blocker blocker = new Blocker(hardwareMap, telemetry);
        waitForStart();

        if (isStopRequested()) return;

        Gamepad driverController = new Gamepad();
        Gamepad operatorController = new Gamepad();


        while (opModeIsActive()) {

            // colorSensor.updateTelemetry();
            blocker.powerServo(operatorController, telemetry);

            //The Y button is for shooting
            //Use the Dpad to change the speed of the motors
            boolean wasYPressed = gamepad2.yWasPressed();
            boolean wasAPressed = gamepad2.aWasPressed();
            boolean wasBPressed = gamepad2.bWasPressed();
            boolean wasXPressed = gamepad2.xWasPressed();

            driverController.copy(gamepad1);
            operatorController.copy(gamepad2);

            // Drivetrain code
            driveTrain.drive(driverController, telemetry);

            //Shooting Code
            if (wasAPressed && buttonState != ButtonState.A) {
                buttonState = ButtonState.A;
            } else if (wasBPressed && buttonState != ButtonState.B) {
                buttonState = ButtonState.B;
            } else if (wasYPressed && buttonState != ButtonState.Y) {
                buttonState = ButtonState.Y;
            } else if (wasXPressed && buttonState != ButtonState.X) {
                buttonState = ButtonState.X;
            } else {
                buttonState = ButtonState.None;
            }

            switch (buttonState) {
                case A:
                    shooter.shooter50();
                case B:
                    shooter.shooter70();
                case Y:
                    shooter.shooter100();
                case X:
                    shooter.setZero();
                case None:
                    shooter.setZero();
            }

            //Telemetry for movement motors and shooters
            telemetry.addData("motors", "frontLeft(%.2f) frontRight(%.2f) backLeft(%.2f) backRight(%.2f)", driveTrain.getFrontLeftPower(), driveTrain.getFrontRightPower(), driveTrain.getBackLeftPower(), driveTrain.getBackRightPower());
            telemetry.addData("shooter", "shooter(%.2f)", shooter.getShooterPower());
            telemetry.addData("shooter encoder", "shooter encoder (%.2f), ", shooter.shooterEncoderPosition());
            telemetry.addData("intake","intake (%.2f)", intake.getIntakePower());
            telemetry.addData("Blocker left", "blocker left position (%.2f), ", blocker.getLeftServoPosition());
            telemetry.addData("Blocker right", "block right position (%.2f), ", blocker.getRightServoPosition());
            telemetry.update();
        }
    }
}
