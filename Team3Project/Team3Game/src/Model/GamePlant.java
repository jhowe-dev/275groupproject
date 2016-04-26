package Model;

public class GamePlant {
	boolean good;
	int x;
	int y;
	String name;
	
	
	public GamePlant(String n, int x, int y, boolean g)
	{
		good = g;
		this.x = x;
		this.y = y;
		this.name = n;
	}
	public String getName(){return name;}
	public boolean getGood()
	{
		return good;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}

}
