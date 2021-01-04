package com.example;

public class Buff {
	String type;
	float currHP;
	float currMana;
	float intelligence;
	float strength;
	float accuracy;
	float speed;
	float defence;
	int duration;
	
	public Buff(String type, float healthPoint, float mana, float intelligence, float strength, float accuracy, float speed, float defence, int duration) {
		this.type = type;
		this.currHP = healthPoint;
		this.currMana = mana;
		this.intelligence = intelligence;
		this.strength = strength;
		this.accuracy = accuracy;
		this.speed = speed;
		this.defence = defence;
		this.duration = duration;
	}
}
