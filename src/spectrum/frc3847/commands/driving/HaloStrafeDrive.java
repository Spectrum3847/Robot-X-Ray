package spectrum.frc3847.commands.driving;

import spectrum.frc3847.Dashboard;
import spectrum.frc3847.OI;
import spectrum.frc3847.Utilities;
import spectrum.frc3847.commands.CommandBase;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class HaloStrafeDrive extends PIDCommand {
	private boolean IMUConnected;
	
	public HaloStrafeDrive() {
		super(0, 0, 0, 0.01);
	}

	protected void initialize() {
		System.out.println("HaloStrafe, GO!");
		CommandBase.drivebase.dropHWheel();
		IMUConnected = CommandBase.drivebase.getIMU().isConnected();
		if(IMUConnected) {
			CommandBase.drivebase.getIMU().zeroYaw();
			this.getPIDController().setOutputRange(-0.3, 0.3);
	        this.getPIDController().setSetpoint(0);
		}
	}

	protected void execute() {
		if(!IMUConnected) {
			this.getPIDController().disable();
	        double turn = -Utilities.haloDeadBand(OI.gamepad.getRightX(), OI.gamepad.getLeftY(), .15, .17);
	        double scaled_turn = Utilities.smartRamp(Dashboard.STEER_RAMP_FUNCTION, turn);
	        
	        CommandBase.drivebase.setArcade(0, scaled_turn);
		}
		else {
			this.getPIDController().enable();
			double p = SmartDashboard.getNumber(Dashboard.DRIVEBASE_PID_P, 0);
			double i = SmartDashboard.getNumber(Dashboard.DRIVEBASE_PID_I, 0)*0.001;
			double d = SmartDashboard.getNumber(Dashboard.DRIVEBASE_PID_D, 0);
			double t = SmartDashboard.getNumber(Dashboard.DRIVEBASE_PID_TOLERANCE, 0);
			
			this.getPIDController().setPID(p, i, d);
			this.getPIDController().setPercentTolerance(t);
		}
		
        double triggers = OI.gamepad.getOldTriggers();
        double scaled_triggers = Utilities.smartRamp(Dashboard.STRAFE_RAMP_FUNCTION, triggers);
        
        CommandBase.drivebase.setHWheel(scaled_triggers);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		CommandBase.drivebase.liftHWheel();
        CommandBase.drivebase.setArcade(0, 0);
	}

	protected void interrupted() {
		end();
	}

	@Override
	protected double returnPIDInput() {
		return CommandBase.drivebase.getIMU().getYaw();
	}

	@Override
	protected void usePIDOutput(double output) {
		double sign = Math.abs(returnPIDInput())/returnPIDInput();
		double f = sign*SmartDashboard.getNumber(Dashboard.DRIVEBASE_PID_F, 0);
        SmartDashboard.putNumber("PID output", f+output);
        CommandBase.drivebase.setArcade(0, output+f);
	}
}
