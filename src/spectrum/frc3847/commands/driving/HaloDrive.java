package spectrum.frc3847.commands.driving;

import spectrum.frc3847.Dashboard;
import spectrum.frc3847.OI;
import spectrum.frc3847.Utilities;
import spectrum.frc3847.commands.CommandBase;

public class HaloDrive extends CommandBase {

	protected void initialize() {
		System.out.println("HaloDrive, GO!");
        drivebase.setHWheel(0);
		drivebase.liftHWheel();
		drivebase.getIMU().zeroYaw();
	}

	protected void execute() {
        double throttle = -Utilities.haloDeadBand(OI.gamepad.getLeftY(), OI.gamepad.getRightX(), .15, .17);
        double turn = -Utilities.haloDeadBand(OI.gamepad.getRightX(), OI.gamepad.getLeftY(), .15, .17);

        double scaled_throttle = Utilities.smartRamp(Dashboard.THROTTLE_RAMP_FUNCTION, throttle);
        double scaled_turn = Utilities.smartRamp(Dashboard.STEER_RAMP_FUNCTION, turn);
        
        drivebase.setArcade(scaled_throttle, scaled_turn);
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
