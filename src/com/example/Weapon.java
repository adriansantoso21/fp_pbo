package com.example;

public class Weapon extends Equippable {
	float strength;
	float intelligence;
	float accuracy;
	float speed;
	
	public Weapon(String name, float weight, float strength, float intelligence, float accuracy, float speed) {
		super(name, weight);
		this.strength = strength;
		this.intelligence = intelligence;
		this.accuracy = accuracy;
		this.speed = speed;
	}
	
}
