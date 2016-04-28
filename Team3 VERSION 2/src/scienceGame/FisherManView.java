package scienceGame;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.border.LineBorder;

import general.Game;


public class FisherManView extends JComponent {
	private volatile int x;
	private volatile int y;
	public double hratio= Game.HEIGHTRATIO;
	public double wratio= Game.WIDTHRATIO;
	public FisherManView(int x, int y){
		this.x=x;
		this.y=y;
		setLayout(null);
		setBorder(new LineBorder(Color.RED, 3));
		setBackground(Color.WHITE);
		setBounds((int)(x*wratio), (int)(y*hratio), (int)(100*wratio), (int)(150*hratio));
		setOpaque(false);
	}

}
