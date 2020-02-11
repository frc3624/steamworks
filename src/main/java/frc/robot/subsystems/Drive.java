/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  
  /*
   * The robot has 4 motors which are used for driving, so we need a speed controller for each motor
   * While there are 4 motors, the robot has been built such that the left side and the right
   * side move as wholes - a differential drive
   * http://planning.cs.uiuc.edu/node659.html
   * There are 2 motors for each side, but the motors *don't* work each wheel. Instead, they are
   * put together in something called a gear box, which makes them work as one unit
   * https://www.vexrobotics.com/wcp-ds.html
   */
  private final WPI_TalonSRX leftMaster = new WPI_TalonSRX(LEFT_MASTER_ID);
  private final WPI_TalonSRX leftSlave = new WPI_TalonSRX(LEFT_SLAVE_ID);
  private final WPI_TalonSRX rightMaster = new WPI_TalonSRX(RIGHT_MASTER_ID);
  private final WPI_TalonSRX rightSlave = new WPI_TalonSRX(RIGHT_SLAVE_ID);

  /* 
   * We only need a DifferentialDrive for the masters because we are going to make the slaves "follow"
   * the masters. When a speed controller follows another speed controller, it will copy whatever percent voltage
   * the followed motor has.
   * In this case, DifferentialDrive sets the speed of leftMaster and rightMaster, and since leftSlave and rightSlave
   * follow their respective master, they will be set to the correct speed too.
   */
  private final DifferentialDrive differentialDrive = new DifferentialDrive(leftMaster, rightMaster);

  public Drive() {
    leftSlave.set(ControlMode.Follower, LEFT_MASTER_ID);
    rightSlave.set(ControlMode.Follower, RIGHT_MASTER_ID);
  }

  public void arcadeDrive(double speed, double rotation) {
    differentialDrive.arcadeDrive(speed, rotation);
  }
  public void arcadeDrive(double speed, double rotation, boolean squareInput) {
    differentialDrive.arcadeDrive(speed, rotation, squareInput);
  }

}
