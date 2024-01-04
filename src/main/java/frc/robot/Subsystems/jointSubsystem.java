// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotConstants;

public class jointSubsystem extends SubsystemBase {
 
  VictorSPX JointMotor;
  /** Creates a new jointSubsystem. */
  public jointSubsystem() {
     JointMotor = new VictorSPX(RobotConstants.JointMotorID);
     
  }

  public void LiftUp(){
    JointMotor.set(VictorSPXControlMode.PercentOutput,1*RobotConstants.JointMaxOutput);
  }

  public void PutDown(){
    JointMotor.set(VictorSPXControlMode.PercentOutput,-1*RobotConstants.JointMaxOutput);
  }
  
    public void Stop(){
    JointMotor.set(VictorSPXControlMode.PercentOutput,0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
