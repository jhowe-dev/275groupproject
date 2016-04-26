package Controller;

import view.MainView;

public class MainController {
	
	
	
	
	public static void main(String[] args) {
		FlyGameController flygame = new FlyGameController();
		SelectGameController plntGame = new SelectGameController();
		BossFight1Controller bf1 = new BossFight1Controller();
		ScientistGameController sgame=new ScientistGameController();
		GridGameController ggame=new GridGameController();
		MainView frame = new MainView(bf1); 
		frame.addMenu(flygame, plntGame, sgame);
		frame.setVisible(true);
		flygame.onTick();
		bf1.OnTick();
		flygame.onTick();
		frame.repaint();
		frame.revalidate();
//		frame.dispose();
//		frame = new MainView();
//		frame.addMenu(flygame, plntGame, bf1);
//		frame.setVisible(true);
//		plntGame.onTick();
		//flygame.onTick();
		
		//frame.dispose();
		//frame = new MainView();
		//frame.addMenu(flygame, plntGame);
		//frame.setVisible(true);
		//plntGame.onTick();

		
		//frame.showMenu();
		
	}
	

}
