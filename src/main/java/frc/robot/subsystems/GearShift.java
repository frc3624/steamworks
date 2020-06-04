package frc.robot.subsystems;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GearShift extends SubsystemBase {

  private final DoubleSolenoid gearPiston = new DoubleSolenoid(PCM_ID, GEARSHIFT_FORWARD_CHANNEL, GEARSHIFT_REVERSE_CHANNEL);

  public GearShift() {
    gearPiston.set(Value.kForward);
  }

  public void toggleGear() {
    if (gearPiston.get() == Value.kReverse)
      gearPiston.set(Value.kForward);
    else if (gearPiston.get() == Value.kForward)
      gearPiston.set(Value.kReverse);
    else
      gearPiston.set(Value.kReverse);
  }

}
