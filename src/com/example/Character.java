package com.example;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Character extends Creature {
	
	public ArrayList<Inventory> inventory = new ArrayList<Inventory>();
	public ArrayList<Skill> skills = new ArrayList<Skill>();
	public Armor equippedArmor;
	public Weapon equippedWeapon;
	public int armorA, weaponA, potionA;
	public int attributeP;
	public int gold;	
	String story;
	private List <Image> ImgPool;
	private List <Image> IdleImgPool;
	private List <Image> SpellImgPool;
	Image curr;
	int now, idlenow, spellnow, whatnow;
	
	public Character(String name, float healthPoint, float mana, float intelligence, float strength, float accuracy,
			float speed, float defence, float weight, String story) {
		super(name, healthPoint, mana, intelligence, strength, accuracy, speed, defence, weight);
		this.gold = 10000;
		this.story = story;
		this.attributeP = 10;
		ImgPool = new ArrayList<Image>();
		IdleImgPool = new ArrayList<Image>();
		SpellImgPool = new ArrayList<Image>();
	}
	
	public void addAttackImage(Image img) {
		ImgPool.add(img);
		this.now = 0;
		this.curr = ImgPool.get(this.now);
	}
	
	public void addIdleImage(Image img) {
		IdleImgPool.add(img);
		this.idlenow = 0;
		this.curr = ImgPool.get(this.now);
	}
	
	public void addSpellImage(Image img) {
		SpellImgPool.add(img);
		this.spellnow = 0;
		this.curr = ImgPool.get(this.now);
	}
	
	public int getAttackImageSize() {
		return this.ImgPool.size();
	}
	
	public int getIdleImageSize() {
		return this.IdleImgPool.size();
	}
	
	public int getSpellImageSize() {
		return this.IdleImgPool.size();
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
	
	public void unequipWeapon(Weapon equippedWeapon) {
		this.equippedWeapon = null;
		this.strength -= equippedWeapon.strength;
		this.accuracy -= equippedWeapon.accuracy;
		this.intelligence -= equippedWeapon.intelligence;
		this.speed -= equippedWeapon.speed;
		this.weight -= equippedWeapon.weight;
	}
	
	public void usePotion(Potion potion) {
		if(potion.buff.currHP > 0 || potion.buff.currMana > 0) {
			if(potion.buff.type.equals("Non")) {
				this.healHealth(potion.buff.currHP);
				this.healMana(potion.buff.currMana);
			}
			else {
				this.healHealth(potion.buff.currHP * this.currHP /100);
				this.healMana(potion.buff.currMana * this.currMana /100);
			}
		}
		else {
			this.buffs.add(potion.buff);
		}
		this.inventory.remove(potion);
		this.potionA -= 1;
	}
	
	public void AttackAnimation() {
		if (this.now>=this.ImgPool.size()-1)this.now=0;
		else {this.now++;}
		this.curr = this.ImgPool.get(now);
		this.whatnow = 3;
	}
	
	public void IdleAnimation() {
		if (this.idlenow>=this.IdleImgPool.size()-1) {
			this.idlenow=0;
		}
		else {this.idlenow++;}
		this.curr = this.IdleImgPool.get(idlenow);
		this.whatnow = 2;
		System.out.println(idlenow);
	}
	
	public void SpellAnimation() {
		if (this.spellnow>=this.SpellImgPool.size()-1)this.spellnow=0;
		else {this.spellnow++;}
		this.curr = this.SpellImgPool.get(spellnow);
		this.whatnow = 1;
	}
	
	public void draw(Graphics g) {
		if(this.name.equals("Rogue") && whatnow == 1) {
			g.drawImage(this.curr, 0, 50, null);
		}
		else if (this.name.equals("Rogue") && whatnow == 3) {
			g.drawImage(this.curr, 10, 37, null);
		}
		else if (this.name.equals("Rogue") && whatnow == 2) {
			g.drawImage(this.curr, 0, 25, null);
		}
		else if (this.name.equals("Wizard")) {
			g.drawImage(this.curr, 0, -55, null);
		}
		else {
			g.drawImage(this.curr, 0, 20, null);
		}
	}
	
}
