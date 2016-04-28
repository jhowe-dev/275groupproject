package scienceGame;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import general.Game;


public class ToolTableView extends JPanel {
	private volatile int x;
	private volatile int y;
	public double hratio = Game.HEIGHTRATIO;
	public double wratio = Game.WIDTHRATIO;

	
	public ToolTableView(int x, int y){
		this.x=x;
		this.y=y;
		setLayout(null);
		setBorder(new LineBorder(Color.ORANGE, 3));
		setBackground(Color.WHITE);
		setBounds((int)(x*wratio), (int)(y*hratio), (int)(400*wratio), (int)(200*hratio));
		setOpaque(false);

	}

}
