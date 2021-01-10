package com.example;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	Image imgg = new ImageIcon("images/skillpic.jpg").getImage();
	public ButtonPanel(GridLayout gridLayout) {
		super(gridLayout);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imgg, 0, 0, null);
	}
}
