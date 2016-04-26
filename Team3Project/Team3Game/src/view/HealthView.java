package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controller.SelectGameController;
public class HealthView extends JLabel{

	public HealthView(int x, int y, int height, int width){
			setLayout(null);
			setBorder(new LineBorder(Color.GREEN, 5));
			setBackground(Color.GREEN);
			setBounds(x,y,height,width);
			setOpaque(true);
			setFont(new Font("TimesRoman", Font.PLAIN, 60));
			setText("100");
	}
	public void setHealth(int health){
		setText(""+health);
	}

    }
