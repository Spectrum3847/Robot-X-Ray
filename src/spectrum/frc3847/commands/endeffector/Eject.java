package spectrum.frc3847.commands.endeffector;

import spectrum.frc3847.commands.CommandBase;

/**
 *
 */
public class Eject extends CommandBase {

    public Eject() {
        requires(endEffector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	endEffector.setCollection(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	endEffector.collectionOut();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	endEffector.setCollection(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}