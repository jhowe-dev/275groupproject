package flyGame;

public class TrashCan extends general.Character {
	private int imageWidth = (int)(general.Game.IMAGEWIDTH * general.Game.WIDTHRATIO);
	private int imageHeight = (int)(general.Game.IMAGEHEIGHT * general.Game.HEIGHTRATIO);
	
	
	public TrashCan(int x, int y) {
		super(x, y);
	}
	
	public boolean isEatingTrash(Trash trash) {
		boolean ytestoutter=(trash.getY() <= (y+imageHeight)||(trash.getImgY()<=(y+imageHeight)));
		boolean ytestinner=(trash.getY() >= y||(trash.getImgY())>=y);
		boolean xtestoutter=(trash.getX()<=x+imageWidth||(trash.getImgX())<=x+imageWidth);
		boolean xtestinner=(trash.getX()>=(x)||(trash.getImgX())>=(x));
		return(ytestinner&&xtestinner&&ytestoutter&&xtestoutter);
	}
	

}
