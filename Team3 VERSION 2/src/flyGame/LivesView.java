package flyGame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import general.Game;

public class LivesView extends JLabel {
	
	public LivesView(int live){
		setLayout(null);
		setBorder(new LineBorder(Color.RED, 3));
		setBackground(Color.WHITE);
		setBounds((int)(600* Game.WIDTHRATIO), (int)(700* Game.HEIGHTRATIO), (int)(200* Game.WIDTHRATIO), (int)(100* Game.HEIGHTRATIO));
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
