// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.RomiDrivetrain;
import frc.robot.subsystems.SingleServoSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.Constants;
import frc.robot.Constants.GripperConstants;
import frc.robot.Constants.LiftConstants;
import frc.robot.Constants.PivotConstants;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  final CommandXboxController m_controller = new CommandXboxController(0);
  // The robot's subsystems and commands are defined here...
  private final RomiDrivetrain m_romiDrivetrain = new RomiDrivetrain();
  private final SingleServoSubsystem m_lift = new SingleServoSubsystem(LiftConstants.kPort, LiftConstants.kMinPulse, LiftConstants.kMaxPulse);
  private final SingleServoSubsystem m_pivot = new SingleServoSubsystem(PivotConstants.kPort, PivotConstants.kMinPulse, PivotConstants.kMaxPulse);
  private final SingleServoSubsystem m_gripper = new SingleServoSubsystem(GripperConstants.kPort, 0, 1);


  private final ExampleCommand m_autoCommand = new ExampleCommand(m_romiDrivetrain);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_romiDrivetrain.setDefaultCommand(new RunCommand(
      () -> m_romiDrivetrain.arcadeDrive(m_controller.getLeftY(), m_controller.getRightX()),
      m_romiDrivetrain)
    );
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_controller.a().whileTrue(m_lift.raiseCommand());
    m_controller.b().whileTrue(m_lift.lowerCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
