package com.diamondcastle.gameplaypanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.diamondcastle.main.Main;
import com.diamondcastle.music.musicPlay;

public class credit extends JPanel {
	public static ArrayList<Integer> position = new ArrayList<Integer>();
	private double countDown = 92.5;
	private Image imgg, img1, img2, img3, img4, img5, img6, img7, img8;
	static musicPlay music3 = new musicPlay();
	public Font Title, sub, credit, thank;
	
	public credit(){
		
		try {
			Title = Font.createFont(Font.TRUETYPE_FONT, new File("resource/font/Maghrib-MVZpx.ttf")).deriveFont(80f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Title);
			
			sub = Font.createFont(Font.TRUETYPE_FONT, new File("resource/font/AfternoonCoffee-GOqyO.ttf")).deriveFont(47f);
			GraphicsEnvironment ge0 = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge0.registerFont(sub);
			
			credit = Font.createFont(Font.TRUETYPE_FONT, new File("resource/font/Alohasummer-PKX7r.ttf")).deriveFont(40f);
			GraphicsEnvironment ge1 = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge1.registerFont(credit);
			
			thank = Font.createFont(Font.TRUETYPE_FONT, new File("resource/font/AllessaPersonalUse-4pRl.ttf")).deriveFont(45f);
			GraphicsEnvironment ge2 = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge2.registerFont(thank);
			
	   }
	   catch(IOException | FontFormatException e) {
	    
	   }
		
		music3.playMusic("resource/song/credit.wav");
		this.imgg = new ImageIcon("resource/images/credit_bg.jpg").getImage();
		this.img1 = new ImageIcon("resource/images/omori1.png").getImage();
		this.img2 = new ImageIcon("resource/images/omori2.png").getImage();
		this.img3 = new ImageIcon("resource/images/omori3.png").getImage();
		this.img4 = new ImageIcon("resource/images/omori4.png").getImage();
		this.img5 = new ImageIcon("resource/images/omori5.png").getImage();
		this.img6 = new ImageIcon("resource/images/omori6.png").getImage();
		this.img7 = new ImageIcon("resource/images/omori7.png").getImage();
		this.img7 = new ImageIcon("resource/images/omori8.png").getImage();
		position.add(750);//made by
		position.add(850);
		position.add(890);
		position.add(970);
		position.add(1010);
		
		position.add(1210);//special thanks to
		
		position.add(1340);//game inspirations
		position.add(1400);
		position.add(1440);
		position.add(1480);
		
		position.add(1610);//assets
		position.add(1670);
		position.add(1710);
		position.add(1750);
		position.add(1790);
		position.add(1830);
		
		position.add(1960);//backsound songs
		position.add(2020);
		position.add(2060);
		position.add(2100);
		position.add(2140);
		position.add(2180);
		position.add(2220);
		
		position.add(2420);//finally
		position.add(2770);
		position.add(800);
		position.add(1000);
		position.add(1200);
		position.add(1400);
		position.add(1600);
		position.add(1800);
		position.add(2000);
		position.add(2300);
	}

    public void paint(Graphics gp) {
	     super.paint(gp);
	     Graphics2D g2d= (Graphics2D) gp;
	     g2d.setFont(Title);
	     g2d.setColor(new Color(0, 0, 128));
	     gp.drawImage(img1, 100, position.get(25), null);
	     gp.drawImage(img2, 900, position.get(26), null);
	     gp.drawImage(img3, 100, position.get(27), null);
	     gp.drawImage(img4, 900, position.get(28), null);
	     gp.drawImage(img5, 100, position.get(29), null);
	     gp.drawImage(img6, 900, position.get(30), null);
	     gp.drawImage(img7, 100, position.get(31), null);
	     gp.drawImage(img8, 900, position.get(32), null);
	     drawCenteredString("Made By :", 1280, position.get(0), g2d);
	     
	     g2d.setFont(credit);
	     g2d.setColor(new Color (255, 153, 0));
	     drawCenteredString("James Rafferty Lee",1280, position.get(1), g2d);
	     drawCenteredString("05111940000055",1280, position.get(2), g2d);
	     drawCenteredString("Adrian",1280, position.get(3), g2d);
	     drawCenteredString("05111940000130",1280, position.get(4), g2d);
	     
	     g2d.setFont(Title);
	     g2d.setColor(new Color(0, 0, 128));
	     drawCenteredString("Special Thanks to :",1280, position.get(5), g2d);
	     
	     g2d.setFont(sub);
	     g2d.setColor(new Color(0, 77, 0));
	     drawCenteredString("Game Inspirations : ",1280, position.get(6), g2d);
	     g2d.setFont(credit);
	     g2d.setColor(new Color (255, 153, 0));
	     drawCenteredString("Omori",1280, position.get(7), g2d);
	     drawCenteredString("Final Fantasy",1280, position.get(8), g2d);
	     drawCenteredString("Divinity : Original Sin II",1280, position.get(9), g2d);
	    
	     g2d.setFont(sub);
	     g2d.setColor(new Color(0, 77, 0));
	     drawCenteredString("Assets : ",1280, position.get(10), g2d);
	     g2d.setFont(credit);
	     g2d.setColor(new Color (255, 153, 0));
	     drawCenteredString("https://luizmelo.itch.io/wizard-pack",1280, position.get(11), g2d);
	     drawCenteredString("https://luizmelo.itch.io/martial-hero",1280, position.get(12), g2d);
	     drawCenteredString("https://clembod.itch.io/warrior-free-animation-set",1280, position.get(13), g2d);
	     drawCenteredString("Omori",1280, position.get(14), g2d);
	     drawCenteredString("Divinity : Original Sin II",1280, position.get(15), g2d);
	     
	     g2d.setFont(sub);
	     g2d.setColor(new Color(0, 77, 0));
	     drawCenteredString("Backsound Songs : ",1280, position.get(16), g2d);
	     g2d.setFont(credit);
	     g2d.setColor(new Color (255, 153, 0));
	     drawCenteredString("Omori - 002 White Space",1280, position.get(17), g2d);
	     drawCenteredString("Omori - 004 Spaces in Between",1280, position.get(18), g2d);
	     drawCenteredString("Omori - 005 By Your Side",1280, position.get(19), g2d);
	     drawCenteredString("Naruto Shippuden - Shipppuden",1280, position.get(20), g2d);
	     drawCenteredString("Naruto Shippuden - Departure to the Front Lines",1280, position.get(21), g2d);
	     drawCenteredString("Naruto Shippuden - Keisei Gyakuten",1280, position.get(22), g2d);
	     
	     g2d.setFont(thank);
	     g2d.setColor(new Color(255, 0, 0));
	     drawCenteredString("Finally : Thank You Mr Rizky Januar",1280, position.get(23), g2d);
	     drawCenteredString("Thank You for Playing !!",1280, position.get(24), g2d);
	     
	     try {
		     if(countDown <= 0) {
		    	 Main.frame.dispose();
		     }
		    	 
		     Thread.sleep(165);
		     if(countDown > 11) {
		    	 for(int a = 0; a<position.size(); a++) {
			    	 int c = position.get(a);
			    	 c-=5;
			    	 position.set(a,c);
			     }
		     }
		     
		     countDown -= 0.165; 
		     repaint();
	     }
	     
	     catch (InterruptedException ex) {
	    	 JOptionPane.showMessageDialog(this, ex);
	     }
	     
    }

	private void drawCenteredString(String string, int i, int j, Graphics2D g2d) {
		// TODO Auto-generated method stub
		FontMetrics fm = g2d.getFontMetrics();
	    int x = (i - fm.stringWidth(string)) / 2;
	    g2d.drawString(string, x, j);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imgg, 0, 0, null);
	}
}