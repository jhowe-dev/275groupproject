package Controller;

import view.MainView;

public class GameEngine {
	
	public static void main(String[] args) {
		FlyGameController flygame = new FlyGameController();
		SelectGameController plntGame = new SelectGameController();
		BossFight1Controller bf1 = new BossFight1Controller();
		ScientistGameController sgame=new ScientistGameController();
		GridGameController ggame=new GridGameController();
	//	MainView frame = new MainView(bf1); 
		MainController con = new MainController(bf1, flygame, plntGame, sgame);
		MainView frame = con.frame;
		try {
			Thread.sleep(1000);
			} 
		catch (InterruptedException e) {
			e.printStackTrace();
			}
		//frame.addMenu(flygame, plntGame, sgame);
		if (con.flyStart) {
			flygame.onTick();
			frame.showMenu();
		}
	}

}
