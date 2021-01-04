package com.example;

public class DebuffSkill extends Skill {

	public Buff debuff;
	
	public DebuffSkill(String name, float manaCost, Buff debuff) {
		super(name, manaCost);
		this.debuff = debuff;
	}

	void unleash(Creature debuffed, Creature debuffer) {
		debuffed.buffs.add(this.debuff);
		debuffer.currMana -= this.manaCost;
	}

}
