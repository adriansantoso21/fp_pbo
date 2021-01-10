package com.example;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Potion extends Consumables {

	Buff buff;
	Image image;
	float price;

	public Potion(String name, float weight, float price,Buff buff) {
		super(name, weight);
		this.buff = buff;
		this.price = price;
		this.image = new ImageIcon("potion/"+name+".jpg").getImage();
	}
	
	public Potion(Potion pot) {
		super(pot.name, pot.weight);
		this.buff = pot.buff;
		this.price = pot.price;
		this.image = new ImageIcon("potion/"+pot.name+".jpg").getImage();
	}

}
