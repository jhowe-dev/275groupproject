package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.BossFight1Controller;
import Controller.FlyGameController;
import Controller.ScientistGameController;
import Controller.SelectGameController;

public class MainView extends JFrame {
	final static int frameWidth = 900;
    final static int frameHeight = 1440;
    
    private JPanel contentPane;
    private JPanel menu;
    private JPanel flyView;
    private JPanel selectView;
    private JPanel bf1view;
    private JLayeredPane layeredPane; 
    private ScientistGameController sgame;
    volatile boolean start=false;
    private FlyGameController game;
    private SelectGameController selectGame;
    private BossFight1Controller bf1;
//    private boolean game1 = true;
    
    
    
    public MainView() {
    	new JFrame("Fly Game");
    	setLayout(null);
    	setSize((int) 1440, (int) 900);
    	  //setExtendedState(JFrame.MAXIMIZED_BOTH); 
    	 // setUndecorated(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize((int)(frameHeight), (int)(frameWidth));
    	setVisible(true);
    }
    /**
    public boolean getGame1() {
    	return game1;
    }
    
    public void setGame1(boolean a) {
    	this.game1 = a;
    }
    **/
    

    public void addMenu(FlyGameController agame, SelectGameController sgame, BossFight1Controller bf1) {
    	this.game = agame;
    	this.selectGame = sgame;
    	this.bf1 = bf1;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new CardLayout(0, 0));
		setContentPane(contentPane);
		
		layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, "Team 3 Game");
		
		menu = new JPanel();
		layeredPane.setLayer(menu, 0);
		menu.setBounds(0, 0, 1440, 900);
		layeredPane.add(menu);
		
		
		JButton birdGame = new JButton("Redknot Game");
		birdGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addflyGame();
				layeredPane.setLayer(menu, 0);
				layeredPane.setLayer(flyView, 1);
				//game1 = true;
			}
		});
		menu.add(birdGame);
		
		JButton plantGame = new JButton("Plant Game");
		plantGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPlntGame();
				layeredPane.setLayer(menu, 0);
				layeredPane.setLayer(selectView, 1);
				//game1 = false;
			}
		});
		menu.add(plantGame);
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
		JButton bossFight1 = new JButton("Boss Fight");
		bossFight1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBossFight1();
				layeredPane.setLayer(menu, 0);
				layeredPane.setLayer(bf1view, 1);
				//game1 = false;
			}
		});
		menu.add(bossFight1);
		
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
    	start=true;
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
    	layeredPane.setLayer(flyView, 1);
    	layeredPane.setLayer(selectView, 2);
    	layeredPane.setLayer(bf1view, 3);
    }
    
    public void addPlntGame() {
    	selectView = selectGame.getView();
    	selectView.setLayout(null);
    	selectView.setSize((int) frameHeight, (int) frameWidth);
    	selectView.setBounds(0, 0,  1440,  900);
    	layeredPane.setLayer(selectView, 100);
    	layeredPane.add(selectView);
    	setVisible(true);
    	
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
    
    public boolean canI(){
    	return start;
    }
}
