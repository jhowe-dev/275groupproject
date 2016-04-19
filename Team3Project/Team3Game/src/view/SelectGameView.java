package view;

import java.awt.*;
import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.*;

import Controller.SelectGameController;
import Model.ExitArrow;
import Model.Plant;
public class SelectGameView extends View {

	private double imgw = 1440; 
	private double imgh = 900; 
	
	private ArrayList<PlantView> plants = new ArrayList<PlantView>();
	private ExitArrowView exArr;
	private double heightRatio=1;
	private double widthRatio=1;
	boolean start = true;
	private HealthView health= new HealthView();
	
	public SelectGameView(ArrayList<Plant> plantList, ExitArrow exit){
		for(Plant p:plantList){
			plants.add(new PlantView(p.getX(),p.getY()));
		}
		exArr= new ExitArrowView(exit.getX(), exit.getY());
	}		
	
	public void render(){
			for(PlantView p:plants)
			{
				add(p);
			}
		add(exArr);
		add(health);
		setSize((int)(1440*widthRatio),(int)(900*heightRatio));
		setVisible(true);	
	}
	public void displayMessage(String message){
		JOptionPane.showMessageDialog(null, message);
	}
}
