package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.BossFight1Controller;
import Controller.BossFight2Controller;
import Controller.FlyGameController;
import Controller.GridGameController;
import Controller.ScientistGameController;
import Controller.SelectGameController;

public class MainView extends JFrame {
	final static int frameWidth = 900;
    final static int frameHeight = 1440;
    
    private JPanel contentPane;
    public JPanel menu;
    // Game Views
    public JPanel flyView;
    private JPanel selectView;
    private JPanel gridView;
    private JPanel scientistview;
    private JPanel bf1view;
    private JPanel bf2View;
    public JLayeredPane layeredPane; 
    // Games
    private ScientistGameController sgame;
    private GridGameController ggame;
    private FlyGameController game;
    private SelectGameController selectGame;
    private BossFight1Controller bf1;
    private BossFight2Controller bf2;
    volatile boolean start = false;
    public boolean flyGameStart;
    public boolean plantGameStart;
    public boolean gridGameStart;
    public boolean scienceGameStart;
    public boolean finalBossStart;
    
    public JButton birdGame;
    
//    private boolean game1 = true;
    
    
    
    public MainView(BossFight1Controller bf1, FlyGameController agame, SelectGameController sgame, ScientistGameController ggame,
    		GridGameController gridController, BossFight2Controller bf2) {
    	this.bf1 = bf1;
    	new JFrame("Fly Game");
    	setLayout(null);
    	setSize((int) 1440, (int) 900);
    	  //setExtendedState(JFrame.MAXIMIZED_BOTH); 
    	 // setUndecorated(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize((int)(frameHeight), (int)(frameWidth));
    	setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new CardLayout(0, 0));
		setContentPane(contentPane);
		layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, "Team 3 Game");
		addBossFight1();
		bf1.OnTick();
		layeredPane.setLayer(bf1view, 0);
		
		addMenu(agame, sgame, ggame, gridController, bf2);
		
    }
    
    public boolean getFlyGameStart() {
    	return this.flyGameStart;
    }
    
    public void startFlyGame() {
    	this.flyGameStart = true;
    }
    

    public void addMenu(FlyGameController agame, SelectGameController sgame, ScientistGameController ggame,
    		GridGameController gridController, BossFight2Controller bf2)  {
    	this.game = agame;
    	this.selectGame = sgame;
    	this.sgame = ggame;
    	this.ggame = gridController;
    	this.bf2 = bf2;
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
//		contentPane.setLayout(new CardLayout(0, 0));
//		setContentPane(contentPane);
//		
//		layeredPane = new JLayeredPane();
//		contentPane.add(layeredPane, "Team 3 Game");
    	
		// Menu
		menu = new JPanel();
		menu.setLayout(null);
    	menu.setSize((int) 1440, (int) 900);
		layeredPane.setLayer(menu, 10);
//		menu.setBounds(0, 0, 1440, 900);
		layeredPane.add(menu);
		
		// Redknot Game
		birdGame = new JButton("Redknot Game");
		birdGame.setSize(200,300);
		birdGame.setLocation(50,0);
		birdGame.setBackground(Color.RED);
		/*birdGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addflyGame();
				layeredPane.setLayer(menu, 0);
				layeredPane.setLayer(flyView, 1);
				flyGameStart = true;
				System.out.println(flyGameStart);
			}
		});*/
		menu.add(birdGame);
		//game.onTick();
		
		// Select Game
		JButton plantGame = new JButton("Plant Game");
		plantGame.setSize(200,300);
		plantGame.setLocation(400,0);
		plantGame.setBackground(Color.GREEN);
		plantGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPlntGame();
				layeredPane.setLayer(menu, 0);
				layeredPane.setLayer(selectView, 2);
				plantGameStart = true;
			}
		});
		menu.add(plantGame);
		
		// Grid Game
		JButton gridGame = new JButton("Grid Game");
		gridGame.setSize(200, 300);
		gridGame.setLocation(50,  400);
		gridGame.setBackground(Color.GRAY);
		gridGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addGridGame();
				layeredPane.setLayer(menu, 0);
				layeredPane.setLayer(gridView, 3);
				gridGameStart = true;
			}
		});
		menu.add(gridGame);
		
		/**
		JButton scienceGame = new JButton("Scientist Game");
		scienceGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addflyGame();
				layeredPane.setLayer(menu, 0);
				layeredPane.setLayer(selectView, 1);
			}
		});
		menu.add(scienceGame);
		**/
		JButton scientist = new JButton("Scientist Game");
		scientist.setSize(200,300);
		scientist.setLocation(400,400);
		scientist.setBackground(Color.BLUE);
		scientist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addScienceGame();
				layeredPane.setLayer(menu, 0);
				layeredPane.setLayer(scientistview, 4);
				scienceGameStart = true;
			}
		});
		menu.add(scientist);
		
		// BossFight 2 Game
		JButton finalBoss = new JButton("Boss Fight 2");
		finalBoss.setSize(400, 600);
		finalBoss.setLocation(800,  10);
		finalBoss.setBackground(Color.MAGENTA);
		finalBoss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBossFight2();
				layeredPane.setLayer(menu, 0);
				layeredPane.setLayer(bf2View, 5);
				finalBossStart = true;
			}
		});
		menu.add(finalBoss);
		
		revalidate();
		repaint();
		layeredPane.setVisible(true);
    	
    }
    
    public void addflyGame() {
    	// FlyGameController game = new FlyGameController();
    
    	flyView = game.flyGameViewer;
    	flyView.setLayout(null);
    	flyView.setSize((int) frameHeight, (int) frameWidth);
    	flyView.setBounds(0, 0, 1440, 900);
    	layeredPane.setLayer(flyView, 0);
    	layeredPane.add(flyView);
    	game.start=true;
    	
    	flyGameStart = true;
    	System.out.println("add" + flyGameStart);
    	flyView = game.flyGameViewer;
    	flyView.setLayout(null);
    	flyView.setSize((int) frameHeight, (int) frameWidth);
    	flyView.setBounds(0, 0, 1440, 900);
    	layeredPane.setLayer(flyView, 0);
    //	layeredPane.add(flyView);
    	setVisible(true);
    }
    
    public void showMenu() {
    	layeredPane.setLayer(menu, 10);
    //	layeredPane.setLayer(flyView, 1);
    //	layeredPane.setLayer(selectView, 2);
    //	layeredPane.setLayer(bf1view, 3);
    }
    
    public void addPlntGame() {
    	selectView = selectGame.getView();
    	selectView.setLayout(null);
    	selectView.setSize((int) frameHeight, (int) frameWidth);
    	selectView.setBounds(0, 0,  1440,  900);
    	layeredPane.setLayer(selectView, 100);
    	layeredPane.add(selectView);
    	setVisible(true);
    	repaint();
    	
    }
    
    public void addGridGame() {
    	gridView = ggame.getView();
    	gridView.setLayout(null);
    	gridView.setSize((int) frameHeight, (int) frameWidth);
    	gridView.setBounds(0, 0,  1440,  900);
    	layeredPane.setLayer(gridView, 100);
    	layeredPane.add(gridView);
    	setVisible(true);
    	repaint();
    }
    
    public void addScienceGame() {
    	this.scientistview = sgame.scientistGameViewer;
    	scientistview.setLayout(null);
    	scientistview.setSize((int) frameHeight, (int) frameWidth);
    	scientistview.setBounds(0, 0,  1440,  900);
    	layeredPane.setLayer(scientistview, 100);
    	layeredPane.add(scientistview);
    	setVisible(true);
    	revalidate();
    }
    
    public void addBossFight1(){
    	this.bf1view = bf1.view;
    	bf1view.setLayout(null);
    	bf1view.setSize((int) frameHeight, (int) frameWidth);
    	bf1view.setBounds(0, 0,  1440,  900);
    	layeredPane.setLayer(bf1view, 100);
    	layeredPane.add(bf1view);
    	setVisible(true);
    	revalidate();
    }
    
    public void addBossFight2() {
    	this.bf2View = bf2.view;
    	bf2View.setLayout(null);
    	bf2View.setSize((int) frameHeight, (int) frameWidth);
    	bf2View.setBounds(0, 0,  1440,  900);
    	layeredPane.setLayer(bf2View, 100);
    	layeredPane.add(bf2View);
    	setVisible(true);
    	revalidate();
    	
    }
    
    public boolean canI(){
    	return start;
    }
}
