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
		System.out.println(cloning.currHP);
		if(cloning.currHP > 0 || cloning.currMana > 0) {
			if(cloning.type.equals("Non")) {
				buffed.healHealth(cloning.currHP);
				buffed.healMana(cloning.currMana);
			}
			else {
				buffed.healHealth(cloning.currHP * buffed.currHP /100);
				buffed.healMana(cloning.currMana * buffed.currMana /100);
			}
		}
		else {
			buffed.buffs.add(cloning);
		}
		buffed.currMana -= this.manaCost;
	}

}
