package kiloboltgame;

public class Background {

	private int bgX, bgY, speedX;

	public Background(int x, int y) {

		bgX = x;
		bgY = y;
		speedX = 0; // speed of background moving
	}

	public void update() {

		bgX += speedX; // changes speed in the x direction

		if (bgX <= -2160) // if background isn't visible, move background
			bgX += 4320;

	}

	public int getBgX() {
		return bgX;
	}

	public int getBgY() {
		return bgY;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setBgX(int bgX) {
		this.bgX = bgX;
	}

	public void setBgY(int bgY) {
		this.bgY = bgY;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
}
