package hostSocket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;

import frame.PanelManager;

public class HostSocketInputThread extends Thread {

	private Socket socket;
	private DataInputStream dis;
	private PanelManager panelManager;
	
	public HostSocketInputThread(Socket socket, PanelManager panelManager) {
		this.socket = socket;
		this.panelManager = panelManager;
		try {
			dis = new DataInputStream(socket.getInputStream());
			String data = dis.readUTF();
			if(data.equals("client connected"))
				System.out.println("connection success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			try {
				String data = dis.readUTF();
				if(data.equals("ready")) {
					panelManager.getReadyPanel().enableStartBtn();
				} else if(data.contains("mouse")) {
					System.out.println(data);
					String[] str = data.split(" ");
					String[] mouseX = str[1].split(":");
					String[] mouseY = str[2].split(":");
					panelManager.getStagePanel().setMouseLabel(Integer.parseInt(mouseX[1]), Integer.parseInt(mouseY[1]));
				}
			} catch (IOException e) {
				e.getStackTrace();
				try {
					if(socket!=null&&socket.isConnected())
						socket.close();
				} catch (IOException e1) {
					e1.getStackTrace();
				}
			}
		}
	}

}
