package Model;

public class Boss extends Character{
	//stationary character
	private int health;

	public Boss(int x, int y) {
		super(x, y);
		this.health = 100;
	}
	public boolean isTouching (Projectile p){
		//TODO: fill this in
		return false;
	}
	public void decrementHealth(int decrement) {
		this.health -=decrement;
	}
	public int getHealth(){
		return health;
	}
}
