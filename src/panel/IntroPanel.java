package panel;

import javax.swing.*;

import frame.ImageCollection;
import frame.MainFrame;
import frame.PanelManager;


public class IntroPanel extends JPanel {
	


	//Title gameStart Button, TitleImage
	JButton gameStartButton = new JButton("gameStart");
	//ImageIcon icon = new ImageIcon("image/Title.png");
	JLabel Title = new JLabel();
	///////////////////////////////////////////////////////
	
	//Main Moving Thread image
	JLabel walkingMan = new JLabel();
	IntroPanel introPanel = this;
	TitleMove titleMove = new TitleMove(introPanel, walkingMan);
	///////////////////////////////////////////////////////
	
	//�� ���� ���� ��ư ������ �ٸ� �гη� ����
	//Stage1Panel stage1Panel = new Stage1Panel();
	///////////////////////////////////////////////////////

	//
	private MainFrame mainFrame;
	
	
	//JFrame --> 1. IntroPanel
	public IntroPanel(PanelManager panelManager) {

		//this.mainFrame = mainFrame;
		
		setLayout(null);

		Title.setBounds(200, 100, 1000, 600);
		Title.setIcon(ImageCollection.Title_Collection);

		//�ڹ�ư ������ �ٸ� �гη� ����
		gameStartButton.setBounds(700, 500, 100, 50);
		add(gameStartButton);
		gameStartButton.addActionListener(e -> {
			//removeAll();
			//repaint();
			titleMove.interrupt();
			panelManager.changePanel(PanelManager.STAGE1_PANEL);

		});
		//////////////////////////////////////////////////
		add(Title);
		add(walkingMan);

		titleMove.start();

	}
	///////////////////////////////////////////////////////

	public class TitleMove extends Thread {

		IntroPanel panel;
		JLabel manLabel;
		ImageIcon man1Icon = new ImageIcon("image/man1.png");
		ImageIcon man2Icon = new ImageIcon("image/man2.png");
		ImageIcon man3Icon = new ImageIcon("image/shoot2.png");

		int MoveX = 0;/* Moving X Position*/ 

		public TitleMove(IntroPanel walkingMan, JLabel label) {
			panel = walkingMan;
			manLabel = label;
		}

		public void run() {
			try {
				while (true) {
					MoveX += 1;
					if ((MoveX % 2) == 1) {
						manLabel.setIcon(man1Icon);
						manLabel.setBounds(MoveX, 100, 150, 150);
					}else if(MoveX == 700){
						break;
					}else {
						manLabel.setIcon(man2Icon);
						manLabel.setBounds(MoveX, 100, 150, 150);
					}
					panel.repaint();
					Thread.sleep(1);
				}
				manLabel.setIcon(man3Icon);
			} catch (InterruptedException e) {
				
			}
		}// run() end
	}// TitleMove() end
}//IntroPanel() end
