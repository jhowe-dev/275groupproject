package view;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.border.LineBorder;

public class Trashcanview extends JComponent {
	private volatile int x;
	private volatile int y;
	public Trashcanview(){
		this.x=x;
		this.y=y;
		setLayout(null);
		setBorder(new LineBorder(Color.GREEN, 3));
		setBackground(Color.WHITE);
		setBounds(50, 650, 150, 200);
		setOpaque(false);
	}
}
