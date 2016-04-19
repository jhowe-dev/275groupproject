package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ExitArrowView extends JLabel{
	public ExitArrowView(int x, int y){
		setLayout(null);
		setBorder(new LineBorder(Color.RED, 3));
		setBackground(Color.BLUE);
		setBounds(x,y, 150, 100);
		setOpaque(false);
		setLocation(x,y);
		setText("Exit");
		setFont(new Font("TimesRoman", Font.PLAIN, 60));
	}
}
