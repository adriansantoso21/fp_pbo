package com.example;

public abstract class Inventory {
	public String name;
	float weight;
	
	public Inventory(String name, float weight) {
		this.name = name;
		this.weight = weight;
	}
}
