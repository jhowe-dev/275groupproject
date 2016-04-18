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

import Model.RedKnot;
import Model.Trash;
import Model.TrashCan;
import view.FlyGameView;

public class FlyGameController {
	private FlyGameView flyGameViewer=new FlyGameView();
	private ArrayList<Trash> trashList=new ArrayList<Trash>();
	private ArrayList<int []> coordinateList=new ArrayList<int []>();
	public static double screenwidth=1440;
	public static double screenheight=900;
	public static double widthratio=screenwidth/1440;
	public static double heightratio=screenheight/900;
	private int length=3;
	private boolean addTrash=false;
	private int life=7;
	private int time=61;
	private ArrayList<Boolean> notHeldList=new ArrayList<Boolean>();
	public static int imgw=100;
	public static int imgh=100;
	private volatile int screenX = 0;
	private volatile int screenY = 0;
	private volatile int trashXCoor = 0;
	private volatile int trashYCoor = 0;
	private Random rand=new Random();
	private RedKnot red=new RedKnot(100,(int)(225*heightratio));
	private TrashCan trashCan=new TrashCan((int)(50*widthratio), (int)(650*heightratio));
	private Timer timer=new Timer(1000,addTime());
	public FlyGameController(){
		for(int i=0;i<3;i++){
			trashList.add(new Trash((int)(1200*widthratio),(int)(200*i*heightratio)));
			int [] x=new int [2];
			x[0]=((int)(1200*widthratio));
			x[1]=((int)(200*i*heightratio));
			coordinateList.add(x);
			notHeldList.add(true);
		}
		flyGameViewer.render(coordinateList);
		flyGameViewer.frame.addMouseListener(addMouseListener());
		flyGameViewer.frame.addMouseMotionListener(addMouseMotion());
	}
	public void onTick(){
		timer.setInitialDelay(0);
        timer.start();
		while(time>0&&life>0){
			try {
				Thread.sleep(65);
				} 
			catch (InterruptedException e) {
				e.printStackTrace();
				}
			red.move();
			flyGameViewer.updateRed(red.gety());
			for(int k=0;k<length;k++){
				if(notHeldList.get(k)){
					trashList.get(k).move();
					coordinateList.get(k)[0]=trashList.get(k).getx();
				}
				else{
					coordinateList.get(k)[0]=trashList.get(k).getx();
					coordinateList.get(k)[1]=trashList.get(k).gety();
				}
				if(red.isTouching(trashList.get(k))&&notHeldList.get(k)){
					life--;
					flyGameViewer.updateLives(life);
					removeTrash(k);
				}
				if(trashList.get(k).getx()+trashList.get(k).getXAdjusted()<=0&&notHeldList.get(k)){
					removeTrash(k);
				}
			}
			flyGameViewer.updateTime(time);
			flyGameViewer.render(coordinateList);
			if(addTrash&&length<6&&!(time>=60)){
				addTrash();
			}
		}
		if(life>0){
			System.out.println("You win");
		}
		else{
			System.out.println("You lose");
		}
	}
	public MouseListener addMouseListener(){
		MouseListener l=new MouseListener(){

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
			public void mousePressed(MouseEvent e) {
				screenX = e.getXOnScreen();
		        screenY = e.getYOnScreen();
				for(int i=0;i<length;i++){
					if(trashList.get(i).isGrabbed(screenX,screenY)){
						notHeldList.set(i,false);
				        trashXCoor=trashList.get(i).getx();
				        trashYCoor=trashList.get(i).gety();
				        i=length+1;
					}
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				for(int i=0;i<length;i++){
					if(!notHeldList.get(i)){
						if(trashCan.isEatingTrash(trashList.get(i))){
							trashList.remove(i);
							coordinateList.remove(i);
							length--;
							flyGameViewer.removeTrash(i);
							notHeldList.remove(i);
						}
						else{
							trashList.get(i).setcoor(trashXCoor, trashYCoor);
							coordinateList.get(i)[0]=trashList.get(i).getx();
							coordinateList.get(i)[1]=trashList.get(i).gety();
						}
					}
					notHeldList.set(i,true);
				}
			}
			
		};
		return l;
	}
	public MouseMotionListener addMouseMotion(){
		MouseMotionListener l=new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent e) {
				for(int k=0;k<length;k++){
					if(!notHeldList.get(k)){
						int deltaX = e.getXOnScreen() - screenX;
				        int deltaY = e.getYOnScreen() - screenY;
				        trashList.get(k).setcoor(trashXCoor + deltaX, trashYCoor + deltaY);
					}
				}
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			
		};
		return l;
	}
	public ActionListener addTime(){
		ActionListener timerListener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				time--;
				addTrash=true;
			}
			
		};
		return(timerListener);
	}
	public void addTrash(){
		int r=rand.nextInt(3);
		trashList.add(new Trash((int)(1200*widthratio),(int)(200*r*heightratio)));
		int [] x=new int [2];
		x[0]=((int)(1200*widthratio));
		x[1]=((int)(200*r*heightratio));
		coordinateList.add(x);
		notHeldList.add(true);
		flyGameViewer.addTrash((int)(1200*widthratio),(int)(200*r*heightratio));
		addTrash=false;
		length++;
	}
	public void removeTrash(int index){
		trashList.remove(index);
		coordinateList.remove(index);
		notHeldList.remove(index);
		flyGameViewer.removeTrash(index);
		length--;
	}
	public int getLength(){
		return length;
	}
	
	public static void main(String[] args){
		FlyGameController p=new FlyGameController();
		p.onTick();
	}
}
