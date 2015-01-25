package spectrum.frc3847.commands.driving;

import spectrum.frc3847.Dashboard;
import spectrum.frc3847.OI;
import spectrum.frc3847.Utilities;
import spectrum.frc3847.commands.CommandBase;

public class HaloStrafeDrive extends CommandBase {

	protected void initialize() {
		System.out.println("HaloStrafe, GO!");
		drivebase.dropHWheel();
	}

	protected void execute() {
        double turn = -Utilities.haloDeadBand(OI.gamepad.getRightX(), OI.gamepad.getLeftY(), .15, .17);
        double triggers = OI.gamepad.getOldTriggers();
        
        double scaled_turn = Utilities.smartRamp(Dashboard.STEER_RAMP_FUNCTION, turn);
        double scaled_triggers = Utilities.smartRamp(Dashboard.STRAFE_RAMP_FUNCTION, triggers);
        
        drivebase.setArcade(0, scaled_turn);
        drivebase.setHWheel(scaled_triggers);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		drivebase.liftHWheel();
        drivebase.setArcade(0, 0);
	}

	protected void interrupted() {
		end();
	}

}
