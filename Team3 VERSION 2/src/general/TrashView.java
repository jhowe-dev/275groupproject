package general;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;

public class TrashView extends JComponent {
	private volatile int x;
	private volatile int y;
	private int type;
	private Random rand=new Random();
	private BufferedImage image;
	public TrashView(int x, int y){
		this.x=x;
		this.y=y;
		setLayout(null);
		setBorder(new LineBorder(Color.BLUE, 3));
		setBackground(Color.WHITE);
		setBounds(x, y, (int)(100* Game.WIDTHRATIO), (int)(100* Game.HEIGHTRATIO));
		setOpaque(false);
		type=rand.nextInt(3);
		try {
			switch(type){
			case 0:
				image = ImageIO.read(new File("images/shopping-bag-30543_1280.png"));
				break;
			case 1:
				image = ImageIO.read(new File("images/coca-cola-443123_1280.png"));
				break;
			case 2:
				image = ImageIO.read(new File("images/6_pack_rings.png"));
				break;
			}
			
			
            
        } catch (final IOException e) {
            e.printStackTrace();
        }   
		
	}
	public void setcoor(int xc){
		x=xc;
		setLocation(x,y);
		  validate();
		  repaint();
	}
	public void setDragcoor(int xc,int yc){
		x=xc;
		y=yc;
		setLocation(x,y);
	}
	public void paint(Graphics g){
		g.drawImage(image, 0, 0, (int)(100* Game.WIDTHRATIO),(int)(100* Game.HEIGHTRATIO), null);
	}
}
