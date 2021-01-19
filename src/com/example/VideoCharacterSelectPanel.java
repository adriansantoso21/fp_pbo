package com.example;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VideoCharacterSelectPanel extends JPanel{
	ArrayList<Image> beg;
	Image current;
	JFrame frame;
	int i;
	static musicPlay music4 = new musicPlay();
	
	public VideoCharacterSelectPanel(JFrame frame){
		music4.playMusic("song/beginning.wav");
		beg = new ArrayList<Image>();
		this.frame = frame;
		for(int i = 0; i<439; i++) {
			if(i<10) {
				beg.add(new ImageIcon("video/beginning_00"+i+".jpg").getImage());
			}
			else if(i<100) {
				beg.add(new ImageIcon("video/beginning_0"+i+".jpg").getImage());
			}
			else {
				beg.add(new ImageIcon("video/beginning_"+i+".jpg").getImage());
			}
		}
		startVideoThread();
	}
	public void startVideoThread() {
		Thread vidThread = new Thread() {
			public void run() {
				for(i =0; i<beg.size(); i++) {
					current = beg.get(i);
					repaint();
					try {
						Thread.sleep(97, 950);
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
		if(i == 438) {
			music4.stopMusic();
			Main.frame.setContentPane(new Map(frame));
			Main.frame.pack();
		}
	}
}