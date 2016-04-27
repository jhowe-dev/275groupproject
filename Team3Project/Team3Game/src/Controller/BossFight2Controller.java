package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

import Model.Boss;
import Model.BossFight1;
import Model.BossFight2;
import Model.CaptainEstuary;
import Model.EmployeeHero;
import view.BossFight1View;
import view.BossFight2View;

public class BossFight2Controller {
	public BossFight2View view = new BossFight2View();
	public BossFight2 model = new BossFight2();
	private boolean clicked=false;
	private boolean yourTurn = true;
	
	//bad code starts right here
	public static int imgw=100;//these need to be phased out by like, the alpha
	public static int imgh=100;
	public static double screenwidth=1440;
	public static double screenheight=900;
	public static double widthratio=screenwidth/1440; //TODO: figure out why matt did this
	public static double heightratio=screenheight/900;
	
	public BossFight2Controller(){//constructor
		view.addMouseListener(addMouse1());
	}
	public void OnTick(){
		System.out.println("hi");
		view.displayMessage("A trash monster appeared! It's your job to defend the estuary!");
		//TODO: pause then display next message
		while(model.boss.getHealth()!=0){
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
				if(model.boss.getHealth()>0){
					view.displayMessage("The monster responds!");
					//TODO: projectile animation
					model.hero.decrementHealth(10);
					view.BossAttacks(model.hero.getHealth());
					yourTurn = true;
				}
				Thread.sleep(600);
				} 
			catch (InterruptedException e) {
				e.printStackTrace();
				}
		}
		view.displayMessage("You won! Great work, honorable DNREC Employee! ");
	}
	public MouseListener addMouse1(){
		MouseListener ear = new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(yourTurn){
					clicked = true;
					//TODO: pause and wait for a click here
					model.boss.decrementHealth(20);
					view.HeroPunches(model.boss.getHealth());
					yourTurn = false;
				}
			}
			@Override public void mouseEntered(MouseEvent e) {}@Override public void mouseExited(MouseEvent e) {}@Override public void mousePressed(MouseEvent e) {}@Override public void mouseReleased(MouseEvent e) {}
		};
		return ear;
	}
}
