package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import Controller.FlyGameController;

public class FlyGameView extends View {
	private ArrayList<Trashview> trashlist=new ArrayList<Trashview>();
	private Trashcanview can=new Trashcanview();
	public int imgw=FlyGameController.imgw;
	public int imgh=FlyGameController.imgh;
	public double hratio=FlyGameController.heightratio;
	public double wratio=FlyGameController.widthratio;
	private boolean start=true;
	private Livesview lifepic=new Livesview(7);
	private Clocker cl=new Clocker(60);
	private Redknotview red=new Redknotview(100,1220);
	public void render(ArrayList<int []> coordinates){
		
		if(start){
			int q=0;
			for(int[] i:coordinates){
				trashlist.add(new Trashview(i[0],i[1]));
				Trashview t=trashlist.get(q);
				frame.add(t);
				q++;
			}
			start=false;
			frame.add(can);
			frame.add(cl);
			frame.add(red);
			frame.add(lifepic);
			frame.setSize((int)(1440*wratio), (int)(900*hratio));
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	//frame.setUndecorated(true);
	    	frame.setVisible(true);
		}
		else{
			int q=0;
			for(int[] i:coordinates){
				trashlist.get(q).setcoor(i[0],i[1]);
				q++;
			}
		}
		//frame.setUndecorated(true);
		
	}
	public void addTrash(int x, int y){
		Trashview t=new Trashview(x,y);
		trashlist.add(t);
		frame.add(t);
	}
	public void removeTrash(int index){
		frame.remove(trashlist.get(index));
		trashlist.remove(index);
		frame.repaint();
	}
	public void updateTime(int time){
		cl.setTime(time);
	}
	public void updateLives(int lives){
		lifepic.setlive(lives);
	}
	public void updateRed(int yPosition){
		red.sety(yPosition);
	}
	
}
