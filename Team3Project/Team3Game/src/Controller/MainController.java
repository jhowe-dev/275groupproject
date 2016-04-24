package Controller;

import view.MainView;

public class MainController {
	
	
	
	
	public static void main(String[] args) {
		FlyGameController flygame = new FlyGameController();
		SelectGameController plntGame = new SelectGameController();
		MainView frame = new MainView(); 
		frame.addMenu(flygame, plntGame);
		frame.setVisible(true);
		flygame.onTick();
		
		frame.dispose();
		frame = new MainView();
		frame.addMenu(flygame, plntGame);
		frame.setVisible(true);
		plntGame.onTick();

		
		//frame.showMenu();
		
	}
	

}
