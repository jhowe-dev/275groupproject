package Model;

import Controller.FlyGameController;

public class Trash extends Character {
	public int imgw=(int)(FlyGameController.imgw*FlyGameController.widthratio);
	public int imgh=(int)(FlyGameController.imgh*FlyGameController.heightratio);
	public Trash(int x, int y) {
		super(x, y);
	}
	public void setcoor(int x, int y){
		this.x=x;
		this.y=y;
	}
	public int getx(){
		return x;
	}
	public int gety(){
		return y;
	}
	public int getXAdjusted(){
		return x+imgw;
	}
	public int getYAdjusted(){
		return y+imgh;
	}
	public void move(){
		x-=10;
	}
	public boolean isGrabbed(int mouseX, int mouseY){
		return(x <= mouseX && mouseX <= getXAdjusted() && y <= mouseY && mouseY <= getYAdjusted());
	}
	
}
