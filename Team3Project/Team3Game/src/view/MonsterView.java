package view;

import java.awt.Color;
import javax.swing.JComponent;

public class MonsterView extends JComponent{
	int x,y;
	int height, width;
	private String filename;
	MonsterView(String filename, int x, int y, int height, int width){
		this.filename=filename; this.x=x; this.y=y; this.height=height; this.width=width;
	}
	public void Attack(){
		
	}
}
