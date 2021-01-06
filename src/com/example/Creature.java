package com.example;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public abstract class Creature {
	String name;
	float currHP;
	float currMana;
	float healthPoint;
	float mana;
	float intelligence;
	float strength;
	float accuracy;
	float speed;
	float defence;
	float weight;
//	Image image;
	public ArrayList<Skill> skills = new ArrayList<Skill>();
	public ArrayList<Buff> buffs = new ArrayList<Buff>();
	
	public Creature(String name, float healthPoint, float mana, float intelligence, float strength, float accuracy, float speed, float defence, float weight){
		this.name = name;
		this.healthPoint = healthPoint;
		this.currHP = healthPoint;
		this.mana = mana;
		this.currMana = mana;
		this.intelligence = intelligence;
		this.strength = strength;
		this.accuracy = accuracy;
		this.speed = speed;
		this.defence = defence;
		this.weight = weight;
//		this.image = new ImageIcon("FinalProject/creature/"+name+".png").getImage();
//				
//		try {
//			this.image = ImageIO.read(new File(name + ".png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public float attack() {
		Random ran = new Random();
		int x = ran.nextInt(10);
		float damage = (float) (this.showStrength() + x);
		return (damage);
	}
	
	public void healHP() {
		this.currHP = this.healthPoint;
	}
	
	public void damaged(float damage) {
		this.currHP = this.currHP - damage;
		if (this.currHP < 0) {
			this.currHP=0;
		}
	}
	
	public boolean isDead() {
		return currHP == 0;
	}
	
	
	//-------------------BUFF RELATED-------------------//
	
	public void decreaseDuration() {
		for (Buff curr : buffs) {
			curr.duration -= 1;
			if(curr.duration == 0) {
				this.buffs.remove(curr);
			}
		}
	}
	
	float showSpeed() {
		float full = this.speed;
		float part = 0;
		for (Buff curr : buffs) {
			if(curr.speed!=0) {
				if(curr.type.equals("Modifier")) {
					part = this.speed * curr.speed / 100;
				}
				else {
					part = curr.speed;
				}
				full += part;
			}
		}
		return full;
	}
	
	float showDefence() {
		float full = this.defence;
		float part = 0;
		for (Buff curr : buffs) {
			if(curr.defence!=0) {
				if(curr.type.equals("Modifier")) {
					part = this.defence * curr.defence / 100;
				}
				else {
					part = curr.defence;
				}
				full += part;
			}
		}
		return full;
	}
	
	float showIntelligence() {
		float full = this.intelligence;
		float part = 0;
		for (Buff curr : buffs) {
			if(curr.intelligence!=0) {
				if(curr.type.equals("Modifier")) {
					part = this.intelligence * curr.intelligence / 100;
				}
				else {
					part = curr.intelligence;
				}
				full += part;
			}
		}
		return full;
	}
	
	float showStrength() {
		float full = this.strength;
		float part = 0;
		for (Buff curr : buffs) {
			if(curr.strength!=0) {
				if(curr.type.equals("Modifier")) {
					part = -(this.strength * -curr.strength) / 100;
				}
				else {
					part = curr.strength;
				}
				full += part;
			}
		}
		return full;
	}
	
	float showAccuracy() {
		float full = this.accuracy;
		float part = 0;
		for (Buff curr : buffs) {
			if(curr.accuracy!=0) {
				if(curr.type.equals("Modifier")) {
					part = this.accuracy * curr.accuracy / 100;
				}
				else {
					part = curr.accuracy;
				}
				full += part;
			}
		}
		return full;
	}
	
}
