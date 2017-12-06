package clientSocket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JTextField;

import frame.PanelManager;

public class ClientSocket {

	private Socket socket;
	private ClientSocketInputThread clientSocketInputThread;
	public static ClientSocketOutputThread clientSocketOutputThread;
	
	public ClientSocket(PanelManager panelManager, JTextField IPtextField) {
		try {
			socket = new Socket(IPtextField.getText(), 22394);
			clientSocketInputThread = new ClientSocketInputThread(socket);
			clientSocketOutputThread = new ClientSocketOutputThread(socket);
			clientSocketInputThread.start();
			clientSocketOutputThread.start();
			panelManager.changePanel(PanelManager.READY_PANEL);
		} catch (IOException e) {
			System.out.println("new Socket error : " + e.getMessage());
			e.printStackTrace();
			try {
				if (socket != null) {
					IPtextField.setText("");
					socket.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
