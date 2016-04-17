package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controller.FlyGameController;

public class Livesview extends JLabel {
	public double hratio=FlyGameController.heightratio;
	public double wratio=FlyGameController.widthratio;
	public Livesview(int live){
		setLayout(null);
		setBorder(new LineBorder(Color.RED, 3));
		setBackground(Color.WHITE);
		setBounds((int)(600*wratio), (int)(700*hratio), (int)(200*wratio), (int)(100*hratio));
		setOpaque(false);
		setText(""+live);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		setFont(new Font("TimesRoman", Font.PLAIN, 60));
	    
	}
	
	public void setlive(int live){
		setText(""+live);
	}
}
