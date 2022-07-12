package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.Swerve;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TeleopSwerve extends CommandBase {

    private double rotation;
    private Translation2d translation;
    private boolean fieldRelative;
    private boolean openLoop;

    private Swerve s_Swerve;
    private GenericHID controller;

    /**
     * Driver control
     */
    public TeleopSwerve(Swerve s_Swerve, GenericHID m_driver, boolean fieldRelative, boolean openLoop) {
        this.s_Swerve = s_Swerve;
        addRequirements(s_Swerve);

        this.controller = m_driver;
        this.fieldRelative = fieldRelative;
        this.openLoop = openLoop;
    }

    @Override
    public void execute() {
        double yAxis = -getYAxisLeft();
        double xAxis = -getXAxisLeft();
        double rAxis = -getXAxisRight();

        /* Deadbands */
        yAxis = (Math.abs(yAxis) < Constants.stickDeadband) ? 0 : yAxis;
        xAxis = (Math.abs(xAxis) < Constants.stickDeadband) ? 0 : xAxis;
        rAxis = (Math.abs(rAxis) < Constants.stickDeadband) ? 0 : rAxis;

        translation = new Translation2d(yAxis, xAxis).times(Constants.SwerveConstants.maxSpeed);
        rotation = rAxis * Constants.SwerveConstants.maxAngularVelocity;
        s_Swerve.drive(translation, rotation, fieldRelative, openLoop);
    }

    private double getXAxisLeft() {
        double XAxisLeft;
        if (controller.getRawAxis(Constants.leftXAxis) > 0) {
            XAxisLeft = controller.getRawAxis(1) / 0.91;
        } else { // negative value
            XAxisLeft = controller.getRawAxis(1) / 0.85;
        }
        XAxisLeft = XAxisLeft + 0.1369;
        return XAxisLeft;
    }

    private double getYAxisLeft() {
        double YAxisLeft;
        if (controller.getRawAxis(Constants.leftYAxis) > 0) {
            YAxisLeft = controller.getRawAxis(0) / 0.826;
        } else
            YAxisLeft = controller.getRawAxis(0) / 0.807;

        YAxisLeft = YAxisLeft - 0.03937007;

        return YAxisLeft;

    }

    private double getXAxisRight() {
        double XAxisRight;
        if (0.07 > controller.getRawAxis(Constants.rightXAxis) && controller.getRawAxis(4) > 0) {
            XAxisRight = 0;
        } else if (controller.getRawAxis(4) > 0) {
            XAxisRight = controller.getRawAxis(4) / 0.74;
        } else { // negative value
            XAxisRight = controller.getRawAxis(4) / 0.61;
        }

        return XAxisRight;
    }


      // private double getYAxisRight(){
  // if (0.0627 > m_driver.getRawAxis(3) && m_driver.getRawAxis(3) > 0){
  // rightAxis = 0;
  // }
  // else if (m_driver.getRawAxis(3) > 0){
  // rightYaw = m_driver.getRawAxis(3)/0.88;
  // }
  // else{
  // rightYaw = m_driver.getRawAxis(3)/0.77;
  // }

  // return 0;
  // }
}