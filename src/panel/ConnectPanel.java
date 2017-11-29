package panel;

import java.awt.Graphics;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import frame.ImageCollection;
import frame.PanelManager;

public class ConnectPanel extends JPanel{

	private JButton connectBtn = new JButton(ImageCollection.CONNECT_BTN_IMAGE);
	private JTextField IPtextField = new JTextField();
	
	public ConnectPanel(PanelManager panelManager) {
		setLayout(null);
		
		connectBtn.setBounds(250, 450, 500, 60);
		connectBtn.setOpaque(false);
		connectBtn.setContentAreaFilled(false);
		connectBtn.setBorderPainted(false);
		connectBtn.setPressedIcon(ImageCollection.CONNECT_BTN_CLICK_IMAGE);
		connectBtn.addActionListener(e -> {
			if(serverListening(IPtextField.getText()))
				panelManager.changePanel(PanelManager.READY_PANEL);
		});
		
		IPtextField.setBounds(250, 400, 500, 60);
		
		add(connectBtn);
		add(IPtextField);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageCollection.CONNECT_IMAGE.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
		setOpaque(false);
	}
	
	public boolean serverListening(String host)
	{
	    Socket s = null;
	    try
	    {
	        s = new Socket(host, 12312);
	        return true;
	    }
	    catch (Exception e)
	    {
	        return false;
	    }
	    finally
	    {
	        if(s != null)
	            try {s.close();}
	            catch(Exception e){}
	    }
	}
}
