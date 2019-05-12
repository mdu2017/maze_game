package maze;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {

	private Timer timer;
	private Map map;
	private Player player;
	private Font font = new Font("Arial", Font.BOLD, 48);
	private boolean isDead = false, onCoin = false,
			hasKey = false, hasStartLoc = false, onButton = false;	
	private static boolean hasWon = false;
	private int moves, deaths, coins, score, startR = 1, startC = 1;
	private String keyStatus = "No";

	public Board() {

		moves = 0;
		deaths = 0;
		addKeyListener(new KeyListener());
		setFocusable(true);
		this.map = new Map();
		this.player = new Player();
		timer = new Timer(25, this);
		timer.start();
	}
	
	public static void setHasWon(boolean bool){//change if needed
		hasWon = bool;
	}
	public static boolean getHasWon()//change if needed
	{
		return hasWon;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (map.getTileSpot(player.getTileX(), player.getTileY())) {
		case "E":
			if (keyStatus.equals("Yes")) {
				hasWon = true;
			}
			break;
		case "A":
			isDead = true;
			break;
		case "C":
			onCoin = true;
			break;
		case "K":
			keyStatus = "Yes";
			hasKey = true;
			break;
		case "P":
			onButton = true;
			break;
		}

		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);

		// BIGGER MAP (uses smaller tiles) 25x25 pixels
		// *************************************************************
		if (!hasWon && map.getNumRows() > 20) {
			for (int y = 0; y < map.getNumCols(); y++) {
				for (int x = 0; x < map.getNumRows(); x++) {
					switch (map.getTileSpot(y, x)) {
					case "X":
						g.drawImage(map.getWall(), y * 60, x * 60, this);
						break;
					case "O":
						g.drawImage(map.getPath(), y * 60, x * 60, this);
						break;
					case "E":
						g.drawImage(map.getExit(), y * 60, x * 60, this);
						break;
					case "A":
						g.drawImage(map.getSpike(), y * 60, x * 60, this);
						break;
					case "C":
						g.drawImage(map.getCoin(), y * 60, x * 60, this);
						break;
					case "H":
						g.drawImage(map.getHiddenPath(), y * 60, x * 60, this);
						break;
					case "K":
						g.drawImage(map.getKey(), y * 60, x * 60, this);
						break;
					case "P":
						g.drawImage(map.getButton(), y * 60, x * 60, this);
						break;
					case "Q":
						if (onButton) {
							map.setTileSpot(y, x, "O");
						}
						g.drawImage(map.getSecretWall(), y * 60, x * 60, this);
						break;
					case "S":
						hasStartLoc = true;
						startR = y;
						startC = x;
						g.drawImage(map.getPath(), y * 60, x * 60, this);
						break;
					}
				}
			}

			if (isDead) {
				if (hasStartLoc == false) {
					startR = 1;
					startC = 1; // if no starting location in text file
					score -= 20;
				}
				player.setTileX(startR);
				player.setTileY(startC);
				deaths++;
				hasStartLoc = false;
				isDead = false;
				score -= 20;
			}
			if (onCoin) {
				map.setTileSpot(player.getTileX(), player.getTileY(), "O");
				coins++;
				onCoin = false;
			}
			if (hasKey) {
				map.setTileSpot(player.getTileX(), player.getTileY(), "O");
				hasKey = false;
			}
			if (onButton) {
				map.setTileSpot(player.getTileX(), player.getTileY(), "O");
				onButton = false;// check later
			}
			if (moves == 0) {
				g.drawImage(player.getPlayer(), startR * 60, startC * 60, this);
				player.setTileX(startR);
				player.setTileY(startC);
			}

			g.drawImage(player.getPlayer(), player.getTileX() * 60,  //draws player to map
					player.getTileY() * 60, this);
			g.setFont(font); //larger word size
			g.drawString("Moves: " + moves, map.getNumCols() * 60 + 60, 60);
			g.drawString("Deaths: " + deaths, map.getNumCols() * 60 + 60, 120);
			g.drawString("Coins: " + coins, map.getNumCols() * 60 + 60, 180);
			g.drawString("Has Key: " + keyStatus, map.getNumCols() * 60 + 60, 240);

		}
		// SMALLER MAP (tiles are bigger) 80x80 pixels
		// ***************************************************************
		if (!hasWon && map.getNumRows() <= 20) {
			for (int y = 0; y < map.getNumCols(); y++) {
				for (int x = 0; x < map.getNumRows(); x++) {
					switch (map.getTileSpot(y, x)) {
					case "X":
						g.drawImage(map.getWall(), y * 80, x * 80, this);
						break;
					case "O":
						g.drawImage(map.getPath(), y * 80, x * 80, this);
						break;
					case "E":
						g.drawImage(map.getExit(), y * 80, x * 80, this);
						break;
					case "A":
						g.drawImage(map.getSpike(), y * 80, x * 80, this);
						break;
					case "C":
						g.drawImage(map.getCoin(), y * 80, x * 80, this);
						break;
					case "H":
						g.drawImage(map.getHiddenPath(), y * 80, x * 80, this);
						break;
					case "K":
						g.drawImage(map.getKey(), y * 80, x * 80, this);
						break;
					case "P":
						g.drawImage(map.getButton(), y * 80, x * 80, this);
						break;
					case "Q":
						if (onButton) {
							map.setTileSpot(y, x, "O");
						}
						g.drawImage(map.getSecretWall(), y * 80, x * 80, this);
						break;
					case "S":
						hasStartLoc = true;
						startR = y;
						startC = x;
						g.drawImage(map.getPath(), y * 80, x * 80, this);
						break;
					}
				}
			}

			if (isDead) {
				if (hasStartLoc == false) {
					startR = 1;
					startC = 1; // if no S in text file
					score -= 20;
				}
				player.setTileX(startR);
				player.setTileY(startC);
				deaths++;
				hasStartLoc = false;
				isDead = false;
				score -= 20;
			}
			if (onCoin) {
				map.setTileSpot(player.getTileX(), player.getTileY(), "O");
				coins++;
				score += 10;
				onCoin = false;
			}
			if (hasKey) {
				map.setTileSpot(player.getTileX(), player.getTileY(), "O");
				hasKey = false;
			}
			if (onButton) {
				map.setTileSpot(player.getTileX(), player.getTileY(), "O");
				onButton = false;
			}
			if (moves == 0) {
				g.drawImage(player.getPlayer(), startR * 80, startC * 80, this);
				player.setTileX(startR);
				player.setTileY(startC);
			}

			g.drawImage(player.getPlayer(), player.getTileX() * 80,
					player.getTileY() * 80, this);
			g.setFont(font); //makes words larger
			g.drawString("Moves: " + moves, map.getNumCols() * 80 + 60, 60);
			g.drawString("Deaths: " + deaths, map.getNumCols() * 80 + 60, 120);
			g.drawString("Coins: " + coins, map.getNumCols() * 80 + 60, 180);
			g.drawString("Has Key: " + keyStatus, map.getNumCols() * 80 + 60, 240);

		}// last bracket of for loop

		if (hasWon && keyStatus.equals("Yes")) {
			g.setColor(Color.RED);
			g.setFont(font);
			g.drawString("YOU WIN!", 90, 50);
			g.setColor(Color.BLACK);
			g.drawString("SCORE: " + score, 25, 135);
		}
		
	}

	public class KeyListener extends KeyAdapter {

		private boolean isPressed = false;

		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();

			int x = player.getTileX();
			int y = player.getTileY();

			if (key == KeyEvent.VK_UP) {
				if (!(map.getTileSpot(x, y - 1).equals("X") || map.getTileSpot(
						x, y - 1).equals("Q"))) {
					player.setPlayer(Player.PLAYER_UP);
					player.move(0, -1);
					if (player.getReadyToMove())
						moves++;
					player.setReadyToMove(false);
				}

			}

			if (key == KeyEvent.VK_DOWN) {
				if (!(map.getTileSpot(x, y + 1).equals("X") || map.getTileSpot(
						x, y + 1).equals("Q"))) {
					player.setPlayer(Player.PLAYER_DOWN);
					player.move(0, 1);
					if (player.getReadyToMove())
						moves++;
					player.setReadyToMove(false);
				}
			}

			if (key == KeyEvent.VK_LEFT) {
				if (!(map.getTileSpot(x - 1, y).equals("X") || map.getTileSpot(
						x - 1, y).equals("Q"))) {
					player.setPlayer(Player.PLAYER_LEFT);
					player.move(-1, 0);
					if (player.getReadyToMove())
						moves++;
					player.setReadyToMove(false);
				}
			}

			if (key == KeyEvent.VK_RIGHT) {
				if (!(map.getTileSpot(x + 1, y).equals("X") || map.getTileSpot(
						x + 1, y).equals("Q"))) {
					player.setPlayer(Player.PLAYER_RIGHT);
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
