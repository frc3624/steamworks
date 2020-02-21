/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GearShift;

public class SwitchGear extends CommandBase {

  private final GearShift gearShift;

  public SwitchGear(GearShift gearShift) {
    this.gearShift = gearShift;
    addRequirements(gearShift);
  }

  @Override
  public void initialize() {
    gearShift.toggleGear();
  }

  /* 
   * We don't need this command to run for any period of time. It just needs to run initialize and it's done.
   * isFinished() will return true the very moment the command is started and the command will end.
   */
  @Override
  public boolean isFinished() {
    return true;
  }
  
}
