package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;

public class TEstVew extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel panel;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TEstVew frame = new TEstVew();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TEstVew() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, "name_116447553138312");
		
		panel_1 = new JPanel();
		layeredPane.setLayer(panel_1, 1);
		panel_1.setBounds(6, 6, 101, 206);
		layeredPane.add(panel_1);
		
		JButton btnGame_1 = new JButton("Game 2");
		btnGame_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(panel_1, 0);
				layeredPane.setLayer(panel,  1);
			}
		});
		panel_1.add(btnGame_1);
		
		panel = new JPanel();
		panel.setBounds(6, 6, 101, 206);
		layeredPane.add(panel);
		
		JButton btnGame = new JButton("Game");
		btnGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setLayer(panel, 0);
				layeredPane.setLayer(panel_1,  1);
			}
		});
		panel.add(btnGame);
		
	}
}
