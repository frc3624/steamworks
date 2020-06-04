package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ClimbCommand;
import frc.robot.commands.JoystickDrive;
import frc.robot.commands.SwitchGear;
import frc.robot.commands.auto.DriveStraight;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.GearShift;

public class RobotContainer {

  private final Joystick joystick = new Joystick(Constants.JOYSTICK_ID);
  private final JoystickButton climbButton = new JoystickButton(joystick, 1);
  private final JoystickButton switchGearButton = new JoystickButton(joystick, 6);

  private final Drive drive = new Drive();
  private final GearShift gearShift = new GearShift();
  private final Climb climb = new Climb();

  private final JoystickDrive joystickDrive = new JoystickDrive(joystick, drive);
  private final SwitchGear switchGear = new SwitchGear(gearShift);
  private final ClimbCommand climbCommand = new ClimbCommand(climb);
  
  private final Command autoCommand = CommandGroupBase.sequence(new DriveStraight(drive, .25, 3), new DriveStraight(drive, .5, 1.5));

  public RobotContainer() {
    drive.setDefaultCommand(joystickDrive);
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    climbButton.whileHeld(climbCommand);
    switchGearButton.whenPressed(switchGear);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return autoCommand;
  }
  
}
