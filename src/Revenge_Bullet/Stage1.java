package Revenge_Bullet;

import java.awt.Color;

import javax.swing.*;

public class Stage1 extends JPanel{
	
	ImageIcon shooter = new ImageIcon("image/shoot2.png");
	JLabel label = new JLabel();
	
	
	public Stage1(){

		setLayout(null);
		setBackground(Color.yellow);
		
		label.setIcon(shooter);
		label.setBounds(100, 100, 500, 500);
		
		add(label);
		
	}
}
