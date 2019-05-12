package platformer;

import java.awt.Color;
import java.awt.Frame;
import javax.swing.JFrame;

public class StartClass 
{
	public static void main(String[] args)
	{
		new StartClass();
	}
	
	public StartClass()
	{
		JFrame frame = new JFrame();
		frame.setTitle("Platformer");		
		frame.setSize(1200, 635);
		frame.add(new Background());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
