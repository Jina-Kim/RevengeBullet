package Revenge_Bullet;

import javax.swing.*;

public class IntroPanel extends JPanel {

	//★제목★
	JButton gameStartButton = new JButton("gameStart");
	ImageIcon icon = new ImageIcon("image/Title.png");
	JLabel Title = new JLabel();
	///////////////////////////////////////////////////////
	
	//★움직이는 놈★
	JLabel walkingMan = new JLabel();
	IntroPanel introPanel = this;
	TitleMove titleMove = new TitleMove(introPanel, walkingMan);
	///////////////////////////////////////////////////////
	
	//★ 게임 시작 버튼 누르면 다른 패널로 변경
	Stage1 stage1Panel = new Stage1();
	///////////////////////////////////////////////////////

	//
	private MainFrame mainFrame;
	
	
	//★제목★
	public IntroPanel(MainFrame mainFrame) {

		this.mainFrame = mainFrame;
		
		setLayout(null);

		Title.setBounds(200, 100, 1000, 600);
		Title.setIcon(icon);

		//★버튼 누르면 다른 패널로 변경
		gameStartButton.setBounds(700, 500, 100, 50);
		add(gameStartButton);
		gameStartButton.addActionListener(e -> {
			//removeAll();
			//repaint();
			titleMove.interrupt();
			mainFrame.setContentPane(stage1Panel);
			mainFrame.revalidate();

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

		int MoveX = 0;/*X축 이동하는 놈*/ 

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
		}// run() 종료
	}// TitleMove() 종료
}//IntroPanel() 종료
