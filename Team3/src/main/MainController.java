package main;

import flyGame.FlyGame;
import flyGame.FlyGameController;
import flyGame.FlyGameView;

public class MainController {
	
	public static void main(String[] args) {
		FlyGame flyGame = new FlyGame();
		FlyGameView flyGameView = new FlyGameView();
		FlyGameController flyGameController = new FlyGameController(flyGame, flyGameView);
		
		MainView frame = new MainView();
		frame.addMenu(flyGameView);
		frame.setVisible(true);
		flyGameController.onTick();
		frame.removeFlyGame();
	}

}
