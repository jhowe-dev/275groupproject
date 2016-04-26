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
	}
	
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
							int random = rand.nextInt(3);
							while(!flag)
							{
								if(!possibleSpots[random])
								{
									System.out.println("First Spot is" + random);
									switch(random)
									{
									case 0:
										newX = bgp.getX();
										newY = bgp.getY() -1;
										gameGrid[newX][newY] = new BadGridPlant("name",newX,newY);
										System.out.println(newX +" "+ newY + "Case 0");
										flag = true;
										break;
									case 1:
										newX = bgp.getX();
										newY = bgp.getY() +1;
										gameGrid[newX][newY] = new BadGridPlant("name",newX,newY);
										System.out.println(newX +" "+ newY + "Case 1"); 
										flag = true;
										break;
									case 2:
										newX = bgp.getX() + 1;
										newY = bgp.getY();
										gameGrid[newX][newY] = new BadGridPlant("name",newX,newY);
										System.out.println(newX +" "+ newY + "Case 2");
										flag = true;
										break;
									case 3:
										newX = bgp.getX() - 1;
										newY = bgp.getY();
										gameGrid[newX][newY] = new BadGridPlant("name",newX,newY);
										System.out.println(newX + " " + newY + "Case 3");
										flag = true;
										break;
									}
									
								}//if
								random = rand.nextInt(3);
								System.out.println("new random number: "+random);
							}//while
							
						}//if
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
						
						
						/*
						int bgpX = bgp.getX();
						int bgpY = bgp.getY();
						int newX = 0;
						int newY = 0;
						int random = rand.nextInt(3);
						
						boolean south = (!(bgpY + 1 >= gameGrid.length) && (gameGrid[bgpY + 1][bgpX] == null)) ? false:true;
						boolean north = (!(bgpY - 1 <= gameGrid.length) && (gameGrid[bgpY - 1][bgpX] == null)) ? false:true;
						boolean east = (!(bgpX + 1 >= gameGrid.length) && (gameGrid[bgpY][bgpX + 1] == null)) ? false:true;
						boolean west = (!(bgpX - 1 >= gameGrid.length) && (gameGrid[bgpY][bgpX - 1] == null)) ? false:true;
						
						boolean[] allowed = {south,north,east,west};
						while(!allowed[random]){
							random = rand.nextInt(3);
						}//while
						switch(random)
						{
						case 0:
							newX = bgpX;
							newY = bgpY +1;
							break;
						case 1:
							newX = bgpX;
							newY = bgpY + 1;
						case 2:
							newX = bgpX + 1;
							newY = bgpY;
							break;
						case 3:
							newX = bgpX - 1;
							newY = bgpY;
						}
						BadGridPlant newPlant = new BadGridPlant("Name",newX, newY);
						badGridPlants.add(newPlant);
						gameGrid[newY][newX] = newPlant;
						*/
			
	
	//checks if given Bad Plant is surround by good Plants.
	private boolean[] surroundedBy(BadGridPlant bgp){
		boolean surrounded = false;
		int bgpX = bgp.getX();
		int bgpY = bgp.getY();
		GamePlant flagger = new GamePlant(0,0,"Flag",false);
		boolean north = true, south = true, east = true, west = true;
		try{
			System.out.print("hit North");
			flagger = gameGrid[bgpX -1][bgpY];
			if(flagger == null)
				System.out.print("hit North");
				north = true;
				
		}//north Try
		catch(IndexOutOfBoundsException e){
			System.out.print("hit North");
			flagger = null;
			north = false;
		}//north catch
		
		try{
			System.out.print("hit Sorth");
			flagger = gameGrid[bgpX +1][bgpY];
			if(flagger == null)
				System.out.print("hit Sorth");
				south = false;
		}//south Try
		catch(IndexOutOfBoundsException e){
			flagger = null;
			System.out.print("hit Sorth");	
			south = false;
		}//south catch
		
		try{
			System.out.print("hit Eorth");
			
			flagger = gameGrid[bgpX][bgpY + 1];
			if(flagger == null)
				System.out.print("hit Eorth");
				east = true;
		}//east Try
		catch(IndexOutOfBoundsException e){
			flagger = null;
			System.out.print("hit Eorth");
			
			east = false;
		}//east catch
		
		try{
			System.out.print("hit Worth");
			
			flagger = gameGrid[bgpX][bgpY - 1];
			if(flagger == null)
				System.out.print("hit Worth");
				west = false;
		}//west Try
		catch(IndexOutOfBoundsException e){
			flagger = null;
			System.out.print("hit Worth");
			west = false;
		}//west catch		
		boolean[] allowed = {north,south,east,west};
		return allowed;
	}
	
	public MouseListener addmousel(){
		MouseListener l = new MouseListener(){
			@Override
			public void mousePressed(MouseEvent e){
				}
			@Override
		    public void mouseEntered(MouseEvent e){ 
				if(turn == 1){
					if(turn ==1){
						inHand= new GoodGridPlant(3,3,"This is a test");
						System.out.println(inHand.getName());
					}//if
					
					else if(true)//clicks in grid
					{
						if(inHand != null)
						{
							//verify that clicked grid pos. is null
							//add thing to grid gameGrid[][] = inHand;
							inHand = null;
						}//if
						else
						{
							System.out.println("Pick up a plant first!");
						}//else
					}//else
				}//if
				else{System.out.println("Not your turn!");}//else
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
	public static void main(String[] args)
	{
		GridGameController ggc = new GridGameController();
		ggc.onTick();
	}
	
	
}
