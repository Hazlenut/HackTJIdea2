import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
public class Shop extends JFrame{
	private static JButton red;
	private static JButton orange;
	private static JButton yellow;
	private static Bird a;
	private static int points;
	public Shop(Bird a, int points) {
		this.a = a;
		this.points = points;
	}
	public static void createWindow() {
		JFrame myFrame = new JFrame("Shop");
		myFrame.setSize(750,500);
		myFrame.setLayout(null);
		JLabel title = new JLabel("Welcome to the Shop!");
	
		title.setBounds(150,50, 200, 50);
		myFrame.add(title);
		 red = new JButton("Red Bird");
		
		red.setBounds(450,250,150, 50);
		 orange = new JButton("Orange Bird");
		orange.setBounds(50,250,150,50);
		 yellow = new JButton("Yellow Bird");
		yellow.setBounds(250,250,150,50);
		
		myFrame.add(red);
		myFrame.add(orange);
		myFrame.add(yellow);
		myFrame.setVisible(true);
		
		}
	
	public void actionPerformed(ActionEvent e) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("BirdColor.txt"));
	
	    if (e.getSource() == red && points >= 50) {
	    	writer.write("red");
	    	points -= 50;
	    }
	    if (e.getSource() == orange && points >= 50) {
	    	writer.write("orange");
	    	points -= 50;
	    }
	    if (e.getSource() == yellow && points >= 50) {
	    	writer.write("yellow");
	    	points-=50;
	    }
	    writer.close();
	}
	
	}
	

