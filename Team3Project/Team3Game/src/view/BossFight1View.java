package view;

import Controller.BossFight1Controller;

public class BossFight1View extends View{
	public MonsterView boss = new MonsterView();
	public EmployeeHeroView hero = new EmployeeHeroView();
	
	//using this code for now even though it's bad
	public int imgw=BossFight1Controller.imgw;
	public int imgh=BossFight1Controller.imgh;
	public double hratio=BossFight1Controller.heightratio;
	public double wratio=BossFight1Controller.widthratio;
	
	Livesview livesView = new Livesview(1); //gotta make a health bar instead of this!
	
	public void render(){
		//TODO: finish this after the controller is done
	}
	
	public void updateLives(int i){//temporary
		livesView.setlive(i);
	}
}
