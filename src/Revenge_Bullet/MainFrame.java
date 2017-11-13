package Revenge_Bullet;

import java.awt.*;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	private Container contentPane = getContentPane();
	
	private Image img;
	private Cursor cursor;
	
	
	private MainFrame mainFrame = this;
	
	public MainFrame(){
		
		//★마우스 커서 설정★ 
		////////////////////////////////////////////////////////
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("image/target2.png");
		Point point = new Point(0,0);
		cursor = tk.createCustomCursor(img, point, "reman");
		setCursor(cursor);
		////////////////////////////////////////////////////////
		
		setTitle("Revenge Bullets");
		setSize(1500, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		setContentPane(new IntroPanel(mainFrame));
		
		setVisible(true);
		
	}
}
