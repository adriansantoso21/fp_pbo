package com.example;

import java.util.ArrayList;
import java.util.Random;

public abstract class Creature {
	String name;
	float currHP;
	float healthPoint;
	float mana;
	float intelligence;
	float strength;
	float accuracy;
	float speed;
	float defence;
	float weight;
	public ArrayList<Skill> skills = new ArrayList<Skill>();
	
	public Creature(String name, float healthPoint, float mana, float intelligence, float strength, float accuracy, float speed, float defence, float weight) {
		this.name = name;
		this.healthPoint = healthPoint;
		this.currHP = healthPoint;
		this.mana = mana;
		this.intelligence = intelligence;
		this.strength = strength;
		this.accuracy = accuracy;
		this.speed = speed;
		this.defence = defence;
		this.weight = weight;
	}
	
	public float attack() {
		Random ran = new Random();
		int x = ran.nextInt(10);
		float damage = (float) (this.strength + x);
		return (damage);
	}
	
	public void healHP() {
		this.currHP = this.healthPoint;
	}
	
	public void damaged(float damage) {
		this.currHP = this.currHP - damage;
		if (this.currHP < 0) {
			this.currHP=0;
		}
	}
	
	public boolean isDead() {
		return currHP == 0;
	}
	
}