package spectrum.frc3847.commands.endeffector;

import spectrum.frc3847.commands.CommandBase;

public class Expand extends CommandBase {

	//Override
	protected void initialize() {
		endEffector.expand();
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
		endEffector.close();
	}

	//Override
	protected void interrupted() {
		end();
	}

}
