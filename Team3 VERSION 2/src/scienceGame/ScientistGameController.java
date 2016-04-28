package scienceGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.Timer;

public class ScientistGameController {
	private ScientistGame scientistGame;
	private ScientistGameView scientistGameView;
	private Timer timer = new Timer(1000,addTime());
	private Random rand = new Random();
	
	public ScientistGameController(ScientistGame scientistGame, ScientistGameView scientistGameView) {
		this.scientistGame = scientistGame;
		this.scientistGameView = scientistGameView;
		scientistGameView.addMouseListener(addMouse());
		scientistGameView.addTicketButton(addTicket());
		scientistGameView.addBinButton(addBin());
		scientistGameView.addVileButton(addVile());
		scientistGameView.addTagButton(addTag());
	}
	
	public void onTick() {
		timer.setInitialDelay(0);
        timer.start();
		while(scientistGame.getTime() > 0){
			System.out.println("working");
			try {
				Thread.sleep(60);
				} 
			catch (InterruptedException e) {
				e.printStackTrace();
				}
			for(int i=0;i<12;i++){
				if(scientistGame.getFishmen()[i]!=null){
					scientistGame.getFishmen()[i].tick();
					if(scientistGame.getFishmen()[i].getTimer()>120){
						scientistGame.removeFishman(i);
						scientistGameView.removeFisherman(i);
						scientistGame.decrementScore();
					}
				}
			}
			for(int i=0;i<4;i++){
				for(int j=0;j<14;j++){
					if(scientistGame.getRiver()[i][j]!=null){
						scientistGame.getRiver()[i][j].tick();
						if(scientistGame.getRiver()[i][j].getTimer()>120){
							removeRiverItem(i,j,scientistGame.getRiver()[i][j].getType(),scientistGame.getRiver()[i][j].getIndex());
							scientistGame.decrementScore();
						}
						
					}
					
				}
			}
			while((scientistGame.getCounter()>=60)){
				int r=rand.nextInt(4);
				if(r==0){
					r=rand.nextInt(12);
					switch(r){
					case 0:
						scientistGame.addFishman(r,r);
						scientistGameView.addFisherman(r, r);
						break;
					case 1:
						scientistGame.addFishman(r,r);
						scientistGameView.addFisherman(r, r);
						break;
					case 2:
						scientistGame.addFishman(r,r);
						scientistGameView.addFisherman(r, r);
						break;
					case 3:
						scientistGame.addFishman(r,r);
						scientistGameView.addFisherman(r, r);
						break;
					case 4:
						scientistGame.addFishman(r,r);
						scientistGameView.addFisherman(r, r);
						break;
					case 5:
						scientistGame.addFishman(r,r);
						scientistGameView.addFisherman(r, r);
						break;
					case 6:
						scientistGame.addFishman(r+2,r);
						scientistGameView.addFisherman(r, r);
						break;
					case 7:
						scientistGame.addFishman(r+2,r);
						scientistGameView.addFisherman(r, r);
						break;
					case 8:
						scientistGame.addFishman(r+2,r);
						scientistGameView.addFisherman(r, r);
						break;
					case 9:
						scientistGame.addFishman(r+2,r);
						scientistGameView.addFisherman(r, r);
						break;
					case 10:
						scientistGame.addFishman(r+2,r);
						scientistGameView.addFisherman(r, r);
						break;
					case 11:
						scientistGame.addFishman(r+2,r);
						scientistGameView.addFisherman(r, r);
						break;
					}
					scientistGame.setCounter(0);;
				}
				else{
					int xr=rand.nextInt(14);
					int yr=rand.nextInt(4);
					if(scientistGame.getRiver()[yr][xr]==null){
						int tr=rand.nextInt(3);
						addRiverItem(xr,yr,tr);
						scientistGame.setCounter(0);
					}
				}
				
			}
			scientistGame.incrementCounter();;
			scientistGameView.setScore(scientistGame.getScore());
			scientistGameView.updateTime(scientistGame.getTime());
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
				scientistGame.decrementTime();
				
			}
			
		};
		return(timerListener);
	}
	
	public MouseListener addMouse(){
		MouseListener listen=new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent event) {
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
				if(scientistGame.getTrash() || scientistGame.getFishman() || scientistGame.getFish() || scientistGame.getLiquid()) {
					int screenX = (event.getX());
					int screenY = (event.getY()-470);
					if(screenY>=0){
						screenX/=100;
						screenY/=100;
						if(scientistGame.getRiver()[screenY][screenX]!=null) {
							if(scientistGame.getTrash() && scientistGame.getRiver()[screenY][screenX].getType()==0){
								removeRiverItem(screenY,screenX,scientistGame.getRiver()[screenY][screenX].getType(),scientistGame.getRiver()[screenY][screenX].getIndex());
								scientistGame.incrementScore();;
							}
							else if(scientistGame.getFish()&&scientistGame.getRiver()[screenY][screenX].getType()==1){
								removeRiverItem(screenY,screenX,scientistGame.getRiver()[screenY][screenX].getType(),scientistGame.getRiver()[screenY][screenX].getIndex());
								scientistGame.incrementScore();
							}
							else if(scientistGame.getFishman()){

							}
							else if(scientistGame.getLiquid()&&scientistGame.getRiver()[screenY][screenX].getType()==2){
								removeRiverItem(screenY,screenX,scientistGame.getRiver()[screenY][screenX].getType(),scientistGame.getRiver()[screenY][screenX].getIndex());
								scientistGame.incrementScore();
							}
							else{
								scientistGame.decrementScore();
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
							if(scientistGame.getFishmen()[indexer]!=null){
								if(scientistGame.getFishman()){
									scientistGame.removeFishman(indexer);
									scientistGameView.removeFisherman(indexer);
									scientistGame.incrementScore();;
								}
								else{
									scientistGame.decrementScore();;
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
				scientistGame.setFishman(!scientistGame.getFishman());
				scientistGame.setFish(false);
				scientistGame.setTrash(false);
				scientistGame.setLiquid(false);				
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
				scientistGame.setFishman(false);
				scientistGame.setFish(false);
				scientistGame.setTrash(!scientistGame.getTrash());
				scientistGame.setLiquid(false);
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
				scientistGame.setFishman(false);
				scientistGame.setFish(false);
				scientistGame.setTrash(false);
				scientistGame.setLiquid(!scientistGame.getLiquid());
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
				scientistGame.setFishman(false);
				scientistGame.setFish(!scientistGame.getFish());
				scientistGame.setTrash(false);
				scientistGame.setLiquid(false);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		};
		return listen;
	}
	
	public void addRiverItem(int x,int y,int type){
		if(type==0){
			RiverItem item=new RiverItem(x,y,type,scientistGame.getCounterTrash());
			scientistGame.getRiver()[y][x]=item;
			scientistGameView.addTrash(x,y,scientistGame.getCounterTrash());
			scientistGame.incrementCounterTrash();;
		}
		else if(type==1){
			RiverItem item=new RiverItem(x,y,type,scientistGame.getCounterFish());
			scientistGame.getRiver()[y][x]=item;
			scientistGameView.addFish(x,y,scientistGame.getCounterFish());
			scientistGame.incrementCounterFish();;
		}
		else if(type==2){
			RiverItem item=new RiverItem(x,y,type,scientistGame.getCounterLiquid());
			scientistGame.getRiver()[y][x]=item;
			scientistGameView.addLiquid(x,y,scientistGame.getCounterLiquid());
			scientistGame.incrementCounterLiquid();;
		}

	}
	
	public void removeRiverItem(int x,int y,int type,int index){
		if(type==0){
			scientistGame.getRiver()[x][y]=null;
			scientistGameView.removeTrash(index);
			
		}
		else if(type==1){
			scientistGame.getRiver()[x][y]=null;
			scientistGameView.removeFish(index);

		}
		else if(type==2){
			scientistGame.getRiver()[x][y]=null;
			scientistGameView.removeLiquid(index);

		}

	}

}
