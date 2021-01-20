package com.diamondcastle.inventory;

import java.awt.Image;
import javax.swing.ImageIcon;

import com.diamondcastle.skill.Buff;

public class Potion extends Consumables {

	public Buff buff;
	public Image image;
	public float price;

	public Potion(String name, float weight, float price,Buff buff) {
		super(name, weight);
		this.buff = buff;
		this.price = price;
		this.image = new ImageIcon("resource/shop/potion/"+name+".jpg").getImage();
	}
	
	public Potion(Potion pot) {
		super(pot.name, pot.weight);
		this.buff = pot.buff;
		this.price = pot.price;
		this.image = new ImageIcon("resource/shop/potion/"+pot.name+".jpg").getImage();
	}

}
