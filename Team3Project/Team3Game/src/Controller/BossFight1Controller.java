package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.Boss;
import Model.EmployeeHero;
import view.BossFight1View;

public class BossFight1Controller {
	public BossFight1View view = new BossFight1View();
	public Boss boss = new Boss(4, 5);
	public EmployeeHero hero = new EmployeeHero(330, 450, 100);//will probably change all coordinates
	
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
		//I'm calling render() every time I change the caption, do I need to do this?
		boolean playersTurn = true;
		view.displayMessage("A trash monster appeared! It's your job to defend the estuary!");
		//TODO: pause then display next message
		while(hero.getHealth()!=0){
			if (playersTurn == true){
				view.displayMessage("Click to attack!");
				//TODO: pause and wait for a click here
				view.HeroPunches(boss.getHealth());
			}else{
				view.displayMessage("The monster responds!");
				//TODO: projectile animation
				hero.decrementHealth(25);
				view.BossAttacks(hero.getHealth());
			}
			playersTurn = !playersTurn;//switch turn
		}
		view.displayMessage("You lost! You weren't strong enough to defeat the trash monster :( ");
	}
	public MouseListener addMouse1(){
		MouseListener ear = new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//shoot something at the boss
				boss.decrementHealth(5);
				view.HeroPunches(boss.getHealth());
			}
			@Override public void mouseEntered(MouseEvent e) {}@Override public void mouseExited(MouseEvent e) {}@Override public void mousePressed(MouseEvent e) {}@Override public void mouseReleased(MouseEvent e) {}
		};
		return ear;
	}
	public static void main(String[] args){
		BossFight1Controller p=new BossFight1Controller();
		p.OnTick();
	}
}
