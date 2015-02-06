package spectrum.frc3847;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * @author matthew
 */
public class Dashboard {

    static final boolean ENABLE_SPECTRUM_DASHBOARD = true;
    static final double SHORT_DELAY = .015;
    static double shortOldTime = 0.0;
    static final double LONG_DELAY = 2;
    static double longOldTime = 0.0;
    
    public static String DRIVEBASE_PID_P = "Drivebase PID P";
    public static String DRIVEBASE_PID_I = "Drivebase PID I";
    public static String DRIVEBASE_PID_D = "Drivebase PID D";
    public static String DRIVEBASE_PID_TOLERANCE = "Drivebase PID Tolerance";
    
    public static String SQUARE_OFF_PID_ERROR = "Square Off PID Error";
    public static String SQUARE_OFF_PID_LEFT_SENSOR = "Square Off Left Sensor";
    public static String SQUARE_OFF_PID_RIGHT_SENSOR = "Square Off Right Sensor";
    public static String SQUARE_OFF_PID_OUTPUT = "Square Off PID Output";
    
    public static String LIFT_DOWN_MULTIPLIER = "Lift Down Multiplier";
    
    public static String THROTTLE_RAMP_FUNCTION = "Throttle Ramp Function";
    public static String STEER_RAMP_FUNCTION = "Steer Ramp Function";
    public static String STRAFE_RAMP_FUNCTION = "Strafe Ramp Function";
    
    public static String TOTE_COLLECTION = "Tote Collection Speed";

    public static void intializeDashboard() {
        if (ENABLE_SPECTRUM_DASHBOARD) {
            SmartDashboard.putNumber(Dashboard.DRIVEBASE_PID_P, 0);
            SmartDashboard.putNumber(Dashboard.DRIVEBASE_PID_I, 0);
            SmartDashboard.putNumber(Dashboard.DRIVEBASE_PID_D, 0);
            SmartDashboard.putNumber(Dashboard.DRIVEBASE_PID_TOLERANCE, 5);
            
            SmartDashboard.putNumber(Dashboard.SQUARE_OFF_PID_ERROR, 0);
            SmartDashboard.putNumber(Dashboard.SQUARE_OFF_PID_LEFT_SENSOR, 0);
            SmartDashboard.putNumber(Dashboard.SQUARE_OFF_PID_RIGHT_SENSOR, 0);
            SmartDashboard.putNumber(Dashboard.SQUARE_OFF_PID_OUTPUT, 0);
            
            SmartDashboard.putNumber(LIFT_DOWN_MULTIPLIER, 0.1);
            
            SmartDashboard.putNumber(Dashboard.TOTE_COLLECTION, 0.6);
            
            SmartDashboard.putString(THROTTLE_RAMP_FUNCTION, "0.1*x^9+0.3*x^5+0.1*x");
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
                //Thing that should be updated every LONG_DELAY
                longOldTime = Timer.getFPGATimestamp();
            }
        }
    }
}
