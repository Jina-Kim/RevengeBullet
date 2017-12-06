package clientSocket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSocketInputThread extends Thread {

	private DataInputStream dis;

	public ClientSocketInputThread(Socket socket) {
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			try {
				System.out.println(dis.readUTF());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
