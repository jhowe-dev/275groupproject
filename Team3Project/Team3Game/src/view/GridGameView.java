package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

public class GridGameView extends View {
	PlantButtonView native1 = new PlantButtonView("native 1", 0);
	PlantButtonView native2 = new PlantButtonView("native 2", 1);
	PlantButtonView native3 = new PlantButtonView("native 3", 2);
	PlantButtonView invasive1 = new PlantButtonView("invasive 1", 3);
	PlantButtonView invasive2 = new PlantButtonView("invasive 2", 4);
	PlantButtonView invasive3 = new PlantButtonView("invasive 3", 5);
	GridView[][] dirtGrid=new GridView[5][5];
	Caption caption=new Caption(570,0,300,100);
	public GridGameView(){
		setLayout(null);
		setSize((int) 1440, (int) 900);
		add(native1);
		add(native2);
		add(native3);
		add(invasive1);
		add(invasive2);
		add(invasive3);
		caption.setText("Your Turn");
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				dirtGrid[i][j]=new GridView(345+i*150,120+j*150);
				add(dirtGrid[i][j]);
			}
		}
		
		add(caption);
		setVisible(true);
		repaint();
		revalidate();
		  //setExtendedState(JMAXIMIZED_BOTH); 
		 // setUndecorated(true);
		
	}
	public void updateGrid(int x, int y,boolean invasive){
		if(!invasive){
			dirtGrid[y][x].setBorder(new LineBorder(Color.GREEN, 3));
		}
		else{
			dirtGrid[y][x].setBorder(new LineBorder(Color.RED, 3));
		}
	}
	public void updateTurn(String text){
		caption.setText(text);
	}
	public static void main(String[] args){
		JFrame frame = new JFrame();
		GridGameView ggView = new GridGameView();
		
		frame.setLayout(null);
    	frame.setSize((int) 1440, (int) 900);
    	  //setExtendedState(JFrame.MAXIMIZED_BOTH); 
    	 // setUndecorated(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.add(ggView);
    	frame.setVisible(true);
    	ggView.updateGrid(1,1,false);
    	ggView.updateTurn("Computer turn");
		
	}
}
