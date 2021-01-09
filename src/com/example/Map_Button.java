package com.example;

import java.awt.Color;

import javax.swing.JButton;

public class Map_Button extends JButton{
	int x;
	int y;
	int type;
	boolean active;
	
	//1 for shop , 2 for random monster
	public Map_Button(int x, int y, int type, boolean active) {
		this.x = x;
		this.y = y;
		this.active = active;
		this.type = type;
		this.setEnabled(true);
		this.setBounds(x, y, 25, 25);
		this.setBackground(Color.black );
		this.setOpaque(false);
	}
}
