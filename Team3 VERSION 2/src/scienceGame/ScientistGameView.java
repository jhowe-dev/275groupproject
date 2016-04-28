package scienceGame;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import general.View;
import general.Clocker;
import general.TrashView;

public class ScientistGameView extends View {
	FisherManView[] fishermen=new FisherManView[12];
	Map<Integer,FishView> fishes=new HashMap<Integer,FishView>();
	Map<Integer,TrashView> trashes=new HashMap<Integer,TrashView>();
	Map<Integer,LiquidView> liquids=new HashMap<Integer,LiquidView>();
	ToolButtonView ticket=new ToolButtonView("Ticket",0,0);
	ToolButtonView vile=new ToolButtonView("vile",1,0);
	ToolButtonView bin=new ToolButtonView("bin",0,1);
	ToolButtonView tag=new ToolButtonView("tag",1,1);
	HorseshoeCrabView h=new HorseshoeCrabView(670,200);
	ToolTableView t=new ToolTableView(520,0);
	RiverView r=new RiverView();
	ScoreView scoreview=new ScoreView(0);
	public Clocker cl=new Clocker(61,1240,0);
	public ScientistGameView(){
		setLayout(null);
		setSize((int) 1440, (int) 900);
		ticket.setBackground(Color.RED);
		vile.setBackground(Color.MAGENTA);
		bin.setBackground(Color.GREEN);
		tag.setBackground(Color.ORANGE);
		add(h);
		add(t);
		add(ticket);
		add(bin);
		add(vile);
		add(tag);
		add(r);
		add(cl);
		add(scoreview);
		setVisible(true);
		  //setExtendedState(JMAXIMIZED_BOTH); 
		 // setUndecorated(true);
		
	}
	public void addFisherman(int x,int index){
		
		FisherManView fishman=new FisherManView(x*100,320);
		fishermen[index]=fishman;
		add(fishman);
		repaint();
	}
	public void addFish(int x,int y,int index){
		FishView fish=new FishView(x*100,y*100+470);
		fishes.put(new Integer(index),fish);
		add(fish);
		repaint();
		
	}
	public void addTrash(int x,int y,int index){
		TrashView trash=new TrashView(x*100,y*100+470);
		trashes.put(new Integer(index),trash);
		add(trash);
		repaint();
	}
	public void addLiquid(int x,int y,int index){
		LiquidView liquid=new LiquidView(x*100,y*100+470);
		liquids.put(new Integer(index),liquid);
		add(liquid);
		repaint();
	}
	public void removeFisherman(int index){
		remove(fishermen[index]);
		fishermen[index]=null;
		repaint();
	}
	public void removeFish(int index){
		remove(fishes.get(index));
		fishes.remove(index);
		repaint();
	}
	public void removeTrash(int index){
		remove(trashes.get(index));
		trashes.remove(index);
		repaint();
	}
	public void removeLiquid(int index){
		remove(liquids.get(index));
		liquids.remove(index);
		repaint();
	}
	public void addTicketButton(MouseListener listen){
		ticket.addMouseListener(listen);
	}
	public void addBinButton(MouseListener listen){
		bin.addMouseListener(listen);
	}
	public void addVileButton(MouseListener listen){
		vile.addMouseListener(listen);
	}
	public void addTagButton(MouseListener listen){
		tag.addMouseListener(listen);
	}
	public void setScore(int score){
		scoreview.setScore(score);
	}
	public void updateTime(int time){
		cl.setTime(time);
	}
	
	

}
