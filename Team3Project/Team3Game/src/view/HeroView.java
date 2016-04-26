package view;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class HeroView extends JComponent{
	String filename;
	int x,y;
	int height, width;
	HeroView(String filename, int x, int y, int height, int width){
		this.filename=filename;this.x=x;this.y=y;this.height=height;this.width=width;
		
		setLayout(null);
		setBorder(new LineBorder(Color.RED, 3));
		setBackground(Color.WHITE);
		setBounds(x,y,width,height);
		setOpaque(false);
		setToolTipText("Hero");
	}
	public void Punch(){
		
	}
}
