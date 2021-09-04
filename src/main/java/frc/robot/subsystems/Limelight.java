package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/*
 * 
 */
public class Limelight extends SubsystemBase {

  /*
   * Remember, the thing you connect to is not a radio, no matter what Mr Wilson says.
   * It's really a wifi router, the same kind that you have in your house which you use to 
   */

  private final NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  public Limelight() {

  } 

  @Override
  public void periodic() {
    
  }

  // https://docs.limelightvision.io/en/latest/networktables_api.html

  public boolean hasValidTarget() {
    return table.getEntry("tv").getDouble(0) == 1;
  }

  /**
   * @return The horizontal offset of the center of view of the camera and the target
   */
  public double getHorizontalOffset() {
    return table.getEntry("tx").getDouble(0);
  }
  /**
   * @return The vertical offset of the center of view of the camera and the target
   */
  public double getVerticalOffset() {
    return table.getEntry("ty").getDouble(0);
  }

  /**
   * @return The percentage of the screen the target takes up, [0, 100]
   */
  public double getTargetArea() {
    return table.getEntry("ta").getDouble(0);
  }

  /**
   * @return How the target is rotated relative to the view of the robot
   */
  public double getTargetSkew() {
    return table.getEntry("ts").getDouble(0);
  }

}