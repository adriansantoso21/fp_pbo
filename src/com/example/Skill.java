package com.example;

import java.awt.Image;

import javax.swing.ImageIcon;

abstract public class Skill {
	public String name;
	public float manaCost;
	Image image;
	
	public Skill(String name, float manaCost) {
		this.name = name;
		this.manaCost = manaCost;
		this.image = new ImageIcon("Skill/"+name+".png").getImage();
	}
	
}
