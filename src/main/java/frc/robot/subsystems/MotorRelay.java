// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class MotorRelay extends SubsystemBase {
  private final DigitalOutput m_dio;
  
  /** Creates a new MotorRelay. */
  public MotorRelay() {
    m_dio = new DigitalOutput(kMotorRelaySignalPort);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public Command onCommand() {
    return this.runOnce(() -> m_dio.set(true));
  }

  public Command offCommand() {
    return this.runOnce(() -> m_dio.set(false));
  }
}
