package flyGame;

import java.util.Random;

import general.Game;

public class RedKnot extends general.Character {
	private int imageWidth = (int)(general.Game.IMAGEWIDTH * general.Game.WIDTHRATIO);
	private int imageHeight = (int)(general.Game.IMAGEHEIGHT * general.Game.HEIGHTRATIO);
	private int randomStart;
	private int endPoint;
	private boolean start = false;
	private Random rand = new Random();
	private boolean up;
	
	

	public RedKnot(int x, int y) {
		super(x, y);
		randomStart = rand.nextInt(2);
		endPoint = (int) (400 * Game.HEIGHTRATIO);
	}
	
	public boolean isTouching(Trash t){
		boolean ytestoutter=(t.getY()<=(y+imageHeight)||(t.getImgY()<=(y+imageHeight)));
		boolean ytestinner=(t.getY()>=y||(t.getImgY())>=y);
		boolean xtestoutter=(t.getX()<=x+imageWidth||(t.getImgX())<=x+imageWidth);
		boolean xtestinner=(t.getX()>=(x)||(t.getImgX())>=(x));
		return(ytestinner&&xtestinner&&ytestoutter&&xtestoutter);
	}
	public void move(){
		if(!start){
			if(randomStart==1){
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
		if(y>=endPoint){
			up=true;
		}
		if(up){
			y-=5;
		}
		else{
			y+=5;
		}
	}
	

}
