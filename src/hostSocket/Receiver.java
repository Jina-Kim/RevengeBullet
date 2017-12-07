package hostSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import frame.PanelManager;

public class Receiver extends Thread {

	private ServerSocket serverSocket;
	private Socket socket;
	private PanelManager panelManager;
	public static HostSocketInputThread hostSocketInputThread;
	public static HostSocketOuputThread hostSocketOuputThread;
	private int count = 0;

	public Receiver(PanelManager panelManager) {
		this.panelManager = panelManager;
	}

	synchronized void add() {
		count++;
	}

	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(22394);
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (true) {			
			try {
				if (count == 0) {
					socket = serverSocket.accept();
					serverSocket.close();
					add();
					hostSocketInputThread = new HostSocketInputThread(socket, panelManager);
					hostSocketOuputThread = new HostSocketOuputThread(socket);
					hostSocketInputThread.start();
					hostSocketOuputThread.start();
				}
				sleep(10);
				// else throw new IOException();
			} catch (Exception e) {
				System.out.println("" + e.getMessage());
				try {
					serverSocket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
