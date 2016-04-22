package Model;

public class RiverItem extends Character {
	int type;
	int index;
	int timer;
	public RiverItem(int x, int y,int type,int index) {
		super(x, y);
		this.type=type;
		this.index=index;
		timer=0;
		// TODO Auto-generated constructor stub
	}
	public int getTimer(){
		return timer;
	}
	public int getType(){
		return type;
	}
	public int getIndex(){
		return index;
	}
	public void tick(){
		timer++;
	}
}
