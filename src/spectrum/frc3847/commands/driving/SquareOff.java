package spectrum.frc3847.commands.driving;

import spectrum.frc3847.Dashboard;
import spectrum.frc3847.commands.CommandBase;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SquareOff extends PIDCommand {
	public SquareOff() {
		super(0, 0, 0);
		requires(CommandBase.drivebase);
	}

	@Override
	protected void initialize() {
		System.out.println("SquareOff, GO!");
		this.getPIDController().setPID(0, 0, 0);
		double Tolerance = SmartDashboard.getNumber(Dashboard.DRIVEBASE_PID_D);
		this.getPIDController().setPercentTolerance(Tolerance);
		this.getPIDController().setInputRange(0, 5);
		this.getPIDController().setOutputRange(-1, 1);
		returnPIDInput();
		this.getPIDController().enable();
	}

	@Override
	protected void execute() {
		double P = SmartDashboard.getNumber(Dashboard.DRIVEBASE_PID_P);
		double I = SmartDashboard.getNumber(Dashboard.DRIVEBASE_PID_I);
		double D = SmartDashboard.getNumber(Dashboard.DRIVEBASE_PID_D);
		double Tolerance = SmartDashboard.getNumber(Dashboard.DRIVEBASE_PID_D);
		this.getPIDController().setPercentTolerance(Tolerance);
		this.getPIDController().setPID(P, I, D);
		
		SmartDashboard.putNumber(Dashboard.SQUARE_OFF_PID_ERROR, this.getPIDController().getError());
		SmartDashboard.putNumber(Dashboard.SQUARE_OFF_PID_LEFT_SENSOR, CommandBase.drivebase.getLeftSharpDistance());
		SmartDashboard.putNumber(Dashboard.SQUARE_OFF_PID_RIGHT_SENSOR, CommandBase.drivebase.getRightSharpDistance());
	}

	@Override
	protected boolean isFinished() {
		System.out.println(this.getPIDController().onTarget() + "  " + this.getPIDController().getError());
		return this.getPIDController().onTarget();
	}

	@Override
	protected void end() {
		this.getPIDController().disable();
		System.out.println("SquareOff, DONE!");
		CommandBase.drivebase.setArcade(0, 0);
	}

	@Override
	protected void interrupted() {
		end();
	}

	@Override
	protected double returnPIDInput() {
		double left = CommandBase.drivebase.getLeftSharpDistance();
		double right = CommandBase.drivebase.getRightSharpDistance();
		double greater, lesser;
		if(left > right) {
			greater = left;
			lesser = right;
		}
		else {
			greater = right;
			lesser = left;
		}
		this.setSetpoint(lesser);
		return greater;
	}

	@Override
	protected void usePIDOutput(double output) {
		SmartDashboard.putNumber(Dashboard.SQUARE_OFF_PID_OUTPUT, output);
		double left = CommandBase.drivebase.getLeftSharpDistance();
		double right = CommandBase.drivebase.getRightSharpDistance();
		if(left < right) {
			CommandBase.drivebase.getDrive().setLeftRightMotorOutputs(output, -output);
		}
		else {
			CommandBase.drivebase.getDrive().setLeftRightMotorOutputs(-output, output);
		}
	}

}
