package flyGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;

import general.Game;

public class TrashCanView extends JComponent {
	private BufferedImage image;
	public TrashCanView(){
		setLayout(null);
		setBorder(new LineBorder(Color.GREEN, 3));
		setBackground(Color.WHITE);
		setBounds((int)(50* Game.WIDTHRATIO), (int)(650* Game.HEIGHTRATIO), (int)(150* Game.WIDTHRATIO), (int)(200* Game.HEIGHTRATIO));
		setOpaque(false);
		try {
            image = ImageIO.read(new File("images/bin-147288_1280.png"));
        } catch (final IOException e) {
            e.printStackTrace();
        }    
	}
	public void paint(Graphics g){
		g.drawImage(image, 0, 0, (int)(150* Game.WIDTHRATIO),(int)(200* Game.HEIGHTRATIO), null);
	}
}
