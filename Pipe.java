import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Pipe {
	
	private int heightTop;
	private int heightBottom;
	private int width;
	private Color aColor;
	private int x;
	public Pipe() {
		this.width = 50;
		this.heightTop = (int) (Math.random() * 400);
		this.heightBottom = 400- this.heightTop;
		
		this.aColor = Color.black;
		this.x = 0;
		
	}
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(x,600-heightBottom,width, heightBottom);
		g.fillRect(x, 600-heightBottom, width, heightBottom);
		g.setColor(Color.pink);
		g.drawRect(x, 0, width, heightTop);
		g.fillRect(x, 0, width, heightTop);
	}
	public int getWidth() {
		return width;
	}
	public int getHeightTop() {
		return heightTop;
		
	}
	public int getHeightBottom() {
		return heightBottom;
	}
	public void update() {
		x += 5;
	}
	public int getX() {
		return x;
	}
	
	
}
