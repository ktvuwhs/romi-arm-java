// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final int kMotorRelaySignalPort = 8;

  public final class LiftConstants {
    // Max and min pulse values for Servo can be found https://www.pololu.com/docs/0J76/4
    public static final int kPort = 4;
    public static final double kMinPulse = 0; // 1000 microseconds -> 0
    public static final double kMaxPulse = 900.0/1000.0;
  }

  public final class GripperConstants {
    public static final int kPort = 2;
  }

  public final class PivotConstants {
    public static final int kPort = 3;
    public static final double kMinPulse = 200.0 / 1000.0; // 1200 microseconds out of 1000 is fully closed
    public static final double kMaxPulse = 900.0 / 1000.0; // 1900 microseconds out of 2000 is fully open
  }
}
