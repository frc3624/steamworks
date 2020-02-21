/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb;

public class ClimbCommand extends CommandBase {

  private final Climb climb;

  public ClimbCommand(Climb climb) {
    this.climb = climb;
    addRequirements(climb);
  }

  @Override
  public void initialize() {
    climb.set(1);
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
    climb.set(0);
  }

  /* 
   * We dont want this command to self-terminate. We only want this command to end when it is interrupted
   * Since we used joystickButton.whileHeld() for this command, it gets interrupted once the button is released.
   */
  @Override
  public boolean isFinished() {
    return false;
  }
  
}
