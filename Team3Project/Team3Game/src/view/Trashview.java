package view;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JComponent;

import Controller.FlyGameController;

public class Trashview extends JComponent {
	private volatile int x;
	private volatile int y;
	public double hratio=FlyGameController.heightratio;
	public double wratio=FlyGameController.widthratio;
	public Trashview(int x, int y){
		this.x=x;
		this.y=y;
		setLayout(null);
		setBorder(new LineBorder(Color.BLUE, 3));
		setBackground(Color.WHITE);
		setBounds(x, y, (int)(100*wratio), (int)(100*hratio));
		setOpaque(false);
	}
	public void setcoor(int xc, int yc){
		x=xc;
		y=yc;
		setLocation(x,y);
	}
}
