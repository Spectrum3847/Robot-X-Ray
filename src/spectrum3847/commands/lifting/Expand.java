package spectrum3847.commands.lifting;

import spectrum3847.commands.CommandBase;

public class Expand extends CommandBase {

	//Override
	protected void initialize() {
		lift.expand();
	}

	//Override
	protected void execute() {
	}

	//Override
	protected boolean isFinished() {
		return false;
	}

	//Override
	protected void end() {
		lift.collapse();
	}

	//Override
	protected void interrupted() {
		end();
	}

}
