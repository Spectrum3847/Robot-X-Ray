package spectrum3847.subsystems;

import spectrum3847.Dashboard;
import spectrum3847.HW;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Collector extends Subsystem {
	private Talon leftCollector, rightCollector;
	
	public Collector(){
		leftCollector = new Talon(HW.LEFT_COLLECTOR);
		rightCollector = new Talon(HW.RIGHT_COLLECTOR);
	}

	public void setCollector(double x){
		leftCollector.set(-x);
		rightCollector.set(x);
	}
	
	public void collectionIn(){
		setCollector(SmartDashboard.getNumber(Dashboard.TOTE_COLLECTION, 0.6));
	}
	
	public void collectionOut(){
		setCollector(SmartDashboard.getNumber(Dashboard.TOTE_EJECTION, -1.0));
	}
	
    protected void initDefaultCommand() {
    }
}

