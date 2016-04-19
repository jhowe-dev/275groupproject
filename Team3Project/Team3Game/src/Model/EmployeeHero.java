package Model;

public class EmployeeHero extends Hero {
	public int health;

	public EmployeeHero(int x, int y) {
		super(x, y);
		this.health = 100;
	}
	public boolean isTouching (Projectile p){
		//TODO: fill this in
		return false;
	}
	public void decrementHealth() {
	}

}
