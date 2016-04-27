package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

import Model.Boss;
import Model.BossFight1;
import Model.EmployeeHero;
import view.BossFight1View;

public class BossFight1Controller {
	public BossFight1View view = new BossFight1View();
	public BossFight1 model = new BossFight1();
	private boolean clicked=false;
	
	//bad code starts right here
	public static int imgw=100;//these need to be phased out by like, the alpha
	public static int imgh=100;
	public static double screenwidth=1440;
	public static double screenheight=900;
	public static double widthratio=screenwidth/1440; //TODO: figure out why matt did this
	public static double heightratio=screenheight/900;
	
	public BossFight1Controller(){//constructor
		view.addMouseListener(addMouse1());
	}
	public void OnTick(){
		view.displayMessage("A trash monster appeared! It's your job to defend the estuary!");
		//TODO: pause then display next message
		while(model.hero.getHealth()!=0){
			while(!clicked){
				view.displayMessage("Click to attack!");
			}
			try{
				Thread.sleep(700);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			clicked = false;
			try {
				view.displayMessage("The monster responds!");
				//TODO: projectile animation
				model.hero.decrementHealth(100);
				view.BossAttacks(model.hero.getHealth());
				Thread.sleep(600);
				} 
			catch (InterruptedException e) {
				e.printStackTrace();
				}
		}
		view.displayMessage("You lost! You weren't strong enough to defeat the trash monster :( ");
	}
	public MouseListener addMouse1(){
		MouseListener ear = new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				clicked = true;
				//TODO: pause and wait for a click here
				model.boss.decrementHealth(5);
				view.HeroPunches(model.boss.getHealth());
			}
			@Override public void mouseEntered(MouseEvent e) {}@Override public void mouseExited(MouseEvent e) {}@Override public void mousePressed(MouseEvent e) {}@Override public void mouseReleased(MouseEvent e) {}
		};
		return ear;
	}
}
