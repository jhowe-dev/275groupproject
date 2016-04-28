package general;

import main.MainView;

import java.awt.Dimension;
import java.awt.Toolkit;
public class Game {
	private boolean isOver;
	private int health;
	protected int score;
	protected int time;
	private GameDifficulty difficulty;
	private boolean hasPlantFriend;
	private boolean hasBirdFriend;
	private boolean hasScienceFriend;
	private boolean paused;
	private boolean showingAnimation;
	static Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	public static final double SCREENWIDTH = d.getWidth(); 
	public static final double SCREENHEIGHT = d.getHeight();
	public static final double WIDTHRATIO = SCREENWIDTH / 1440;
	public static final double HEIGHTRATIO = SCREENHEIGHT / 900;
	
	public static final int IMAGEWIDTH = 100;
	public static final int IMAGEHEIGHT = 100;
	
	
	
	public Game() {
		this.isOver = false;
		this.health = 100;
		this.score = 0;
		this.difficulty = GameDifficulty.EASY;
		this.hasPlantFriend = false;
		this.hasBirdFriend = false;
		this.hasScienceFriend = false;
		this.paused = false;
		this.showingAnimation = false;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public void setTime(int t) {
		this.time = t;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void incrementScore() {
		this.score++;
	}
	
	public void decrementScore() {
		this.score--;
	}
}


