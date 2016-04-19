package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import Model.Tool;
import view.ScientistGameView;

public class ScientistGameController {
	ScientistGameView a=new ScientistGameView();
	ArrayList<Tool> t=new ArrayList<Tool>();
	ArrayList<int []> j=new ArrayList<int []>();
	static int length=3;
	boolean held=false;
	boolean playing=true;
	boolean add=false;
	int life=7;
	int time=61;
	ArrayList<Boolean> notheld=new ArrayList<Boolean>();
	int imgw=100;
	int imgh=100;
	private volatile int screenX = 0;
	private volatile int screenY = 0;
	private volatile int myX = 0;
	private volatile int myY = 0;
	Random rand=new Random();
	Timer timer=new Timer(1000,addtime());
	public ScientistGameController(){
		for(int i=0;i<3;i++){
			t.add(new Tool(600,200*i));
			int [] x=new int [2];
			x[0]=(1200);
			x[1]=(200*i);
			j.add(x);
			notheld.add(true);
		}
		a.onTick(j);
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
			for(int k=0;k<length;k++){
				if(notheld.get(k)){
					//t.get(k).move();
					j.get(k)[0]=t.get(k).x;
				}
				else{
					j.get(k)[0]=t.get(k).x;
					j.get(k)[1]=t.get(k).y;
				}
				if(t.get(k).x<=100&&notheld.get(k)){
					t.remove(k);
					j.remove(k);
					notheld.remove(k);
					a.removeTrash(k);
					life--;
					a.updatelives(life);
					length--;
				}
			}
			a.updatetime(time);
			a.onTick(j);
			/*if(add&&length<6&&!(time>=60)){
				int r=rand.nextInt(3);
				t.add(new Tool(600,200*r));
				int [] x=new int [2];
				x[0]=(600);
				x[1]=(200*r);
				j.add(x);
				notheld.add(true);
				a.addTrash(600,200*r);
				add=false;
				length++;
			}*/
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
				        myX=t.get(i).x;
				        myY=t.get(i).y;
				        
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
							j.get(i)[0]=t.get(i).x;
							j.get(i)[1]=t.get(i).y;
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
	public static void main(String[] args){
		ScientistGameController p=new ScientistGameController();
		p.onTick();
	}
}
