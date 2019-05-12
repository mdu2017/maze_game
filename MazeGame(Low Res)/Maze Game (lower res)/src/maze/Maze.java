package maze;

import javax.swing.*;

public class Maze {

	public static void main(String[] args) {

		new Maze();
	}

	public Maze() {

		JFrame frame = new JFrame();
		frame.setTitle("Labyrinth");
		frame.add(new Board());
		frame.setSize(1440, 1080); // max size is 26 x 26
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
