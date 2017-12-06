package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import clientSocket.ClientSocket;
import frame.ImageCollection;
import frame.PanelManager;
import hostSocket.HostSocketOuputThread;
import hostSocket.Receiver;

public class ReadyPanel extends JPanel {

	private JButton startBtn = new JButton(ImageCollection.GAME_START_BTN_IMAGE);
	private JButton readyBtn = new JButton(ImageCollection.READY_BTN_IMAGE);

	public ReadyPanel(PanelManager panelManager) {
		setLayout(null);
	}

	public void setButton() {
		if (PanelManager.hostClient == 1) {
			startBtn.setBounds(250, 450, 500, 60);
			startBtn.setOpaque(false);
			startBtn.setContentAreaFilled(false);
			startBtn.setBorderPainted(false);
			startBtn.setEnabled(false);
			startBtn.setRolloverIcon(ImageCollection.GAME_START_BTN_CLICK_IMAGE);
			startBtn.addActionListener(e -> {
				
			});
			add(startBtn);
		}
		else if(PanelManager.hostClient == 2) {
			readyBtn.setBounds(250, 450, 500, 60);
			readyBtn.setOpaque(false);
			readyBtn.setContentAreaFilled(false);
			readyBtn.setBorderPainted(false);
			readyBtn.setRolloverIcon(ImageCollection.READY_BTN_CLICK_IMAGE);
			readyBtn.addActionListener(e -> {
				ClientSocket.clientSocketOutputThread.send("ready");
			});
			add(readyBtn);
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageCollection.INTRO_IMAGE.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
		setOpaque(false);
	}

}
