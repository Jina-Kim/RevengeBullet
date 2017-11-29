package clientSocket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSocketInputThread extends Thread {

	private Socket socket;
	private DataInputStream dis;

	public ClientSocketInputThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		//while (true) {
			try {
				dis = new DataInputStream(socket.getInputStream());
				System.out.println(dis.readUTF());
			} catch (IOException e) {
				e.printStackTrace();
			}
		//}
	}

}
