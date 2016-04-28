package scienceGame;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.border.LineBorder;

import general.Game;


public class LiquidView extends JComponent {
	private volatile int x;
	private volatile int y;
	public double hratio= Game.HEIGHTRATIO;
	public double wratio= Game.WIDTHRATIO;
	public  LiquidView(int x, int y){
		this.x=x;
		this.y=y;
		setLayout(null);
		setBorder(new LineBorder(Color.MAGENTA, 3));
		setBackground(Color.WHITE);
		setBounds(x, y, (int)(100*wratio), (int)(100*hratio));
		setOpaque(false);
	}

}
