// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DriveSubsystem;

public class goForward extends CommandBase {
  
  private final DriveSubsystem m_drive;
  private final DoubleSupplier m_speed;
  
  /** Creates a new goForward. */
  public goForward(DriveSubsystem subsystem, DoubleSupplier speed) {
    m_drive = subsystem;
    m_speed = speed;
    addRequirements(m_drive);
    
    // Use addRequirements() here to declare subsystem dependencies.
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.forwardRob(1, m_speed.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.DriveBitchesDrive(0, 0);}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
