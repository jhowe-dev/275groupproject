package Controller;

import view.MainView;

public class MainController {
	
	
	
	
	public static void main(String[] args) {
		FlyGameController flygame = new FlyGameController();
		ScientistGameController scigame=new ScientistGameController();
		MainView frame = new MainView(); 
		frame.addMenu(scigame);
		scigame.onTick();
//		frame.showMenu();
	}
	

}
