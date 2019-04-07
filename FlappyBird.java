import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FlappyBird extends JFrame implements KeyListener {
	private static Pipe thePipe;
	private static ArrayList<Pipe> pipes;
	private static Bird a;
	private static int points;
	private static int counter;
	private static int highScores;
	

	FlappyBird() {
		setSize(1000, 1000);
		this.getContentPane().setBackground(Color.cyan);
		setBackground(Color.cyan);
		setTitle("An Empty Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		KeyListener listener = new KeyListener() {
			public void keyPressed(KeyEvent e) {
				char c;
				c = e.getKeyChar();
				if (c == (' ')) {
					for (int i = 0; i < 20; i++) {
						a.flap();
						try {
							TimeUnit.MILLISECONDS.sleep(1);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}

			}

			public void keyReleased(KeyEvent e) {
				char c;
				c = e.getKeyChar();
			}

			/** Handle the key typed event from the text field. */
			public void keyTyped(KeyEvent e) {
				char c;
				c = e.getKeyChar();
			}

		};
		this.addKeyListener(listener);

	}

	public static void main(String[] args) throws InterruptedException, IOException {
		FlappyBird m = new FlappyBird();
		ArrayList<String> musicfiles = new ArrayList<String>();
		musicfiles.add("likey.wav.crdownload");
		musicfiles.add("babyShark.wav.crdownload");
		musicfiles.add("HitorMiss.wav");
		String filepath = musicfiles.get((int)(Math.random()*2));
		PlayMusic myMusic = new PlayMusic();
		myMusic.playMusic(filepath);
		boolean gameOver = false;
		BufferedReader read = new BufferedReader(new FileReader("BirdColor.txt"));
		String birdie = read.readLine();
		
		if(birdie.equals("red")) {
			a = new Bird(Color.red);
		}else if(birdie.equals("orange")) {
			a = new Bird(Color.orange);
		}else{
			a = new Bird(Color.yellow);
		}
		read.close();
		pipes = new ArrayList<Pipe>();
		points = 0;
		counter = -3;
		int k = 0;
		m.repaint();
		while (!gameOver) {
			if (k % 8 == 0) {
				thePipe = new Pipe();
				pipes.add(thePipe);
				counter++;
				if(counter % 10 == 0 && counter != 0) {
					points += 5;
				}
			}
			

			for (int i = 0; i < pipes.size(); i++) {
				TimeUnit.MILLISECONDS.sleep(50);
				for (int c = 0; c < 12; c++) {
					a.gravity();
					TimeUnit.MILLISECONDS.sleep(1);
					if (checkCollision(a, pipes.get(0))) {
						gameOver = true;
						break;
					}
					if (a.getY() >= 600) {
						gameOver = true;
					}
				}
				for (int j = 0; j < 10; j++) {
					pipes.get(i).update();
					if (pipes.get(i).getX() == a.getX()) {
						points++;
					}
					TimeUnit.MILLISECONDS.sleep(1);
					if (checkCollision(a, pipes.get(0))) {
						gameOver = true;
						break;
					}
					if (a.getY() >= 600) {
						gameOver = true;
					}
				}

				if (pipes.get(i).getX() >= 1000) {
					pipes.remove(i);
				}
			}
			m.repaint();
			k++;

		}
		System.out.println(points);
		BufferedReader reader = new BufferedReader(new FileReader("HighScore.txt"));
		try {
			highScores = reader.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		highScores += points;
		BufferedWriter writer = new BufferedWriter(new FileWriter("HighScore.txt"));
		writer.write(highScores);		
		writer.close();
		m.repaint();
		Shop q = new Shop(a, highScores);
		q.createWindow();
	}

	public static boolean checkCollision(Bird a, Pipe b) {
		int birdX = a.getX();
		int birdY = a.getY();
		int pipeTopX = b.getX();
		int pipeBottomX = b.getX();
		int pipeTopY = b.getHeightTop();
		int pipeBottomY = 600 - b.getHeightBottom();
		if(birdX >= pipeBottomX && birdX <= pipeBottomX + 50 && birdY > pipeBottomY) {
			return true;
			//return true;
		}else if(birdX >= pipeTopX && birdX <= pipeTopX + 50 && birdY <= pipeTopY) {
			return true;
			//return true;
		}
		
		return false;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		a.paint(g);
		g.setColor(Color.green);
		g.drawRect(0, 600, 1000, 400);
		g.fillRect(0, 600, 1000, 400);
		for (int i = 0; i < pipes.size(); i++) {
			pipes.get(i).paint(g);
		}

		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 45));
		g.drawString("$" + Integer.toString(points), 500, 80);

	}
	

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
