package hostSocket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class HostSocketInputThread extends Thread {

	private Socket socket;
	private DataInputStream dis;

	public HostSocketInputThread(Socket socket) {
		this.socket = socket;
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
				System.out.println(data);
				
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
