package com.example;

public class Potion extends Consumables {

	Buff buff;

	public Potion(String name, float weight, Buff buff) {
		super(name, weight);
		this.buff = buff;
	}

}
