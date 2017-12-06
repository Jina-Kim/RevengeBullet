package frame;

import java.awt.AWTException;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;

public class App {

	public static void main(String[] args) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Point point = new Point(0,0);
		Cursor cursor = tk.createCustomCursor(tk.getImage(ImageCollection.TARGET1_IMAGE), point, "reman");
		new MainFrame();
		//ClientSocket clientSocket = new ClientSocket();
		//HostSocket hostSocket = new HostSocket();
	}

}
