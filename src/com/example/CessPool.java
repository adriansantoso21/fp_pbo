package com.example;

import java.util.ArrayList;

import javax.swing.JFrame;

public class CessPool {
	public static Character selected = new Character("Heroman", 300, 60, 20, 40, 40, 30, 30, 30," ");
	public static ArrayList<Monster> monsterz = new ArrayList<Monster>();
	public static ArrayList<Weapon> weaponz = new ArrayList<Weapon>();
	public static ArrayList<Armor> armorz = new ArrayList<Armor>();
	public static ArrayList<Potion> potionz = new ArrayList<Potion>();
	public static ArrayList<Skill> skillz = new ArrayList<Skill>();
	public static ArrayList<SkillBook> skillbookz = new ArrayList<SkillBook>();
	public static ArrayList<Integer> location = new ArrayList<Integer>();
	int curLoc;
	
	public CessPool() {
		location.add(0);
		
		monsterz.add(new Monster("Villain", 300, 28, 20, 40, 40, 30, 30, 30));
		monsterz.add(new Monster("2nd Villain", 150, 34, 20, 40, 40, 30, 30, 30));
		
		armorz.add(new Armor("Sunlight Armor", 30, 60, 45, 15, 20, 750));
		armorz.add(new Armor("Ancient Armor", 10, 40, 25, 25, 30, 800));
		armorz.add(new Armor("Armor of the Warzone", 40, 60, 70, 30, 15, 900));
		armorz.add(new Armor("Death", 100, 100, 100, 100, 100, 1500));
		
		weaponz.add(new Weapon("Killer", 100, 100, 100, 100, 100, 400));
		weaponz.add(new Weapon("Ancient Sword", 10, 40, 25, 25, 30, 600));
		weaponz.add(new Weapon("Sword of the Warzone", 40, 60, 70, 30, 15, 700));
		weaponz.add(new Weapon("Sunlight Spear", 30, 60, 45, 15, 20, 800));
		
		potionz.add(new Potion("Defence Potion", 0, 100, new Buff("Non", 0, 0, 0, 0, 0, 0, 10, 3)));
		potionz.add(new Potion("Attack Potion", 0,100, new Buff("Non", 0, 0, 0, 10, 0, 0, 0, 3)));
		potionz.add(new Potion("Accuracy Potion", 0,100, new Buff("Modifier", 0, 0, 0, 0, 10, 0, 0, 3)));
		potionz.add(new Potion("Speed Potion", 0,100, new Buff("Modifier", 0, 0, 0, 0, 0, 10, 0, 3)));
		potionz.add(new Potion("Mana Potion", 0,100, new Buff("Non", 0, 40, 0, 10, 0, 0, 0, 3)));
		potionz.add(new Potion("Strength Potion", 0,100, new Buff("Modifier", 0, 0, 0, 0, 10, 0, 0, 3)));
		potionz.add(new Potion("Intelligence Potion", 0,100, new Buff("Modifier", 0, 0, 0, 0, 0, 10, 0, 3)));
		
		skillz.add(new AttackSkill("Shattering Star", 50, "Modifier", 200));
		skillz.add(new BuffSkill("Sword Saint", 40,200, new Buff("Non", 0, 0, 0, 10, 0, 0, 0, 3)));
		skillz.add(new BuffSkill("Faint Destroyer", 45,200, new Buff("Modifier", 0, 0, 0, 0, 10, 0, 0, 3)));
		skillz.add(new DebuffSkill("Earthquake", 35,200, new Buff("Modifier", 0, 0, 0, 0, 0, -10, 0, 3)));
		skillz.add(new DebuffSkill("Meteor Shower", 30,200, new Buff("Non", 0, 0, 0, -10, 0, 0, 0, 3)));
		skillz.add(new BuffSkill("Water Pulse", 50,200, new Buff("Modifier", 100, 0, 0, 0, 10, 0, 0, 3)));
		skillz.add(new BuffSkill("Winter Blast", 45,200, new Buff("Modifier", 50, 0, 0, 0, 0, 0, 0, 3)));
		
//		selected.skills.add(new AttackSkill("Shattering Star", 50, "Modifier", 30));
//		selected.skills.add(new BuffSkill("Shattering Star", 0, new Buff("Non", 0, 0, 0, 0, 0, 0, 10, 3)));
//		selected.skills.add(new BuffSkill("Shattering Star", 0, new Buff("Non", 0, 0, 0, 0, 0, 0, 10, 3)));
//		selected.skills.add(new BuffSkill("Shattering Star", 0, new Buff("Non", 0, 0, 0, 0, 0, 0, 10, 3)));
//		selected.skills.add(new BuffSkill("Shattering Star", 0, new Buff("Non", 0, 0, 0, 0, 0, 0, 10, 3)));
//		selected.skills.add(new BuffSkill("Shattering Star", 0, new Buff("Non", 0, 0, 0, 0, 0, 0, 10, 3)));
//		selected.skills.add(new BuffSkill("Shattering Star", 0, new Buff("Non", 0, 0, 0, 0, 0, 0, 10, 3)));
//
//		selected.inventory.add(new Potion("Attack Potion", 0, new Buff("Non", 0, 0, 0, 50, 0, 0, 0, 3)));
//		selected.inventory.add(new Potion("Modifier Speed Potion", 0, new Buff("Modifier", 0, 0, 0, 0, 0, 10, 0, 3)));
//		selected.inventory.add(new Potion("Defense Potion", 0, new Buff("Non", 0, 0, 0, 0, 0, 0, 10, 3)));
//		selected.inventory.add(new Potion("Attack Potion", 0, new Buff("Non", 0, 0, 0, 10, 0, 0, 0, 3)));
//		selected.inventory.add(new Potion("Mana Restoring Potion", 0, new Buff("Non", 0, 20, 0, 10, 0, 0, 0, 3)));
//		selected.inventory.add(new Potion("Health Restoring Potion", 0, new Buff("Non", 50, 0, 0, 10, 0, 0, 0, 3)));
//
//		
//		selected.inventory.add(new Armor("Sunlight Armor", 30, 60, 45, 15, 20));
//		selected.inventory.add(new Armor("Sunlight Armor", 30, 60, 45, 15, 20));
//		selected.inventory.add(new Armor("Sunlight Armor", 30, 60, 45, 15, 20));
//		selected.inventory.add(new Armor("Sunlight Armor", 30, 60, 45, 15, 20));
//		
//		selected.inventory.add(new Weapon("Killer", 100, 100, 100, 100, 100));
//		selected.inventory.add(new Weapon("Killer", 100, 100, 100, 100, 100));
//		selected.inventory.add(new Weapon("Killer", 100, 100, 100, 100, 100));
//		selected.inventory.add(new Weapon("Killer", 100, 100, 100, 100, 100));

	}
}
