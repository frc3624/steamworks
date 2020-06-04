package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Climb;

public class ClimbCommand extends InstantCommand {

  private final Climb climb;

  public ClimbCommand(Climb climb) {
    this.climb = climb;
    addRequirements(climb);
  }

  @Override
  public void initialize() {
    
  }

  @Override
  public void execute() {
    climb.set(1);
  }

  @Override
  public void end(boolean interrupted) {
    climb.set(0);
  }
  
}
