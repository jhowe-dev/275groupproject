package view;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;

public class MonsterView extends JComponent{
	int x,y;
	int height, width;
	private String filename;
	MonsterView(String filename, int x, int y, int height, int width){
		this.filename=filename; this.x=x; this.y=y; this.height=height; this.width=width;
		
		setLayout(null);
		setBorder(new LineBorder(Color.RED, 3));
		setBackground(Color.WHITE);
		setBounds(x,y,width,height);
		setOpaque(false);
		setToolTipText("Boss");
	}
	public void Attack(){
		
	}
}
