package com.diamondcastle.skill;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.diamondcastle.creature.Creature;

public class DebuffSkill extends Skill {

	public Buff debuff;
	float price;
	
	public DebuffSkill(String name, float manaCost,float price, Buff debuff) {
		super(name, manaCost, price);
		this.debuff = debuff;
	}

	public void unleash(Creature debuffed, Creature debuffer) {
		Buff cloning = new Buff(debuff);
		debuffed.buffs.add(cloning);
		debuffer.currMana -= this.manaCost;
	}

}
