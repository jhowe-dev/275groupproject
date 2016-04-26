package Model;

public class EmployeeHero extends Hero {
	

	public EmployeeHero(int x, int y, int health) {
		super(x, y, health);
	}
	public void decrementHealth(int dec){
		super.decrementHealth(dec);
	}
}
