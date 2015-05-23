package spectrum3847.commands.driving;

import spectrum3847.Dashboard;
import spectrum3847.OI;
import spectrum3847.Utilities;
import spectrum3847.commands.CommandBase;
import spectrum3847.driver.Gamepad;

public class HaloDrive extends CommandBase {
	
	public HaloDrive() {
		requires(drivebase);
	}

	protected void initialize() {
		System.out.println("HaloDrive, GO!");
	}

protected void execute() {
		
        double throttle = -Utilities.haloDeadBand(OI.gamepad.getLeftY(), OI.gamepad.getRightX(), .15, .17);
        double turn = -Utilities.haloDeadBand(OI.gamepad.getRightX(), OI.gamepad.getLeftY(), .15, .17);

        double scaled_throttle = Utilities.smartRamp(Dashboard.THROTTLE_RAMP_FUNCTION, throttle);
        double scaled_turn = Utilities.smartRamp(Dashboard.STEER_RAMP_FUNCTION, turn);
        double quickTurnTriggers = OI.gamepad.getOldTriggers();
        

		if(OI.gamepad.getButton(Gamepad.RIGHT_BUMPER)) {
			scaled_throttle *= 0.5;
			scaled_turn *= 0.5;
		}
        
        drivebase.setArcade(scaled_throttle, scaled_turn);
        
        if (quickTurnTriggers != 0) {
            drivebase.setCheesyDrive(0, quickTurnTriggers, true);
        }
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
        drivebase.setArcade(0, 0);
	}

	protected void interrupted() {
		end();
	}

}
