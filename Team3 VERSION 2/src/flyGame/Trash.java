package flyGame;

public class Trash extends general.Character {
	private int imageWidth = (int)(general.Game.IMAGEWIDTH * general.Game.WIDTHRATIO);
	private int imageHeight = (int)(general.Game.IMAGEHEIGHT * general.Game.HEIGHTRATIO);

	public Trash(int x, int y) {
		super(x, y);
	}
	
	public int getImgX() {
		return this.x + imageWidth;
	}
	
	public int getImgY() {
		return this.y + imageHeight;
	}
	
	
	public boolean isGrabbed(int mouseX, int mouseY) {
		return(x <= mouseX && mouseX <= getImgX() && y <= mouseY && mouseY <= getImgY());
	}

}
