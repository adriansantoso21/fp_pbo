package com.example;

public class AttackSkill extends Skill {
	
	String type;
	float att;

	public AttackSkill(String name, float manaCost, String type, float price) {
		super(name, manaCost, price);
		this.price = price;
		this.type = type;
		this.att = att;
	}
	
	float unleash(Creature attacker, Creature attacked) {
		attacker.currMana -= this.manaCost;
		float damage;
		if(type.equals("Non")) {
			damage = attacker.showStrength() + att;
		}
		else {
			damage = attacker.showStrength() + (attacker.showStrength() * att / 100);
		}
		float damages = 2 * damage * damage / (damage + attacked.showDefence());
		attacked.damaged(damages);
		return damages;
	}
}
