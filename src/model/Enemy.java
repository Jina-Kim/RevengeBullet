package model;

import javax.swing.JLabel;

import frame.ImageCollection;

public class Enemy extends JLabel implements Runnable {

	private int startX;
	private int startY;
	private int movingX;
	private int direction = 0; // 0=right, 1=left
	private boolean alive = true;
	Thread thread;

	public Enemy(int startX, int startY, int movingX) {
		this.startX = startX;
		this.startY = startY;
		this.movingX = movingX;

		setIcon(ImageCollection.ENEMY1_IMAGE);
		setBounds(startX, startY, 70, 120);
		thread = new Thread(this);
		thread.start();
	}

	public void killThread() {
		setIcon(ImageCollection.ENEMY5_IMAGE);
		thread.interrupt();
	}

	public boolean isAlive() {
		return alive;
	}

	@Override
	public void run() {
		int x = 0;
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// e.printStackTrace();
				System.out.println("enemy killed");
				return;
			}
			x = (int) getLocation().getX();
			int space = (int) (x - startX);
			if (space > movingX) {
				direction = 1;
			} else if (space < 0) {
				direction = 0;
			}

			if (direction == 0) {
				x = x + 5;
			} else if (direction == 1) {
				x = x - 5;
			}
			setLocation(x, startY);
		}
	}
}
