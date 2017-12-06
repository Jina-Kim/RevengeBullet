package clientSocket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSocketInputThread extends Thread {

	private Socket socket;
	private DataInputStream dis;

	public ClientSocketInputThread(Socket socket) {
		this.socket = socket;
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
