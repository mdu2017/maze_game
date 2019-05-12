package mazecopy;

import java.util.*;
import java.io.*;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class MapCopy {

	private Scanner in;
	private String[] tempArray;
	private String[][] tiles;
	private Image path, wall, exit, lava, coin;
	private static int numRows, numCols;

	public MapCopy() {

		ImageIcon image = null;
		ImageIcon image2 = null;
		ImageIcon image3 = null;
		ImageIcon image4 = null;
		ImageIcon image5 = null;

		if (numRows <= 20) {
			image = new ImageIcon(
					"C://Users//Real Admin//Documents//EclipseJavaFiles//Maze Game//MazeMaps//grass.png");
			image2 = new ImageIcon(
					"C://Users//Real Admin//Documents//EclipseJavaFiles//Maze Game//MazeMaps//wall.png");
			image3 = new ImageIcon(
					"C://Users//Real Admin//Documents//EclipseJavaFiles//Maze Game//MazeMaps//exit.png");
			image4 = new ImageIcon(
					"C://Users//Real Admin//Documents//EclipseJavaFiles//Maze Game//MazeMaps//lava.png");
			image5 = new ImageIcon(
					"C://Users//Real Admin//Documents//EclipseJavaFiles//Maze Game//MazeMaps//coinTile.png");
		} else {
			image = new ImageIcon(
					"C://Users//Real Admin//Documents//EclipseJavaFiles//Maze Game//MazeMaps//grass2.png");
			image2 = new ImageIcon(
					"C://Users//Real Admin//Documents//EclipseJavaFiles//Maze Game//MazeMaps//wall2.png");
			image3 = new ImageIcon(
					"C://Users//Real Admin//Documents//EclipseJavaFiles//Maze Game//MazeMaps//exit2.png");
			image4 = new ImageIcon(
					"C://Users//Real Admin//Documents//EclipseJavaFiles//Maze Game//MazeMaps//lava2.png");
			image5 = new ImageIcon(
					"C://Users//Real Admin//Documents//EclipseJavaFiles//Maze Game//MazeMaps//coinTile2.png");
		}

		path = image.getImage();
		wall = image2.getImage();
		exit = image3.getImage();
		lava = image4.getImage();
		coin = image5.getImage();

		openFile();
		readFile();
		closeFile();

		transfer(tempArray);

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

	public Image getLava() {
		return lava;
	}

	public Image getCoin() {
		return coin;
	}

	public void transfer(String[] list) {

		tiles = new String[numRows][numCols];

		for (int r = 0; r < tiles.length; r++) {

			for (int c = 0; c < tiles[0].length; c++) {
				tiles[r][c] = list[r].substring(c, c + 1);
			}
		}
	}

	public String print2DArray() {

		transfer(tempArray);

		String s = "";

		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				s += tiles[i][j] + " ";
			}
			s += "\n";
		}

		return s;
	}

	public String getTileSpot(int x, int y) {

		return tiles[y][x];

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
