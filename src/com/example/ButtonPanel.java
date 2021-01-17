package com.example;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	Image imgg = new ImageIcon("images/skillpic.jpg").getImage();
	Image imgg2 = new ImageIcon("images/bgchar.jpg").getImage();
	Image imgg3 = new ImageIcon("images/bg_war.jpg").getImage();
	int test;
	
	public ButtonPanel(GridLayout gridLayout, int test) {
		super(gridLayout);
		this.test = test;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(test == 0) g.drawImage(this.imgg, 0, 0, null);
		else if(test == 1) g.drawImage(this.imgg2, 0, 0, null);
		else if(test == 3) g.drawImage(this.imgg3, 0, 0, null);
	}
}
