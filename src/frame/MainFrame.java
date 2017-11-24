package frame;

import java.awt.*;

import javax.swing.JFrame;

import panel.IntroPanel;

public class MainFrame extends JFrame{
	
	private Cursor cursor;
	private PanelManager panelManager;
	
	public MainFrame(){
		super("Revenge Bullets");
		//cursor image setting
		Toolkit tk = Toolkit.getDefaultToolkit();
		Point point = new Point(0,0);
		cursor = tk.createCustomCursor(tk.getImage(ImageCollection.TARGET1_IMAGE), point, "reman");
		setCursor(cursor);
		setSize(960, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		panelManager = new PanelManager(this);
		panelManager.changePanel(PanelManager.INTRO_PANEL);
		setVisible(true);
	}
}
