package panel;

import java.awt.*;
import javax.swing.*;

import frame.ImageCollection;
import frame.PanelManager;

public class Stage1Panel extends JPanel{
	
	JLabel enemy1 = new JLabel();
	int stageFlag = 1;
	boolean enemy = true;
	
	public Stage1Panel(PanelManager panelManager){
		setLayout(null);
		setBackground(Color.white);
		//enemy test
		enemy1.setIcon(ImageCollection.ENEMY1_IMAGE);
		enemy1.setBounds(100, 100, 500, 500);
		add(enemy1);
	}
	public void setStateOneEmthyEnemy() {
		
	}
	public void setStateOneExistEnemy() {
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setOpaque(false);
		switch(stageFlag) {
		case 1:
			if(enemy) 
				setStateOneExistEnemy();
			else
				setStateOneEmthyEnemy();
			g.drawImage(ImageCollection.STAGE1_IMAGE.getImage(), 0, 0, getWidth(), getHeight(), this);			
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		}

	}
	
}
