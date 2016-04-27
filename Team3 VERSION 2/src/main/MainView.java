package main;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import flyGame.FlyGameView;
import general.Game;

public class MainView extends JFrame {
	private int frameHeight = (int)Game.SCREENHEIGHT;
	private int frameWidth = (int)Game.SCREENWIDTH;
	private JPanel contentPane;
	private JPanel menu;
	private JLayeredPane layeredPane;
	private FlyGameView flyGameView;
	
	public MainView() {
		new JFrame("Fly Game");
    	setLayout(null);
    	setSize((int) frameWidth, (int) frameHeight);
    	  //setExtendedState(JFrame.MAXIMIZED_BOTH); 
    	 // setUndecorated(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
    	//setSize((int)(frameWidth), (int)(frameHeight));
    	setVisible(true);
	}
	
	public void addMenu(final FlyGameView flyGameView) {
		this.flyGameView = flyGameView;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new CardLayout(0, 0));
		setContentPane(contentPane);
		
		layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, "Team 3 Game");
		
		menu = new JPanel();
		layeredPane.setLayer(menu, 0);
		menu.setBounds(0, 0, frameWidth, frameHeight);
		layeredPane.add(menu);
		
		
		JButton birdGame = new JButton("Redknot Game");
		birdGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFlyGame();
				layeredPane.setLayer(menu, 0);
				layeredPane.setLayer(flyGameView, 1);
				//game1 = true;
			}
		});
		menu.add(birdGame);
	}
	
	public void addFlyGame() {
		flyGameView.setLayout(null);
		flyGameView.setSize((int) frameWidth, (int) frameHeight);
		flyGameView.setBounds(0, 0, frameWidth, frameHeight);
    	layeredPane.setLayer(flyGameView, 0);
    	layeredPane.add(flyGameView);
    	setVisible(true);
	}
	public void removeFlyGame(){
		layeredPane.remove(flyGameView);
		layeredPane.setLayer(menu, 1);
		revalidate();
		repaint();
		setVisible(true);
	}

}
