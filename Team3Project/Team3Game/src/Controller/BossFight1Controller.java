package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.Boss;
import Model.EmployeeHero;
import view.BossFight1View;

public class BossFight1Controller {
	public BossFight1View view = new BossFight1View();
	public Boss boss = new Boss(78, 39);
	public EmployeeHero hero = new EmployeeHero(200, 90);
	
	//bad code starts right here
	public static int imgw=100;//these need to be phased out by like, the alpha
	public static int imgh=100;
	public static double screenwidth=1440;
	public static double screenheight=900;
	public static double widthratio=screenwidth/1440; //TODO: figure out why matt did this
	public static double heightratio=screenheight/900;
	
	public BossFight1Controller(){
		//TODO: fill this in
	}
	public void OnTick(){
		//TODO: fill this in
	}
	public MouseListener addMouse1(){
		MouseListener ear = new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO: shoot something at the boss
			}
			@Override public void mouseEntered(MouseEvent e) {}
			@Override public void mouseExited(MouseEvent e) {}
			@Override public void mousePressed(MouseEvent e) {}
			@Override public void mouseReleased(MouseEvent e) {}
		};
		return ear;
	}
}
