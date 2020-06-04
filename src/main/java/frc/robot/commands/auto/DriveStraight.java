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
    this.timer = new Timer(); // Keeps track of time elapsed since command is initialized (not instantiated)
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
