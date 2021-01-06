package com.example;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Weapon extends Equippable {
	float strength;
	float intelligence;
	float accuracy;
	float speed;
	Image image;
	
	public Weapon(String name, float weight, float strength, float intelligence, float accuracy, float speed) {
		super(name, weight);
		this.strength = strength;
		this.intelligence = intelligence;
		this.accuracy = accuracy;
		this.speed = speed;
		this.image = new ImageIcon("weapon/"+name+".jpg").getImage();
	}
	
}
