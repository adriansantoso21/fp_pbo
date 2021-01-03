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
		if(potion.buff.currHP > 0 || potion.buff.currMana > 0) {
			this.currHP += potion.buff.currHP;
			this.currMana += potion.buff.currMana;
		}
		else {
			this.buffs.add(potion.buff);
		}
		this.inventory.remove(potion);
	}
	
}
