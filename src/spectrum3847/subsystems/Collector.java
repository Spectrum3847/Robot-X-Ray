package spectrum3847.subsystems;

import spectrum3847.Dashboard;
import spectrum3847.HW;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Collector extends Subsystem {
	private Talon leftCollectorBottom, rightCollectorBottom;
	private Talon leftCollectorTop, rightCollectorTop;
	private DoubleSolenoid actuation;
	
	public Collector(){
		leftCollectorBottom = new Talon(HW.LEFT_COLLECTOR_BOTTOM);
		rightCollectorBottom = new Talon(HW.RIGHT_COLLECTOR_BOTTOM);
		leftCollectorTop = new Talon(HW.LEFT_COLLECTOR_TOP);
		rightCollectorTop = new Talon(HW.RIGHT_COLLECTOR_TOP);
		actuation = new DoubleSolenoid(HW.COLLECTORS_DS, HW.COLLECTORS_DS+1);
	}
	
	public void setActuation(boolean in){
		actuation.set(in?Value.kForward:Value.kReverse);
	}

	public void setCollectorBottom(double x){
		leftCollectorBottom.set(-x);
		rightCollectorBottom.set(x);
	}
	
	public void setCollectorTop(double x){
		leftCollectorTop.set(-x);
		rightCollectorTop.set(x);
	}

	public void collectionInTop(){
		setCollectorTop(SmartDashboard.getNumber(Dashboard.TOTE_TOP_COLLECTION, 1.0));
	}
	
	public void collectionInBottom(){
		setCollectorBottom(SmartDashboard.getNumber(Dashboard.TOTE_COLLECTION, 0.6));
	}
	
	public void collectionOutBottom(){
		setCollectorBottom(SmartDashboard.getNumber(Dashboard.TOTE_EJECTION, -1.0));
	}
	
    protected void initDefaultCommand() {
    }
}

