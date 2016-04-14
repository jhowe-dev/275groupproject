package view;

import java.awt.Color;



import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Clocker extends JLabel {
	public Clocker(int time){
		setLayout(null);
		setBorder(new LineBorder(Color.YELLOW, 3));
		setBackground(Color.WHITE);
		setBounds(1200, 650, 200, 200);
		setOpaque(false);
		setText(""+time);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		setFont(new Font("TimesRoman", Font.PLAIN, 60));
	    
	}
	
	public void settime(int time){
		setText(""+time);
	}
}
