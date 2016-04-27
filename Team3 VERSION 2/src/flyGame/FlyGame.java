package flyGame;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import general.Game;


public class FlyGame extends general.Game {
	private int lives;
	private int length = 0;
	private int time = 61;
	private ArrayList<Trash> trashList = new ArrayList<Trash>();
	private ArrayList<Integer> coordinateList=new ArrayList<Integer>();
	private RedKnot red=new RedKnot(100,(int)(225* Game.HEIGHTRATIO));
	private TrashCan trashCan = new TrashCan((int)(50* Game.WIDTHRATIO), (int)(650* Game.HEIGHTRATIO));
	private ArrayList<Boolean> notHeldList=new ArrayList<Boolean>();
	private boolean addTrash = false;
	
	public FlyGame() {
		this.lives = 7;
	}
	
	public ArrayList<Boolean> getNotHeldList() {
		return this.notHeldList;
	}
	
	public ArrayList<Trash> getTrashList() {
		return this.trashList;
	}
	
	public RedKnot getRedKnot() {
		return this.red;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public void increaseLength() {
		 this.length++;
	}
	
	public void decreaseLength() {
		this.length--;
	}
	
	public int getLives() {
		return this.lives;
	}
	
	public TrashCan getTrashCan() {
		return this.trashCan;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public void decreaseTime() {
		this.time--;
	}
	
	public boolean getAddTrash() {
		return this.addTrash;
	}
	
	public void setAddTrash(boolean b) {
		this.addTrash = b;
	}
	
	public ArrayList<Integer> getCoordinateList() {
		return this.coordinateList;
	}
	
	public void decreaseLives() {
		this.lives--;
	}

	
	public void addTrash(int y){
		
		trashList.add(new Trash((int)(1400* Game.WIDTHRATIO),(int)(200*y* Game.HEIGHTRATIO)));
		coordinateList.add((int)(1400* Game.WIDTHRATIO));
		notHeldList.add(true);
		addTrash=false;
		length++;
	}
	
	public void removeTrash(int index){
		trashList.remove(index);
		coordinateList.remove(index);
		notHeldList.remove(index);
		length--;
	}
	
	
	
}
