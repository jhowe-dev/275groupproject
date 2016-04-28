package scienceGame;

import java.util.Random;
import general.Game;




public class ScientistGame extends Game {
	RiverItem[][] river = new RiverItem[4][14];
	RiverItem[] fishmen = new RiverItem[12];
	private int time = 61;
	private int counter = 0;
	private int counterFishman = 0;
	private int counterFish = 0;
	private int counterTrash = 0;
	private int counterLiquid = 0;
	private boolean start = true;
	private boolean fishman = false;
	private boolean fish = false;
	private boolean trash = false;
	private boolean liquid = false;
	private Random rand = new Random();
	
	public ScientistGame() {
		score = 0;
	}
	
	public int getCounter() {
		return this.counter;
	}
	
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public void decrementCounter() {
		this.counter--;
	}
	
	public void incrementCounter() {
		this.counter++;
	}
	
	public RiverItem[] getFishmen() {
		return this.fishmen;
	}
	
	public void decrementTime() {
		this.time--;
	}
	
	public boolean getFish() {
		return this.fish;
	}
	
	public void setFish(boolean fish) {
		this.fish = fish;
	}
	
	public boolean getLiquid() {
		return this.liquid;
	}
	
	public void setLiquid(boolean liquid) {
		this.liquid = liquid;
	}

	
	public boolean getTrash() {
		return this.trash;
	}
	
	public void setTrash(boolean trash) {
		this.trash = trash;
	}
	
	public boolean getFishman() {
		return this.fishman;
	}
	
	public void setFishman(boolean fishman) {
		 this.fishman = fishman;
	}
	
	public RiverItem[][] getRiver() {
		return this.river;
	}
	
	public int getCounterTrash() {
		return this.counterTrash;
	}
	
	public int getCounterLiquid() {
		return this.counterLiquid;
	}
	
	public int getCounterFish() {
		return this.counterFish;
	}
	
	public void incrementCounterTrash() {
		this.counterTrash++;
	}
	
	public void incrementCounterLiquid() {
		this.counterLiquid++;
	}
	
	public void incrementCounterFish() {
		this.counterFish++;
	}
	
	public void addFishman(int x,int index){
		fishmen[index]=new RiverItem(x*100,320,3,index);
	}
	
	public void removeFishman(int index){
		fishmen[index]=null;
	}
	
	
	
	

}
