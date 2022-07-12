// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.subsystems;


// import com.ctre.phoenix.sensors.Pigeon2;
// import com.ctre.phoenix.sensors.WPI_Pigeon2;
// import com.swervedrivespecialties.swervelib.SwerveModule;

// //import com.ctre.phoenix.sensors.PigeonIMU;

// import edu.wpi.first.math.geometry.Rotation2d;
// import edu.wpi.first.math.geometry.Translation2d;
// import edu.wpi.first.math.kinematics.ChassisSpeeds;
// import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
// import edu.wpi.first.math.kinematics.SwerveModuleState;
// import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
// import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
// import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;


// import frc.robot.Constants.SwerveConstants;
// import frc.robot.Ports;
// import frc.robot.Constants;


// public class DrivetrainSubsystem extends SubsystemBase {

// /*

//         public SwerveModule[] mSwerveMods;
//        // private final Pigeon2 m_pigeon = new Pigeon2(Ports.DRIVETRAIN_PIGEON_ID);



// //swerve kinematics
//   private final SwerveDriveKinematics m_kinematics = new SwerveDriveKinematics(
//           // Front left
//           new Translation2d(Constants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, Constants.DRIVETRAIN_WHEELBASE_METERS / 2.0),
//           // Front right
//           new Translation2d(Constants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, -Constants.DRIVETRAIN_WHEELBASE_METERS / 2.0),
//           // Back left
//           new Translation2d(-Constants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, Constants.DRIVETRAIN_WHEELBASE_METERS / 2.0),
//           // Back right
//           new Translation2d(-Constants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, -Constants.DRIVETRAIN_WHEELBASE_METERS / 2.0)
//   );


  

  

//  // mSwerveMods = new SwerveModule[] {
//    //   new SwerveModule(0, Constants.SwerveConstants.Mod0.SwerveModuleConstants()),
//     //  new SwerveModule(1, Constants.SwerveConstants.Mod1.SwerveModuleConstants()),
//    //   new SwerveModule(2, Constants.SwerveConstants.Mod2.SwerveModuleConstants()),
//    //   new SwerveModule(3, Constants.SwerveConstants.Mod3.SwerveModuleConstants())
//  // };

//   private ChassisSpeeds m_chassisSpeeds = new ChassisSpeeds(0.0, 0.0, 0.0);

//   public DrivetrainSubsystem() {
//     ShuffleboardTab tab = Shuffleboard.getTab("Drivetrain");



//   }

//   /**
//    * Sets the gyroscope angle to zero. This can be used to set the direction the robot is currently facing to the
//    * 'forwards' direction.
//    */

//   public void zeroGyroscope() {
//     //m_pigeon.setYaw(0.0);
//     System.out.println("zeroing Gyro");
//   }

//   //public Rotation2d getGyroscopeRotation() {
//     //return Rotation2d.fromDegrees(m_pigeon.getYaw());
//  // }
// /*
//   public void drive(ChassisSpeeds chassisSpeeds) {
//     m_chassisSpeeds = chassisSpeeds;
//   }

//   @Override
//   public void periodic() {

 
//     SwerveModuleState[] states = m_kinematics.toSwerveModuleStates(m_chassisSpeeds);
//     //SwerveDriveKinematics.desaturateWheelSpeeds(states, MAX_VELOCITY_METERS_PER_SECOND);

//     //m_frontLeftModule.set(states[0].speedMetersPerSecond / MAX_VELOCITY_METERS_PER_SECOND * MAX_VOLTAGE, states[0].angle.getRadians());
//     //m_frontRightModule.set(states[1].speedMetersPerSecond / MAX_VELOCITY_METERS_PER_SECOND * MAX_VOLTAGE, states[1].angle.getRadians());
//     //m_backLeftModule.set(states[2].speedMetersPerSecond / MAX_VELOCITY_METERS_PER_SECOND * MAX_VOLTAGE, states[2].angle.getRadians());
//     //m_backRightModule.set(states[3].speedMetersPerSecond / MAX_VELOCITY_METERS_PER_SECOND * MAX_VOLTAGE, states[3].angle.getRadians());

//     //m_frontLeftModule.set(states[0].speedMetersPerSecond / MAX_VELOCITY_METERS_PER_SECOND * MAX_VOLTAGE, 0);
//     //m_frontRightModule.set(states[1].speedMetersPerSecond / MAX_VELOCITY_METERS_PER_SECOND * MAX_VOLTAGE, 0);
//     //m_backLeftModule.set(states[2].speedMetersPerSecond / MAX_VELOCITY_METERS_PER_SECOND * MAX_VOLTAGE, 0);
//     //m_backRightModule.set(states[3].speedMetersPerSecond / MAX_VELOCITY_METERS_PER_SECOND * MAX_VOLTAGE, 0);
//   }
// }
