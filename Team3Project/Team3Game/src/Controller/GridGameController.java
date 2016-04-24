package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

import Model.GoodGridPlant;
import Model.BadGridPlant;
import Model.GamePlant;
public class GridGameController {
	
	private ArrayList<BadGridPlant> badGridPlants = new ArrayList<BadGridPlant>();
	private ArrayList<GoodGridPlant> goodGridPlants = new ArrayList<GoodGridPlant>();
	private BadGridPlant firstPlant;
	private int placeable = 3;
	private GamePlant[][] gameGrid = new GamePlant[10][10];
	private Random rand = new Random();
	//private Timer timer = new Timer(1000, addTime());
	
	//set Bad Plant initial position, can't be 0 or [length-1], don't want it to be on the corner or edge
	private void initPlant(BadGridPlant bgp){
		int bound = gameGrid.length - 3;
		int x = rand.nextInt(bound) + 1;
		int y  = rand.nextInt(bound) +1;
		
		bgp.setX(x);
		bgp.setY(y);
	}	
	//Add initial plant/s to grid.  Only bad plants start in grid.
	private void initializeGrid()
	{
		for(BadGridPlant bp:badGridPlants)
		{
			gameGrid[bp.getX()][bp.getY()] = bp;
		}
	}
	
	public GridGameController()
	{	
		initPlant(firstPlant);
	}
	
	public void onTick()
	{
		initializeGrid();
		//do everything else
		//such as for each bp in gameGrid, check if surrounded.  Remove if it is.
	}
	
	//checks if given Bad Plant is surround by good Plants Assumes that, as above, neither X or Y can be in 0 or [length-1]
	private boolean surrounded(BadGridPlant bgp){
		boolean surrounded = false;
		int bgpX = bgp.getX();
		int bgpY = bgp.getY();
		
		GamePlant north = gameGrid[bgpY + 1][bgpX];
		GamePlant south = gameGrid[bgpY - 1][bgpX];
		GamePlant east = gameGrid[bgpY][bgpX + 1];
		GamePlant west = gameGrid[bgpY][bgpX - 1];
		
		if(north.getGood() && south.getGood() && east.getGood() && west.getGood())
		{
			surrounded = true;
		}
		else{
			surrounded = false;
		}
		
		return surrounded;
	}
	
}
