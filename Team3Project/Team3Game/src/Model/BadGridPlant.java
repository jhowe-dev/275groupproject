package Model;

public class BadGridPlant extends GamePlant{
	private String name;
	private int x;
	private int y;
	
	public BadGridPlant(String n, int x, int y)
	{
		super(n, x, y, false);
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public String getName(){
		return name;
	}
	
	public void setX(int x){this.x = x;}
	public void setY(int y){this.y = y;}
	public void setName(String n){name = n;}
	
	public boolean getCanGrow()
	{
		return true;
	}
	
}
