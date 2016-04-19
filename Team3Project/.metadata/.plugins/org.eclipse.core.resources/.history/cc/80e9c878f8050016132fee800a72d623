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
import view.FlyGameView;

public class FlyGameController {
	public FlyGameView a=new FlyGameView();
	ArrayList<Trash> t=new ArrayList<Trash>();
	ArrayList<int []> j=new ArrayList<int []>();
	public static double screenwidth=1440;
	public static double screenheight=900;
	public static double widthratio=screenwidth/1440;
	public static double heightratio=screenheight/900;
	public int length=3;
	boolean held=false;
	boolean add=false;
	int life=7;
	int time=61;
	ArrayList<Boolean> notheld=new ArrayList<Boolean>();
	public static int imgw=100;
	public static int imgh=100;
	private volatile int screenX = 0;
	private volatile int screenY = 0;
	private volatile int myX = 0;
	private volatile int myY = 0;
	Random rand=new Random();
	RedKnot red=new RedKnot(100,(int)(225*heightratio));
	Timer timer=new Timer(1000,addtime());
	public FlyGameController(){
		for(int i=0;i<3;i++){
			t.add(new Trash((int)(1200*widthratio),(int)(200*i*heightratio)));
			int [] x=new int [2];
			x[0]=((int)(1200*widthratio));
			x[1]=((int)(200*i*heightratio));
			j.add(x);
			notheld.add(true);
			System.out.println(x);
		}
		a.render(j);
		a.addMouseListener(addmousel());
		a.addMouseMotionListener(addmousem());
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
			a.updatered(red.gety());
			for(int k = 0; k < length; k++){
				if(notheld.get(k)){
					t.get(k).move();
					j.get(k)[0]=t.get(k).getx();
				}
				else{
					j.get(k)[0]=t.get(k).getx();
					j.get(k)[1]=t.get(k).gety();
				}
				if(red.istouching(t.get(k))&&notheld.get(k)){
					life--;
					a.updatelives(life);
					removetrash(k);
				}
				if(t.get(k).getx()+t.get(k).imgw<=0&&notheld.get(k)){
					removetrash(k);
				}
			}
			a.updatetime(time);
			a.render(j);
			if(add&&length<6&&!(time>=60)){
				addtrash();
			}
		}
		if(life>0){
			System.out.println("You win");
		}
		else{
			System.out.println("You lose");
		}
	}
	public MouseListener addmousel(){
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
				for(int i=0;i<length;i++){
					if(t.get(i).x<e.getXOnScreen()&&e.getXOnScreen()<(t.get(i).x+imgw)&&t.get(i).y<e.getYOnScreen()&&e.getYOnScreen()<(t.get(i).y+imgh)){
						notheld.set(i,false);
						screenX = e.getXOnScreen();
				        screenY = e.getYOnScreen();
				        myX=t.get(i).getx();
				        myY=t.get(i).gety();
				        
				        i=length+1;
					}
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				for(int i=0;i<length;i++){
					if(!notheld.get(i)){
						if(50<e.getXOnScreen()&&e.getXOnScreen()<50+150&&650<e.getYOnScreen()&&e.getYOnScreen()<850){
							t.remove(i);
							j.remove(i);
							length--;
							a.removeTrash(i);
							notheld.remove(i);
						}
						else{
							t.get(i).setcoor(myX, myY);
							j.get(i)[0]=t.get(i).getx();
							j.get(i)[1]=t.get(i).gety();
						}
					}
					notheld.set(i,true);
				}
			}
			
		};
		return l;
	}
	public MouseMotionListener addmousem(){
		MouseMotionListener l=new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent e) {
				for(int k=0;k<length;k++){
					if(!notheld.get(k)){
						int deltaX = e.getXOnScreen() - screenX;
				        int deltaY = e.getYOnScreen() - screenY;
				        t.get(k).setcoor(myX + deltaX, myY + deltaY);
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
	public ActionListener addtime(){
		ActionListener timerListener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				time--;
				add=true;
			}
			
		};
		return(timerListener);
	}
	public void addtrash(){
		int r=rand.nextInt(3);
		t.add(new Trash((int)(1200*widthratio),(int)(200*r*heightratio)));
		int [] x=new int [2];
		x[0]=((int)(1200*widthratio));
		x[1]=((int)(200*r*heightratio));
		j.add(x);
		notheld.add(true);
		a.addTrash((int)(1200*widthratio),(int)(200*r*heightratio));
		add=false;
		length++;
	}
	public void removetrash(int index){
		t.remove(index);
		j.remove(index);
		notheld.remove(index);
		a.removeTrash(index);
		length--;
	}
	public static void main(String[] args){
		FlyGameController p=new FlyGameController();
		p.onTick();
	}
}
