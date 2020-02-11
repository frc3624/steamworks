/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

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
     * The drive subsystem will maintain the speed we last set it to, so we'll do the polite thing and
     * set the speed to 0 once we are done with it.
     */
    drive.arcadeDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
