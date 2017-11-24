package frame;

import panel.IntroPanel;
import panel.ReadyPanel;
import panel.Stage1Panel;

public class PanelManager {
	
	public final static int INTRO_PANEL = 0;
	public final static int STAGE1_PANEL = 1;
	public final static int READY_PANEL = 2;
	
	private MainFrame mainFrame;
	private IntroPanel introPanel;
	private ReadyPanel readyPanel;
	private Stage1Panel stage1Panel;
	
	public PanelManager(MainFrame mainFrame){
		this.mainFrame = mainFrame;
		this.introPanel = new IntroPanel(this);
		this.readyPanel = new ReadyPanel(this);
		this.stage1Panel = new Stage1Panel(this);
	}
	
	public void changePanel(int panel){
		switch(panel) {
			case INTRO_PANEL : {
				mainFrame.setContentPane(introPanel);
				mainFrame.revalidate();
				break;
			}
			case READY_PANEL : {
				mainFrame.setContentPane(readyPanel);
				mainFrame.revalidate();
				break;
			}
			case STAGE1_PANEL : {
				mainFrame.setContentPane(stage1Panel);
				mainFrame.revalidate();
				break;
			}
		}
	}
}
