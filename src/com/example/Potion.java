package com.example;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Potion extends Consumables {

	Buff buff;
	Image image;

	public Potion(String name, float weight, Buff buff) {
		super(name, weight);
		this.buff = buff;
		this.image = new ImageIcon("potion/"+name+".jpg").getImage();
	}

}
