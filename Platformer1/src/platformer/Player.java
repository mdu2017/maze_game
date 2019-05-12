package platformer;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Player {

	private int x, y, xLength, xLength2;
	private Image player;

	public Player() {
		x = 75;		
		xLength = 1190;
		xLength2 = 0;
		y = 405;
		ImageIcon p1 = new ImageIcon(
				"C://Users//Real Admin//Documents//EclipseJavaFiles//Platformer1//robot.png");
		player = p1.getImage();

	}

	public void move(int dx) {
		x += dx;
		xLength += dx;
		xLength2 += dx;
	}

	public int getX() {
		return x;
	}
	
	public int getXLength(){
		return xLength;
	}
	
	public int getXLength2(){
		return xLength2;
	}
	
	public void setXLength(int val){
		xLength = val;
	}
	
	public void setXLength2(int val){
		xLength2 = val;
	}
	public void setX(int val){
		x = val;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int val){
		y = val;
	}
	
	public Image getPlayer(){
		return player;
	}
	
	
	
}
