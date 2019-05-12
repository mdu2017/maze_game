package mazecopy;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BoardCopy extends JPanel implements ActionListener {

	private Timer timer;
	private MapCopy map;
	private PlayerCopy player;
	private Font font = new Font("Arial", Font.BOLD, 48);
	private boolean hasWon = false;
	private boolean isDead = false;
	private boolean hasStartLoc = false;
	private int moves, deaths, startR = 1, startC = 1;

	public BoardCopy() {

		moves = 0;
		deaths = 0;
		addKeyListener(new KeyListener());
		setFocusable(true);
		this.map = new MapCopy();
		this.player = new PlayerCopy();
		timer = new Timer(25, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (map.getTileSpot(player.getTileX(), player.getTileY())
				.equalsIgnoreCase("E")) {
			hasWon = true;
		}
		if (map.getTileSpot(player.getTileX(), player.getTileY())
				.equalsIgnoreCase("L")) {
			isDead = true;
		}
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);

		// pixels 25x25 for maps > 20x20
		/*
		 * if (!hasWon && MapCopy.getSize() > 20) {
		 * 
		 * for (int row = 0; row < MapCopy.getSize(); row++) { for (int col = 0;
		 * col < MapCopy.getSize(); col++) { if (map.getTileSpot(row,
		 * col).equalsIgnoreCase("X")) { g.drawImage(map.getWall(), row * 25,
		 * col * 25, this); } if (map.getTileSpot(row,
		 * col).equalsIgnoreCase("O")) { g.drawImage(map.getPath(), row * 25,
		 * col * 25, this); } if (map.getTileSpot(row,
		 * col).equalsIgnoreCase("E")) { g.drawImage(map.getExit(), row * 25,
		 * col * 25, this); } if (map.getTileSpot(row,
		 * col).equalsIgnoreCase("L")) { g.drawImage(map.getLava(), row * 25,
		 * col * 25, this); } if (map.getTileSpot(row,
		 * col).equalsIgnoreCase("S") ) { hasStartLoc = true; startR = row;
		 * startC = col; g.drawImage(map.getPath(), row * 25, col * 25, this); }
		 * } }
		 * 
		 * if (isDead) { if (hasStartLoc == false) { startR = 1; startC = 1; //
		 * if no S in text file } player.setTileX(startR);
		 * player.setTileY(startC); deaths++; hasStartLoc = false; isDead =
		 * false; }
		 * 
		 * if (moves == 0){ g.drawImage(player.getPlayer(), startR * 25, startC
		 * * 25, this); player.setTileX(startR); player.setTileY(startC); }
		 * 
		 * g.drawImage(player.getPlayer(), player.getTileX() * 25,
		 * player.getTileY() * 25, this); g.drawString("Moves: " + moves,
		 * MapCopy.getSize() * 25 + 60, 50); g.drawString("Deaths: " + deaths,
		 * MapCopy.getSize() * 25 + 60, 70);
		 * 
		 * }// last bracket of for loop
		 */

		if (!hasWon && map.getNumRows() <= 20 && map.getNumCols() <= 20) {
			for (int y = 0; y < map.getNumCols(); y++) {
				for (int x = 0; x < map.getNumRows(); x++) {
					if (map.getTileSpot(y, x).equalsIgnoreCase("X")) {
						g.drawImage(map.getWall(), y * 32, x * 32, this);						
					}
					if (map.getTileSpot(y, x).equalsIgnoreCase("O")) {
						g.drawImage(map.getPath(), y * 32, x * 32, this);
					}
					if (map.getTileSpot(y, x).equalsIgnoreCase("E")) {
						g.drawImage(map.getExit(), y * 32, x * 32, this);
					}
					if (map.getTileSpot(y, x).equalsIgnoreCase("L")) {
						g.drawImage(map.getLava(), y * 32, x * 32, this);
					}
					if (map.getTileSpot(y, x).equalsIgnoreCase("C")) {
						g.drawImage(map.getCoin(), y * 32, x * 32, this);
					}
					if (map.getTileSpot(y, x).equalsIgnoreCase("S")) {
						hasStartLoc = true;
						startR = y;
						startC = x;
						g.drawImage(map.getPath(), y * 32, x * 32, this);
					}
				}
			}

			if (isDead) {
				if (hasStartLoc == false) {
					startR = 1;
					startC = 1; // if no S in text file
				}
				player.setTileX(startR);
				player.setTileY(startC);
				deaths++;
				hasStartLoc = false;
				isDead = false;
			}

			if (moves == 0) {
				g.drawImage(player.getPlayer(), startR * 32, startC * 32, this);
				player.setTileX(startR);
				player.setTileY(startC);
			}

			g.drawImage(player.getPlayer(), player.getTileX() * 32,
					player.getTileY() * 32, this);
			g.drawString("Moves: " + moves, map.getNumCols() * 32 + 60, 50);
			g.drawString("Deaths: " + deaths, map.getNumCols() * 32 + 60, 70);

		}// last bracket of for loop

		if (hasWon) {
			g.setColor(Color.RED);
			g.setFont(font);
			g.drawString("YOU WIN!", 90, 50);
			g.setColor(Color.BLACK);
			g.drawString("SCORE: ", 25, 135);
			//System.out.println(map.print2DArray());
		}
	}

	public class KeyListener extends KeyAdapter {

		private boolean isPressed = false;

		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();

			if (key == KeyEvent.VK_UP) {
				if (!map.getTileSpot(player.getTileX(), player.getTileY() - 1)
						.equals("X")) {
					player.move(0, -1);
					if (player.getReadyToMove())
						moves++;
					player.setReadyToMove(false);
				}

			}

			if (key == KeyEvent.VK_DOWN) {
				if (!map.getTileSpot(player.getTileX(), player.getTileY() + 1)
						.equals("X")) {
					player.move(0, 1);
					if (player.getReadyToMove())
						moves++;
					player.setReadyToMove(false);
				}
			}

			if (key == KeyEvent.VK_LEFT) {
				if (!map.getTileSpot(player.getTileX() - 1, player.getTileY())
						.equals("X")) {
					player.move(-1, 0);
					if (player.getReadyToMove())
						moves++;
					player.setReadyToMove(false);
				}
			}

			if (key == KeyEvent.VK_RIGHT) {
				if (!map.getTileSpot(player.getTileX() + 1, player.getTileY())
						.equals("X")) {
					player.move(1, 0);
					if (player.getReadyToMove())
						moves++;
					player.setReadyToMove(false);
				}

			}
		}

		public void keyReleased(KeyEvent e) {

			switch (e.getKeyCode()) {

			case KeyEvent.VK_UP:
				player.setReadyToMove(true);
				break;

			case KeyEvent.VK_DOWN:
				player.setReadyToMove(true);
				break;

			case KeyEvent.VK_LEFT:
				player.setReadyToMove(true);
				break;

			case KeyEvent.VK_RIGHT:
				player.setReadyToMove(true);
				break;

			}

		}

		public boolean getIsPressed() {
			return isPressed;
		}

		public void keyTyped(KeyEvent e) {

		}
	}
}
