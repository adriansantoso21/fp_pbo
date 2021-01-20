package com.diamondcastle.inventory;

public abstract class Inventory {
	public String name;
	public float weight;
	
	public Inventory(String name, float weight) {
		this.name = name;
		this.weight = weight;
	}
}
