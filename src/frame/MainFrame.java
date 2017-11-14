package frame;

import java.awt.*;

import javax.swing.JFrame;

import panel.IntroPanel;

public class MainFrame extends JFrame{
	
	private Image img;
	private Cursor cursor;

	private PanelManager panelManager;
	
	public MainFrame(){
		super("Revenge Bullets");
		//cursor image setting
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("image/target2.png");
		Point point = new Point(0,0);
		cursor = tk.createCustomCursor(img, point, "reman");
		setCursor(cursor);
		
		setSize(1500, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		panelManager = new PanelManager(this);
		panelManager.changePanel(PanelManager.INTRO_PANEL);
		setVisible(true);
	}
}
