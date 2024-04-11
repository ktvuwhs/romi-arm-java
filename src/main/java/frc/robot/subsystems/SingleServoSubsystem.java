// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** A subsystem that represents one of the components from the Romi
 * Arm Kit that has a Servo on it.  These Servos contain an extra,
 * green wire that reports the position of the Servo in volts.  The
 * position in mV is at a near 1:1 correspondence with its pulse
 * value in miliseconds.
 * 
 * If the green wire is not used, then the AnalogOutput object is
 * set to null.
 * 
 * kMinPulse  The minimum operating pulse value for the Servo based
 *            on the geometry of the Arm Kit.
 * kMaxPulse  The maximum operating pulse value for the Servo based
 *            on the geometry of the Arm Kit.
 * @see       https://www.pololu.com/docs/0J76/4
 */
public class SingleServoSubsystem extends SubsystemBase {
  private final Servo m_servo;
  private final double kMinPulse;
  private final double kMaxPulse;
  private AnalogOutput m_signal;
  
  public SingleServoSubsystem(final int port,
                              final double min, 
                              final double max) {
    m_servo = new Servo(port);
    kMinPulse = min;
    kMaxPulse = max;
    m_signal = null;
  }

  public SingleServoSubsystem(final int port,
                              final int signal,
                              final double min,
                              final double max) {
    m_servo = new Servo(port);
    kMinPulse = min;
    kMaxPulse = max;
    m_signal = new AnalogOutput(signal);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  private double getPosition() {
    if (m_signal != null) {
      return m_signal.getVoltage();
    }
    return m_servo.get();
  }

  public Command raiseCommand() {
    return this.run(() -> m_servo.set(
      MathUtil.clamp(getPosition() + 0.01, kMinPulse, kMaxPulse)));
  }

  public Command lowerCommand() {
    return this.run(() -> m_servo.set(
      MathUtil.clamp(getPosition() - 0.01, kMinPulse, kMaxPulse)));
  }
}
