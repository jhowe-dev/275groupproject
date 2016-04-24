package Model;

public class BadGridPlant extends GamePlant{
	private String name;
	private int x;
	private int y;
	
	public BadGridPlant(String n, int x, int y)
	{
		super(false);
		name = n;
		this.x = x;
		this.y = y;
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
	
}
