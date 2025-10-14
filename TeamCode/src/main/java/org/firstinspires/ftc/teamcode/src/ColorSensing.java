package org.firstinspires.ftc.teamcode.src;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import android.graphics.Color;

@TeleOp
public class ColorSensing extends LinearOpMode {
    // Define a variable for our color sensor
    private NormalizedColorSensor test_color;


    @Override
    public void runOpMode() {
        // Get the color sensor from hardwareMap
        test_color = hardwareMap.get(NormalizedColorSensor.class, "test_color");

        // Wait for the Play button to be pressed
        waitForStart();

        // While the Op Mode is running, update the telemetry values.
        while (opModeIsActive()) {
            telemetry.addData("Light Detected", ((OpticalDistanceSensor) test_color).getLightDetected());
            NormalizedRGBA colors = test_color.getNormalizedColors();
            
            // Determining the amount of red, green and blue
            // Get normalized color values

            float r = colors.red;
            float g = colors.green;
            float b = colors.blue;

            // Convert RGB to HSV
            float[] hsv = new float[3];
            Color.RGBToHSV((int)(r * 255), (int)(g * 255), (int)(b * 255), hsv);
            float hue = hsv[0];

            String detectedColor;
            if (hue >= 120 && hue <= 180) {
                detectedColor = "Green";
            } else if (hue >= 210 && hue <= 250) {
                detectedColor = "Purple";
            } else {
                detectedColor = "Unknown";
            }

// Telemetry output
            telemetry.addData("Red", "%.3f", colors.red);
            telemetry.addData("Green", "%.3f", colors.green);
            telemetry.addData("Blue", "%.3f", colors.blue);
            telemetry.addData( "Hue", "%.1f", hue);
            telemetry.addData("Detected Color", detectedColor);
            telemetry.update();

            sleep(20);



        }
    }
}