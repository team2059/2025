// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.team2059.Wonko;

import edu.wpi.first.math.Matrix;
import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.numbers.N1;
import edu.wpi.first.math.numbers.N3;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosly.
 */
public final class Constants {
  
  public static class OperatorConstants {

    public static final boolean tuningMode = true;

    /* ===== */
    /* PORTS */
    /* ===== */

    public static final int logitechControllerPort = 0;
    public static final int buttonBoxPort = 1;

    /* ==== */
    /* AXES */
    /* ==== */

    public static final int JoystickTranslationAxis = 1;
    public static final int JoystickStrafeAxis = 0;
    public static final int JoystickRotationAxis = 2;
    public static final int JoystickSliderAxis = 3;

    /* ======= */
    /* BUTTONS */
    /* ======= */

    public static final int JoystickResetHeading = 5;
    public static final int JoystickRobotRelative = 3;
    public static final int JoystickIntakeCoral = 6;
    public static final int JoystickReleaseCoral = 4;
    public static final int JoystickIntakeAlgae = 0;
    public static final int JoystickReleaseAlgae = 0;
  }

  public static class ClimberConstants {
    public static final int motor1ID = 17;
    public static final int motor2ID = 18; 
  }

  public static class DrivetrainConstants {

    public static final double wheelBase = Units.inchesToMeters(25.125); // distance between front wheels (like train track)
    public static final double trackWidth = Units.inchesToMeters(21.25); // distance from center of wheels on side

    public static final double wheelDiameter = Units.inchesToMeters(4.0 / 1.0);

    // Kinematics gets each module relative to center. X is forward/backward and Y is left/right
    public static final SwerveDriveKinematics kinematics = new SwerveDriveKinematics(
      new Translation2d(wheelBase / 2.0, trackWidth / 2.0), // front right (+,+)
      new Translation2d(wheelBase / 2.0, -trackWidth / 2.0), // back right (+,-)
      new Translation2d(-wheelBase / 2.0, trackWidth / 2.0), // front left (-,+)
      new Translation2d(-wheelBase / 2.0, -trackWidth / 2.0) // back left (-,-)
    );

    /* =========== */
    /* GEAR RATIOS */
    /* =========== */

    public static final double driveGearRatio = (5.9 / 1.0); // 5.9:1
    public static final double rotationGearRatio = (18.75 / 1.0); // 18.75

    /* ================== */
    /* CONVERSION FACTORS */
    /* ================== */

    // Given Motor Rotations, convert to Meters traveled
    // (pi * d) / (Gear Ratio)
    // where d is wheel diameter, in meters
    public static final double driveEncoderPositionConversionFactor = 0.05409929044;
    // Given Motor RPM, convert to Meters/second
    public static final double driveEncoderVelocityConversionFactor = driveEncoderPositionConversionFactor / 60.0;
    // Given Motor Rotations, convert to Radians
    // (2 * pi) / (Gear Ratio)
    public static final double rotationEncoderPositionConversionFactor = 0.3351032164;
    // Given Motor RPM, convert to Radians/second
    public static final double rotationEncoderVelocityConversionFactor = rotationEncoderPositionConversionFactor / 60.0;

    /* ============== */
    /* SWERVE MODULES */
    /* ============== */

    /*
     * CAN IDs: found and set via REV hardware client
     * CANcoder Offsets: found in Phoenix Tuner X as "Absolute position"
     *  after manually straightening wheel (converted to radians here)
     */

    // front left
    public static final int frontLeftDriveMotorId = 1;
    public static final int frontLeftRotationMotorId = 2;
    public static final int frontLeftCanCoderId = 10;
    public static final double frontLeftOffsetRad = 0.443359 * 2 * Math.PI;
    // front right
    public static final int frontRightDriveMotorId = 3;
    public static final int frontRightRotationMotorId = 4;
    public static final int frontRightCanCoderId = 20;
    public static final double frontRightOffsetRad = 0.675537 * 2 * Math.PI;
    // back left
    public static final int backLeftDriveMotorId = 5;
    public static final int backLeftRotationMotorId = 6;
    public static final int backLeftCanCoderId = 30;
    public static final double backLeftOffsetRad = 0.051758 * 2 * Math.PI;
    // back right
    public static final int backRightDriveMotorId = 7;
    public static final int backRightRotationMotorId = 8;
    public static final int backRightCanCoderId = 40;
    public static final double backRightOffsetRad = 0 * 2 * Math.PI;

    /* ======== */
    /* MAXIMUMS */
    /* ======== */

    // Global maximums
    public static final double maxVelocity = 5; // meters/sec
    public static final double maxAcceleration = 10; // meters/sec^2
    public static final double maxAngularVelocity = 2 * Math.PI; // rad/sec
    public static final double maxAngularAcceleration = 4 * Math.PI; // rad/sec^2
    // Teleop max speeds
    public static final double kTeleDriveMaxSpeed = 7.5 / 4.0;
    public static final double kTeleDriveMaxAngularSpeed = 3;

    /* =============================== */
    /* SWERVE MODULE CONTROL CONSTANTS */
    /* =============================== */
    
    public static final double kPRotation = 0.25;
    // kS: voltage needed to overcome static friction
    // kV: voltage needed to run at constant velocity
    // kA: voltage needed to accelerate
    public static final SimpleMotorFeedforward driveFF = new SimpleMotorFeedforward(0.17821, 1.9047, 0.14686);
    public static final SimpleMotorFeedforward turnFF = new SimpleMotorFeedforward(0, 0, 0);

    /* FOR ROBOTCONFIG AUTO STUFF... */
    public static final double kMass = 30;
    public static final double kMomentOfIntertia = 3;
    
    // CoF taken from https://www.chiefdelphi.com/t/coefficient-of-friction/467778
    public static final double kWheelCoF = 1.542; // Coefficient of friction of wheels
    public static final int driveCurrentLimit = 40;
    public static final int turnCurrentLimit = 20;
  }

  public static class AutoConstants {

    public static final double kAutoTranslationP = 5.0;
    public static final double kAutoTranslationD = 0;

    public static final double kAutoRotationP = 5.0;
    public static final double kAutoRotationD = 0.0;
  }

  public static class VisionConstants {
    public static final String upperCameraName = "Bcam9782";
    public static final String lowerCameraName = "Acam9782";
    
    // example below: Cam mounted facing forward, half a meter forward of center, half a meter up from center.
    public static final Transform3d upperCameraToRobot = 
      new Transform3d(
        new Translation3d(0.5, 0.0, 0.5), 
        new Rotation3d(0,0,0)
      );
    
    public static final Transform3d lowerCameraToRobot = 
      new Transform3d(
        new Translation3d(0.5, 0.0, 0.5), 
        new Rotation3d(0,0,0)
      );

    public static final Matrix<N3, N1> stateStdDevs = VecBuilder.fill(0.1, 0.1, 10);
    public static final Matrix<N3, N1> measurementStdDevs = VecBuilder.fill(5, 5, 500);
  }

  public static class AlgaeCollectorConstants {
    public static final int motor1Id = 11;
    public static final int motor2Id = 12;
    public static final int tiltMotorId = 13;

    public static final int tiltEncoderDio = 5;
    public static final double tiltEncoderMin = 0.02;
    public static final double tiltEncoderMax = 0.98;

    public static final double stallDetectionAmps = 20.0;

    public static final double holdSpeed = 0.02;

    // TODO: Tune values
    public static final double kPAlgae = 0.0;
    public static final double kIAlgae = 0.0;
    public static final double kDAlgae = 0.0;

  }

  public static class CoralCollectorConstants {
    public static final int intakeMotorId = 14;
    public static final int tiltMotorId = 15;
    public static final int irSensorDio = 6;
    public static final int thruBoreDio = 7;
    public static final double tiltEncoderMin = 0.148; // UPPER MAX POSITION
    public static final double tiltEncoderMax = 0.717; // LOWER MAX POSITION

    // TODO: tune values
    public static final double kPCoral = 0.0;
    public static final double kICoral = 0.0;
    public static final double kDCoral = 0.0;
  }

  public static class ElevatorConstants {
    public static final int motorId = 16;

    public static final double positionConversionFactor = 0.0354650904; // 0.1016/(9xpi)
    public static final double velocityConversionFactor = positionConversionFactor / 60;

    public static final int[] limitSwitchDIO = {0, 1, 2, 3, 4};
    public static final double[] levels = {0.1, 0.5, 1, 1.5, 2};
  }
}
