package spectrum.frc3847.commands.driving;

import spectrum.frc3847.commands.CommandBase;

public class DropHWheel extends CommandBase {

	@Override
	protected void initialize() {
		drivebase.dropHWheel();
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		drivebase.liftHWheel();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
