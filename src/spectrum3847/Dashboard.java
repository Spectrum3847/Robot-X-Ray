package spectrum3847;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * @author matthew
 */
public class Dashboard {

    static final boolean ENABLE_SPECTRUM_DASHBOARD = true;
    static final double SHORT_DELAY = .025;
    static final double LONG_DELAY = 2;
    
    static double shortOldTime = 0.0;
    static double longOldTime = 0.0;
    
    public static final String LIFT_DOWN_MULTIPLIER = "Lift Down Multiplier";
    public static final String LIFT_UP_MULTIPLIER = "Lift Up Multiplier";
	public static final String LIFT_DOWN_RAMP_RATE = "Lift Down Ramp Rate";
	public static final String LIFT_UP_RAMP_RATE = "Lift Up Ramp Rate";
    
    public static final String THROTTLE_RAMP_FUNCTION = "Throttle Ramp Function";
    public static final String STEER_RAMP_FUNCTION = "Steer Ramp Function";
    public static final String STRAFE_RAMP_FUNCTION = "Strafe Ramp Function";
    public static final String COMPRESSOR = "Compressor";
    
    public static final String TOTE_COLLECTION = "Tote Collection Speed";
    public static final String TOTE_EJECTION = "Tote Ejection Speed";
	public static final String AUTON_FORWARD_SPEED = "Auton Forward Speed";
	public static final String AUTON_DRIVE_FORWARD_TIME = "Auton Drive Forward Time";
	public static final String AUTON_DRIVE_DELAY_TIME = "Auton Delay Forward Time";

    public static void intializeDashboard() {
        if (ENABLE_SPECTRUM_DASHBOARD) {
        	SmartDashboard.putBoolean(COMPRESSOR, true);
            
            SmartDashboard.putNumber(LIFT_DOWN_MULTIPLIER, 0.25);
            SmartDashboard.putNumber(LIFT_UP_MULTIPLIER, 1);
            SmartDashboard.putNumber(LIFT_DOWN_RAMP_RATE, 8.00);
            SmartDashboard.putNumber(LIFT_UP_RAMP_RATE, 8.00);
            
            SmartDashboard.putNumber(Dashboard.TOTE_COLLECTION, 0.3);
            SmartDashboard.putNumber(Dashboard.TOTE_EJECTION, -0.6);

            SmartDashboard.putNumber(AUTON_FORWARD_SPEED, 1);
            SmartDashboard.putNumber(AUTON_DRIVE_DELAY_TIME, 1);
            SmartDashboard.putNumber(AUTON_DRIVE_FORWARD_TIME, 1);
            
            SmartDashboard.putString(THROTTLE_RAMP_FUNCTION, "x");
            SmartDashboard.putString(STEER_RAMP_FUNCTION, "x");
            SmartDashboard.putString(STRAFE_RAMP_FUNCTION, "x");
        }
    }

    private static void updatePut() {
    }

    public static void updateDashboard() {
        if (ENABLE_SPECTRUM_DASHBOARD) {
            if ((Timer.getFPGATimestamp() - shortOldTime) > SHORT_DELAY) {
                shortOldTime = Timer.getFPGATimestamp();
                updatePut();
            }
            if ((Timer.getFPGATimestamp() - longOldTime) > LONG_DELAY) {
                longOldTime = Timer.getFPGATimestamp();
            }
        }
    }
}
