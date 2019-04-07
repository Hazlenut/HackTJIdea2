import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author User
 */
public class Bird {
	private int width;
	private int height;
	private int x;
	private int y;
	private Color aColor;
	public Bird(Color aColor) {
		width = 50;
		height = 50;
		x = 900;
		y = 300;
		this.aColor = aColor;
	}
	public void flap() {
		y-=5;
	}
	public int getY() {
		return y;
	}
	public void gravity() {
		y+=2;
	}
	public int getX() {
		return x;
	}
	public void paint(Graphics g) {
		g.setColor(aColor);
		g.drawRect(x, y, width, height);
		g.fillRect(x, y, width, height);
	}
	public void changeColor(Color change) {
		aColor = change;
	}
	
	
}
