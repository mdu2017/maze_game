package platformer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Background extends JPanel implements ActionListener {

	private Image background;
	private Player player;
	private Timer timer;

	public Background() {
		player = new Player();
		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon bg = new ImageIcon(
				"C://Users//Real Admin//Documents//EclipseJavaFiles//Platformer1//background.png");
		background = bg.getImage();
		timer = new Timer(5, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
	
		if (player.getX() == 380){
			player.setXLength2(0);
		}
		if (player.getX() == 1590){
			player.setXLength(0);
		}
		g.drawImage(background, 1190-player.getXLength(), 0, null);
		if (player.getX() >= 380){
			g.drawImage(background, 1190-player.getXLength2(), 0, null);
		}
		g.drawImage(player.getPlayer(), 100, player.getY(), null);
		
		
	}

	public class AL extends KeyAdapter {

		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();

			if (key == KeyEvent.VK_LEFT) {
				player.move(-25);
			}
			if (key == KeyEvent.VK_RIGHT) {
				player.move(25);
			}
		}

		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();

			/*if (key == KeyEvent.VK_LEFT) {
				player.move(0);
			}
			if (key == KeyEvent.VK_RIGHT) {
				player.move(0);
			}*/
		}
	}
}
