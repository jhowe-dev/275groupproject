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
	public static double screenwidth=1440;
	public static double screenheight=900;
	public static double widthratio=screenwidth/1440;
	public static double heightratio=screenheight/900;
	private int life=7;
	private int score=0;
	private int time=61;
	private int counter=0;
	private int counterFishman=0;
	private int counterFish=0;
	private int counterTrash=0;
	private int counterLiquid=0;
	public boolean start=true;
	private ArrayList<Boolean> notHeldList=new ArrayList<Boolean>();
	public static int imgw=100;
	public static int imgh=100;
	private volatile int screenX = 0;
	private volatile int screenY = 0;
	private volatile int trashXCoor = 0;
	private volatile int trashYCoor = 0;
	private Random rand=new Random();
	private Timer timer=new Timer(1000,addTime());
	public ScientistGameController(){
		
	}
	public void onTick(){
		timer.setInitialDelay(0);
        timer.start();
		while(time>0&&life>0){
			try {
				Thread.sleep(60);
				} 
			catch (InterruptedException e) {
				e.printStackTrace();
				}
			for(int i=0;i<4;i++){
				for(int j=0;j<14;j++){
					if(river[i][j]!=null){
						river[i][j].tick();
						if(river[i][j].getTimer()>60){
							removeRiverItem(i,j,river[i][j].getType(),river[i][j].getIndex());
							score--;
						}
						
					}
					
				}
			}
			while((counter>=60)){
				int xr=rand.nextInt(14);
				int yr=rand.nextInt(4);
				if(river[yr][xr]==null){
					int tr=rand.nextInt(3);
					addRiverItem(xr,yr,tr);
					counter=0;
				}
				
			}
			counter++;
		}
		if(life>0){
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
	public void addRiverItem(int x,int y,int index){
		if(index==0){
			RiverItem item=new RiverItem(x,y,index,counterTrash);
			river[y][x]=item;
			scientistGameViewer.addTrash(x,y,addMouse());
			counterTrash++;
		}
		else if(index==1){
			RiverItem item=new RiverItem(x,y,index,counterFish);
			river[y][x]=item;
			scientistGameViewer.addFish(x,y,addMouse());
			counterFish++;
		}
		else if(index==2){
			RiverItem item=new RiverItem(x,y,index,counterLiquid);
			river[y][x]=item;
			scientistGameViewer.addLiquid(x,y,addMouse());
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
	public MouseListener addMouse(){
		MouseListener listen=new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
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
				// TODO Auto-generated method stub
				
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
