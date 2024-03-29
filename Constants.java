// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.trajectory.constraint.CentripetalAccelerationConstraint;
import edu.wpi.first.math.util.Units;
import frc.robot.lib.SwerveModuleConstants;
import frc.robot.lib.math.Conversions;
import frc.robot.lib.math.geometry.Rotation2d;
import frc.robot.subsystems.Limelight.LimelightConstants;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    // robot loop time
	public static final double kLooperDt = 0.02;

    public static final double MAX_VOLTAGE = 12.0;
    public static final double DRIVETRAIN_WHEELBASE_METERS = 0.51427;
    public static final double DRIVETRAIN_TRACKWIDTH_METERS = 0.51427;

    public static final double stickDeadband = 0.02;
    public static final int leftXAxis = 0;
    public static final int leftYAxis = 1;
    public static final int rightXAxis = 3;
    public static final int rightYAxis = 4;

    public static final class SwerveConstants {

        public static final boolean invertGyro = false;
        public static final boolean invertXAxis = false;
        public static final boolean invertYAxis = true;
        public static final boolean invertRotAxis = false;

        //Drivetrain Constants
        public static final double driveGearRatio = 6.55;
        public static final double angleGearRatio = 10.29; // 72:14:24:12

        public static final double wheelDiameter = Units.inchesToMeters(4.0);
        public static final double wheelCircumference = wheelDiameter * Math.PI;

        public static final double openLoopRamp = 0.25;
        public static final double closedLoopRamp = 0.0;

        // toggle constants between comp bot and practice bot ("epsilon")
        public static final boolean isComp = true;

        /* Angle Encoder Invert */
        public static final boolean canCoderInvert = false;

        /* Swerve Profiling Values */
        public static final double maxSpeed = 5.18; // meters per second
        public static final double maxAngularVelocity = 8;
        
        //maxSpeed / Math.hypot(Constants.DRIVETRAIN_TRACKWIDTH_METERS 
        /// 2.0, Constants.DRIVETRAIN_WHEELBASE_METERS / 2.0); //14.244 radians per second
        
        /* Neutral Modes */
        public static final NeutralMode angleNeutralMode = NeutralMode.Coast;
        public static final NeutralMode driveNeutralMode = NeutralMode.Brake;

        /* Motor Inverts */
        public static final boolean driveMotorInvert = false;
        public static final boolean angleMotorInvert = true; //TODO: I changed this
        

        public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(3.2); 
        public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(168.2); 
        public static final double BACK_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(98.3); 
        public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(129.5); 

        public static final SwerveDriveKinematics m_kinematics = new SwerveDriveKinematics(
            // Front left
            new Translation2d(Constants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, Constants.DRIVETRAIN_WHEELBASE_METERS / 2.0),
            // Front right
            new Translation2d(Constants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, -Constants.DRIVETRAIN_WHEELBASE_METERS / 2.0),
            // Back left
            new Translation2d(-Constants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, Constants.DRIVETRAIN_WHEELBASE_METERS / 2.0),
            // Back right
            new Translation2d(-Constants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, -Constants.DRIVETRAIN_WHEELBASE_METERS / 2.0)
    );


        /*** MODULE SPECIFIC CONSTANTS ***/

        /* Front Left Module - Module 0 */
        public static final class Mod0 {
            
            public static final double angleOffset = 1.494;

            public static SwerveModuleConstants SwerveModuleConstants() {
                return new SwerveModuleConstants(Ports.FL_DRIVE, Ports.FL_ROTATION, Ports.FL_CANCODER,
                        angleOffset);
            }
        }

        /* Front Right Module - Module 1 */
        public static final class Mod1 {
            
            public static final double angleOffset = 343.916;

            public static SwerveModuleConstants SwerveModuleConstants() {
                return new SwerveModuleConstants(Ports.FR_DRIVE, Ports.FR_ROTATION, Ports.FR_CANCODER,
                        angleOffset);
            }
        }

        /* Back Left Module - Module 2 */
        public static final class Mod2 {
            public static final double angleOffset = 98.965;

            public static SwerveModuleConstants SwerveModuleConstants() {
                return new SwerveModuleConstants(Ports.BL_DRIVE, Ports.BL_ROTATION, Ports.BL_CANCODER,
                        angleOffset);
            }
        }

        /* Back Right Module - Module 3 */
        public static final class Mod3 {
            public static final double angleOffset = 129.902; //129.5

            public static SwerveModuleConstants SwerveModuleConstants() {
                return new SwerveModuleConstants(Ports.BR_DRIVE, Ports.BR_ROTATION, Ports.BR_CANCODER,
                        angleOffset);
            }
        }

        /* Swerve Current Limiting */
        public static final int angleContinuousCurrentLimit = 25;
        public static final int anglePeakCurrentLimit = 40;
        public static final double anglePeakCurrentDuration = 0.1;
        public static final boolean angleEnableCurrentLimit = true;

        public static final int driveContinuousCurrentLimit = 35;
        public static final int drivePeakCurrentLimit = 60;
        public static final double drivePeakCurrentDuration = 0.1;
        public static final boolean driveEnableCurrentLimit = true;
        public static final String SwerveConstants = null;

        /* Angle Motor PID Values */
        public static final double angleKP = 0.3;//1.1
        public static final double angleKI = 0.0;//0.01
        public static final double angleKD = 0.0;//5
        public static final double angleKF = 0.0;//1023/20818

        /* Drive Motor PID Values */
        public static final double driveKP = 0.05; //0.018
        public static final double driveKI = 0.0;//0.0005
        public static final double driveKD = 0.0;//0.5
        public static final double driveKF = 0.0;//1023/22365

        public static final double driveKS = (0.32 / 12); //TODO:figure out how to tune theese vaules
        public static final double driveKV = (1.51 / 12);
        public static final double driveKA = (0.27 / 12);

    }

    public static final class AutoConstants {
        public static final double kSlowSpeedMetersPerSecond = 0.3;
        public static final double kSlowAccelerationMetersPerSecondSquared = 0.5;

        public static final double kMaxSpeedMetersPerSecond = 0.5; 
        public static final double kMaxAccelerationMetersPerSecondSquared = 1;
        
        public static final double kSlowMaxAngularSpeedRadiansPerSecond = 0.2 * Math.PI;//0.8
        public static final double kSlowMaxAngularSpeedRadiansPerSecondSquared = Math.pow(kSlowMaxAngularSpeedRadiansPerSecond, 2);

        public static final double kMaxAngularSpeedRadiansPerSecond = .6 * Math.PI;
        public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.pow(kMaxAngularSpeedRadiansPerSecond, 2);

        public static final double kPXController = -1;
        public static final double kPYController = 1;
        public static final double kPThetaController = 1; //used to be 5

        // Constraint for the motion profilied robot angle controller
        public static final TrapezoidProfile.Constraints kThetaControllerConstraints =
                new TrapezoidProfile.Constraints(
                        kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);

        // Constraint for the motion profilied robot angle controller
        public static final TrapezoidProfile.Constraints kSlowThetaControllerConstraints =
                new TrapezoidProfile.Constraints(
                        kSlowMaxAngularSpeedRadiansPerSecond, kSlowMaxAngularSpeedRadiansPerSecondSquared);


        public static TrajectoryConfig createConfig(double maxSpeed, double maxAccel, double startSpeed, double endSpeed) {
            TrajectoryConfig config = new TrajectoryConfig(maxSpeed, maxAccel);
            config.setKinematics(Constants.SwerveConstants.m_kinematics);
            config.setStartVelocity(startSpeed);
            config.setEndVelocity(endSpeed);
            config.addConstraint(new CentripetalAccelerationConstraint(3.0));
            return config;
        }

        // Trajectory Speed Configs
        public static final TrajectoryConfig defaultSpeedConfig =
                new TrajectoryConfig(
                        kMaxSpeedMetersPerSecond,
                        kMaxAccelerationMetersPerSecondSquared)
                        .setKinematics(Constants.SwerveConstants.m_kinematics);

        public static final TrajectoryConfig slowSpeedConfig =
                new TrajectoryConfig(
                kSlowSpeedMetersPerSecond,
                kSlowAccelerationMetersPerSecondSquared)    
                .setKinematics(Constants.SwerveConstants.m_kinematics)
                        .setStartVelocity(0)
                        .setEndVelocity(0); 
    }

    public static final class VisionConstants {
		public static final LimelightConstants kLimelightConstants = new LimelightConstants();
		    static {
                kLimelightConstants.kName = "Limelight";
                kLimelightConstants.kTableName = "limelight";
                kLimelightConstants.kHeight = Conversions.inchesToMeters(15.0); // meters
                kLimelightConstants.kHorizontalPlaneToLens = Rotation2d.fromDegrees(34.0);
            }

		public static final double kHorizontalFOV = 59.6; // degrees
		public static final double kVerticalFOV = 49.7; // degrees
		public static final double kImageCaptureLatency = 11.0 / 1000.0; // seconds
        
        // lookahead time
        public static final double kLookaheadTime = 0.0; // 1.10 as latest

        /* Goal Tracker Constants */
        public static final double kMaxTrackerDistance = 8.0;
        public static final double kMaxGoalTrackAge = 10.0;
        public static final double kMaxGoalTrackSmoothingTime = 1.5;
        public static final double kCameraFrameRate = 90.0;

        public static final double kTrackStabilityWeight = 0.0;
        public static final double kTrackAgeWeight = 10.0;
        public static final double kTrackSwitchingWeight = 100.0;

        public static final int kDefaultPipeline = 0;
        public static final double kGoalHeight = 2.63; // meters
        public static final double kGoalRadius = 0.678; // meters
	}
    public static final class VisionAlignConstants {
        public static final double kP = 6.37;
        public static final double kI = 0.0;
        public static final double kD = 0.10;
        public static final double kTimeout = 0.25;
        public static final double kEpsilon = 5.0;

        // Constraints for the profiled angle controller
        public static final double kMaxAngularSpeedRadiansPerSecond = 2.0 * Math.PI;
        public static final double kMaxAngularSpeedRadiansPerSecondSquared = 10.0 * Math.PI;
        
        public static final TrapezoidProfile.Constraints kThetaControllerConstraints =
                new TrapezoidProfile.Constraints(kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
    }


    // Timeout constants
    public static final int kLongCANTimeoutMs = 100;
    public static final int kCANTimeoutMs = 10;
}
