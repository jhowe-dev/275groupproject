package main;

import flyGame.FlyGame;
import flyGame.FlyGameController;
import flyGame.FlyGameView;
import scienceGame.ScientistGame;
import scienceGame.ScientistGameController;
import scienceGame.ScientistGameView;

public class MainController {
	
	public static void main(String[] args) {
		// Fly Game Initialization 
		FlyGame flyGame = new FlyGame();
		FlyGameView flyGameView = new FlyGameView();
		FlyGameController flyGameController = new FlyGameController(flyGame, flyGameView);
		// Scientist Game Initialization
		ScientistGame scientistGame = new ScientistGame();
		ScientistGameView scientistGameView = new ScientistGameView();
		ScientistGameController scientistGameController = new ScientistGameController(scientistGame, scientistGameView);
		
		MainView frame = new MainView();
		frame.addMenu(flyGameView, scientistGameView);
		frame.setVisible(true);
		//flyGameController.onTick();
		scientistGameController.onTick();
		frame.removeFlyGame();
	}

}
