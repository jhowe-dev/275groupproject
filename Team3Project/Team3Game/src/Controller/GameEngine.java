package Controller;

import view.MainView;

public class GameEngine {
	
	public static void main(String[] args) {
		BossFight1Controller bf1 = new BossFight1Controller();
		FlyGameController flygame = new FlyGameController();
		SelectGameController plntGame = new SelectGameController();
		GridGameController ggame=new GridGameController();
		ScientistGameController sgame=new ScientistGameController();
		BossFight2Controller bf2 = new BossFight2Controller();
		
		//MainView frame = new MainView(bf1); 
		MainController con = new MainController(bf1, flygame, plntGame, sgame, ggame, bf2);
		MainView frame = con.frame;
		boolean finale = false;
		while(!finale){
//		try {
//			Thread.sleep(3000);
//			} 
//		catch (InterruptedException e) {
//			e.printStackTrace();
//			}
//		 frame.addMenu(flygame, plntGame, sgame);
//		if (con.flyStart) {
//			flygame.onTick();
//			//flygame = new FlyGameController();
//			con.flyStart = false;
//			frame.showMenu();
//		}
//		try {
//			Thread.sleep(3000);
//			} 
//		catch (InterruptedException e) {
//			e.printStackTrace();
//			}
//		if (frame.plantGameStart) {
//			plntGame.onTick();
//			frame.plantGameStart = false;
//			frame.showMenu();
//		}
//		try {
//			Thread.sleep(3000);
//			} 
//		catch (InterruptedException e) {
//			e.printStackTrace();
//			}
//		if (frame.gridGameStart) {
//			ggame.onTick();
//			frame.gridGameStart = false;
//			frame.showMenu();
//		}
//		try {
//			Thread.sleep(3000);
//			} 
//		catch (InterruptedException e) {
//			e.printStackTrace();
//			}
//		if (frame.scienceGameStart) {
//			sgame.onTick();
//			frame.scienceGameStart = false;
//			frame.showMenu();
//		}
//		try {
//			Thread.sleep(300);
//			} 
//		catch (InterruptedException e) {
//			e.printStackTrace();
//			}
		System.out.println("initiate bf2");
		if (frame.finalBossStart) {
			System.out.println("started");
			bf2.OnTick();
			frame.finalBossStart = false;
		}
		}
	}

}
