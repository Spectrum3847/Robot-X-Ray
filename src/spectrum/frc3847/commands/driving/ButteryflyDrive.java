package spectrum.frc3847.commands.driving;

import java.math.BigDecimal;

import spectrum.frc3847.Dashboard;
import spectrum.frc3847.OI;
import spectrum.frc3847.Utilities;
import spectrum.frc3847.commands.CommandBase;
import spectrum.frc3847.driver.Gamepad;
import spectrum.frc3847.math.Expression;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/*
 * @author Matthew
 */
public class ButteryflyDrive extends CommandBase {

    public ButteryflyDrive() {
        requires(CommandBase.drivebase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Butteryflydrive, GO!");
        drivebase.setCheesySensetivity(SmartDashboard.getNumber(Dashboard.BUTTERY_SENSITIVITY, 0.674));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Expression exp = new Expression(SmartDashboard.getString(Dashboard.DRIVE_RAMP_FUNCTION));
        
        double throttle = -Utilities.haloDeadBand(OI.gamepad.getLeftY(), OI.gamepad.getRightX(), .15, .17);
        double wheel = Utilities.haloDeadBand(OI.gamepad.getRightX(), OI.gamepad.getLeftY(), .15, .17);
        boolean quickturn = OI.gamepad.getButton(Gamepad.RIGHT_CLICK);
        
        double joythrottle = -Utilities.haloDeadBand(OI.gamepad.getLeftY(), OI.gamepad.getRightX(), .15, .17);
        double joywheel = Utilities.haloDeadBand(OI.gamepad.getRightX(), OI.gamepad.getLeftY(), .15, .17);
        boolean joyquickturn = OI.auxstick.getRawButton(3);

        if(throttle == 0)
        	throttle = joythrottle;
        if(wheel == 0)
        	wheel = joywheel;
        if(!quickturn)
        	quickturn = joyquickturn;
        	
        double result = exp.with("x", BigDecimal.valueOf(throttle)).eval().doubleValue();
        double expthrottle = result; //Utilities.expMap(throttle);
        double quickTurnTriggers = OI.gamepad.getOldTriggers();

        if (quickTurnTriggers != 0) {
            wheel = -(quickTurnTriggers != 0 ? quickTurnTriggers : wheel);
        }
        drivebase.setCheesyDrive(expthrottle, wheel, quickturn);
        drivebase.setHWheel(quickTurnTriggers);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        drivebase.setArcade(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
