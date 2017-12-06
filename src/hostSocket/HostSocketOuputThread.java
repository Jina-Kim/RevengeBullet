package hostSocket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class HostSocketOuputThread extends Thread{
	
	//private Socket socket;
	private DataOutputStream dos;
	private BlockingQueue<String> dataQueue = new ArrayBlockingQueue<String>(50);
	
	HostSocketOuputThread(Socket socket) {
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
	public void send(String data) {
		dataQueue.add(data);
		System.out.println(data);
	}
	
	@Override
	public void run() {
		while(true) {
				try {
					dos.writeUTF(dataQueue.take());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
}
