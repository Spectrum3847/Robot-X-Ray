package spectrum3847.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/**
 * A {@link WaitCommand} will wait for a certain amount of time before finishing.
 * It is useful if you want a {@link CommandGroup} to pause for a moment.
 * @author Joe Grinstead
 * @see CommandGroup
 */
public class Wait extends Command {

    /**
     * Instantiates a {@link WaitCommand} with the given timeout.
     * @param timeout the time the command takes to run
     */
    public Wait(String timeout) {
    	super(Double.parseDouble(timeout));
    }
    
    public Wait(double timeout) {
    	super(timeout);
    }

    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}