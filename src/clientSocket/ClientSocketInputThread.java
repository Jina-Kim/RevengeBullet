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
				}
			} catch (IOException e) {
				e.printStackTrace();
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
