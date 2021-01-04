package com.example;

public class Potion extends Consumables {
	
	float healthPoint;
	float mana;
	float intelligence;
	float strength;
	float accuracy;
	float speed;
	float defence;

	public Potion(String name, float weight, float healthPoint, float mana, float intelligence, float strength, float accuracy,
			float speed, float defence) {
		super(name, weight);
		this.healthPoint = healthPoint;
		this.mana = mana;
		this.intelligence = intelligence;
		this.strength = strength;
		this.accuracy = accuracy;
		this.speed = speed;
		this.defence = defence;
	}

}