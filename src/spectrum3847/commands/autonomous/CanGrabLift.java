package spectrum3847.commands.autonomous;

import spectrum3847.commands.CommandBase;

public class CanGrabLift extends CommandBase {

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
        CommandBase.cangrabber.reelGrabber();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
        CommandBase.cangrabber.reelGrabber();
		// TODO Auto-generated method stub
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}

}
