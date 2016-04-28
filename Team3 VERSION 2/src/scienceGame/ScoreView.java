package scienceGame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import general.Game;


public class ScoreView extends JLabel {
	public double hratio= Game.HEIGHTRATIO;
	public double wratio= Game.WIDTHRATIO;
	public ScoreView(int score){
		setLayout(null);
		setBorder(new LineBorder(Color.RED, 3));
		setBackground(Color.WHITE);
		setBounds((int)(0*wratio), (int)(0*hratio), (int)(200*wratio), (int)(100*hratio));
		setOpaque(false);
		setText(""+score);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		setFont(new Font("TimesRoman", Font.PLAIN, 60));
	    
	}
	
	public void setScore(int score){
		setText(""+score);
	}

}
