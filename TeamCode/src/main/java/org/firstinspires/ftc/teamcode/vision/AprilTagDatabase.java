package org.firstinspires.ftc.teamcode.vision;

import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Quaternion;
import org.firstinspires.ftc.vision.apriltag.AprilTagGameDatabase;
import org.firstinspires.ftc.vision.apriltag.AprilTagLibrary;

public class AprilTagDatabase {
    public static AprilTagLibrary getLibrary(){
        return new AprilTagLibrary.Builder()
                .addTag(
                        1,
                        "Name",
                        6,
                        new VectorF(5,10,15),
                        DistanceUnit.INCH,
                        Quaternion.identityQuaternion()
                        )
                .addTags(AprilTagGameDatabase.getDecodeTagLibrary())
                .build();

    }
}
