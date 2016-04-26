package view;

import javax.swing.JButton;

public class PlantButtonView extends JButton{
	public PlantButtonView(String name, int y){
		setText(name);
		setSize(100,100);
		setLocation(0,195+100*y);
	}
}
