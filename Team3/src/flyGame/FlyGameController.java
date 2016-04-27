package flyGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.Timer;

import general.Game;

public class FlyGameController {
	private FlyGame flyGame;
	private FlyGameView flyGameView;
	private Random rand = new Random();
	private volatile int screenX = 0;
	private volatile int screenY = 0;
	private volatile int trashXCoor = 0;
	private volatile int trashYCoor = 0;
	private int counter = 0;
	private Timer timer = new Timer(1000,addTime());
	
	public FlyGameController(FlyGame flyGame, FlyGameView flyGameView) {
		this.flyGame = flyGame;
		this.flyGameView = flyGameView;
		for (int i = 0; i < 3; i++) {
			addTrash(i);
		}
		flyGameView.render(flyGame.getCoordinateList());
		flyGameView.addMouseListener(addMouseListener());
		flyGameView.addMouseMotionListener(addMouseMotion());
	}
	
	public FlyGame getFlyGame() {
		return this.flyGame;
	}
	
	public void setFlyGame(FlyGame game) {
		this.flyGame = game;
	}
	
	public void setFlyGameView(FlyGameView view) {
		this.flyGameView = view;
	}
	
	public void onTick() {
		timer.setInitialDelay(0);
        timer.start();
        
        while(flyGame.getTime() > 0 && flyGame.getLives() > 0){
			try {
				Thread.sleep(30);
				} 
			catch (InterruptedException e) {
				e.printStackTrace();
				}
			flyGame.getRedKnot().move();
			flyGameView.updateRed(flyGame.getRedKnot().getY());
			for(int k=0;k<flyGame.getLength();k++){
				if(flyGame.getNotHeldList().get(k)){
					flyGame.getTrashList().get(k).move();
					flyGame.getCoordinateList().set(k,(flyGame.getTrashList().get(k).getX()));
				}
				else{
					flyGame.getCoordinateList().set(k,flyGame.getTrashList().get(k).getX());
				}
				if(flyGame.getRedKnot().isTouching(flyGame.getTrashList().get(k)) && flyGame.getNotHeldList().get(k)){
					flyGame.decreaseLives();
					flyGameView.updateLives(flyGame.getLives());
					removeTrash(k);
				}
				if(flyGame.getTrashList().get(k).getImgX()<=0&&flyGame.getNotHeldList().get(k)){
					removeTrash(k);
				}
			}
			flyGameView.updateTime(flyGame.getTime());
			flyGameView.render(flyGame.getCoordinateList());
		//	if(flyGame.getAddTrash() && flyGame.getLength() < 6 && (counter>=30)){
		
			if( flyGame.getLength() < 6 && (counter>=30)){
			
				int r=rand.nextInt(3);
				addTrash(r);
				counter=0;
			}
		
			counter++;
		}
		if(flyGame.getLives()>0){
			System.out.println("You win");
			//System.exit(0);
		}
		else{
			System.out.println("You lose");
			//System.exit(0);
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
			public void mousePressed(MouseEvent event) {
				screenX = event.getX();
		        screenY = event.getY();
				for(int i=0;i<flyGame.getLength();i++){
					if(flyGame.getTrashList().get(i).isGrabbed(screenX,screenY)){
						flyGame.getNotHeldList().set(i,false);
				        trashXCoor = flyGame.getTrashList().get(i).getX();
				        trashYCoor= flyGame.getTrashList().get(i).getY();
				        i= flyGame.getLength() + 1;
					}
				}
			}

			@Override
			public void mouseReleased(MouseEvent event) {
				for(int i=0;i<flyGame.getLength();i++){
					if(!flyGame.getNotHeldList().get(i)){
						if(flyGame.getTrashCan().isEatingTrash(flyGame.getTrashList().get(i))){
//							flyGame.getTrashList().remove(i);
//							flyGame.getCoordinateList().remove(i);
//							flyGame.decreaseLength();;
//							flyGameView.removeTrash(i);
//							flyGame.getNotHeldList().remove(i);
							removeTrash(i);
						}
						else{
							flyGame.getTrashList().get(i).setLoc(trashXCoor, trashYCoor);
							flyGame.getCoordinateList().set(i,flyGame.getTrashList().get(i).getX());
							flyGameView.trashDrag(i,flyGame.getTrashList().get(i).getX(),flyGame.getTrashList().get(i).getY());
							flyGame.getNotHeldList().set(i,true);
						}
					}
					
				}
			}
			
		};
		return l;
	}
	
	public MouseMotionListener addMouseMotion(){
		MouseMotionListener listen=new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent event) {
				for(int k=0;k<flyGame.getLength();k++){
					if(!flyGame.getNotHeldList().get(k)){
						int deltaX = event.getX() - screenX;
				        int deltaY = event.getY() - screenY;
				        flyGame.getTrashList().get(k).setLoc(trashXCoor + deltaX, trashYCoor + deltaY);
				        flyGameView.trashDrag(k,trashXCoor + deltaX,trashYCoor + deltaY);
					}
				}
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				
			}

			
		};
		return listen;
	}
	
	public ActionListener addTime(){
		ActionListener timerListener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				flyGame.decreaseTime();
				flyGame.setAddTrash(false);
			}
			
		};
		return(timerListener);
	}
	
	public void addTrash(int y) {
		flyGame.addTrash(y);
		flyGameView.addTrash((int)(1400* Game.WIDTHRATIO),(int)(200 * y * Game.HEIGHTRATIO));
		
	}
	
	public void removeTrash(int index){
		flyGame.removeTrash(index);
		flyGameView.removeTrash(index);
	}

}
