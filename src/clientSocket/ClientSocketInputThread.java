package clientSocket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import frame.PanelManager;

public class ClientSocketInputThread extends Thread {

	private Socket socket;
	private DataInputStream dis;
	private PanelManager panelManager;

	public ClientSocketInputThread(Socket socket, PanelManager panelManager) {
		this.socket = socket;
		this.panelManager = panelManager;
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			try {
				String data = dis.readUTF();
				if(data.equals("start")) {
					panelManager.getReadyPanel().startGame();
				} else if(data.contains("mouse")) {
					//System.out.println(data);
					String[] str = data.split(" ");
					String[] mouseX = str[1].split(":");
					String[] mouseY = str[2].split(":");
					panelManager.getStagePanel().setMouseLabel(Integer.parseInt(mouseX[1]), Integer.parseInt(mouseY[1]));
				} else if(data.contains("enemy")) {
					String[] str = data.split(" ");
					panelManager.getStagePanel().getEnemies().get(Integer.parseInt(str[1])).killThread();
				}
			} catch (IOException e) {
				e.printStackTrace();
				try {
					if(socket!=null && socket.isConnected())
						socket.close();
				} catch (IOException e1) {
					e1.getStackTrace();
				}
			}
		}
	}

}
