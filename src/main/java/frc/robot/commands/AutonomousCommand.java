package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.TimedRobot;



public class AutonomousCommand extends CommandBase {
  /** Creates a new AutonomousDrive. */
  private Timer timer;
  static double initTime;
  Timer clock = new Timer();
  
  public AutonomousCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    timer = new Timer();

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.m_robotContainer.driveSubsystem.stop();
    // timer.reset();
    timer.start();

  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double ultrasonicRange = RobotMap.ultrasonic.getRangeInches();
    // Analog voltage to range in inches converter
    /*
     * Based on the type of ultrasonic sensor, use one of these two variables for
     * the range
     */

    // double startTime = clock.get();
    double newTime = System.currentTimeMillis();
    // double analogDistFromObj = RobotMap.getDistFromObj();
    // double analogDistFromBall = RobotMap.getDistFromBall();

    if (timer.hasElapsed(5) == true) {
  
      Robot.m_robotContainer.driveSubsystem.stop();
      // turnRobot();
      // Robot.m_robotContainer.driveSubsystem.drive(Constants.fastRobotSpeed, 180);
    } else if (timer.hasElapsed(5) == false) {
      moveRobot();

      // while (specialcounter != 1) {
      //   moveRobot();
      // }
     
    }
  }

  private void moveRobot() {
    Robot.m_robotContainer.driveSubsystem.drive(Constants.fastRobotSpeed, 0);
  }

  private void turnRobot() {
    Robot.m_robotContainer.driveSubsystem.drive(Constants.fastRobotSpeed, 180);


  }

  // private void moveRobot() {
  //   Robot.m_robotContainer.driveSubsystem.drive(Constants.slowRobotSpeed, 0);
  // }



  // Called once the command ends or is interrupted.
  // @Override
  // public void end(boolean interrupted) {
  //   Robot.m_robotContainer.driveSubsystem.stop();
  // }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;

  }
}

