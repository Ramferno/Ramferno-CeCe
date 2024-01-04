// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.Commands.DriveCommand;
import frc.robot.Commands.IntakeCommand;
import frc.robot.Commands.LiftJointCommand;
import frc.robot.Commands.LowerJointCommand;
import frc.robot.Commands.ReleaseCommand;
import frc.robot.Commands.driveGuitar;
import frc.robot.Commands.goForward;
import frc.robot.Subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_drive = new DriveSubsystem();
  //private CommandXboxController switchController = new CommandXboxController(0);
  private CommandXboxController XboxController = new CommandXboxController(0);
  

  Trigger rightTrigger = XboxController.rightTrigger();
  Trigger leftTrigger = XboxController.leftTrigger();

  Trigger rightBumper = XboxController.rightBumper();
  Trigger leftBumper = XboxController.leftBumper();

//triggers for the guitar

 /*  Trigger povUpTrigger = guitarHeroController.pov(0);
  Trigger povDownTrigger = guitarHeroController.pov(180);
  
  Trigger greenButton = guitarHeroController.button(1);
  Trigger redButton = guitarHeroController.button(2);
*/
//triggers for the switch controller

/*Trigger leftTrigger = switchController.button(5);
  Trigger rightTrigger = switchController.button(6);
  Trigger leftZTrigger = switchController.button(7);
  Trigger rightZTrigger = switchController.button(8);
  */


  DriveCommand driveCommander;
  
  // Replace with CommandPS4Controller or CommandJoystick if needed

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    

   //   m_drive.setDefaultCommand(new driveGuitar(()->guitarHeroController.button(4).getAsBoolean(), () -> guitarHeroController.getRawAxis(5), () ->guitarHeroController.getRawAxis(4), m_drive));

        m_drive.setDefaultCommand(new DriveCommand(m_drive, () -> XboxController.getLeftY(), () -> XboxController.getLeftX()));

  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    
    


     
     // greenButton.whileTrue(new IntakeCommand());
     // redButton.whileTrue(new ReleaseCommand());
     // povUpTrigger.whileTrue(new LiftJointCommand());
     // povDownTrigger.whileTrue(new LowerJointCommand());
      
      rightBumper.whileTrue(new IntakeCommand());
      leftBumper.whileTrue(new ReleaseCommand());
      rightTrigger.whileTrue(new LiftJointCommand());
      leftTrigger.whileTrue(new LowerJointCommand());
   
   
    
    
   /* 
      leftTrigger.whileTrue(new IntakeCommand());
      rightTrigger.whileTrue(new ReleaseCommand());
      leftZTrigger.whileTrue(new LiftJointCommand());
      rightZTrigger.whileTrue(new LowerJointCommand());
      */
    
   
    
  }

 
}
