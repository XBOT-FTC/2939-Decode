package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Blocker2 {
    Servo blockerServo = null;
    boolean leftBumperPressed;
    boolean rightBumperPressed;
    double leftBlockerClosePosition = 0.9;
    double leftBlockerOpenPosition = 0.6;
    double rightBlockerClosePosition = 0.35;
    double rightBlockerOpenPosition = 1;
    String direction;

    double leftBlockerPose = 0.6;

    // Fix twitches
    boolean previousLeftState = false;
    boolean previousRightState = false;
    boolean isOpen = false;

    double rightBlockerPose = 0.6;


    public Blocker2(HardwareMap hardwareMap, Telemetry telemetry, String direction) {
        blockerServo = hardwareMap.get(Servo.class,direction);
        this.leftBumperPressed = false;
        this.rightBumperPressed = false;
        this.direction = direction;
    }

    public void powerServo(Gamepad gamepad, Telemetry telemetry) {
        controlServo(gamepad, telemetry);
    }

    public void controlServo(Gamepad gamepad, Telemetry telemetry) {
        if (this.direction.equals("left")) {
            if (gamepad.left_stick_x > 0) {
                leftBlockerPose += .01;

//                if (isOpen) {
//                    open();
//                } else {
//                    close();
//                }
            } else if (gamepad.left_stick_x < 0) {
                leftBlockerPose -= .01;

            } blockerServo.setPosition(leftBlockerPose);
            // previousLeftState = gamepad.left_bumper;
        }

        if (this.direction.equals("right")) {
            if (gamepad.right_stick_x > 0) {
                rightBlockerPose +=.001;
//                isOpen = !isOpen;
//
//                if (isOpen) {
//                    open();
//                } else {
//                    close();
//                }
            } else if (gamepad.right_stick_x < 0) {
                rightBlockerPose -=.001;

            }
            blockerServo.setPosition(rightBlockerPose);

            // previousRightState = gamepad.right_bumper;
        }

    }

    public double getServoPosition() {
        return blockerServo.getPosition();
    }

    public void open() {
        if (direction.equals("left")){
            blockerServo.setPosition(leftBlockerOpenPosition);
        } else {
            blockerServo.setPosition(rightBlockerOpenPosition);
        }

    }

    public void close() {
        if (direction.equals("left")){
            blockerServo.setPosition(leftBlockerClosePosition);
        } else {
            blockerServo.setPosition(rightBlockerClosePosition);
        }
    }
}
