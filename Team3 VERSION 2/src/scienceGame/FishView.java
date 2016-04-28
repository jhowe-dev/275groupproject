package scienceGame;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.border.LineBorder;

import general.Game;


public class FishView extends JComponent {
	private volatile int x;
	private volatile int y;
	public double hratio= Game.HEIGHTRATIO;
	public double wratio= Game.WIDTHRATIO;
	public  FishView(int x, int y){
		this.x=x;
		this.y=y;
		setLayout(null);
		setBorder(new LineBorder(Color.ORANGE, 3));
		setBackground(Color.WHITE);
		setBounds(x, y, (int)(100*wratio), (int)(100*hratio));
		setOpaque(false);
	}

}
