package Model;

import java.util.Random;

import Controller.FlyGameController;

public class RedKnot extends Character {
	public int imgw=(int)(FlyGameController.imgw*FlyGameController.widthratio);
	public int imgh=(int)(FlyGameController.imgh*FlyGameController.heightratio);
	private Random rand=new Random();
	public boolean start=false;
	public boolean up;
	public int randstart;
	int endpoint;
	public RedKnot(int x, int y) {
		super(x, y);
		randstart=rand.nextInt(2);
		endpoint=(int)((400)*FlyGameController.heightratio);
		// TODO Auto-generated constructor stub
	}
	public boolean isTouching(Trash t){
		boolean ytestoutter=(t.gety()<=(y+imgh)||(t.getYAdjusted()<=(y+imgh)));
		boolean ytestinner=(t.gety()>=y||(t.getYAdjusted())>=y);
		boolean xtestoutter=(t.getx()<=x+imgw||(t.getXAdjusted())<=x+imgw);
		boolean xtestinner=(t.getx()>=(x)||(t.getXAdjusted())>=(x));
		return(ytestinner&&xtestinner&&ytestoutter&&xtestoutter);
	}
	public void move(){
		if(!start){
			if(randstart==1){
				up=true;
			}
			else{
				up=false;
			}
			start=true;
		}
		if(y<=0){
			up=false;
		}
		if(y>=endpoint){
			up=true;
		}
		if(up){
			y-=5;
		}
		else{
			y+=5;
		}
	}
	public int gety(){
		return y;
	}

}
