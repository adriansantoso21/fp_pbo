package com.diamondcastle.skill;

import com.diamondcastle.creature.Creature;

public class AttackSkill extends Skill {
	
	String type;
	public float att, mag;
	public String desc;

	public AttackSkill(String name, float manaCost, String type, float price, float att, float mag, String desc) {
		super(name, manaCost, price);
		this.type = type;
		this.att = att;
		this.mag = mag;
		this.desc = desc;
	}
	
	public float unleash(Creature attacker, Creature attacked) {
		attacker.currMana -= this.manaCost;
		float damage, strr;
		if(mag==0) {
			strr = attacker.showStrength();
		}
		else {
			strr = attacker.showIntelligence();
		}
		if(type.equals("Non")) {
			damage = strr + att;
		}
		else {
			damage = strr + (strr * att / 100);
		}
		float damages = 2 * damage * damage / (damage + attacked.showDefence());
		attacked.damaged(damages);
		return damages;
	}
}
