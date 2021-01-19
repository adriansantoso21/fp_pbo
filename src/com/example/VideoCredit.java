package com.example;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class VideoCredit extends JPanel{
	ArrayList<Image> beg;
	Image current;
	int i;
	
	public VideoCredit(){
		beg = new ArrayList<Image>();
		for(int i = 0; i<85; i++) {
			if(i<10) {
				beg.add(new ImageIcon("videoCredit/ending_00"+i+".jpg").getImage());
			}
			else if(i<100) {
				beg.add(new ImageIcon("videoCredit/ending_0"+i+".jpg").getImage());
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
						Thread.sleep(94, 238);
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
		if(i == 84) {
			Main.frame.setContentPane(new credit());
			Main.frame.pack();
		}
	}
}
