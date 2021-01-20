package com.diamondcastle.inventory;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Weapon extends Equippable {
	public float strength;
	public float intelligence;
	public float accuracy;
	public float speed;
	public float price;
	public Image image;
	
	public Weapon(String name, float weight, float strength, float intelligence, float accuracy, float speed, float price) {
		super(name, weight);
		this.strength = strength;
		this.intelligence = intelligence;
		this.accuracy = accuracy;
		this.speed = speed;
		this.price = price;
		this.image = new ImageIcon("resource/shop/weapon/"+name+".jpg").getImage();
	}
	
}
