package frame;

import panel.ConnectPanel;
import panel.IntroPanel;
import panel.ReadyPanel;
import panel.Stage1Panel;

public class PanelManager {
	
	public final static int INTRO_PANEL = 0;
	public final static int CONNECT_PANEL = 1;
	public final static int READY_PANEL = 2;
	public final static int STAGE1_PANEL = 3;
	
	public static int hostClient = 0; //1=host 2=client
	
	private MainFrame mainFrame;
	private IntroPanel introPanel;
	private ConnectPanel connectPanel;
	private ReadyPanel readyPanel;
	private Stage1Panel stage1Panel;
	
	public PanelManager(MainFrame mainFrame){
		this.mainFrame = mainFrame;
		this.introPanel = new IntroPanel(this);
		this.connectPanel = new ConnectPanel(this);
		this.readyPanel = new ReadyPanel(this);
		this.stage1Panel = new Stage1Panel(this);
	}
	
	public void setHostClient(int num) {
		hostClient = num;
	}
	
	public void changePanel(int panel){
		switch(panel) {
			case INTRO_PANEL : {
				mainFrame.setContentPane(introPanel);
				mainFrame.revalidate();
				break;
			}
			case CONNECT_PANEL : {
				mainFrame.setContentPane(connectPanel);
				mainFrame.revalidate();
				break;
			}
			case READY_PANEL : {
				readyPanel.setButton();
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
	
	public ReadyPanel getReadyPanel() {
		return readyPanel;
	}
	
}
