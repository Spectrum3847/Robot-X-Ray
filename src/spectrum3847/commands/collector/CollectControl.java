package spectrum3847.commands.collector;

import spectrum3847.OI;
import spectrum3847.Utilities;
import spectrum3847.commands.CommandBase;

/**
 *
 */
public class CollectControl extends CommandBase {
	
    public CollectControl() {
        requires(collector);
    }

    @Override
    protected void initialize() {
    	collector.setCollector(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		double pow = Utilities.deadBand(OI.gamepad_aux.getRightY(), 0.18);
		collector.setCollector(pow);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	collector.setCollector(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
