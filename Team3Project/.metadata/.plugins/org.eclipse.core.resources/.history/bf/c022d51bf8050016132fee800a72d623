package Model;

import java.util.Random;

import Controller.FlyGameController;

public class RedKnot extends Character {
	public int imgw=FlyGameController.imgw;
	public int imgh=FlyGameController.imgh;
	Random rand=new Random();
	boolean start=false;
	boolean up;
	int endpoint;
	public RedKnot(int x, int y) {
		super(x, y);
		endpoint=(int)((400)*FlyGameController.heightratio);
		// TODO Auto-generated constructor stub
	}
	public boolean istouching(Trash t){
		boolean ytestoutter=(t.gety()<=(y+imgh)||(t.gety()+t.imgh<=(y+imgh)));
		boolean ytestinner=(t.gety()>=y||(t.gety()+t.imgh)>=y);
		boolean xtestoutter=(t.getx()<=x+imgw||(t.getx()+t.imgw)<=x+imgw);
		boolean xtestinner=(t.getx()>=(x)||(t.getx()+t.imgw)>=(x));
		return(ytestinner&&xtestinner&&ytestoutter&&xtestoutter);
	}
	public void move(){
		if(!start){
			if(rand.nextInt(2)==1){
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
