package spectrum.frc3847.driver;

import spectrum.frc3847.Utilities;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author JAG
 */
public class SpectrumDrive extends RobotDrive {

    public static double tSens = 1.5;
    public static final double DEADBAND_VALUE = .10;
    SpeedController motor5, motor6;

    public SpectrumDrive(SpeedController SpeedController_1, SpeedController SpeedController_2,
    		SpeedController SpeedController_3, SpeedController SpeedController_4) {
        super(SpeedController_1, SpeedController_2, SpeedController_3, SpeedController_4);
    }

    public SpectrumDrive(SpeedController motor1, SpeedController motor2, SpeedController motor3, 
    		SpeedController motor4, SpeedController motor5, SpeedController motor6) {
        super(motor1, motor2, motor3, motor4);
        this.motor5 = motor5;
        this.motor6 = motor6;
    }

    /**
     * Provide tank steering using the stored robot configuration. This function
     * lets you directly provide joystick values from any source.
     *
     * @param leftValue The value of the left stick.
     * @param rightValue The value of the right stick.
     */
    public void tankDrive(double leftValue, double rightValue) {
        leftValue = limit(leftValue);
        rightValue = limit(rightValue);

        leftValue = Utilities.deadBand(leftValue, DEADBAND_VALUE);
        rightValue = Utilities.deadBand(rightValue, DEADBAND_VALUE);
        setLeftRightMotorOutputs(leftValue, rightValue);
    }

    // Cheesy Drive - Thanks to Austin Schuh and Teams 254/971. Yeah Buddy!
    // It would not be possible to control a fast drive without this
    public void Cheesydrive(double throttle, double wheel, boolean quickTurn) {

        double angular_power;
        double overPower;
        double sensitivity = tSens;
        double rPower;
        double lPower;

        if (quickTurn) {
            overPower = 1.0;
            sensitivity = 1.0;
            angular_power = wheel;
        } else {
            overPower = 0.0;
            angular_power = Math.abs(throttle) * wheel * sensitivity;
        }

        rPower = lPower = throttle;
        lPower += angular_power;
        rPower -= angular_power;

        if (lPower > 1.0) {
            rPower -= overPower * (lPower - 1.0);
            lPower = 1.0;
        } else if (rPower > 1.0) {
            lPower -= overPower * (rPower - 1.0);
            rPower = 1.0;
        } else if (lPower < -1.0) {
            rPower += overPower * (-1.0 - lPower);
            lPower = -1.0;
        } else if (rPower < -1.0) {
            lPower += overPower * (-1.0 - rPower);
            rPower = -1.0;
        }

        lPower = Utilities.deadBand(lPower, DEADBAND_VALUE);
        rPower = Utilities.deadBand(rPower, DEADBAND_VALUE);
        setLeftRightMotorOutputs(lPower, rPower);
    }

    public void setSensitivity(double sensitivity) {
        tSens = sensitivity;
    }

    /**
     * Arcade drive implements single stick driving. This function lets you
     * directly provide joystick values from any source.
     *
     * @param moveValue The value to use for forwards/backwards
     * @param rotateValue The value to use for the rotate right/left
     * @param squaredInputs If set, increases the sensitivity at low speeds
     */
    public void arcadeDrive(double moveValue, double rotateValue, boolean squaredInputs) {
        // local variables to hold the computed PWM values for the motors
        double leftMotorSpeed;
        double rightMotorSpeed;

        moveValue = limit(moveValue);
        rotateValue = limit(rotateValue);

        if (squaredInputs) {
            // cube the inputs (while preserving the sign) to increase fine control while permitting full power
            if (moveValue >= 0.0) {
                moveValue = (moveValue * moveValue * moveValue);
            } else {
                moveValue = (moveValue * moveValue * moveValue);
            }
            if (rotateValue >= 0.0) {
                rotateValue = (rotateValue * rotateValue * rotateValue);
            } else {
                rotateValue = (rotateValue * rotateValue * rotateValue);
            }
        }

        if (moveValue > 0.0) {
            if (rotateValue > 0.0) {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = Math.max(moveValue, rotateValue);
            } else {
                leftMotorSpeed = Math.max(moveValue, -rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            }
        } else {
            if (rotateValue > 0.0) {
                leftMotorSpeed = -Math.max(-moveValue, rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            } else {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
            }
        }
        leftMotorSpeed = Utilities.deadBand(leftMotorSpeed, DEADBAND_VALUE);
        rightMotorSpeed = Utilities.deadBand(rightMotorSpeed, DEADBAND_VALUE);
        setLeftRightMotorOutputs(leftMotorSpeed, rightMotorSpeed);
    }
}
