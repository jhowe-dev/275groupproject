package view;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.border.LineBorder;

import Controller.FlyGameController;

public class Trashcanview extends JComponent {
	public double hratio=FlyGameController.heightratio;
	public double wratio=FlyGameController.widthratio;
	public Trashcanview(){
		setLayout(null);
		setBorder(new LineBorder(Color.GREEN, 3));
		setBackground(Color.WHITE);
		setBounds((int)(50*wratio), (int)(650*hratio), (int)(150*wratio), (int)(200*hratio));
		setOpaque(false);
	}
}
