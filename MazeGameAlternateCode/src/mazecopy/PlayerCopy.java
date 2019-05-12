package mazecopy;

import java.awt.Image;
import javax.swing.ImageIcon;

public class PlayerCopy {

	private int x, y, tileX, tileY;
	private Image player;
	private boolean readyToMove = true;

	public PlayerCopy() {

		ImageIcon image = new ImageIcon(
				"C://Users//Real Admin//Documents//EclipseJavaFiles//Maze Game//MazeMaps//player2.png");
				
		player = image.getImage();

		
		x = 25;
		y = 25;

		tileX = 1;
		tileY = 1;
	}

	public Image getPlayer() {
		return player;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getTileX() {
		return tileX;
	}

	public int getTileY() {
		return tileY;
	}

	public void setTileX(int x) {
		tileX = x;
	}

	public void setTileY(int y) {
		tileY = y;
	}

	public void move(int dx, int dy) {
		if (readyToMove) {
			tileX += dx;
			tileY += dy;
		}
	}

	public boolean getReadyToMove() {
		return readyToMove;
	}

	public void setReadyToMove(boolean b) {
		readyToMove = b;
	}
}
