// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveSubsystem extends SubsystemBase {
  WPI_VictorSPX LeftMotor1;
  WPI_VictorSPX RightMotor1;
  WPI_VictorSPX LeftMotor2;
  WPI_VictorSPX RightMotor2;
  DifferentialDrive drive;
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {

    LeftMotor1 = new WPI_VictorSPX(1);
    RightMotor1 = new WPI_VictorSPX(3); 
    LeftMotor2 = new WPI_VictorSPX(2);
    RightMotor2 = new WPI_VictorSPX(4);
    drive = new DifferentialDrive(LeftMotor1, RightMotor1);
    
    LeftMotor2.follow(LeftMotor1);
    RightMotor2.follow(RightMotor1);

  }
   
  /**
   * the method for driving
   * @param forward The control input for driving forwards/backwards
   * @param rotation The control input for turning
   */
 public void DriveBitchesDrive(double forward, double rotation){
     drive.arcadeDrive(rotation, forward, true);
  }

  public void forwardRob(int direction, double speed){
    drive.arcadeDrive(direction * Constants.RobotConstants.DriveMaxOutout * speed, 0);
  }
  
  public void TurnRob(int direction, double speed){
    drive.arcadeDrive(0,direction * Constants.RobotConstants.DriveMaxOutout * speed);
  }


   
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}



