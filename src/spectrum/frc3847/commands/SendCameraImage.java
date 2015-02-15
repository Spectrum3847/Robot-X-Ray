package spectrum.frc3847.commands;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;

public class SendCameraImage extends CommandBase {
	private int session;
	private Image frame;
	private NIVision.Rect rect;

	public SendCameraImage() {

	}

	protected void initialize() {
		session = NIVision.IMAQdxOpenCamera("cam0",
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);

		NIVision.IMAQdxStartAcquisition(session);
		rect = new NIVision.Rect(10, 10, 100, 100);
	}

	@Override
	protected void execute() {
		NIVision.IMAQdxGrab(session, frame, 1);
        NIVision.imaqDrawShapeOnImage(frame, frame, rect,
                DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
        
        CameraServer.getInstance().setImage(frame);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		 NIVision.IMAQdxStopAcquisition(session);

	}

	protected void interrupted() {
		end();

	}

}
