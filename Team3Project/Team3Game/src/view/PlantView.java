package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controller.SelectGameController;
public class PlantView extends JLabel{
	private double heightRatio = 1;
	private double widthRatio = 1;

	public PlantView(int x, int y){
			setLayout(null);
			setBorder(new LineBorder(Color.GREEN, 5));
			setBackground(Color.BLUE);
			setBounds(x,y, (int)(100*widthRatio), (int)(100*heightRatio));
			setOpaque(true);
			setLocation(x,y);
			setFont(new Font("TimesRoman", Font.PLAIN, 60));
	}


    }
