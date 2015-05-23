package spectrum3847.driver;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

public class PIDController2 {
	private double mP = 0;
	private double mI = 0;
	private double mD = 0;
	private double mF = 0;
	private double mPrevError = 0;
	private double mError = 0;
	private double mTotalError = 0;
	private double mDeltaError = 0;
	private double mIZone = 0;
	private double mPeriod = 20;
	private double mResult = 0;	
	private double mSetpoint = 0;
	private double mUpperBound = 1;
	private double mLowerBound = -1;
	private boolean mEnabled = false;
	private PIDSource mSource;
	private PIDOutput mOutput;

	public PIDController2(double Kp, double Ki, double Kd, double Kf,
			PIDSource source, PIDOutput output, double period, double izone) {
		mP = Kp;
		mI = Ki;
		mD = Kd;
		mF = Kf;
		mSource = source;
		mOutput = output;
		mPeriod = period;
		mIZone = izone;
	}
	
	public void calculate() {
		mError = mSetpoint - mSource.pidGet();
		mDeltaError = (mError - mPrevError);
		if(mIZone == 0 || Math.abs(mError) < mIZone) {
			mTotalError += mError;
		}
		
		if(mEnabled) {
			double pOut = mP*mError;
			double dOut = mD*mDeltaError;
			double fOut = mF*mSetpoint;
			double iOut = 0;
			if(mIZone == 0 || Math.abs(mTotalError) < mIZone) {
				iOut = mI*mTotalError;
			}
			
			mResult = pOut + iOut + dOut + fOut;
			
			mOutput.pidWrite(mResult);
				
		}
		
		mPrevError = mError;
	}
	
	
}
