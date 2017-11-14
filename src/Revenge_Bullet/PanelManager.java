package Revenge_Bullet;

import javax.swing.JPanel;

public class PanelManager {
	private IntroPanel introPanel;
	private Stage1 stage1;
	private MainFrame mainFrame;
	
	public PanelManager(MainFrame mainFrame){
		this.mainFrame = mainFrame;
		
		//패널 다 생성
		
		introPanel = new IntroPanel(mainFrame);
		stage1 = new Stage1();
		mainFrame = new MainFrame();
	}
	
	public void changePanel(JPanel panel){
		mainFrame.setContentPane(panel);
		mainFrame.revalidate();
	}
}
