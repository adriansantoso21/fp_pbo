package com.example;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VideoMiddle extends JPanel{
	ArrayList<Image> beg;
	Image current;
	int i;
	JFrame frame;
	static musicPlay music5 = new musicPlay();
		
		public VideoMiddle(JFrame frame){
			beg = new ArrayList<Image>();
			this.frame = frame;
			for(int i = 0; i<439; i++) {
				if(i<10) {
					beg.add(new ImageIcon("video/Mid/middle_00"+i+".jpg").getImage());
				}
				else if(i<100) {
					beg.add(new ImageIcon("video/Mid/middle_0"+i+".jpg").getImage());
				}
				else {
					beg.add(new ImageIcon("video/Mid/middle_"+i+".jpg").getImage());
				}
			}
			startVideoThread();
		}
		
		public void startVideoThread() {
			Thread vidThread = new Thread() {
				public void run() {
					music5.playMusic("song/middle.wav");
					for(i =0; i<beg.size(); i++) {
						current = beg.get(i);
						repaint();
						try {
							Thread.sleep(99, 352);
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
				music5.stopMusic();
				Main.frame.setContentPane(new Map(frame));
				Main.frame.pack();
			}
		}
		
}
