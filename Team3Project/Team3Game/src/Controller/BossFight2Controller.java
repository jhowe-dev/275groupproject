package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.Boss;
import Model.CaptainEstuary;
import view.BossFight2View;

public class BossFight2Controller {
	public BossFight2View view = new BossFight2View();
	public Boss boss = new Boss(4, 5);
	public CaptainEstuary hero = new CaptainEstuary(330, 450, 100);//will probably change all coordinates
	
	//bad code starts right here
	public static int imgw=100;//these need to be phased out by like, the alpha
	public static int imgh=100;
	public static double screenwidth=1440;
	public static double screenheight=900;
	public static double widthratio=screenwidth/1440; //TODO: figure out why matt did this
	public static double heightratio=screenheight/900;
	
	public BossFight2Controller(){//constructor
		view.render();
		view.addMouseListener(addMouse1());
	}
	public void OnTick(){
		//I'm calling render() every time I change the caption, do I need to do this?
		boolean playersTurn = true;
		view.displayMessage("A trash monster appeared! It's your job to defend the estuary!");
		view.render();
		//TODO: pause then display next message
		while(hero.getHealth()!=0){
			try {
				Thread.sleep(65);
				} 
			catch (InterruptedException e) {
				e.printStackTrace();
				}
			if (playersTurn == true){
				view.displayMessage("Click to attack!");
				view.render();
				//TODO: pause and wait for a click here
				//TODO: add water blast attack. need a different way to signal these
				view.HeroPunches(boss.getHealth());
				view.render();
			}else{
				view.displayMessage("The monster responds!");
				//TODO: projectile animation
				hero.decrementHealth(5);
				view.BossAttacks(hero.getHealth());
				view.render();
			}
			view.render();
			playersTurn = !playersTurn;//switch turn
		}
		view.displayMessage("You won! The estuary is saved! ");
		view.render();
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
