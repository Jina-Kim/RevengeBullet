package panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import frame.ImageCollection;
import frame.PanelManager;

public class ReadyPanel extends JPanel{
	
	public ReadyPanel(PanelManager panelManager){
		setLayout(null);
		setBackground(Color.white);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageCollection.INTRO_IMAGE.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
		setOpaque(false);
		
	}
}
