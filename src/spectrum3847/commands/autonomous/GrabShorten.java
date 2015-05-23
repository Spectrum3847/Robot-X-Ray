package spectrum3847.commands.autonomous;

import spectrum3847.commands.CommandBase;


public class GrabShorten extends CommandBase {

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		cangrabber.shorten();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		cangrabber.shorten();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		cangrabber.shorten();
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

		end();
	}

}
