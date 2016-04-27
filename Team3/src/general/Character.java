package general;

import java.awt.Point;

abstract public class Character {
	protected int x;
	protected int y;
	
	public Character(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void move() {
		this.x = this.x - 10;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Point getLoc() {
		return new Point(x, y);
	}
	
	public void setLoc(int x, int y) {
		this.x = x;
		this.y = y;
	}
	

}
