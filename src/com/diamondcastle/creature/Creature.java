package com.diamondcastle.creature;

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

import com.diamondcastle.skill.Buff;
import com.diamondcastle.skill.Skill;

public abstract class Creature {
	public String name;
	public float currHP;
	public float currMana;
	private float healthPoint;
	private float mana;
	private float intelligence;
	private float strength;
	private float accuracy;
	private float speed;
	private float defence;
	public float weight;
	public ArrayList<Skill> skills = new ArrayList<Skill>();
	public ArrayList<Buff> buffs = new ArrayList<Buff>();
	
	public Creature(String name, float healthPoint, float mana, float intelligence, float strength, float accuracy, float speed, float defence, float weight){
		this.name = name;
		this.setHealthPoint(healthPoint);
		this.currHP = healthPoint;
		this.setMana(mana);
		this.currMana = mana;
		this.setIntelligence(intelligence);
		this.setStrength(strength);
		this.setAccuracy(accuracy);
		this.setSpeed(speed);
		this.setDefence(defence);
		this.weight = weight;
	}
	
	public float attack(Creature attacked) {
		float dam = this.showStrength();
		if(this.name.equals("Wizard")) {
			dam = this.showIntelligence();
		}
		return 2 * dam * dam / (dam + attacked.showDefence());
	}
	
	public void healHP() {
		this.currHP = this.getHealthPoint();
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
		return Math.random() > Math.pow(f, -this.getAccuracy()); // assuming random is in the range [0.0, 1.0]
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

	}
	
	public void healHealth(float healed) {
		this.currHP += healed;
		if (this.currHP>this.getHealthPoint()) {
			this.currHP = this.getHealthPoint();
		}
	}
	
	public void healMana(float healed) {
		this.currMana += healed;
		if (this.currMana>this.getMana()) {
			this.currMana = this.getMana();
		}
	}
	
	public float showSpeed() {
		float full = this.getSpeed();
		float part = 0;
		for (Buff curr : buffs) {
			if(curr.speed!=0) {
				if(curr.type.equals("Modifier")) {
					part = this.getSpeed() * curr.speed / 100;
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
	
	public float showDefence() {
		float full = this.getDefence();
		float part = 0;
		for (Buff curr : buffs) {
			if(curr.defence!=0) {
				if(curr.type.equals("Modifier")) {
					part = this.getDefence() * curr.defence / 100;
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
	
	public float showIntelligence() {
		float full = this.getIntelligence();
		float part = 0;
		for (Buff curr : buffs) {
			if(curr.intelligence!=0) {
				if(curr.type.equals("Modifier")) {
					part = this.getIntelligence() * curr.intelligence / 100;
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
	
	public float showStrength() {
		float full = this.getStrength();
		float part = 0;
		for (Buff curr : buffs) {
			if(curr.strength!=0) {
				if(curr.type.equals("Modifier")) {
					part = -(this.getStrength() * -curr.strength) / 100;
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
	
	public float showAccuracy() {
		float full = this.getAccuracy();
		float part = 0;
		for (Buff curr : buffs) {
			if(curr.accuracy!=0) {
				if(curr.type.equals("Modifier")) {
					part = this.getAccuracy() * curr.accuracy / 100;
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

	public float getHealthPoint() {
		return healthPoint;
	}

	public void setHealthPoint(float healthPoint) {
		this.healthPoint = healthPoint;
	}

	public float getMana() {
		return mana;
	}

	public void setMana(float mana) {
		this.mana = mana;
	}

	public float getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(float accuracy) {
		this.accuracy = accuracy;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(float intelligence) {
		this.intelligence = intelligence;
	}

	public float getDefence() {
		return defence;
	}

	public void setDefence(float defence) {
		this.defence = defence;
	}

	public float getStrength() {
		return strength;
	}

	public void setStrength(float strength) {
		this.strength = strength;
	}
	
}
