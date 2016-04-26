package Controller;

import view.MainView;

public class MainController {
	
	
	
	
	public static void main(String[] args) {
		FlyGameController flygame = new FlyGameController();
		SelectGameController plntGame = new SelectGameController();
		BossFight1Controller bf1 = new BossFight1Controller();
		MainView frame = new MainView(); 
		frame.addMenu(flygame, plntGame, bf1);
		frame.setVisible(true);
		bf1.OnTick();
		frame.repaint();
		frame.revalidate();
		
//		frame.dispose();
//		frame = new MainView();
//		frame.addMenu(flygame, plntGame, bf1);
//		frame.setVisible(true);
//		plntGame.onTick();

		
		//frame.showMenu();
		
	}
	

}
