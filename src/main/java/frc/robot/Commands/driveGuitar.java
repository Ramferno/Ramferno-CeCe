// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DriveSubsystem;

public class driveGuitar extends CommandBase {
  
  BooleanSupplier m_isRight;
  DoubleSupplier m_forward;
  DoubleSupplier m_turningSpeed;
  DriveSubsystem m_drive;
  double m_turning;
  /** Creates a new driveGuitar. */
  public driveGuitar(BooleanSupplier isRight, DoubleSupplier forward,DoubleSupplier turning, DriveSubsystem dSubsystem) {
    m_isRight = isRight;
    m_forward = forward;
    m_turningSpeed = turning;
    m_drive = dSubsystem;
    
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_isRight.getAsBoolean()) m_turning = m_turningSpeed.getAsDouble() * -1;
    else m_turning = m_turningSpeed.getAsDouble();

    m_drive.DriveBitchesDrive(m_forward.getAsDouble(), m_turning);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.DriveBitchesDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
