package com.example;

import java.util.ArrayList;

public class Character extends Creature {
	
	public ArrayList<Inventory> inventory = new ArrayList<Inventory>();
	public ArrayList<Skill> skills = new ArrayList<Skill>();
	public Armor equippedArmor;
	public Weapon equippedWeapon;
	
	public Character(String name, float healthPoint, float mana, float intelligence, float strength, float accuracy,
			float speed, float defence, float weight) {
		super(name, healthPoint, mana, intelligence, strength, accuracy, speed, defence, weight);
	}
	
	public void equipArmor(Armor equippedArmor) {
		this.equippedArmor = equippedArmor;
		this.accuracy += equippedArmor.accuracy;
		this.defence += equippedArmor.defence;
		this.healthPoint += equippedArmor.healthPoint;
		this.speed += equippedArmor.speed;
		this.weight += equippedArmor.weight;
	}
	
	public void equipWeapon(Weapon equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
		this.strength += equippedWeapon.strength;
		this.accuracy += equippedWeapon.accuracy;
		this.intelligence += equippedWeapon.intelligence;
		this.speed += equippedWeapon.speed;
		this.weight += equippedWeapon.weight;
	}

	public void unequipArmor(Armor equippedArmor) {
		this.equippedArmor = null;
		this.accuracy -= equippedArmor.accuracy;
		this.defence -= equippedArmor.defence;
		this.healthPoint -= equippedArmor.healthPoint;
		this.speed -= equippedArmor.speed;
		this.weight -= equippedArmor.weight;
	}
	
	public void unequipArmor(Weapon equippedWeapon) {
		this.equippedWeapon = null;
		this.strength -= equippedWeapon.strength;
		this.accuracy -= equippedWeapon.accuracy;
		this.intelligence -= equippedWeapon.intelligence;
		this.speed -= equippedWeapon.speed;
		this.weight -= equippedWeapon.weight;
	}
	
	public void usePotion(Potion potion) {
		this.buffs.add(potion.buff);
		this.inventory.remove(potion);
	}
	
	public void decreaseDuration() {
		for (Buff curr : buffs) {
			curr.duration -= 1;
			if(curr.duration == 0) {
				this.buffs.remove(curr);
			}
		}
	}
	
	float showHealthPoint() {
		float full = this.healthPoint;
		float part = 0;
		for (Buff curr : buffs) {
			if(curr.healthPoint>0) {
				if(curr.type.equals("Modifier")) {
					part = this.healthPoint * curr.healthPoint;
				}
				else {
					part = this.healthPoint;
				}
				full += part;
			}
		}
		return full;
	}
	
	float showSpeed() {
		float full = this.speed;
		float part = 0;
		for (Buff curr : buffs) {
			if(curr.speed>0) {
				if(curr.type.equals("Modifier")) {
					part = this.speed * curr.speed;
				}
				else {
					part = this.speed;
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
			if(curr.defence>0) {
				if(curr.type.equals("Modifier")) {
					part = this.defence * curr.defence;
				}
				else {
					part = this.defence;
				}
				full += part;
			}
		}
		return full;
	}
	
	float showMana() {
		float full = this.mana;
		float part = 0;
		for (Buff curr : buffs) {
			if(curr.mana>0) {
				if(curr.type.equals("Modifier")) {
					part = this.mana * curr.mana;
				}
				else {
					part = this.mana;
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
			if(curr.intelligence>0) {
				if(curr.type.equals("Modifier")) {
					part = this.intelligence * curr.intelligence;
				}
				else {
					part = this.intelligence;
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
			if(curr.strength>0) {
				if(curr.type.equals("Modifier")) {
					part = this.strength * curr.strength;
				}
				else {
					part = this.strength;
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
			if(curr.accuracy>0) {
				if(curr.type.equals("Modifier")) {
					part = this.accuracy * curr.accuracy;
				}
				else {
					part = this.accuracy;
				}
				full += part;
			}
		}
		return full;
	}
	
}
