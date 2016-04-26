package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import Model.RedKnot;
import Model.RiverItem;
import Model.Tool;
import Model.Trash;
import Model.TrashCan;
import view.FlyGameView;
import view.ScientistGameView;
 
public class ScientistGameController {
	public ScientistGameView scientistGameViewer=new ScientistGameView();
	RiverItem[][] river=new RiverItem[4][14];
	RiverItem[] fishmen=new RiverItem[12];
	public static double screenwidth=1440;
	public static double screenheight=900;
	public static double widthratio=screenwidth/1440;
	public static double heightratio=screenheight/900;
	private int score=0;
	private int time=61;
	private int counter=0;
	private int counterFishman=0;
	private int counterFish=0;
	private int counterTrash=0;
	private int counterLiquid=0;
	public boolean start=true;
	public static int imgw=100;
	public static int imgh=100;
	private boolean fishman=false;
	private boolean fish=false;
	private boolean trash=false;
	private boolean liquid=false;
	private Random rand=new Random();
	private Timer timer=new Timer(1000,addTime());
	public ScientistGameController(){
		scientistGameViewer.addMouseListener(addMouse());
		scientistGameViewer.addTicketButton(addTicket());
		scientistGameViewer.addBinButton(addBin());
		scientistGameViewer.addVileButton(addVile());
		scientistGameViewer.addTagButton(addTag());
	}
	public void onTick(){
		timer.setInitialDelay(0);
        timer.start();
		while(time>0){
			System.out.println("working");
			try {
				Thread.sleep(60);
				} 
			catch (InterruptedException e) {
				e.printStackTrace();
				}
			for(int i=0;i<12;i++){
				if(fishmen[i]!=null){
					fishmen[i].tick();
					if(fishmen[i].getTimer()>120){
						removeFishman(i);
						score--;
					}
				}
			}
			for(int i=0;i<4;i++){
				for(int j=0;j<14;j++){
					if(river[i][j]!=null){
						river[i][j].tick();
						if(river[i][j].getTimer()>120){
							removeRiverItem(i,j,river[i][j].getType(),river[i][j].getIndex());
							score--;
						}
						
					}
					
				}
			}
			while((counter>=60)){
				int r=rand.nextInt(4);
				if(r==0){
					r=rand.nextInt(12);
					switch(r){
					case 0:
						addFishman(r,r);
						break;
					case 1:
						addFishman(r,r);
						break;
					case 2:
						addFishman(r,r);
						break;
					case 3:
						addFishman(r,r);
						break;
					case 4:
						addFishman(r,r);
						break;
					case 5:
						addFishman(r,r);
						break;
					case 6:
						addFishman(r+2,r);
						break;
					case 7:
						addFishman(r+2,r);
						break;
					case 8:
						addFishman(r+2,r);
						break;
					case 9:
						addFishman(r+2,r);
						break;
					case 10:
						addFishman(r+2,r);
						break;
					case 11:
						addFishman(r+2,r);
						break;
					}
					counter=0;
				}
				else{
					int xr=rand.nextInt(14);
					int yr=rand.nextInt(4);
					if(river[yr][xr]==null){
						int tr=rand.nextInt(3);
						addRiverItem(xr,yr,tr);
						counter=0;
					}
				}
				
			}
			counter++;
			scientistGameViewer.setScore(score);
			scientistGameViewer.updateTime(time);
		}
		if(1>0){
			System.out.println("You win");
		}
		else{
			System.out.println("You lose");
		}
	
	}

	public ActionListener addTime(){
		ActionListener timerListener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				time--;
				
			}
			
		};
		return(timerListener);
	}
	public void addRiverItem(int x,int y,int type){
		if(type==0){
			RiverItem item=new RiverItem(x,y,type,counterTrash);
			river[y][x]=item;
			scientistGameViewer.addTrash(x,y,counterTrash);
			counterTrash++;
		}
		else if(type==1){
			RiverItem item=new RiverItem(x,y,type,counterFish);
			river[y][x]=item;
			scientistGameViewer.addFish(x,y,counterFish);
			counterFish++;
		}
		else if(type==2){
			RiverItem item=new RiverItem(x,y,type,counterLiquid);
			river[y][x]=item;
			scientistGameViewer.addLiquid(x,y,counterLiquid);
			counterLiquid++;
		}

	}
	public void removeRiverItem(int x,int y,int type,int index){
		if(type==0){
			river[x][y]=null;
			scientistGameViewer.removeTrash(index);
			
		}
		else if(type==1){
			river[x][y]=null;
			scientistGameViewer.removeFish(index);

		}
		else if(type==2){
			river[x][y]=null;
			scientistGameViewer.removeLiquid(index);

		}

	}
	
	public void addFishman(int x,int index){
		fishmen[index]=new RiverItem(x*100,320,3,index);
		scientistGameViewer.addFisherman(x,index);
	}
	public void removeFishman(int index){
		fishmen[index]=null;
		scientistGameViewer.removeFisherman(index);
	}
	public MouseListener addMouse(){
		MouseListener listen=new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent event) {
//				int screenY = (event.getX());
//		        int screenX = (event.getY()-470);
//		        if(screenX>=0){
//		        	screenY/=100;
//		        	screenX/=100;
//		        	if(river[screenX][screenY]!=null){
//		        		if(trash&&river[screenX][screenY].getType()==0){
//		        			removeRiverItem(screenX,screenY,river[screenX][screenY].getType(),river[screenX][screenY].getIndex());
//		        			score++;
//		        		}
//		        		else if(fish&&river[screenX][screenY].getType()==1){
//		        			removeRiverItem(screenX,screenY,river[screenX][screenY].getType(),river[screenX][screenY].getIndex());
//		        			score++;
//		        		}
//		        		else if(fishman){
//
//		        		}
//		        		else if(liquid&&river[screenX][screenY].getType()==2){
//		        			removeRiverItem(screenX,screenY,river[screenX][screenY].getType(),river[screenX][screenY].getIndex());
//		        			score++;
//		        		}
//		        		else{
//		        			score--;
//		        		}
//		        	}
//		        }
//		        else if(screenX>=-150&&(screenY>=0&&screenY<=600)||(screenY>=800&&screenY<=1400)){
//		        	screenY/=100;
//		        	int indexer;
//					switch(screenY){
//					case 0:
//						indexer=screenY;
//						break;
//					case 1:
//						indexer=screenY;
//						break;
//					case 2:
//						indexer=screenY;
//						break;
//					case 3:
//						indexer=screenY;
//						break;
//					case 4:
//						indexer=screenY;
//						break;
//					case 5:
//						indexer=screenY;
//						break;
//					case 8:
//						indexer=screenY-2;
//						break;
//					case 9:
//						indexer=screenY-2;
//						break;
//					case 10:
//						indexer=screenY-2;
//						break;
//					case 11:
//						indexer=screenY-2;
//						break;
//					case 12:
//						indexer=screenY-2;
//						break;
//					case 13:
//						indexer=screenY-2;
//						break;
//					default:
//						indexer=99;
//					}
//					if(indexer!=99){
//						if(fishmen[indexer]!=null){
//							if(fishman){
//								removeFishman(indexer);
//								score++;
//							}
//							else{
//								score--;
//							}
//						}
//					}
//		        }
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent event) {
				if(trash||fishman||fish||liquid){
					int screenX = (event.getX());
					int screenY = (event.getY()-470);
					if(screenY>=0){
						screenX/=100;
						screenY/=100;
						if(river[screenY][screenX]!=null){
							if(trash&&river[screenY][screenX].getType()==0){
								removeRiverItem(screenY,screenX,river[screenY][screenX].getType(),river[screenY][screenX].getIndex());
								score++;
							}
							else if(fish&&river[screenY][screenX].getType()==1){
								removeRiverItem(screenY,screenX,river[screenY][screenX].getType(),river[screenY][screenX].getIndex());
								score++;
							}
							else if(fishman){

							}
							else if(liquid&&river[screenY][screenX].getType()==2){
								removeRiverItem(screenY,screenX,river[screenY][screenX].getType(),river[screenY][screenX].getIndex());
								score++;
							}
							else{
								score--;
							}
						}
					}
					else if(screenY>=-150&&(screenX>=0&&screenX<=600)||(screenX>=800&&screenX<=1400)){
						screenX/=100;
						int indexer;
						switch(screenX){
						case 0:
							indexer=screenX;
							break;
						case 1:
							indexer=screenX;
							break;
						case 2:
							indexer=screenX;
							break;
						case 3:
							indexer=screenX;
							break;
						case 4:
							indexer=screenX;
							break;
						case 5:
							indexer=screenX;
							break;
						case 8:
							indexer=screenX-2;
							break;
						case 9:
							indexer=screenX-2;
							break;
						case 10:
							indexer=screenX-2;
							break;
						case 11:
							indexer=screenX-2;
							break;
						case 12:
							indexer=screenX-2;
							break;
						case 13:
							indexer=screenX-2;
							break;
						default:
							indexer=99;
						}
						if(indexer!=99){
							if(fishmen[indexer]!=null){
								if(fishman){
									removeFishman(indexer);
									score++;
								}
								else{
									score--;
								}
							}
						}
					}
				}
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		};
		return listen;
	}
	public MouseListener addTicket(){
		MouseListener listen=new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent event) {
//				fishman=!fishman;
//				fish=false;
//				trash=false;
//				liquid=false;
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				fishman=!fishman;
				fish=false;
				trash=false;
				liquid=false;
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		};
		return listen;
	}
	public MouseListener addBin(){
		MouseListener listen=new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent event) {
//				fishman=false;
//				fish=false;
//				trash=!trash;
//				liquid=false;
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				fishman=false;
				fish=false;
				trash=!trash;
				liquid=false;
				time=0;
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		};
		return listen;
	}
	public MouseListener addVile(){
		MouseListener listen=new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent event) {
//				fishman=false;
//				fish=false;
//				trash=false;
//				liquid=!liquid;
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				fishman=false;
				fish=false;
				trash=false;
				liquid=!liquid;
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		};
		return listen;
	}
	public MouseListener addTag(){
		MouseListener listen=new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent event) {
//				fishman=false;
//				fish=!fish;
//				trash=false;
//				liquid=false;
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				fishman=false;
				fish=!fish;
				trash=false;
				liquid=false;
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		};
		return listen;
	}
	public static void main(String[] args){
		ScientistGameController p=new ScientistGameController();
		p.onTick();
	}
}
