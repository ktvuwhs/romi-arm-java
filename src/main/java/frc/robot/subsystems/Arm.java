// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.LiftConstants.*;

public class Arm extends SubsystemBase {
  private final Servo m_servo;
  
  /** Creates a new Arm. */
  public Arm() {
    m_servo = new Servo(kPort);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public Command raiseCommand() {
    return this.run(() -> m_servo.set(MathUtil.clamp(m_servo.get() + 0.01, kMinPulse, kMaxPulse)));
  }

  public Command lowerCommand() {
    return this.run(() -> m_servo.set(MathUtil.clamp(m_servo.get() - 0.01, kMinPulse, kMaxPulse)));
  }
}
