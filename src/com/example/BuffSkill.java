package com.example;

import java.awt.Image;

import javax.swing.ImageIcon;

public class BuffSkill extends Skill {

	public Buff buff;
	
	public BuffSkill(String name, float manaCost,float price, Buff buff) {
		super(name, manaCost, price);
		this.buff = buff;
	}

	void unleash(Creature buffed) {
		Buff cloning = new Buff(buff);
		buffed.buffs.add(cloning);
		buffed.currMana -= this.manaCost;
	}

}
