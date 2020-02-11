/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class DriveStraight extends CommandBase {

  private final Drive drive;
  private final double speed;
  private final Timer timer;
  private final double duration;

  /**
   * @param drive Drive subsystem
   * @param speed speed [-1, 1]
   * @param duration run time of command in seconds, d >= 0
   */
  public DriveStraight(Drive drive, double speed, double duration) {
    this.drive = drive;
    addRequirements(drive);
    this.speed = speed;
    this.timer = new Timer(); // Keeps track of time elapsed since .start() is called
    timer.start();
    this.duration = Math.max(0, duration); // enforces domain of input
  }

  @Override
  public void initialize() {
    drive.arcadeDrive(speed, 0);
  }

  @Override
  public void end(boolean interrupted) {
    drive.arcadeDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return timer.get() > duration;
  }
}
