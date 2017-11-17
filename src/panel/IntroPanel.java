package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.*;

import frame.ImageCollection;
import frame.MainFrame;
import frame.PanelManager;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;

public class IntroPanel extends JPanel {

	// Title gameStart Button, TitleImage
	JButton gameStartButton = new JButton("gameStart");
	///////////////////////////////////////////////////////
	
	// Main Moving Thread image
	JLabel walkingMan = new JLabel();
	IntroPanel introPanel = this;
	TitleMove titleMove = new TitleMove(introPanel, walkingMan);
	///////////////////////////////////////////////////////

	// Title Moving Down Thread image
	JLabel title_moving_down = new JLabel();
	TitleDownMove titleDownMove = new TitleDownMove(introPanel, title_moving_down);
	///////////////////////////////////////////////////////

	// backGround Image
	JLabel title_back_ground = new JLabel();

	//
	private MainFrame mainFrame;
	//

	// Draw BackGround Image
	///////////////////////////////////////////////////////////////////
	ImageIcon icon = new ImageIcon("image/IntroPanel2.png");
	Image IntroPanel_Draw_BackGround_img = icon.getImage();
	

	public void paintComponent(Graphics g) {
		
		g.drawImage(IntroPanel_Draw_BackGround_img, 0, 0, this.getWidth(), this.getHeight(), this);
		super.paintComponent(g);
		setOpaque(false);
		
	}
	///////////////////////////////////////////////////////////////////

	// JFrame --> 1. IntroPanel
	public IntroPanel(PanelManager panelManager) {
		
		setLayout(null);

		// button clicked -> stage1 start
		gameStartButton.setBounds(700, 500, 100, 50);
		gameStartButton.addActionListener(e -> {
			titleMove.interrupt();
			panelManager.changePanel(PanelManager.STAGE1_PANEL);
		});
		//////////////////////////////////////////////////
		add(walkingMan);
		add(title_moving_down);

		titleMove.start();
		titleDownMove.start();

	}
	///////////////////////////////////////////////////////

	public class TitleMove extends Thread {

		IntroPanel panel;
		JLabel manLabel;

		int MoveX = 0;/* Moving X Position */

		public TitleMove(IntroPanel walkingMan, JLabel label) {
			panel = walkingMan;
			manLabel = label;
		}

		public void run() {
			try {
				while (true) {
					MoveX += 1;
					if ((MoveX % 2) == 1) {
						manLabel.setIcon(ImageCollection.man1_Title_walking1_Image);
						manLabel.setBounds(MoveX, 600, 150, 150);
					} else if (MoveX == 700) {
						break;
					} else {
						manLabel.setIcon(ImageCollection.man2_Title_walking2_Image);
						manLabel.setBounds(MoveX, 600, 150, 150);
					}
					Thread.sleep(1);
				}
				manLabel.setIcon(ImageCollection.shoot2_Collection_Image);
				Thread.sleep(500);
				manLabel.setIcon(ImageCollection.Title_fire_shoot_Collection_Image);
			} catch (InterruptedException e) {

			}
		}// run() end
	}// TitleMove() end

	public class TitleDownMove extends Thread {

		IntroPanel panel;
		JLabel label;

		int title_down_move = -400;

		public TitleDownMove(IntroPanel panel, JLabel label) {
			this.panel = panel;
			this.label = label;
		}

		public void run() {
			try {
				while (true) {

					panel.addMouseListener(new MyMouseListener(panel, label, titleDownMove, gameStartButton));

					title_down_move += 1;
					if (title_down_move == 100) {
						panel.add(gameStartButton);
						break;
					} else {
						label.setIcon(ImageCollection.Title_Collection_Image);
						label.setBounds(200, title_down_move, 1000, 600);
					}
					Thread.sleep(7);
				}
			} catch (Exception e) {

			}
		}
	}
}// IntroPanel() end
