package general;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Clocker extends JLabel {
	
	public Clocker(int time,int x, int y){
		setLayout(null);
		setBorder(new LineBorder(Color.YELLOW, 3));
		setBackground(Color.WHITE);
		setBounds((int)(x* Game.WIDTHRATIO), (int)(y* Game.HEIGHTRATIO), (int)(200* Game.WIDTHRATIO), (int)(200* Game.HEIGHTRATIO));
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
