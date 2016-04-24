package view;

import java.awt.Color;
import javax.swing.JComponent;

public class HeroView extends JComponent{
	String filename;
	int x,y;
	int height, width;
	HeroView(String filename, int x, int y, int height, int width){
		this.filename=filename;this.x=x;this.y=y;this.height=height;this.width=width;
	}
	public void Punch(){
		
	}
}
