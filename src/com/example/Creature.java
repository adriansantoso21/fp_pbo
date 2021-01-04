package com.example;

import java.util.ArrayList;
import java.util.Random;

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
	public ArrayList<Skill> skills = new ArrayList<Skill>();
	public ArrayList<Buff> buffs = new ArrayList<Buff>();
	
	public Creature(String name, float healthPoint, float mana, float intelligence, float strength, float accuracy, float speed, float defence, float weight) {
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
	}
	
	public float attack(Creature attacked) {
		return 2 * this.showStrength() * this.showStrength() / (this.showStrength() + attacked.showDefence());
	}
	
	public void healHP() {
		this.currHP = this.healthPoint;
	}
	
	public void damaged(float att) {
		this.currHP = this.currHP - att;
		if (this.currHP < 0) {
			this.currHP=0;
		}
	}
	
	public boolean isDead() {
		return currHP == 0;
	}
	
	
	//----------------------BUFF RELATED----------------------//
	
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
		if(full<0) {
			return 0;
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
		if(full<0) {
			return 0;
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
		if(full<0) {
			return 0;
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
		if(full<0) {
			return 0;
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
		if(full<0) {
			return 0;
		}
		return full;
	}
	
}
