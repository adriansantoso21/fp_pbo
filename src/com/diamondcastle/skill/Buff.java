package com.diamondcastle.skill;

public class Buff {
	public String name;
	public String type;
	public String desc;
	public float currHP;
	public float currMana;
	public float intelligence;
	public float strength;
	public float accuracy;
	public float speed;
	public float defence;
	public int duration;
	
	public Buff(String name, String type, float healthPoint, float mana, float intelligence, float strength, float accuracy, float speed, float defence, int duration, String desc) {
		this.name = name;
		this.type = type;
		this.desc = desc;
		this.currHP = healthPoint;
		this.currMana = mana;
		this.intelligence = intelligence;
		this.strength = strength;
		this.accuracy = accuracy;
		this.speed = speed;
		this.defence = defence;
		this.duration = duration;
	}
	
	public Buff(Buff buff) {
		this.name = buff.name;
		this.type = buff.type;
		this.currHP = buff.currHP;
		this.currMana = buff.currMana;
		this.intelligence = buff.intelligence;
		this.strength = buff.strength;
		this.accuracy = buff.accuracy;
		this.speed = buff.speed;
		this.defence = buff.defence;
		this.duration = buff.duration;
	}
}
