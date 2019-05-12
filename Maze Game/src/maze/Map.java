package maze;

import java.util.*;
import java.io.*;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class Map {

	private Scanner in;
	private String[] tempArray;
	private String[][] tiles;
	private Image path, wall, exit, spike, coin, hiddenPath, key, button, secretWall;
	private int numRows, numCols;
	private ImageIcon image, image2, image3, image4, image5, image6, image7, image8;
	private static int rows;

	public Map() {

		openFile();
		readFile();// assigns numCols and numRows, fills tempArray
		closeFile();
		
		//TILES FOR SMALL MAP
		if (numRows <= 20) { 
			image = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//grass.png");
			image2 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//wall.png");
			image3 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//exit.png");
			image4 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//spikeTile.png");
			image5 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//coinTile.png");
			image6 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//keyTile.png");
			image7 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//switch.png");
			image8 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//secretTile.png");
		} else {
			image = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//grass2.png");
			image2 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//wall2.png");
			image3 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//exit2.png");
			image4 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//spikeTile2.png");
			image5 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//coinTile2.png");
			image6 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//keyTile2.png");
			image7 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//switch2.png");
			image8 = new ImageIcon(
					"C://Users//Mark//Documents//Comp Sci//EclipseJavaFiles//Maze Game//MazeGraphics//secretTile2.png");
		}

		path = image.getImage();
		wall = image2.getImage();
		exit = image3.getImage();
		spike = image4.getImage();
		coin = image5.getImage();
		hiddenPath = image2.getImage();
		key = image6.getImage();
		button = image7.getImage();
		secretWall = image8.getImage();

		fill2DArray();// breaks up temp array >> 2D array
		rows = numRows;
	}

	public Image getPath() {
		return path;
	}

	public Image getWall() {
		return wall;
	}

	public Image getExit() {
		return exit;
	}

	public Image getSpike() {
		return spike;
	}

	public Image getCoin() {
		return coin;
	}

	public Image getHiddenPath() {
		return hiddenPath;
	}

	public Image getKey() {
		return key;
	}
	
	public Image getButton(){
		return button;
	}
	
	public Image getSecretWall()
	{
		return secretWall;
	}
	public static int getRows(){
		return rows;
	}

	public void fill2DArray() {

		tiles = new String[numRows][numCols];

		for (int r = 0; r < tiles.length; r++) {

			for (int c = 0; c < tiles[0].length; c++) {
				tiles[r][c] = tempArray[r].substring(c, c + 1);
			}
		}
	}

	public String getTileSpot(int x, int y) {

		return tiles[y][x];

	}

	public void setTileSpot(int x, int y, String s) {

		tiles[y][x] = s;
	}

	public int getNumRows() {
		return numRows;
	}

	public int getNumCols() {
		return numCols;
	}

	public void openFile() {

		File openFile = null;
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			openFile = chooser.getSelectedFile();
		}

		try {
			in = new Scanner(openFile);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error loading map. Please try again.");
		}

	}

	public void readFile() {

		int count = 0;

		while (in.hasNextLine()) {
			if (count == 0) {
				count++;
				numRows = in.nextInt();
				in.nextLine();
				tempArray = new String[numRows];
			}

			for (int i = 0; i < numRows; i++)
				tempArray[i] = in.nextLine();
		}

		numCols = tempArray[0].length();

	}

	public void closeFile() {
		in.close();
	}
}
