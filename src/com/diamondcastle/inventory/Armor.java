package com.diamondcastle.inventory;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Armor extends Equippable {
	public float healthPoint;
	public float defence;
	public float accuracy;
	public float speed;
	public float price;
	public Image image;
	
	public Armor(String name, float weight, float healthPoint, float defence, float accuracy, float speed, float price) {
		super(name, weight);
		this.healthPoint = healthPoint;
		this.defence = defence;
		this.accuracy = accuracy;
		this.speed = speed;
		this.price = price;
		this.image = new ImageIcon("resource/shop/armor/"+name+".jpg").getImage();
	}
}
