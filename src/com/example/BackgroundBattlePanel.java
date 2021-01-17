package com.example;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundBattlePanel extends JPanel {
	Image imgg = new ImageIcon("images/battlegrounds2.jpg").getImage();
	
	public BackgroundBattlePanel() {
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imgg, -200, -300, null);
	}
}
