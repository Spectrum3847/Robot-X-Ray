package spectrum.frc3847;

import spectrum.frc3847.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * @author matthew
 */
public class Dashboard {

    static final boolean ENABLE_SPECTRUM_DASHBOARD = true;
    static final double SHORT_DELAY = .015;
    static final double LONG_DELAY = 2;
    
    static double shortOldTime = 0.0;
    static double longOldTime = 0.0;
    
    public static final String DRIVEBASE_PID_P = "Drivebase PID P";
    public static final String DRIVEBASE_PID_I = "Drivebase PID I";
    public static final String DRIVEBASE_PID_D = "Drivebase PID D";
    public static final String DRIVEBASE_PID_F = "Drivebase PID F";
    public static final String DRIVEBASE_PID_TOLERANCE = "Drivebase PID Tolerance";
    
    public static final String SQUARE_OFF_PID_ERROR = "Square Off PID Error";
    public static final String SQUARE_OFF_PID_LEFT_SENSOR = "Square Off Left Sensor";
    public static final String SQUARE_OFF_PID_RIGHT_SENSOR = "Square Off Right Sensor";
    public static final String SQUARE_OFF_PID_OUTPUT = "Square Off PID Output";
    
    public static final String LIFT_DOWN_MULTIPLIER = "Lift Down Multiplier";
	public static final String LIFT_DOWN_LIMIT = "Lift Down Limit";
	public static final String LIFT_UP_LIMIT = "Lift Up Limit";
	public static final String LIFT_RAMP_RATE = "Lift Ramp Rate";
    
    public static final String THROTTLE_RAMP_FUNCTION = "Throttle Ramp Function";
    public static final String STEER_RAMP_FUNCTION = "Steer Ramp Function";
    public static final String STRAFE_RAMP_FUNCTION = "Strafe Ramp Function";
    public static final String COMPRESSOR = "Compressor";
    
    public static final String TOTE_COLLECTION = "Tote Collection Speed";
    public static final String TOTE_EJECTION = "Tote Ejection Speed";

    public static void intializeDashboard() {
        if (ENABLE_SPECTRUM_DASHBOARD) {
        	SmartDashboard.putBoolean(COMPRESSOR, true);
            SmartDashboard.putNumber(Dashboard.DRIVEBASE_PID_P, 0);
            SmartDashboard.putNumber(Dashboard.DRIVEBASE_PID_I, 0);
            SmartDashboard.putNumber(Dashboard.DRIVEBASE_PID_D, 0);
            SmartDashboard.putNumber(Dashboard.DRIVEBASE_PID_F, 0);
            SmartDashboard.putNumber(Dashboard.DRIVEBASE_PID_TOLERANCE, 5);
            
            SmartDashboard.putNumber(Dashboard.SQUARE_OFF_PID_ERROR, 0);
            SmartDashboard.putNumber(Dashboard.SQUARE_OFF_PID_LEFT_SENSOR, 0);
            SmartDashboard.putNumber(Dashboard.SQUARE_OFF_PID_RIGHT_SENSOR, 0);
            SmartDashboard.putNumber(Dashboard.SQUARE_OFF_PID_OUTPUT, 0);
            
            SmartDashboard.putNumber(LIFT_DOWN_MULTIPLIER, 0.25);
            SmartDashboard.putNumber(LIFT_DOWN_LIMIT, 731);
            SmartDashboard.putNumber(LIFT_UP_LIMIT, 900);
            SmartDashboard.putNumber(LIFT_RAMP_RATE, 8.00);
            
            SmartDashboard.putNumber(Dashboard.TOTE_COLLECTION, 0.3);
            SmartDashboard.putNumber(Dashboard.TOTE_EJECTION, -0.6);
            
            SmartDashboard.putString(THROTTLE_RAMP_FUNCTION, "0.75*x");
            SmartDashboard.putString(STEER_RAMP_FUNCTION, "0.75*x");
            SmartDashboard.putString(STRAFE_RAMP_FUNCTION, "0.75*x");
        }
    }

    private static void updatePut() {
    	SmartDashboard.putNumber("Lift Pot", CommandBase.lift.getPotValue());
    	SmartDashboard.putData("Lift Up Limit Switch", CommandBase.lift.getUpLim());

        if(CommandBase.drivebase.getIMU().isConnected())
        	SmartDashboard.putNumber("Yaw", CommandBase.drivebase.getIMU().getYaw());
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
