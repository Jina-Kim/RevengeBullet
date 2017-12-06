package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import clientSocket.ClientSocket;
import frame.ImageCollection;
import frame.PanelManager;
import hostSocket.Receiver;

public class ReadyPanel extends JPanel implements MouseMotionListener {
	
	
	public ReadyPanel(PanelManager panelManager){
		setLayout(null);
		setBackground(Color.white);
		addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageCollection.INTRO_IMAGE.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
		setOpaque(false);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		String str = "X:"+e.getX()+" Y:"+e.getY();
		//System.out.println(str);
		//Receiver.hostSocketOuputThread.send("mouse:"+str);
		//if(PanelManager.hostClient==1)
			//Receiver.hostSocketOuputThread.send("mouse: "+str);
		if(PanelManager.hostClient==2)
			ClientSocket.clientSocketOutputThread.send("mouse: "+str);
	}
	
}
