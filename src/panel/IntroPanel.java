package panel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import frame.*;

public class IntroPanel extends JPanel {

	private JButton startBtn = new JButton(ImageCollection.START_BTN_IMAGE);
	private JLabel man = new JLabel();
	private JLabel title = new JLabel();
	//Thread
	private ManMove manMoveThread = new ManMove();
	private TitleMoveDown titleMoveDownThread = new TitleMoveDown();
	
	// JFrame --> 1. IntroPanel
	public IntroPanel(PanelManager panelManager) {
		setLayout(null);
		
		// button clicked -> stage1 start
		startBtn.setBounds(330, 400, 300, 50);
		startBtn.setOpaque(false);
		startBtn.setContentAreaFilled(false);
		startBtn.setBorderPainted(false);
		//startBtn.setPressedIcon(ImageIcon);
		startBtn.addActionListener(e -> {
			manMoveThread.interrupt();
			panelManager.changePanel(PanelManager.STAGE1_PANEL);
		});
		
		add(man);
		add(title);
		
		manMoveThread.start();
		titleMoveDownThread.start();
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//panel.addMouseListener(new MyMouseListener(panel, label, titleDownMove, startBtn));
				//if(arg0.getClickCount() == 1){
				titleMoveDownThread.interrupt();
				title.setBounds(50, 200, 800, 150);
				add(startBtn);
			}
		});
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageCollection.INTRO_IMAGE.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
		setOpaque(false);
		
	}
	
	public class ManMove extends Thread {

		int MoveX = 0;/* Moving X Position */
		
		public void run() {
			try {
				while (true) {
					MoveX += 1;
					if ((MoveX % 2) == 1) {
						man.setIcon(ImageCollection.ENEMY2_IMAGE);
						man.setBounds(MoveX, 500, 150, 150);
					} else if (MoveX == 430) {
						break;
					} else {
						//man.setIcon(ImageCollection.man2_Title_walking2_Image);
						man.setBounds(MoveX, 500, 150, 150);
					}
					Thread.sleep(1);
				}
				man.setIcon(ImageCollection.ENEMY3_IMAGE);
				Thread.sleep(500);
				//man.setIcon(ImageCollection.ENEMY4_IMAGE);
			} catch (InterruptedException e) {

			}
		}// run() end
	}// TitleMove() end

	public class TitleMoveDown extends Thread {

		int title_down_move = -100;

		public void run() {
			try {
				while (true) {
					title_down_move += 1;
					if (title_down_move == 200) {
						add(startBtn);
						break;
					} else {
						title.setIcon(ImageCollection.TITLE_IMAGE);
						title.setBounds(50, title_down_move, 800, 150);
					}
					Thread.sleep(7);
					repaint();
				}
			} catch (Exception e) {

			}
		}
	}//TitleDownMove() end
}// IntroPanel() end
