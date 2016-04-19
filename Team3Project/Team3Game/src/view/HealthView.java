package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controller.SelectGameController;
public class HealthView extends JLabel{

	public HealthView(){
			setLayout(null);
			setBorder(new LineBorder(Color.GREEN, 5));
			setBackground(Color.GREEN);
			setBounds(0,0,400,100);
			setOpaque(true);
			setFont(new Font("TimesRoman", Font.PLAIN, 60));
	}


    }
