/*
 * movecursor - an attempt to prevent the screenlock
 * Copyright (C) 2011, 2013  Niki W. Waibel
 * This file is part of movecursor.
 *
 * movecursor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * movecursor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with movecursor.  If not, see <http://www.gnu.org/licenses/>.
 */

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
