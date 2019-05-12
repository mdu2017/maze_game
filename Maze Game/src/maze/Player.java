package maze;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Player {

	private int x, y, tileX, tileY;
	public static Image PLAYER_UP, PLAYER_DOWN, PLAYER_LEFT, PLAYER_RIGHT;
	private Image playerCurrent;
	private boolean readyToMove = true;
	private ImageIcon image, image2, image3, image4;

	public Player() {

		if (Map.getRows() <= 20) {
			image = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//robotUp.png");
			image2 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//robotDown.png");
			image3 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//robotLeft.png");
			image4 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//robotRight.png");
		} else {
			image = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//robotUp2.png");
			image2 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//robotDown2.png");
			image3 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//robotLeft2.png");
			image4 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//robotRight2.png");
		}

		PLAYER_UP = image.getImage();
		PLAYER_DOWN = image2.getImage();
		PLAYER_LEFT = image3.getImage();
		PLAYER_RIGHT = image4.getImage();

		playerCurrent = PLAYER_DOWN;

		x = 25;
		y = 25;

		tileX = 1;
		tileY = 1;
	}

	public Image getPlayer() {
		return playerCurrent;
	}

	public Image getPlayerUp() {
		return PLAYER_UP;
	}

	public Image getPlayerDown() {
		return PLAYER_DOWN;
	}

	public Image getPlayerRight() {
		return PLAYER_RIGHT;
	}

	public Image getPlayerLeft() {
		return PLAYER_LEFT;
	}

	public void setPlayer(Image image) {
		playerCurrent = image;
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
