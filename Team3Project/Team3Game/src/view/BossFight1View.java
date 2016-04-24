package view;

import Controller.BossFight1Controller;

public class BossFight1View extends View{
	public MonsterView bossView = new MonsterView("Employee image map filename here", 4, 5, 300, 300);
	public HeroView heroView = new HeroView("Employee image map filename here", 330, 450, 200, 200);
	public Caption caption = new Caption(700, 800, 200, 100);
	
	//using this code for now. might not be good java
	public int imgw=BossFight1Controller.imgw;
	public int imgh=BossFight1Controller.imgh;
	public double hratio=BossFight1Controller.heightratio;
	public double wratio=BossFight1Controller.widthratio;
	
	private boolean start = true;
	
	Livesview HeroLivesView = new Livesview(100); //TODO: gotta make a health bar instead of this!
	Livesview BossLivesView = new Livesview(100);
	
	public void render(){
		if(start){
			add(bossView);
			add(heroView);
			add(caption);
			add(HeroLivesView);
			add(BossLivesView);
			setSize((int)(1440*wratio), (int)(900*hratio));
	    	setVisible(true);
			start = false;
		}
		//TODO: will need to render the following:
			//hero doing shit
			//boss doing shit
			//if I'm not mistaken
	}
	public void HeroPunches(int newBossHealth){
		//decrement boss health
		BossLivesView.setlive(newBossHealth);
	}
	public void BossAttacks(int newHeroHealth){
		//decrement hero health
		HeroLivesView.setlive(newHeroHealth);
	}
	public void displayMessage(String message){
		caption.setText(message);
	}
}
