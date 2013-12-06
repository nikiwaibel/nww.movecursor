import java.awt.AWTException;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;

public final class MoveCursor {

private static final String NO_GRAPHICS = "This is a headless configuration.";
private static final String NO_GRAPHICS_NOW = "This has become a headless"
	+ " configuration.";
private static final String NO_PLATFORM_INPUT_CONTROL = "This platform does"
	+ " not allow low-level input control";
private static final String NO_PERMISSION = "There is no createRobot permission"
	+ " granted";
private static final String NO_PERMISSION_NOW = "There is no permission anymore"
	+ " to get the cursor information.";

public static void main(String args[]) {
	if (GraphicsEnvironment.isHeadless()) {
		System.err.println(NO_GRAPHICS);
		System.exit(1);
	}
	try {
		final Robot robot = new Robot();
		Point p;
		for (;;) {
			try {
				p = MouseInfo.getPointerInfo().getLocation();
				robot.mouseMove(p.x + 1, p.y + 1);
				robot.mouseMove(p.x, p.y);
			} catch (HeadlessException e) {
				System.err.println(NO_GRAPHICS_NOW);
				System.exit(1);
			} catch (SecurityException e) {
				System.err.println(NO_PERMISSION_NOW);
				System.exit(1);
			}
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}
	} catch (AWTException e) {
		System.err.println(NO_PLATFORM_INPUT_CONTROL);
		System.exit(1);
	} catch (SecurityException e) {
		System.err.println(NO_PERMISSION);
		System.exit(1);
	}
}

} // public clas MoveCursor
