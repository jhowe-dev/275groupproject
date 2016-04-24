package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controller.BossFight1Controller;
import Controller.BossFight1Controller;

public class Caption extends JLabel {
	public double hratio=BossFight1Controller.heightratio;
	public double wratio=BossFight1Controller.widthratio;
	//to add text use jlabel method 'setText()'
	public Caption(int x, int y, int width, int height){
		setLayout(null);
		setBorder(new LineBorder(Color.RED, 3));
		setBackground(Color.WHITE);
		setBounds((int)(x*wratio), (int)(y*hratio), (int)(width*wratio), (int)(height*hratio));
		setOpaque(false);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		setFont(new Font("TimesRoman", Font.PLAIN, 60));
	}
}
