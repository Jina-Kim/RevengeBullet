package frame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import panel.IntroPanel;

import javax.swing.*;
import panel.IntroPanel.TitleDownMove;

public class MyMouseListener implements MouseListener {
	
	JPanel panel;
	JLabel label;
	JButton button;
	TitleDownMove titleDownMove;
	
	public MyMouseListener(JPanel panel, JLabel label, TitleDownMove titleDownMove, JButton gameStartButton) {
		this.button = gameStartButton;
		this.panel = panel;
		this.label = label;
		this.titleDownMove = titleDownMove;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getClickCount() == 1){
			titleDownMove.interrupt();
			label.setBounds(200, 100, 1000, 600);
			panel.add(button);
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
