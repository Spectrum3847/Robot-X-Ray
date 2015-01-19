package spectrum.frc3847.commands.driving;

import spectrum.frc3847.Dashboard;
import spectrum.frc3847.OI;
import spectrum.frc3847.Utilities;
import spectrum.frc3847.commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/*
 * @author Matthew
 */
public class TriangleDrive extends CommandBase {

    public TriangleDrive() {
        requires(CommandBase.drivebase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Triangledrive, GO!");
        drivebase.setCheesySensetivity(SmartDashboard.getNumber(Dashboard.BUTTERY_SENSITIVITY, 0.674));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
        double r = -Utilities.haloDeadBand(OI.gamepad.getLeftY(), OI.gamepad.getRightX(), .15, .17);
        double x = OI.gamepad.getRightX();
        double y = OI.gamepad.getRightY();
        //double angle = Math.atan2(y, x);
        
        drivebase.setTank(y*Math.sqrt(3)/2 + x/2 + r, y*Math.sqrt(3)/2 - x/2 - r);
        drivebase.setHWheel(x - r);
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
