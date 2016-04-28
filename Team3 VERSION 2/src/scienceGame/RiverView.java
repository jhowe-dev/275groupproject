package scienceGame;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.border.LineBorder;

import general.Game;

public class RiverView extends JComponent {
	private volatile int x;
	private volatile int y;
	public double hratio= Game.HEIGHTRATIO;
	public double wratio= Game.WIDTHRATIO;

	
	public RiverView(){
		setLayout(null);
		setBorder(new LineBorder(Color.BLUE, 3));
		setBackground(Color.CYAN);
		setBounds((int)(-4*wratio), (int)(470*hratio), (int)(1445*wratio), (int)(400*hratio));
		setOpaque(true);

	}

}
