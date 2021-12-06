// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package edu.wpi.first.wpilibj.examples.pacgoat.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.examples.pacgoat.Robot;

/**
 * This command looks for the hot goal and waits until it's detected or timed out. The timeout is
 * because it's better to shoot and get some autonomous points than get none. When called
 * sequentially, this command will block until the hot goal is detected or until it is timed out.
 */
public class CheckForHotGoal extends Command {
  public CheckForHotGoal(double time) {
    setTimeout(time);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut() || Robot.shooter.goalIsHot();
  }
}