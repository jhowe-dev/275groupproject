package view;

import java.awt.Color;



import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controller.FlyGameController;

public class Clocker extends JLabel {
	public double hratio=FlyGameController.heightratio;
	public double wratio=FlyGameController.widthratio;
	public Clocker(int time){
		setLayout(null);
		setBorder(new LineBorder(Color.YELLOW, 3));
		setBackground(Color.WHITE);
		setBounds((int)(1200*wratio), (int)(650*hratio), (int)(200*wratio), (int)(200*hratio));
		setOpaque(false);
		setText(""+time);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		setFont(new Font("TimesRoman", Font.PLAIN, 60));
	    
	}
	
	public void setTime(int time){
		setText(""+time);
	}
}
