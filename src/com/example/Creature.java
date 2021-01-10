package com.example;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public abstract class Creature {
	String name;
	float currHP;
	float currMana;
	float healthPoint;
	float mana;
	float intelligence;
	float strength;
	float accuracy;
	float speed;
	float defence;
	float weight;
//	Image image;
	public ArrayList<Skill> skills = new ArrayList<Skill>();
	public ArrayList<Buff> buffs = new ArrayList<Buff>();
	
	public Creature(String name, float healthPoint, float mana, float intelligence, float strength, float accuracy, float speed, float defence, float weight){
		this.name = name;
		this.healthPoint = healthPoint;
		this.currHP = healthPoint;
		this.mana = mana;
		this.currMana = mana;
		this.intelligence = intelligence;
		this.strength = strength;
		this.accuracy = accuracy;
		this.speed = speed;
		this.defence = defence;
		this.weight = weight;
//		this.image = new ImageIcon("FinalProject/creature/"+name+".png").getImage();
//				
//		try {
//			this.image = ImageIO.read(new File(name + ".png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public float attack(Creature attacked) {
		return 2 * this.showStrength() * this.showStrength() / (this.showStrength() + attacked.showDefence());
	}
	
	public void healHP() {
		this.currHP = this.healthPoint;
	}
	
	public void damaged(float att) {
		this.currHP = this.currHP - att;
		if (this.currHP < 0) {
			this.currHP=0;
		}
	}
	
	public boolean dodgeChance(Creature attacked){
		double attacker_level = this.showSpeed();
		double defender_level = attacked.showSpeed();
	    double x = defender_level/attacker_level;
	    double a = 10.0/ Math.sqrt( 111111.0);
	    double b = 111071.0/ 40000.0;
	    return Math.random() > (a*Math.sqrt(x+b));
	}
	
	public boolean crit(){
		double f = 1.003; // you can mess with this factor to change how quickly it diminishes
		return Math.random() > Math.pow(f, -this.accuracy); // assuming random is in the range [0.0, 1.0]
	}
	
	public boolean isDead() {
		return currHP == 0;
	}
	
	
	//----------------------BUFF RELATED----------------------//
	
	public void decreaseDuration(JTextPane ta) {
		Iterator<Buff> iter = buffs.iterator();
	    
	    while (iter.hasNext()) {
		    Buff str = iter.next();
		    str.duration -= 1;
		    System.out.println(str.strength + " with duration currently "+ str.duration);

		    if (str.duration == 0) {
		        iter.remove();
		        System.out.println(str.strength + "removed");
		        StyledDocument doc = ta.getStyledDocument();
		        try {
					doc.insertString(doc.getLength(), "· "+str.name+"'s effects on "+this.name+" have disappeared.\n", null);
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		}
	    
	    
		
//		for (Buff sumn : this.buffs) {
//			System.out.println(sumn.strength + " with duration " + sumn.duration + "\n");
//		}
//		List<Buff> toRemove = new ArrayList<Buff>();
//		for (Buff str : this.buffs) {
//			str.duration -= 1;
//			System.out.println(str.strength + " with duration currently "+ str.duration);
//			
//		    if (str.duration == 0) {
//		        toRemove.add(str);
//		        System.out.println(str.strength + "removed");
//		    }
//		}
//		this.buffs.removeAll(toRemove);
	}
	
	void healHealth(float healed) {
		this.currHP += healed;
		if (this.currHP>this.healthPoint) {
			this.currHP = this.healthPoint;
		}
	}
	
	void healMana(float healed) {
		this.currMana += healed;
		if (this.currMana>this.mana) {
			this.currMana = this.mana;
		}
	}
	
	float showSpeed() {
		float full = this.speed;
		float part = 0;
		for (Buff curr : buffs) {
			if(curr.speed!=0) {
				if(curr.type.equals("Modifier")) {
					part = this.speed * curr.speed / 100;
				}
				else {
					part = curr.speed;
				}
				full += part;
			}
		}
		if(full<0) {
			return 0;
		}
		return full;
	}
	
	float showDefence() {
		float full = this.defence;
		float part = 0;
		for (Buff curr : buffs) {
			if(curr.defence!=0) {
				if(curr.type.equals("Modifier")) {
					part = this.defence * curr.defence / 100;
				}
				else {
					part = curr.defence;
				}
				full += part;
			}
		}
		if(full<0) {
			return 0;
		}
		return full;
	}
	
	float showIntelligence() {
		float full = this.intelligence;
		float part = 0;
		for (Buff curr : buffs) {
			if(curr.intelligence!=0) {
				if(curr.type.equals("Modifier")) {
					part = this.intelligence * curr.intelligence / 100;
				}
				else {
					part = curr.intelligence;
				}
				full += part;
			}
		}
		if(full<0) {
			return 0;
		}
		return full;
	}
	
	float showStrength() {
		float full = this.strength;
		float part = 0;
		for (Buff curr : buffs) {
			if(curr.strength!=0) {
				if(curr.type.equals("Modifier")) {
					part = -(this.strength * -curr.strength) / 100;
				}
				else {
					part = curr.strength;
				}
				full += part;
			}
		}
		if(full<0) {
			return 0;
		}
		return full;
	}
	
	float showAccuracy() {
		float full = this.accuracy;
		float part = 0;
		for (Buff curr : buffs) {
			if(curr.accuracy!=0) {
				if(curr.type.equals("Modifier")) {
					part = this.accuracy * curr.accuracy / 100;
				}
				else {
					part = curr.accuracy;
				}
				full += part;
			}
		}
		if(full<0) {
			return 0;
		}
		return full;
	}
	
}
