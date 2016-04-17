package view;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.border.LineBorder;

import Controller.FlyGameController;

public class Redknotview extends JComponent {
	private volatile int x;
	private volatile int y;
	public double hratio=FlyGameController.heightratio;
	public double wratio=FlyGameController.widthratio;
	public Redknotview(int x, int y){
		this.x=x;
		this.y=y;
		setLayout(null);
		setBorder(new LineBorder(Color.RED, 3));
		setBackground(Color.WHITE);
		setBounds((int)(100*wratio), (int)(225*hratio), (int)(100*wratio), (int)(100*hratio));
		setOpaque(false);
	}
	public void sety(int i){
		y=i;
		setLocation(x,y);
	}

}
