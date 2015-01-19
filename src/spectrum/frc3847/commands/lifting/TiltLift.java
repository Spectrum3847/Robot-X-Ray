package spectrum.frc3847.commands.lifting;

import spectrum.frc3847.commands.CommandBase;

public class TiltLift extends CommandBase {

	@Override
	protected void initialize() {
		lift.tiltOn();
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
		lift.tiltOff();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
