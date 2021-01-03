package com.example;

public class BuffSkill extends Skill {

	public Buff buff;
	
	public BuffSkill(String name, float manaCost, Buff buff) {
		super(name, manaCost);
		this.buff = buff;
	}

	void unleash(Creature buffed) {
		buffed.buffs.add(buff);
		buffed.currMana -= this.manaCost;
	}

}
