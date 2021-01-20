package com.diamondcastle.video;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.diamondcastle.main.Main;
import com.diamondcastle.map.Map;
import com.diamondcastle.music.musicPlay;

public class VideoCharacterSelectPanel extends JPanel{
	ArrayList<Image> beg;
	Image current;
	JFrame frame;
	int i;
	static musicPlay music4 = new musicPlay();
	
	public VideoCharacterSelectPanel(JFrame frame){
		beg = new ArrayList<Image>();
		this.frame = frame;
		for(int i = 0; i<439; i++) {
			if(i<10) {
				beg.add(new ImageIcon("resource/video/Beginning/beginning_00"+i+".jpg").getImage());
			}
			else if(i<100) {
				beg.add(new ImageIcon("resource/video/Beginning/beginning_0"+i+".jpg").getImage());
			}
			else {
				beg.add(new ImageIcon("resource/video/Beginning/beginning_"+i+".jpg").getImage());
			}
		}
		startVideoThread();
	}
	public void startVideoThread() {
		Thread vidThread = new Thread() {
			public void run() {
				music4.playMusic("resource/song/beginning.wav");
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