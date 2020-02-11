/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GearShift extends SubsystemBase {

  private final DoubleSolenoid gearPiston = new DoubleSolenoid(PCM_ID, GEARSHIFT_FORWARD_CHANNEL, GEARSHIFT_REVERSE_CHANNEL);

  public GearShift() {
    // the initial state of DoubleSolenoids is Value.kOff, so we want to change it to high gear
    /* 
     * I want to note that Value is something called an enum - something you probably have not
     * learned of yet. I highly suggest doing a quick google on what enums are before continuing
     */
    gearPiston.set(Value.kForward);
  }

  public void toggleGear() {
    if (gearPiston.get() == Value.kReverse)
      gearPiston.set(Value.kForward);
    else if (gearPiston.get() == Value.kForward)
      gearPiston.set(Value.kReverse);
    /*
     * Value has 4 values:
     * kForward, kReverse, kOn, and kOff
     * Since we set the state to kForward in the constructor, it is impossible for the
     * state to be something other than kForward or kReverse, but I put this final else
     * statement in the case that it is kOff or kOn to let me sleep easier at night.
     */
    else
      gearPiston.set(Value.kReverse);
  }

}
