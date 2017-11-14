package frame;

import panel.IntroPanel;
import panel.Stage1Panel;

public class PanelManager {
	
	public final static int INTRO_PANEL = 0;
	public final static int STAGE1_PANEL = 1;

	private MainFrame mainFrame;
	private IntroPanel introPanel;
	private Stage1Panel stage1Panel;
	
	public PanelManager(MainFrame mainFrame){
		this.mainFrame = mainFrame;
		this.introPanel = new IntroPanel(this);
		this.stage1Panel = new Stage1Panel(this);
	}
	
	public void changePanel(int panel){
		
		mainFrame.revalidate();
		
		switch(panel) {
			case INTRO_PANEL :{
				mainFrame.setContentPane(introPanel);
				break;
			}
			case STAGE1_PANEL :{
				mainFrame.setContentPane(stage1Panel);
				break;
			}
		}
	}
}
