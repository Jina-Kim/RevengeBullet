package hostSocket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HostSocket{
	
	private ServerSocket serverSocket;
	private Socket socket;
	
	public HostSocket() {
		try {
			serverSocket = new ServerSocket(12312);
			Connection();
		} catch (IOException e) {
			System.out.println("new ServerSocket error : " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	private void Connection() {
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					socket = serverSocket.accept();
					HostSocketOuputThread hostSocketOuputThread = new HostSocketOuputThread(socket);
					hostSocketOuputThread.start();
					HostSocketInputThread hostSocketInputThread = new HostSocketInputThread(socket);
					hostSocketInputThread.start();
				} catch (IOException e) {
					System.out.println("serverSocket accept : " + e.getMessage());
					e.printStackTrace();
				}
			}
		});
		th.start();
	}
	
	class HostSocketOuputThread extends Thread{
		
		private Socket socket;
		private DataOutputStream dos;
		
		HostSocketOuputThread(Socket socket) {
			this.socket = socket;
			try {
				dos = new DataOutputStream(socket.getOutputStream());
				dos.writeUTF(new String("안녕?"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		@Override
		public void run() {
			
		}
		
	}

}
