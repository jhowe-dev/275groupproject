package scienceGame;

import javax.swing.JButton;

public class ToolButtonView extends JButton {
	public ToolButtonView(String name,int x, int y){
		setText(name);
		setSize(200,100);
		setLocation(520+200*x,0+100*y);
	}

}