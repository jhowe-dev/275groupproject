package view;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.border.LineBorder;

import Controller.FlyGameController;

public class Riverview extends JComponent{
	private volatile int x;
	private volatile int y;
	public double hratio=FlyGameController.heightratio;
	public double wratio=FlyGameController.widthratio;

	
	public Riverview(){
		setLayout(null);
		setBorder(new LineBorder(Color.BLUE, 3));
		setBackground(Color.CYAN);
		setBounds((int)(-4*wratio), (int)(470*hratio), (int)(1445*wratio), (int)(400*hratio));
		setOpaque(true);

	}
}
