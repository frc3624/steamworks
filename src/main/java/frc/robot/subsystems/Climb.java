/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climb extends SubsystemBase {

  private final WPI_TalonSRX climbMotor = new WPI_TalonSRX(Constants.CLIMB_MOTOR_ID);

  public Climb() {

  }

  /**
   * Set the speed of the climb motor
   * @param speed speed of climb motor [0, 1]
   */
  public void set(double speed) {
    /*
     * The climb subsystem uses a ratchet gear, so the motor should only spin the gear one way.
     * The Talon was installed so that the positive direction is the correct direction, so all values < 0
     * are denied so that the ratchet gear doesn't break.
     */
    speed = Math.max(0, speed);
    climbMotor.set(speed);
  }

}
