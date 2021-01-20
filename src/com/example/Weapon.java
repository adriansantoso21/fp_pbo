package com.example;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Weapon extends Equippable {
	float strength;
	float intelligence;
	float accuracy;
	float speed;
	float price;
	Image image;
	
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
