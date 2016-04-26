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
import Model.Plant;
import view.GridGameView;
import Model.BadGridPlant;
import Model.GamePlant;
public class GridGameController {
	
	private ArrayList<BadGridPlant> badGridPlants = new ArrayList<BadGridPlant>();
	private ArrayList<GoodGridPlant> goodGridPlants = new ArrayList<GoodGridPlant>();
	private BadGridPlant firstPlant;
	private int placeable = 3;
	private GamePlant[][] gameGrid = new GamePlant[5][5];
	private Random rand = new Random();
	private GamePlant inHand;
	private int turn = -1;
	private boolean gameOver = false;
	//private Timer timer = new Timer(1000, addTime());
	public int getTurn(){return turn;}
	private GridGameView ggv = new GridGameView();
	
	//set Bad Plant initial position, can't be 0 or [length-1], don't want it to be on the corner or edge
	private void initPlant(BadGridPlant bgp){
		int x = rand.nextInt(gameGrid.length-1);
		int y  = rand.nextInt(gameGrid.length -1);
		bgp = new BadGridPlant("",x,y);
		bgp.setX(x);
		bgp.setY(y);
		badGridPlants.add(bgp);
	}	
	//Add initial plant/s to grid.  Only bad plants start in grid
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
		ggv.addPlantButtonListen(addmouseNat(), 0);
		ggv.addPlantButtonListen(addmouseNat(), 1);
		ggv.addPlantButtonListen(addmouseNat(), 2);
		ggv.addPlantButtonListen(addmouseInvasive(), 3);
		ggv.addPlantButtonListen(addmouseInvasive(), 4);
		ggv.addPlantButtonListen(addmouseInvasive(), 5);
	}
	public GridGameView getView(){return ggv;}
	
	public void onTick()
	{
		initializeGrid();
		while(!gameOver){
			System.out.println("Game is running");
			if(turn == -1){
				//boolean gameOverFlag = true;
				for(BadGridPlant bgp:badGridPlants){
					if(bgp.getCanGrow()) 
					{
						System.out.println("Something Can Grow");
						boolean[] possibleSpots = surroundedBy(bgp);
						for(int i = 0; i < possibleSpots.length; i ++)
							System.out.println(possibleSpots[i]);
						if(!possibleSpots[0] ||
						   !possibleSpots[1] ||
						   !possibleSpots[2] ||
						   !possibleSpots[3])//0 == north 1 == south 2 == east 3 == west
						{
					//		gameOverFlag = false;
							System.out.println("Found a spot");
							int newX;
							int newY;
							boolean flag = false;
							int random = rand.nextInt(4);
							while(!flag)
							{
								if(!possibleSpots[random])
								{
									newX = 0;
									newY = 0;
									System.out.println("First Spot is" + random);
									switch(random)
									{
									case 0:
										newX = bgp.getX();
										newY = bgp.getY() -1;
										gameGrid[newX][newY] = new BadGridPlant("name",newX,newY);
										System.out.println(newX +" "+ newY + "Case 0");
										surroundedBy(bgp);
										flag = true;
										break;
									case 1:
										newX = bgp.getX();
										newY = bgp.getY() +1;
										gameGrid[newX][newY] = new BadGridPlant("name",newX,newY);
										System.out.println(newX +" "+ newY + "Case 1"); 
										surroundedBy(bgp);
										flag = true;
										break;
									case 2:
										newX = bgp.getX() + 1;
										newY = bgp.getY();
										gameGrid[newX][newY] = new BadGridPlant("name",newX,newY);
										System.out.println(newX +" "+ newY + "Case 2");
										surroundedBy(bgp);
										flag = true;
										break;
									case 3:
										newX = bgp.getX() - 1;
										newY = bgp.getY();
										gameGrid[newX][newY] = new BadGridPlant("name",newX,newY);
										System.out.println(newX + " " + newY + "Case 3");
										surroundedBy(bgp);
										flag = true;
										break;
									}
									
								}//if
								random = rand.nextInt(3);
								System.out.println("new random number: "+random);
							}//while
							
						}//if
						else
						{
							gameOver = true;
						}
					}//if
				}//for
			turn = 1;
			}//if
			else{
				try{Thread.sleep(10000);}
				catch(InterruptedException e){ e.printStackTrace();}
				for(int i = 0; i < gameGrid.length; i++)
				{
					for(int j = 0; j< gameGrid.length; j++)
					{
						if(gameGrid[i][j] == null)
							System.out.print("null");
						else
							System.out.print("Plant");
					}
					System.out.println("New Row");
				}
				System.out.println("Player turn shit");
				System.out.println("Player turn shit");
				System.out.println("Player turn shit");
				System.out.println("Player turn shit");
				turn = -1;
			}//elseSystem.out.println("Player turn shit");
		}//while
	}//onTick			
	//checks if given Bad Plant is surround by good Plants.
	private boolean[] surroundedBy(BadGridPlant bgp){
		int bgpX = bgp.getX();
		int bgpY = bgp.getY();
		boolean north,south,east,west;
		if(bgpX - 1 < 0 || gameGrid[bgpX-1][bgpY] != null)
		{
			west = true;
		}
		else{
			west = false;
		}
		if(bgpX + 1 > gameGrid.length -1 || gameGrid[bgpX + 1][bgpY] != null)
		{
			east = true;
		}
		else{
			east = false;
		}
		if(bgpY -1 < 0 || gameGrid[bgpX][bgpY - 1] != null)
		{
			north = true;
		}	
		else{
			north = false;
		}
		if(bgpY + 1 > gameGrid.length -1 || gameGrid[bgpX][bgpY + 1] != null)
		{
			south = true;
		}
		else{
			south = false;
		}
		boolean[] allowed = {north,south,east,west};
		return allowed;
	}
	
	public MouseListener addmousePlayer(){
		MouseListener l = new MouseListener(){
			@Override
			public void mousePressed(MouseEvent e){
			}
			@Override
		    public void mouseEntered(MouseEvent e){}
			@Override
			public void mouseExited(MouseEvent e){}
			@Override
			public void mouseClicked(MouseEvent e){}	
			@Override
			public void mouseReleased(MouseEvent e){}
		};
		return l;
		
	}
	public MouseListener addmouseInvasive(){
		MouseListener inv = new MouseListener(){
			@Override
			public void mousePressed(MouseEvent e){
			}
			@Override
		    public void mouseEntered(MouseEvent e){}
			@Override
			public void mouseExited(MouseEvent e){}
			@Override
			public void mouseClicked(MouseEvent e){
				
			}	
			@Override
			public void mouseReleased(MouseEvent e){}
		};
		return inv;
		
	}
	public MouseListener addmouseNat(){
		MouseListener nat = new MouseListener(){
			@Override
			public void mousePressed(MouseEvent e)
			{
			}
			@Override
		    public void mouseEntered(MouseEvent e){}
			@Override
			public void mouseExited(MouseEvent e){}
			@Override
			public void mouseClicked(MouseEvent e){}	
			@Override
			public void mouseReleased(MouseEvent e){}
		};
		return nat;
		
	}
	public static void main(String[] args)
	{
		GridGameController ggc = new GridGameController();
		ggc.onTick();
	}
	
	
}
