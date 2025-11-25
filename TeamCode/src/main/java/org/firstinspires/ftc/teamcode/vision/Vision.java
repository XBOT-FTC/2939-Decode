package org.firstinspires.ftc.teamcode.vision;

import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;


@TeleOp
public class Vision extends LinearOpMode {
    VisionPortal visionPortal;


    @Override
    public void runOpMode() throws InterruptedException {
        AprilTagProcessor tagProcessor = new AprilTagProcessor.Builder()
                .setDrawAxes(true)
                .setDrawCubeProjection(true)
                .setDrawTagID(true)
                .setDrawTagOutline(true)
                .build();

        VisionPortal.Builder VisionPortalBuilder;
        VisionPortalBuilder = new VisionPortal.Builder();

        VisionPortalBuilder.addProcessor(tagProcessor);
        VisionPortalBuilder.setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"));
        VisionPortalBuilder.setCameraResolution(new Size(1280, 720));
        VisionPortalBuilder.setStreamFormat(VisionPortal.StreamFormat.MJPEG);
        VisionPortalBuilder.enableLiveView(true);
        VisionPortalBuilder.setAutoStartStreamOnBuild(true);
        VisionPortalBuilder.setShowStatsOverlay(true);

        visionPortal = VisionPortalBuilder.build();

        waitForStart();


        while (!isStopRequested() && opModeIsActive()){
            if (tagProcessor.getDetections().size() > 0){
                AprilTagDetection tag = tagProcessor.getDetections().get(0);

                telemetry.addData("x", tag.ftcPose.x);
                telemetry.addData("y", tag.ftcPose.y);
                telemetry.addData("z", tag.ftcPose.z);
                telemetry.addData("elevation", tag.ftcPose.elevation);
                telemetry.addData("roll", tag.ftcPose.roll);
                telemetry.addData("range", tag.ftcPose.range);
                telemetry.addData("bearing", tag.ftcPose.bearing);
                telemetry.addData("yaw", tag.ftcPose.yaw);
                telemetry.addData("elevation", tag.ftcPose.elevation);
            }
            telemetry.update();
        }
    }






}