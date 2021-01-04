package com.example;

import java.util.ArrayList;

import javax.swing.JFrame;

public class CessPool {
	public static Character selected = new Character("Heroman", 300, 60, 20, 40, 40, 30, 30, 30);
	public static ArrayList<Monster> monsterz = new ArrayList<Monster>();
	public static ArrayList<Weapon> weaponz = new ArrayList<Weapon>();
	public static ArrayList<Armor> armorz = new ArrayList<Armor>();
	public static ArrayList<Potion> potionz = new ArrayList<Potion>();
	public static ArrayList<SkillBook> skillbookz = new ArrayList<SkillBook>();

	
	public CessPool() {
		monsterz.add(new Monster("Villain", 300, 28, 20, 40, 40, 30, 30, 30));
		monsterz.add(new Monster("2nd Villain", 150, 34, 20, 40, 40, 30, 30, 30));
		armorz.add(new Armor("Sunlight Armor", 30, 60, 45, 15, 20));
		armorz.add(new Armor("Ancient Armor", 10, 40, 25, 25, 30));
		armorz.add(new Armor("Armor of the Warzone", 40, 60, 70, 30, 15));
		armorz.add(new Armor("Death", 100, 100, 100, 100, 100));
		weaponz.add(new Weapon("Killer", 100, 100, 100, 100, 100));
		weaponz.add(new Weapon("Ancient Sword", 10, 40, 25, 25, 30));
		weaponz.add(new Weapon("Sword of the Warzone", 40, 60, 70, 30, 15));
		weaponz.add(new Weapon("Sunlight Spear", 30, 60, 45, 15, 20));
		potionz.add(new Potion("Defense Potion", 0, new Buff("Non", 0, 0, 0, 0, 0, 0, 10, 3)));
		potionz.add(new Potion("Attack Potion", 0, new Buff("Non", 0, 0, 0, 10, 0, 0, 0, 3)));
		potionz.add(new Potion("Accuracy Potion", 0, new Buff("Modifier", 0, 0, 0, 0, 10, 0, 0, 3)));
		potionz.add(new Potion("Speed Potion", 0, new Buff("Modifier", 0, 0, 0, 0, 0, 10, 0, 3)));
		skillbookz.add(new SkillBook("Shattering Star", 10));
		skillbookz.add(new SkillBook("Sword Saint", 10));
		skillbookz.add(new SkillBook("Faint Destroyer", 10));
		skillbookz.add(new SkillBook("Yo", 10));
		selected.skills.add(new BuffSkill("Shining Star", 20, new Buff("Modifier", 0, 0, 0, 50, 50, 50, 0, 3)));
		selected.skills.add(new DebuffSkill("Blinding Starlight", 30, new Buff("Modifier", 0, 0, 0, -30, -30, 0, 0, 3)));
		selected.inventory.add(new Potion("Attack Potion", 0, new Buff("Non", 0, 0, 0, 50, 0, 0, 0, 3)));
		selected.inventory.add(new Potion("Modifier Speed Potion", 0, new Buff("Modifier", 0, 0, 0, 0, 0, 10, 0, 3)));
		selected.inventory.add(new Potion("Defense Potion", 0, new Buff("Non", 0, 0, 0, 0, 0, 0, 10, 3)));
		selected.inventory.add(new Potion("Attack Potion", 0, new Buff("Non", 0, 0, 0, 10, 0, 0, 0, 3)));
		selected.inventory.add(new Potion("Mana Restoring Potion", 0, new Buff("Non", 0, 20, 0, 10, 0, 0, 0, 3)));
		selected.inventory.add(new Potion("Health Restoring Potion", 0, new Buff("Non", 50, 0, 0, 10, 0, 0, 0, 3)));
	}
}
