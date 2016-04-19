package Model;

import Controller.FlyGameController;

public class TrashCan extends Character {
	public int imgw=(int)(150*FlyGameController.widthratio);
	public int imgh=(int)(200*FlyGameController.heightratio);
	public TrashCan(int x, int y) {
		super(x, y);
	}
	public boolean isEatingTrash(Trash trash){
		boolean ytestoutter=(trash.gety()<=(y+imgh)||(trash.getYAdjusted()<=(y+imgh)));
		boolean ytestinner=(trash.gety()>=y||(trash.getYAdjusted())>=y);
		boolean xtestoutter=(trash.getx()<=x+imgw||(trash.getXAdjusted())<=x+imgw);
		boolean xtestinner=(trash.getx()>=(x)||(trash.getXAdjusted())>=(x));
		return(ytestinner&&xtestinner&&ytestoutter&&xtestoutter);
	}

}
