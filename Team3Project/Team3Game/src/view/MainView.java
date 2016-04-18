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

import Controller.FlyGameController;

public class MainView extends JFrame {
	final static int frameWidth = 900;
    final static int frameHeight = 1440;
    
    private JPanel contentPane;
    private JPanel menu;
    private JPanel view;
    private JLayeredPane layeredPane; 
    private FlyGameController game;
    
    
    
    public MainView() {
    	new JFrame("Fly Game");
    	setLayout(null);
    	setSize((int) 1440, (int) 900);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize((int)(frameHeight), (int)(frameWidth));
    	setVisible(true);
    }
    
    public void addMenu(FlyGameController agame) {
    	this.game = agame;
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
				layeredPane.setLayer(view, 1);
			}
		});
		menu.add(birdGame);
		
		JButton plantGame = new JButton("Plant Game");
		plantGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addflyGame();
				layeredPane.setLayer(menu, 0);
				layeredPane.setLayer(view, 1);
			}
		});
		menu.add(plantGame);
		
		JButton scienceGame = new JButton("Scientist Game");
		scienceGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addflyGame();
				layeredPane.setLayer(menu, 0);
				layeredPane.setLayer(view, 1);
			}
		});
		menu.add(scienceGame);
		
		layeredPane.setVisible(true);
    	
    }
    
    public void addflyGame() {
    	// FlyGameController game = new FlyGameController();
    	view = game.a;
    	view.setLayout(null);
    	view.setSize((int) frameHeight, (int) frameWidth);
    	view.setBounds(0, 0, 1440, 900);
    	layeredPane.setLayer(view, 0);
    	layeredPane.add(view);
    	setVisible(true);
    }
    
    public void showMenu() {
    	layeredPane.setLayer(menu, 100);
    }

}
