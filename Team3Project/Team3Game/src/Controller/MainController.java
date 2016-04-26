package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainView;

public class MainController {
	MainView frame;
	FlyGameController game;
	public boolean flyStart;
	
	public MainController(BossFight1Controller bf1, FlyGameController agame, SelectGameController sgame, ScientistGameController ggame) {
		this.frame = new MainView(bf1, agame, sgame, ggame);
		this.game = agame;
		this.frame.birdGame.addActionListener(addFlyActionListener(agame, frame));
	}
	
	

/*	public static void main(String[] args) {
		FlyGameController flygame = new FlyGameController();
		SelectGameController plntGame = new SelectGameController();
		BossFight1Controller bf1 = new BossFight1Controller();
		ScientistGameController sgame=new ScientistGameController();
		GridGameController ggame=new GridGameController();
		MainView frame = new MainView(bf1); 
		frame.addMenu(flygame, plntGame, sgame);
		//System.out.println(frame.getFlyGameStart());
		while(frame.getFlyGameStart()) {
			flygame.onTick();
		}
		
		
		*//**
		frame.setVisible(true);
		flygame.onTick();
		bf1.OnTick();
		flygame.onTick();
		frame.repaint();
		frame.revalidate();
		**//*
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
		
	}*/

	
	public ActionListener addFlyActionListener(FlyGameController agame, MainView aframe) {
		this.frame = aframe;
		this.game = agame;
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("button clicked");
				frame.addflyGame();
				frame.layeredPane.setLayer(frame.menu, 0);
				frame.layeredPane.setLayer(frame.flyView, 1);
				//game.onTick();
				flyStart = true;
			}
			
		};
		return listener;
	}
	
	public void startFlyGame(FlyGameController game) {
		game.onTick();
	}
	
	public void start() {
		this.flyStart = true;
	}
	

}
