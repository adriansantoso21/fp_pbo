package com.example;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Monster extends Creature {

	Image image;
	int skillChance;
	
	public Monster(String name, float healthPoint, float mana, float intelligence, float strength, float accuracy,
			float speed, float defence, float weight, int skillChance) {
		super(name, healthPoint, mana, intelligence, strength, accuracy, speed, defence, weight);
		this.image = new ImageIcon("monster/"+name+".png").getImage();
		this.skillChance = skillChance;
	}

}
