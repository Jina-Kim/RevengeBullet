package clientSocket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ClientSocketOutputThread extends Thread {

	private DataOutputStream dos;
	private BlockingQueue<String> dataQueue = new ArrayBlockingQueue<String>(50);

	public ClientSocketOutputThread(Socket socket) {
		try {
			dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF("client connected");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void send(String data) {
		// this.data = data;
		dataQueue.add(data);
		System.out.println(data);
	}

	public void run() {
		while (true) {
			try {
				dos.writeUTF(dataQueue.take());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
