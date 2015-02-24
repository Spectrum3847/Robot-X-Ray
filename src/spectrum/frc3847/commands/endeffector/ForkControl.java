package spectrum.frc3847.commands.endeffector;

import spectrum.frc3847.OI;
import spectrum.frc3847.Utilities;
import spectrum.frc3847.commands.CommandBase;

/**
 *
 */
public class ForkControl extends CommandBase {
	
    public ForkControl() {
        requires(endEffector);
    }

    @Override
    protected void initialize() {
    	endEffector.setFork(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		double pow = Utilities.deadBand(OI.gamepad_aux.getRightY(), 0.18);
		endEffector.setFork(pow);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	endEffector.setFork(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
