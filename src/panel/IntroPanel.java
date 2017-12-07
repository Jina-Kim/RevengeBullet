package panel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import frame.*;
import hostSocket.Receiver;

public class IntroPanel extends JPanel {

	private JButton hostStartBtn = new JButton(ImageCollection.HOST_START_BTN_IMAGE);
	private JButton clientStartBtn = new JButton(ImageCollection.CLIENT_START_BTN_IMAGE);
	
	private JLabel man = new JLabel();
	private JLabel title = new JLabel();
	//Thread
	private ManMove manMoveThread = new ManMove();
	private TitleMoveDown titleMoveDownThread = new TitleMoveDown();
	
	// JFrame --> 1. IntroPanel
	public IntroPanel(PanelManager panelManager) {
		setLayout(null);
		
		// button clicked -> stage1 start
		hostStartBtn.setBounds(150, 340, 500, 60);
		hostStartBtn.setOpaque(false);
		hostStartBtn.setContentAreaFilled(false);
		hostStartBtn.setBorderPainted(false);
		hostStartBtn.setRolloverIcon(ImageCollection.HOST_START_BTN_CLICK_IMAGE);
		hostStartBtn.addActionListener(e -> {
			manMoveThread.interrupt();
			titleMoveDownThread.interrupt();
			Receiver receiver = new Receiver(panelManager);
			receiver.start();
			panelManager.setHostClient(1);
			panelManager.changePanel(PanelManager.READY_PANEL);
		});
		
		clientStartBtn.setBounds(180, 420, 500, 60);
		clientStartBtn.setOpaque(false);
		clientStartBtn.setContentAreaFilled(false);
		clientStartBtn.setBorderPainted(false);
		clientStartBtn.setRolloverIcon(ImageCollection.CLIENT_START_BTN_CLCK_IMAGE);
		clientStartBtn.addActionListener(e -> {
			manMoveThread.interrupt();
			titleMoveDownThread.interrupt();
			panelManager.setHostClient(2);
			panelManager.changePanel(PanelManager.CONNECT_PANEL);
		});
		
		add(man);
		add(title);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				titleMoveDownThread.interrupt();
				title.setBounds(50, 200, 800, 150);
				add(hostStartBtn);
				add(clientStartBtn);
				repaint();
			}
		});
		
		manMoveThread.start();
		titleMoveDownThread.start();	
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
						add(hostStartBtn);
						add(clientStartBtn);
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
