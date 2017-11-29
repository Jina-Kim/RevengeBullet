package clientSocket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {

	private Socket socket;

	public ClientSocket() {
		try {
			socket = new Socket("127.0.0.1", 12312);
			ClientSocketOutputThread clientSocketOutputThread = new ClientSocketOutputThread(socket);
			clientSocketOutputThread.start();
			ClientSocketInputThread clientSocketInputThread = new ClientSocketInputThread(socket);
			clientSocketInputThread.start();
		} catch (IOException e) {
			System.out.println("new Socket error : " + e.getMessage());
		}
	}

	class ClientSocketOutputThread extends Thread {

		private Socket socket;
		private DataOutputStream dos;

		public ClientSocketOutputThread(Socket socket) {
			this.socket = socket;
			try {
				dos = new DataOutputStream(socket.getOutputStream());
				//String string = new String("안녕!!");
				dos.writeUTF(new String("안녕!!"));
			} catch (IOException e) {
				System.out.println("new Socket error : " + e.getMessage());
			}
		}

		public void run() {

		}
	}
}
