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
	ArrayList<Trashview> trashlist=new ArrayList<Trashview>();
	Trashcanview can=new Trashcanview();
	public int imgw=FlyGameController.imgw;
	public int imgh=FlyGameController.imgh;
	public double hratio=FlyGameController.heightratio;
	public double wratio=FlyGameController.widthratio;
	boolean start=true;
	Livesview lv=new Livesview(7);
	public Clocker cl=new Clocker(60);
	Redknotview red=new Redknotview(100,1220);
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
			frame.add(lv);
			frame.setSize((int)(1440*wratio), (int)(900*hratio));
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	public void removeTrash(int i){
		frame.remove(trashlist.get(i));
		trashlist.remove(i);
		frame.repaint();
	}
	public void updatetime(int i){
		cl.settime(i);
	}
	public void updatelives(int i){
		lv.setlive(i);
	}
	public void updatered(int i){
		red.sety(i);
	}
	
}
