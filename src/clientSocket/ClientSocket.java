package clientSocket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSocket {

	private Socket socket;
	private ClientSocketInputThread clientSocketInputThread;
	public static ClientSocketOutputThread clientSocketOutputThread;
	
	public ClientSocket(String IP) {
		try {
			socket = new Socket(IP, 22394);
			clientSocketInputThread = new ClientSocketInputThread(socket);
			clientSocketOutputThread = new ClientSocketOutputThread(socket);
			clientSocketInputThread.start();
			clientSocketOutputThread.start();
		} catch (IOException e) {
			System.out.println("new Socket error : " + e.getMessage());
			e.printStackTrace();
			try {
				if (socket != null)
					socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
