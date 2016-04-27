package flyGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import general.Game;

public class RedknotView extends JComponent {
	private volatile int x;
	private volatile int y;
	private BufferedImage image;
	public RedknotView(int x, int y){
		this.x=x;
		this.y=y;
		setLayout(null);
		setBorder(new LineBorder(Color.RED, 3));
		setBackground(Color.WHITE);
		setBounds((int)(100* Game.WIDTHRATIO), (int)(225* Game.HEIGHTRATIO), (int)(100* Game.WIDTHRATIO), (int)(100* Game.HEIGHTRATIO));
		setOpaque(false);
		try {
            image = ImageIO.read(new File("images/Humming_Bird_Transparent_PNG_Clipart_Picture.png"));
        } catch (final IOException e) {
            e.printStackTrace();
        }    
		
	}
	public void sety(int i){
		y=i;
		setLocation(x,y);
	}
	public void paint(Graphics g){
		g.drawImage(image, 0, 0, (int)(100* Game.WIDTHRATIO),(int)(100* Game.HEIGHTRATIO), null);
	}
}
