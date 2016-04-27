package flyGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import general.Game;
import general.View;

public class FlyGameView extends View {
	ArrayList<TrashView> trashlist=new ArrayList<TrashView>();
	TrashCanView can = new TrashCanView();
	LivesView lifepic;
	public Clocker cl;
	RedknotView red;
	boolean start = true;
	private Image image;
	public FlyGameView() {
		lifepic = new LivesView(7);
		cl = new Clocker(61, 1200, 650);
		red = new RedknotView(100, 1220);
	}
	
	public void render(ArrayList<Integer> coordinates) {
		
		if(start){
			start=false;
			add(can);
			add(cl);
			add(red);
			add(lifepic);
			
			setSize((int)(1440* Game.WIDTHRATIO), (int)(900* Game.HEIGHTRATIO));
	    	setVisible(true);
			try {
	            //image = ImageIO.read(new File("images/Flygame.png"));
	            image = ImageIO.read(new File("images/background-21717_1920(1).jpg"));
	            //
	            System.out.println(image.getWidth(null));
	            System.out.println(image.getHeight(null));
	            image= image.getScaledInstance((int)(1440* Game.WIDTHRATIO), (int)(900* Game.HEIGHTRATIO), Image.SCALE_DEFAULT);
	            System.out.println(image.getWidth(null));
	            System.out.println(image.getHeight(null));
	        } catch (final IOException e) {
	            e.printStackTrace();
	        }   
	    	//background-21717_1920.jpg
		}
		else {
			int q = 0;
			for(int i : coordinates){
				setCoor(q,i);
				q++;
			}
			remove(can);
			remove(cl);
			remove(red);
			remove(lifepic);
			add(can);
			add(cl);
			add(red);
			add(lifepic);
		}
		revalidate();
		repaint();
	}
	
	public void addTrash(int x, int y){
		TrashView t=new TrashView(x,y);
		trashlist.add(t);
		add(t);
		revalidate();
		repaint();
		//repaint();
	}
	public void removeTrash(int index){
		remove(trashlist.get(index));
		trashlist.remove(index);
		revalidate();
		repaint();
		//repaint();
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
	public void trashDrag(int index, int x, int y){
		trashlist.get(index).setDragcoor(x,y);
	}
	public void setCoor(int index, int coorx){
		trashlist.get(index).setcoor(coorx);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}
}
