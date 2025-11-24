package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import android.graphics.Color;

public class ColorSensing {

    private NormalizedColorSensor colorSensor;
    private Telemetry telemetry;

    public ColorSensing(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        this.colorSensor = hardwareMap.get(NormalizedColorSensor.class, Constants.getColorSensorName());
        colorSensor.setGain(2); // optional gain tuning
    }

    public void updateTelemetry() {
        NormalizedRGBA colors = colorSensor.getNormalizedColors();

        // Convert RGB to HSV
        float[] hsv = new float[3];
        Color.RGBToHSV((int) (colors.red * 255), (int) (colors.green * 255), (int) (colors.blue * 255), hsv);
        float hue = hsv[0];

        // Determine detected color
        String detectedColor;
        if (hue >= 120 && hue <= 180) {
            detectedColor = "Green";
        } else if (hue >= 210 && hue <= 250) {
            detectedColor = "Purple";
        } else {
            detectedColor = "Unknown";
        }

        // Send data to telemetry
        telemetry.addData("Red", "%.3f", colors.red);
        telemetry.addData("Green", "%.3f", colors.green);
        telemetry.addData("Blue", "%.3f", colors.blue);
        telemetry.addData("Hue", "%.1f", hue);
        telemetry.addData("Detected Color", detectedColor);
        telemetry.update();
    }
}