package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class JoystickDrive extends CommandBase {

  private final Joystick joystick;
  private final Drive drive;

  public JoystickDrive(Joystick joystick, Drive drive) {
    this.joystick = joystick;
    this.drive = drive;
    addRequirements(drive);
  }

  @Override
  public void execute() {
    drive.arcadeDrive(joystick.getY(), joystick.getX());
  }

  @Override
  public void end(boolean interrupted) {
    /* 
     * The drive subsystem maintains the speed it was last set it to, so it is set to (0, 0) when this
     * command ends to prevent the robot from losing control.
     */
    drive.arcadeDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
  
}
