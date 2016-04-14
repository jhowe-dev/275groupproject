package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Livesview extends JLabel {
	public Livesview(int live){
		setLayout(null);
		setBorder(new LineBorder(Color.RED, 3));
		setBackground(Color.WHITE);
		setBounds(600, 700, 200, 100);
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
