package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

import frame.PanelManager;

public class Stage1Panel extends JPanel{
	
	ImageIcon shooter = new ImageIcon("image/shoot2.png");
	JLabel label = new JLabel();
	// Stage1 BackGround Image
	//////////////////////////////////////////////////////////////////////
	ImageIcon stage1BackGround = new ImageIcon("image/stage1BackGround.png");
	Image stage1BackGround_Image = stage1BackGround.getImage();
	
	public void paintComponant2(Graphics g){
		
		g.drawImage(stage1BackGround_Image, 240, 0, this.getWidth(), this.getHeight(), this);
		super.paintComponent(g);
		setOpaque(false);
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
