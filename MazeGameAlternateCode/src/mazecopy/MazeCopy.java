package mazecopy;

import javax.swing.*;

public class MazeCopy {
	
	public static void main(String[] args) {

		new MazeCopy();
				
	}

	public MazeCopy() {
		
		JFrame frame = new JFrame();
		frame.setTitle("Rolling Maze");
		frame.add(new BoardCopy());
		frame.setSize(500, 500); // max size is 26 x 26
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
