// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotConstants;



import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
public class IntakeSubsytem extends SubsystemBase {
  /** Creates a new IntakeSubsytem. */
  VictorSPX LeftIntakeMotor;
  VictorSPX RightIntakeMotor;
  public IntakeSubsytem() {
    LeftIntakeMotor = new VictorSPX(RobotConstants.intakeMotorIDs[0]);
    RightIntakeMotor = new VictorSPX(RobotConstants.intakeMotorIDs[1]);
    LeftIntakeMotor.setInverted(true);
    LeftIntakeMotor.follow(RightIntakeMotor);

  }
  
  /**
   * Creates a method for intaking game pieces
   * @param speed the number at of which the motor will turnn
   */
  public void Intake(){
    RightIntakeMotor.set(VictorSPXControlMode.PercentOutput,RobotConstants.JointMaxOutput);
  }
  /**
   * Creates a method for releasing damn darnit cones into the public
   * @param speed the percentage to spin  the motors att
   */
  public void Release(){
    RightIntakeMotor.set(VictorSPXControlMode.PercentOutput,-RobotConstants.JointMaxOutput);
  }
  
    public void Stop(){
    RightIntakeMotor.set(VictorSPXControlMode.PercentOutput,0);
  }

}
