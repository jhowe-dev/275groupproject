package Model;

public abstract class Hero extends Character{
	//mobile character in certain circumstances
	private int health;
	
	public Hero(int x, int y, int health){
		super(x, y);
		this.health = health;
	}
	public void decrementHealth(int decrement) {
		this.health = this.health - decrement;
	}
	public int getHealth(){
		return this.health;
	}

}
