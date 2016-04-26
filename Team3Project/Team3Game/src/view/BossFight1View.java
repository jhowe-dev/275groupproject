package view;

import Controller.BossFight1Controller;

public class BossFight1View extends View{
	public MonsterView bossView = new MonsterView("Employee image map filename here", 20, 20, 300, 300);
	public HeroView heroView = new HeroView("Employee image map filename here", 400, 100, 200, 200);
	public Caption caption = new Caption(20, 400, 800, 100);
	
	//using this code for now. might not be good java
	public int imgw=BossFight1Controller.imgw;
	public int imgh=BossFight1Controller.imgh;
	public double hratio=BossFight1Controller.heightratio;
	public double wratio=BossFight1Controller.widthratio;
	
	private boolean start = true;
	
	HealthView HeroLivesView = new HealthView(400, 600, 100, 100); //TODO: gotta make a health bar instead of this!
	HealthView BossLivesView = new HealthView(250, 600, 100, 100);
	
	public BossFight1View(){
		add(bossView);
		add(heroView);
		add(caption);
		add(HeroLivesView);
		add(BossLivesView);
		setSize((int)(1440*wratio), (int)(900*hratio));
    	setVisible(true);
	}
	
	public void HeroPunches(int newBossHealth){
		//decrement boss health
		BossLivesView.setHealth(newBossHealth);
	}
	public void BossAttacks(int newHeroHealth){
		//decrement hero health
		HeroLivesView.setHealth(newHeroHealth);
	}
	public void displayMessage(String message){
		caption.setText(message);
	}
}
