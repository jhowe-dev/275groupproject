package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class viewtester {
	
	public static void main(String[] args) {
		JFrame frame=new JFrame("Fly Game");
    	frame.setLayout(null);
    	frame.setSize((int) 1440, (int) 900);
    	  //setExtendedState(JFrame.MAXIMIZED_BOTH); 
    	 // setUndecorated(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	ToolButtonView ticket=new ToolButtonView("Ticket",0,0);
    	ticket.setBackground(Color.RED);
    	ToolButtonView vile=new ToolButtonView("vile",1,0);
    	vile.setBackground(Color.MAGENTA);
    	ToolButtonView bin=new ToolButtonView("bin",0,1);
    	bin.setBackground(Color.GREEN);
    	ToolButtonView tag=new ToolButtonView("tag",1,1);
    	tag.setBackground(Color.ORANGE);
    	HorseshoeCrabView h=new HorseshoeCrabView(670,200);
    	ToolTableView t=new ToolTableView(520,0);
    	Riverview r=new Riverview();
    	frame.add(h);
    	frame.add(t);
		frame.add(ticket);
		frame.add(bin);
		frame.add(vile);
		frame.add(tag);
		frame.add(r);
    	frame.setVisible(true);
	}
}
