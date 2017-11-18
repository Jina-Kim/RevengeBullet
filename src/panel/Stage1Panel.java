package panel;

import java.awt.*;
import javax.swing.*;
import frame.PanelManager;

public class Stage1Panel extends JPanel{
	
	ImageIcon shooter = new ImageIcon("image/shoot2.png");
	JLabel label = new JLabel();
	
	// Stage1 BackGround Image
	//////////////////////////////////////////////////////////////////////
	ImageIcon stage1BackGround = new ImageIcon("image/stage1BackGround2.png");
	Image stage1BackGround_Image = stage1BackGround.getImage();
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		setOpaque(false);
		
		g.drawImage(stage1BackGround_Image, 0, 0, getWidth(), getHeight(), this);
	}
	//////////////////////////////////////////////////////////////////////
	
	public Stage1Panel(PanelManager panelManager){

		setLayout(null);
		setBackground(Color.white);
		
		label.setIcon(shooter);
		label.setBounds(100, 100, 500, 500);
	
		add(label);
	}
	
}
