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
     * The climb subsystem was designed in such a way that it can only rotate in one way.
     * If it tries to rotate backwards, in the negative voltage direction (as in climbMotor.set(-1)),
     * it will break.
     * We can use the fact that climbMotor is a private variable to our advantage. This method is the only way
     * it is exposed to other places, so we can make sure it doesn't break by not letting anyone set speed to a negative value.
     */
    climbMotor.set(Math.max(0, speed));
    /*
     * Now, any negative value will just be replaced with 0.
     */
  }

}
