package com.diamondcastle.skill;

import java.awt.Image;

import javax.swing.ImageIcon;

abstract public class Skill {
	public String name;
	public float manaCost;
	public float price;
	public Image image;
	
	public Skill(String name, float manaCost, float price) {
		this.name = name;
		this.manaCost = manaCost;
		this.price = price;
		this.image = new ImageIcon("resource/shop/Skill/"+name+".png").getImage();
	}
	
}
