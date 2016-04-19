package Model;


public class Plant{
	private int imgHeight = 900; 
	private int imgWidth = 1440;
	private String message;
	private int x;
	private int y;
	private boolean bad;

	public Plant(int x, int y, String message, boolean bad){
		this.x = x;
		this.y = y;
		this.message = message;
	}
	//getters
	public boolean getBad()
	{
		return bad;
	}
	public int getX(){
		return this.x;	
	}
	public int getY(){
		return this.y;
	}
	public String getMessage(){
		return this.message;
	}
	//setters
	public void setX(int newX){
		this.x = newX;
	}
	public void setY(int newY){
		this.y = newY;
	}
	
	

}
