package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.Timer;

import Model.ExitArrow;
import Model.Plant;
import view.SelectGameView;
public class SelectGameController{
	private ArrayList<Plant> allPlants = new ArrayList<Plant>();
	private SelectGameView view;
	private ExitArrow ex = new ExitArrow();
	private static double screenWidth=1440;
	private static double screenHeight = 900;
	private static double widthRatio = 1;
	private static double heightRatio = 1;
	private static int imgHeight = 100;
	private static int imgWidth = 100;
	private boolean gameOver = false;
	

	//getters
	public double getScreenWidth(){
		return this.screenWidth;
	}
	public double getScreenHeight(){
		return this.screenHeight;
	}
	public double getWidthRatio(){
		return this.widthRatio;
	}
	public double getHeightRatio(){
		return this.heightRatio;
	}
	public boolean getGameOver()
	{
		return this.gameOver;
	}
	public ArrayList<Plant> getPlants(){
		return this.allPlants;
	}
	public SelectGameView getView(){
		return this.view;
	}


	private void initializePlants()
	{
		allPlants.add(new Plant(500,200, "Good Plant -> Specific plant info goes here",false));
		allPlants.add(new Plant(700, 6, "Not Good! -> Specific plant info goes here",true));
		allPlants.add(new Plant(370, 450, "Not Good! -> Specific plant info goes here",true));
		allPlants.add(new Plant(0, 600, "Good Plant! -> Specific plant info goes here",false));
	}
	public MouseListener addmousel(){
		MouseListener l = new MouseListener(){
			@Override
			public void mousePressed(MouseEvent e){
				for(Plant p: allPlants){
					if(p.getX()<e.getXOnScreen()&&
					   e.getXOnScreen()<p.getX()+imgWidth&&
				       p.getY()<e.getYOnScreen()&&
					   e.getYOnScreen()<p.getY()+imgHeight)
					{ 
						view.displayMessage(p.getMessage());
					}
				}
				if(ex.getX() < e.getXOnScreen() &&
					e.getXOnScreen() < ex.getX()+imgWidth &&
					ex.getY() < e.getYOnScreen() &&
					e.getYOnScreen() < ex.getY() + imgHeight)
				{
					view.displayMessage("Finished so soon?!");
					gameOver = true;
				}
			}
			@Override
		    public void mouseEntered(MouseEvent e){ 
				
			}
			@Override
			public void mouseExited(MouseEvent e){}
			@Override
			public void mouseClicked(MouseEvent e){}	
			@Override
			public void mouseReleased(MouseEvent e){}
		};
		return l;
		
	}
	
	public SelectGameController()
	{
		initializePlants();
		view = new SelectGameView(allPlants, ex);
		view.addMouseListener(addmousel());
	}
	
	public void onTick(){
		if(gameOver){
		}
		else{
				
			view.render();
		}
	}
}
