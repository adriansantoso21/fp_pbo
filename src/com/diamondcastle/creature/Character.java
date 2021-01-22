package com.diamondcastle.creature;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.diamondcastle.inventory.Armor;
import com.diamondcastle.inventory.Inventory;
import com.diamondcastle.inventory.Potion;
import com.diamondcastle.inventory.Weapon;
import com.diamondcastle.skill.Skill;

public class Character extends Creature {
	
	public ArrayList<Inventory> inventory = new ArrayList<Inventory>();
	public ArrayList<Skill> skills = new ArrayList<Skill>();
	private Armor equippedArmor;
	private Weapon equippedWeapon;
	private int armorA, weaponA, potionA, attributeP;
	private float gold;
	private String story;
	private List <Image> ImgPool;
	private List <Image> IdleImgPool;
	private List <Image> SpellImgPool;
	Image curr;
	public int now, idlenow, spellnow;
	int whatnow;
	
	public Character(String name, float healthPoint, float mana, float intelligence, float strength, float accuracy,
			float speed, float defence, float weight, String story) {
		super(name, healthPoint, mana, intelligence, strength, accuracy, speed, defence, weight);
		this.setGold(1000);
		this.setStory(story);
		this.setAttributeP(10);
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
		this.setEquippedArmor(equippedArmor);
		this.setAccuracy(this.getAccuracy() + equippedArmor.accuracy);
		this.setDefence(this.getDefence() + equippedArmor.defence);
		this.setHealthPoint(this.getHealthPoint() + equippedArmor.healthPoint);
		this.setSpeed(this.getSpeed() + equippedArmor.speed);
		this.weight += equippedArmor.weight;
	}
	
	public void equipWeapon(Weapon equippedWeapon) {
		this.setEquippedWeapon(equippedWeapon);
		this.setStrength(this.getStrength() + equippedWeapon.strength);
		this.setAccuracy(this.getAccuracy() + equippedWeapon.accuracy);
		this.setIntelligence(this.getIntelligence() + equippedWeapon.intelligence);
		this.setSpeed(this.getSpeed() + equippedWeapon.speed);
		this.weight += equippedWeapon.weight;
	}

	public void unequipArmor(Armor equippedArmor) {
		this.setEquippedArmor(null);
		this.setAccuracy(this.getAccuracy() - equippedArmor.accuracy);
		this.setDefence(this.getDefence() - equippedArmor.defence);
		this.setHealthPoint(this.getHealthPoint() - equippedArmor.healthPoint);
		this.setSpeed(this.getSpeed() - equippedArmor.speed);
		this.weight -= equippedArmor.weight;
	}
	
	public void unequipWeapon(Weapon equippedWeapon) {
		this.setEquippedWeapon(null);
		this.setStrength(this.getStrength() - equippedWeapon.strength);
		this.setAccuracy(this.getAccuracy() - equippedWeapon.accuracy);
		this.setIntelligence(this.getIntelligence() - equippedWeapon.intelligence);
		this.setSpeed(this.getSpeed() - equippedWeapon.speed);
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
		this.setPotionA(this.getPotionA() - 1);
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

	public float getGold() {
		return gold;
	}

	public void setGold(float f) {
		this.gold = f;
	}

	public int getPotionA() {
		return potionA;
	}

	public void setPotionA(int potionA) {
		this.potionA = potionA;
	}

	public int getAttributeP() {
		return attributeP;
	}

	public void setAttributeP(int attributeP) {
		this.attributeP = attributeP;
	}

	public int getArmorA() {
		return armorA;
	}

	public void setArmorA(int armorA) {
		this.armorA = armorA;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public int getWeaponA() {
		return weaponA;
	}

	public void setWeaponA(int weaponA) {
		this.weaponA = weaponA;
	}
	
	public boolean isWeaponNull() {
		return Objects.isNull(getEquippedWeapon());
	}
	
	public boolean isArmorNull() {
		return Objects.isNull(getEquippedArmor());
	}

	public Armor getEquippedArmor() {
		return equippedArmor;
	}

	public void setEquippedArmor(Armor equippedArmor) {
		this.equippedArmor = equippedArmor;
	}

	public Weapon getEquippedWeapon() {
		return equippedWeapon;
	}

	public void setEquippedWeapon(Weapon equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
	}
	
}
