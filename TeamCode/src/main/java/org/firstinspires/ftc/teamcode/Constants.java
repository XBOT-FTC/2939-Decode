package org.firstinspires.ftc.teamcode;

public class Constants {

    //Motor Constants
    //Port 3
    public static String leftFrontDriveMotor(){
       return "frontLeftMotor";
    }
    //Port 0
    public static String rightFrontDriveMotor(){
        return "frontRightMotor";
    }
    //Port 2
    public static String leftBackDriveMotor(){
        return "backLeftMotor";
    }
    //Port 1
    public static String rightBackDriveMotor(){
        return "backRightMotor";
    }

    // Shooter Constants
    public static String shooterMotor(){
        return "shooterMotor";
    }

    // Starting Power
    public static double shooterPower = .3;

    // Color Sensor
    public static String getColorSensorName () { return "Test"; }
}
