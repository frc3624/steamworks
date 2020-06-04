package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.GearShift;

public class SwitchGear extends InstantCommand {

  private final GearShift gearShift;

  public SwitchGear(GearShift gearShift) {
    this.gearShift = gearShift;
    addRequirements(gearShift);
  }

  @Override
  public void initialize() {
    gearShift.toggleGear();
  }
  
}
