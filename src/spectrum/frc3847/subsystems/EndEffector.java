package spectrum.frc3847.subsystems;

import spectrum.frc3847.Dashboard;
import spectrum.frc3847.HW;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class EndEffector extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private DoubleSolenoid fSolenoid;
	private Victor leftAlign, rightAlign;
	
	public EndEffector(){
		fSolenoid = new DoubleSolenoid(HW.ENDEFFECTOR_GRIP_DS,HW.ENDEFFECTOR_GRIP_DS+1);
		leftAlign = new Victor(HW.LEFT_COLLECTOR);
		rightAlign = new Victor(HW.RIGHT_COLLECTOR);
	}

	public void expand(){
		fSolenoid.set(Value.kForward);
	}
	
	public void close(){
		fSolenoid.set(Value.kReverse);
	}

	public void setCollection(double x){
		leftAlign.set(-x);
		rightAlign.set(x);
	}
	
	public void collectionIn(){
		setCollection(SmartDashboard.getNumber(Dashboard.TOTE_COLLECTION, 0.6));
	}
	
	public void collectionOut(){
		setCollection(SmartDashboard.getNumber(Dashboard.TOTE_COLLECTION, -1.0));
	}
    protected void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

