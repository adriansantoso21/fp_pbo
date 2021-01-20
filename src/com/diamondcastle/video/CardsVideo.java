package com.diamondcastle.video;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

import com.diamondcastle.main.Main;
import com.diamondcastle.map.Map;
import com.diamondcastle.music.musicPlay;

public class CardsVideo extends JPanel {
	ArrayList<Image> beg;
	Image current;
	JFrame frame;
	JPanel panel;
	CardLayout cardlayt;
	int i;
	
	public CardsVideo(JFrame frame, int a, JPanel panel, CardLayout cardlayt){
		beg = new ArrayList<Image>();
		this.frame = frame;
		this.panel = panel;
		this.cardlayt = cardlayt;
		if(a == 0) {
			for (int i = 0; i<5; i++) {
				beg.add(new ImageIcon("resource/video/finalcards/first"+i+".jpg").getImage());
			}
		}
		else if(a == 1) {
			for (int i = 0; i<5; i++) {
				beg.add(new ImageIcon("resource/video/finalcards/second"+i+".jpg").getImage());
			}
		}
		else if(a == 2) {
			for (int i = 0; i<5; i++) {
				beg.add(new ImageIcon("resource/video/finalcards/third"+i+".jpg").getImage());
			}		
		}
		else if(a == 3) {
			for (int i = 0; i<5; i++) {
				beg.add(new ImageIcon("resource/video/finalcards/fourth"+i+".jpg").getImage());
			}
		}
		else if(a == 4) {
			for (int i = 0; i<5; i++) {
				beg.add(new ImageIcon("resource/video/finalcards/fifth"+i+".jpg").getImage());
			}
		}
	}
	
	public void startVideoThread() {
		Thread vidThread = new Thread() {
			public void run() {
				for(i =0; i<beg.size(); i++) {
					current = beg.get(i);
					repaint();
					try {
						Thread.sleep(2000);
					} 
					catch (InterruptedException ex) {}
				}
			}
		};
		vidThread.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(current, 0, 0, null);
		if(i == 4) {
			cardlayt.show(panel, "full");
		}
	}
}
