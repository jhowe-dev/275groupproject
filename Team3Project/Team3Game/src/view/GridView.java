package view;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.border.LineBorder;

public class GridView extends JComponent{
	public GridView(int x, int y){
		setLayout(null);
		setBorder(new LineBorder(new Color(153,76,0), 3));
		setBackground(Color.CYAN);
		setBounds((int)(x), (int)(y), (int)(150), (int)(150));
		setOpaque(true);

	}
}
