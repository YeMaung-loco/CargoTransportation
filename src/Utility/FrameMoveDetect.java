package Utility;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FrameMoveDetect extends ComponentAdapter {
	public static int x;
	public static int y;
	   public void componentMoved(ComponentEvent e) {
	       x = e.getComponent().getX();
	       y = e.getComponent().getY();
	   }
	}
