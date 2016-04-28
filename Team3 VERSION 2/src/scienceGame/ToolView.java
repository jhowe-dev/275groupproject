package scienceGame;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.border.LineBorder;

public class ToolView extends JComponent {
	private volatile int x;
	private volatile int y;
	public ToolView(int x, int y){
		this.x=x;
		this.y=y;
		setLayout(null);
		setBorder(new LineBorder(Color.BLUE, 3));
		setBackground(Color.WHITE);
		setBounds(x, y, 100, 100);
		setOpaque(false);
	}
	public void setCoor(int xc, int yc){
		x=xc;
		y=yc;
		setLocation(x,y);
	}

}
