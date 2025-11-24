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

    // Tuned values
    public static double inPerTick = 0.023856904;
    public static double lateralInPerTick = .02520816;
    public static double trackWidthTicks = 8060.506364813945;
    public static final double kA = .000078;
    public static final double kV = 0.0003510462253567012;
    public static final double kS = 1.1082062641862467;
    public static final double maxWheelVel = 50;
    public static final double minProfileAccel = -30;
    public static final double maxProfileAccel = 50;

    // Shooter Constants
    public static String shooterMotor(){
        return "shooterMotor";
    }

    // Starting Power
    public static double shooterPower = .3;

    // Auto calibration
    public static double inPerTick3231 = 0.02393;
    public static double lateralInPerTick3231 = 0.02519;

    public static double ks3231 = 1.0967513649697667;

    public static double kv3231 = 0.0042730455553834186;

    public static double ka3231 = .00067;

    public static double trackWidth3231 = 1226.5643209432749;

    public static double axialGain3231 = 3;

    public static double axialVelGain3231 = 1.9;

    public static double headingGain3231 = 4.5;

    public static double headingVelGain3231 = .5;

    public static double lateralGain3231 = 1.3;

    public static double lateralVelGain3231 = 0;

    // Color Sensor
    public static String getColorSensorName () { return "Test"; }



}
