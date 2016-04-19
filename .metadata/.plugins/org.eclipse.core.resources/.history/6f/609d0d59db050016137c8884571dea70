package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JComponent;

public class ToolView extends JComponent {
	private volatile int x;
	private volatile int y;
	public ToolView(int x, int y){
		this.x=x;
		this.y=y;
		setLayout(null);
		setBorder(new LineBorder(Color.BLUE, 3));
		setBackground(Color.WHITE);
		setBounds(x, y, 100, 100);
		setOpaque(false);
	}
	public void setcoor(int xc, int yc){
		x=xc;
		y=yc;
		setLocation(x,y);
	}
}
