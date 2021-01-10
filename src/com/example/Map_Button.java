package com.example;

import java.awt.Color;

import javax.swing.JButton;

public class Map_Button extends JButton{
	int x;
	int y;
	int type;
	boolean active;
	
	//1 for shop , 2 for random monster, 3 for rest
	public Map_Button(int x, int y, int type, boolean active) {
		this.x = x;
		this.y = y;
		this.active = active;
		this.type = type;
		this.setEnabled(false);
		this.setBounds(x, y, 40, 40);
		this.setBackground(new Color(61, 61, 92));
		this.setOpaque(false);
	}
}
