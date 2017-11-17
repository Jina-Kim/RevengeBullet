package panel;

import java.awt.Color;

import javax.swing.*;

import frame.PanelManager;

public class Stage1Panel extends JPanel{
	
	ImageIcon shooter = new ImageIcon("image/shoot2.png");
	JLabel label = new JLabel();
	
	
	public Stage1Panel(PanelManager panelManager){

		setLayout(null);
		setBackground(Color.white);
		
		label.setIcon(shooter);
		label.setBounds(100, 100, 500, 500);
		
		add(label);
		
	}
}
