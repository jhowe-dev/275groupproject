package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import Controller.FlyGameController;

public class ScientistGameView extends View {
	ArrayList<FisherManView> fishermen=new ArrayList<FisherManView>();
	ArrayList<FishView> fishes=new ArrayList<FishView>();
	ArrayList<Trashview> trashes=new ArrayList<Trashview>();
	ArrayList<LiquidView> liquids=new ArrayList<LiquidView>();
	ToolButtonView ticket=new ToolButtonView("Ticket",0,0);
	ToolButtonView vile=new ToolButtonView("vile",1,0);
	ToolButtonView bin=new ToolButtonView("bin",0,1);
	ToolButtonView tag=new ToolButtonView("tag",1,1);
	HorseshoeCrabView h=new HorseshoeCrabView(670,200);
	ToolTableView t=new ToolTableView(520,0);
	Riverview r=new Riverview();
	Livesview lifepic=new Livesview(7);
	public Clocker cl=new Clocker(61);
	Redknotview red=new Redknotview(100,1220);
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
		setVisible(true);
		  //setExtendedState(JMAXIMIZED_BOTH); 
		 // setUndecorated(true);
		
	}
	public void addFisherman(int x,MouseListener listen){
		
		FisherManView fishman=new FisherManView(x,350);
		fishermen.add(fishman);
		add(fishman);
		fishman.addMouseListener(listen);
	}
	public void addFish(int x,int y, MouseListener listen){
		FishView fish=new FishView(x*100,y*100+470);
		fishes.add(fish);
		add(fish);
		fish.addMouseListener(listen);
		repaint();
		
	}
	public void addTrash(int x,int y,MouseListener listen){
		Trashview trash=new Trashview(x*100,y*100+470);
		trashes.add(trash);
		add(trash);
		trash.addMouseListener(listen);
		repaint();
	}
	public void addLiquid(int x,int y,MouseListener listen){
		LiquidView liquid=new LiquidView(x*100,y*100+470);
		liquids.add(liquid);
		add(liquid);
		liquid.addMouseListener(listen);
		repaint();
	}
	public void removeFisherman(int index){
		remove(fishermen.get(index));
		//fishermen.remove(index);
		repaint();
	}
	public void removeFish(int index){
		remove(fishes.get(index));
		//fishes.remove(index);
		repaint();
	}
	public void removeTrash(int index){
		remove(trashes.get(index));
		//trashes.remove(index);
		repaint();
	}
	public void removeLiquid(int index){
		remove(liquids.get(index));
		//liquids.remove(index);
		repaint();
	}
}
