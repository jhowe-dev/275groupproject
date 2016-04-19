package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class ScientistGameView extends View {
	ArrayList<ToolView> trashlist=new ArrayList<ToolView>();
	IssueView can=new IssueView();
	boolean start=true;
	Livesview lv=new Livesview(7);
	public Clocker cl=new Clocker(60);
	//Redknotview red=new Redknotview(100,1220);
	public void onTick(ArrayList<int []> coordinates){
		
		if(start){
			int q=0;
			for(int[] i:coordinates){
				trashlist.add(new ToolView(i[0],i[1]));
				ToolView t=trashlist.get(q);
				add(t);
				q++;
			}
			start=false;
			add(can);
			add(cl);
			//add(red);
			add(lv);
			setSize(1440, 900);
	    	//setDefaultCloseOperation(JEXIT_ON_CLOSE);
	    	setVisible(true);
		}
		else{
			int q=0;
			for(int[] i:coordinates){
				trashlist.get(q).setcoor(i[0],i[1]);
				q++;
			}
		}
		//setUndecorated(true);
		
	}
	public void addTrash(int x, int y){
		ToolView t=new ToolView(x,y);
		trashlist.add(t);
		add(t);
	}
	public void removeTrash(int i){
		remove(trashlist.get(i));
		trashlist.remove(i);
		repaint();
	}
	public void updatetime(int i){
		cl.settime(i);
	}
	public void updatelives(int i){
		lv.setlive(i);
	}
	
}
