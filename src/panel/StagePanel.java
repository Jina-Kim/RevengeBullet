package panel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

import clientSocket.ClientSocket;
import frame.ImageCollection;
import frame.PanelManager;
import hostSocket.Receiver;
import model.Enemy;

public class StagePanel extends JPanel {

	private JLabel mouseLabel = new JLabel();
	private int stageFlag = 1; // 1~6
	int i = 0;
	private ArrayList<ArrayList<Enemy>> stageEnemies = new ArrayList<ArrayList<Enemy>>();
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

	public StagePanel(PanelManager panelManager) {
		setLayout(null);
		setBackground(Color.white);
		// mouse label
		mouseLabel.setIcon(ImageCollection.TARGET2_IMAGE);
		mouseLabel.setBounds(0, 0, 50, 50);
		add(mouseLabel);

		addMouseListener(new MyAdapter());
		addMouseMotionListener(new MyAdapter());
	}

	public ArrayList<Enemy> getEnemies(){
		return enemies;
	}
	
	public void setEnemies(int stageFlag) {
		
		enemies.clear();
		enemies.add(new Enemy(100, 310, 200));
		enemies.add(new Enemy(600, 400, 200));
		for (int i = 0; i < enemies.size(); i++) {
			add(enemies.get(i));
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setOpaque(false);
		switch (stageFlag) {
		case 1:
			g.drawImage(ImageCollection.STAGE1_IMAGE.getImage(), 0, 0, getWidth(), getHeight(), this);
			if (i == 0)
				setEnemies(1);
			i++;
			break;
		case 2:
			g.drawImage(ImageCollection.STAGE1_IMAGE.getImage(), 0, 0, getWidth(), getHeight(), this);
			
			break;
		case 3:
			g.drawImage(ImageCollection.STAGE1_IMAGE.getImage(), 0, 0, getWidth(), getHeight(), this);
			
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		}

	}

	class MyAdapter extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			for (int i = 0; i < enemies.size(); i++) {
				if (enemies.get(i).getLocation().getX() - 25 < x && x < enemies.get(i).getLocation().getX() + 25) {
					String msg = "enemy " + i;
					if (PanelManager.hostClient == 1) {
						Receiver.hostSocketOuputThread.send(msg);
					} else if (PanelManager.hostClient == 2) {
						ClientSocket.clientSocketOutputThread.send(msg);
					}
					enemies.get(i).killThread();
				}
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			String msg = "mouse x:" + e.getX() + " y:" + e.getY();
			if (PanelManager.hostClient == 1) {
				Receiver.hostSocketOuputThread.send(msg);
			} else if (PanelManager.hostClient == 2) {
				ClientSocket.clientSocketOutputThread.send(msg);
			}
		}
	}

	public void setMouseLabel(int x, int y) {
		mouseLabel.setLocation(x, y);
	}

}
