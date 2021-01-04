package com.example;

public class Armor extends Inventory {
	float healthPoint;
	float defence;
	float accuracy;
	float speed;
	
	public Armor(String name, float weight, float healthPoint, float defence, float accuracy, float speed) {
		super(name, weight);
		this.healthPoint = healthPoint;
		this.defence = defence;
		this.accuracy = accuracy;
		this.speed = speed;
	}
}
