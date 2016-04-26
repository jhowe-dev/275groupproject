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
	//private ArrayList<GoodGridPlant> goodGridPlants = new ArrayList<GoodGridPlant>();
	private BadGridPlant firstPlant;
	private int placeable = 2;
	private GamePlant[][] gameGrid = new GamePlant[5][5];
	private Random rand = new Random();
	private GamePlant inHand;
	private int turn = -1;
	private boolean gameOver = false;
	//private Timer timer = new Timer(1000, addTime());
	public int getTurn(){return turn;}
	private GridGameView ggv = new GridGameView();
	
	//Add initial plant/s to grid.  Only bad plants start in grid
	private void initializeGrid(BadGridPlant bp)
	{
		int x = rand.nextInt(5), y = rand.nextInt(5);
		firstPlant = new  BadGridPlant("",x,y);
		gameGrid[firstPlant.getX()][firstPlant.getY()] = bp;
		badGridPlants.add(firstPlant);
		ggv.updateGrid(x,y,true);
	}
	
	public GridGameController()
	{	
		
		initializeGrid(firstPlant);
		ggv.addPlantButtonListen(addmouseNat(), 0);
		ggv.addPlantButtonListen(addmouseNat(), 1);
		ggv.addPlantButtonListen(addmouseNat(), 2);
		ggv.addPlantButtonListen(addmouseInvasive(), 3);
		ggv.addPlantButtonListen(addmouseInvasive(), 4);
		ggv.addPlantButtonListen(addmouseInvasive(), 5);
		ggv.addMouseListener(addmousePlayer());
	}
	public GridGameView getView(){return ggv;}
	
	public void onTick()
	{
		while(!gameOver){
			if(turn == -1)
			{
				turn = 1;
				for(BadGridPlant bgp:badGridPlants)
				{
					if(bgp.getCanGrow()) 
					{
						//System.out.println("Something Can Grow");
						boolean[] possibleSpots = surroundedBy(bgp);
						for(int i = 0; i < possibleSpots.length; i ++)
							//System.out.println(possibleSpots[i]);
						if(!possibleSpots[0] ||
						   !possibleSpots[1] ||
						   !possibleSpots[2] ||
						   !possibleSpots[3])//0 == north 1 == south 2 == east 3 == west
						{
							//System.out.println("Found a spot");
							int newX;
							int newY;
							boolean flag = false;
							int random = rand.nextInt(4);
							BadGridPlant badgp = new BadGridPlant("",0,0);
							while(!flag)
							{
								if(!possibleSpots[random])
								{
								//	System.out.println("First Spot is" + random);
									switch(random)
									{
									case 0:
										newX = bgp.getX();
										newY = bgp.getY() -1;
										badgp =  new BadGridPlant("name",newX,newY);
										gameGrid[newX][newY] = badgp;
										ggv.updateGrid(newX, newY, true);
										
										surroundedBy(bgp);
										flag = true;
										break;
									case 1:
										newX = bgp.getX();
										newY = bgp.getY() +1;
										badgp =  new BadGridPlant("name",newX,newY);
										gameGrid[newX][newY] = badgp;
										ggv.updateGrid(newX, newY, true);
										
										surroundedBy(bgp);
										flag = true;
										break;
									case 2:
										newX = bgp.getX() + 1;
										newY = bgp.getY();
										badgp =  new BadGridPlant("name",newX,newY);
										gameGrid[newX][newY] = badgp;
										
										ggv.updateGrid(newX, newY, true);
									
										surroundedBy(bgp);
										flag = true;
										break;
									case 3:
										newX = bgp.getX() - 1;
										newY = bgp.getY();
										badgp =  new BadGridPlant("name",newX,newY);
										gameGrid[newX][newY] = badgp;
										ggv.updateGrid(newX, newY, true);
										
										surroundedBy(badgp);
										flag = true;
										break;
									}
									
								}//if inner
								random = rand.nextInt(3);
								//System.out.println("new random number: "+random);
							}//while inner
							
						}//if possible
						
					}//if grow
				}//for bgp
			}//if
			else{gameOver = true;}
		}//while
		System.out.println("Im dead");
	}//onTick			
	//checks if given Bad Plant is surround by good Plants.
	public boolean isSurroundedBy(BadGridPlant badGamePlant)
	{
		boolean[] surbgp = surroundedBy(badGamePlant);
		boolean answer = true;
		for(int i = 0; i < surbgp.length; i ++)
		{
			if(!surbgp[i])
			{answer = false;}
		}
		return answer;
		
	}
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
				int mouseX = e.getX();
				int mouseY = e.getY();
				
				int arrIndexX = (mouseX - 345);
				if(arrIndexX < 0)
					arrIndexX = 0;
				else
					arrIndexX /= 150;
				
				int arrIndexY = (mouseY - 120);
				if(arrIndexY < 0)
					arrIndexY = 0;
				else
					arrIndexY /= 150;
				
				//ggv.displayMessage();
				
				//ggv.displayMessage(arrIndexX+"");
				//ggv.displayMessage(arrIndexY+"");
				
	//			System.out.println(placeable + "");
				if(inHand != null && gameGrid[arrIndexX][arrIndexY] == null)
				{
					if(placeable > 0){
					inHand.setX(arrIndexX);
					inHand.setY(arrIndexY);

					gameGrid[arrIndexX][arrIndexY] = inHand;
					ggv.updateGrid(arrIndexX, arrIndexY, inHand.getGood());
					placeable --;
					inHand = null;
					}
					else
						turn = -1;
				}//If
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
				if(inHand != null){}
				
				else
					inHand = new BadGridPlant("",0,0);
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
				if(inHand != null){}
			
				else
					inHand = new GoodGridPlant("",0,0);
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
	
}
