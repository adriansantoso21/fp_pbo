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
	int curloc;
	
	public CessPool() {
		location.add(-1);
		
		monsterz.add(new Monster("Abyss-step", 300, 28, 20, 40, 40, 30, 30, 30));
		monsterz.add(new Monster("Ancurantus", 200, 34, 20, 40, 40, 30, 30, 30));
		monsterz.add(new Monster("Blightsnare", 300, 34, 20, 40, 40, 30, 30, 30));
		monsterz.add(new Monster("Bonelich", 400, 34, 20, 40, 40, 30, 30, 30));
		monsterz.add(new Monster("Duskfiend", 500, 34, 20, 40, 40, 30, 30, 30));
		monsterz.add(new Monster("Hell Vengeance", 600, 34, 20, 40, 40, 30, 30, 30));
		monsterz.add(new Monster("Nethermask", 700, 34, 20, 40, 40, 30, 30, 30));
		monsterz.add(new Monster("Phasebrute", 800, 34, 20, 40, 40, 30, 30, 30));
		monsterz.add(new Monster("Plaguechild", 900, 34, 20, 40, 40, 30, 30, 30));
		monsterz.add(new Monster("ShapePod", 1000, 34, 20, 40, 40, 30, 30, 30));
		monsterz.add(new Monster("Venomtooth", 900, 34, 20, 40, 40, 30, 30, 30));
		monsterz.add(new Monster("Warpwings", 1000, 34, 20, 40, 40, 30, 30, 30));
		monsterz.add(new Monster("Astralvind", 1000, 34, 20, 40, 40, 30, 30, 30));
//		monsterz.get(0).skills.add(new DebuffSkill("Earthquake", 35, 200, new Buff("Earthquake", "Modifier", 0, 0, 0, 0, 0, -10, 0, 3, "Reduces enemy speed by 10%.")));
		
		armorz.add(new Armor("Sunlight Armor", 30, 60, 45, 15, 20, 750));
		armorz.add(new Armor("Ancient Armor", 10, 40, 25, 25, 30, 800));
		armorz.add(new Armor("Armor of the Warzone", 40, 60, 70, 30, 15, 900));
		armorz.add(new Armor("Death", 100, 100, 100, 100, 100, 1500));
		armorz.add(new Armor("Amberlite", 100, 100, 100, 100, 100, 1500));
		armorz.add(new Armor("Athena armor", 10, 40, 25, 25, 30, 800));
		armorz.add(new Armor("Death fire", 40, 60, 70, 30, 15, 900));
		armorz.add(new Armor("Feyweave Robe", 100, 100, 100, 100, 100, 1500));
		armorz.add(new Armor("Robe of the Oracle", 100, 100, 100, 100, 100, 1500));
		
		weaponz.add(new Weapon("Killer", 100, 100, 100, 100, 100, 400));
		weaponz.add(new Weapon("Ancient Sword", 10, 40, 25, 25, 30, 600));
		weaponz.add(new Weapon("Sword of the Warzone", 40, 60, 70, 30, 15, 700));
		weaponz.add(new Weapon("Sunlight Sword", 30, 60, 45, 15, 20, 800));
		weaponz.add(new Weapon("Lost Prayer to the Wind", 30, 60, 45, 15, 20, 800));
		weaponz.add(new Weapon("Dragon's Corroded Fang", 10, 40, 25, 25, 30, 600));
		weaponz.add(new Weapon("Dragonwrath", 40, 60, 70, 30, 15, 700));
		weaponz.add(new Weapon("Katana Sword", 30, 60, 45, 15, 20, 800));
		weaponz.add(new Weapon("Tarecgosa's Rest", 30, 60, 45, 15, 20, 800));
		
		potionz.add(new Potion("Defence Potion", 0, 100, new Buff("Defence Potion", "Non", 0, 0, 0, 0, 0, 0, 30, 3, "Increases defense by 30 points for 3 turns.")));
		potionz.add(new Potion("Attack Potion", 0,100, new Buff("Attack Potion", "Non", 0, 0, 0, 10, 0, 0, 0, 3, "Increases attack by 10 points for 3 turns.")));
		potionz.add(new Potion("Accuracy Potion", 0,100, new Buff("Accuracy Potion", "Modifier", 0, 0, 0, 0, 10, 0, 0, 3, "Increases accuracy by 10% for 3 turns.")));
		potionz.add(new Potion("Speed Potion", 0,100, new Buff("Speed Potion", "Modifier", 0, 0, 0, 0, 0, 10, 0, 3, "Increases speed by 10% for 3 turns.")));
		potionz.add(new Potion("Mana Potion", 0,100, new Buff("Mana Potion", "Non", 0, 40, 0, 10, 0, 0, 0, 3, "Replenishes mana by 40 points.")));
		potionz.add(new Potion("Strength Potion", 0,100, new Buff("Strength Potion", "Modifier", 0, 0, 0, 10, 0, 0, 0, 3, "Increases strength by 10% for 3 turns.")));
		potionz.add(new Potion("Intelligence Potion", 0,100, new Buff("Intelligence Potion", "Modifier", 0, 0, 0, 0, 0, 10, 0, 3, "Increases intelligence by 10% for 3 turns.")));
		potionz.add(new Potion("Health Potion", 0,100, new Buff("Health Potion", "Modifier", 50, 0, 0, 0, 0, 0, 0, 3, "Replenishes HP by 50%.")));
		potionz.add(new Potion("Greater Mana Potion", 0,100, new Buff("Greater Mana Potion", "Modifier", 0, 0, 0, 0, 0, 10, 0, 3, "Increases speed by 10% for 3 turns.")));
		potionz.add(new Potion("Modifier Defence Potion", 0,100, new Buff("Greater Defence Potion", "Modifier", 0, 0, 0, 0, 0, 10, 0, 3, "Increases speed by 10% for 3 turns.")));
		potionz.add(new Potion("Greater Health Potion", 0,100, new Buff("Greater Health Potion", "Non", 0, 40, 0, 10, 0, 0, 0, 3, "Replenishes mana by 40 points.")));
		potionz.add(new Potion("Modifier Attack Potion", 0,100, new Buff("Greater Attack Potion", "Non", 0, 40, 0, 10, 0, 0, 0, 3, "Replenishes mana by 40 points.")));
		potionz.add(new Potion("Modifier Intelligence Potion", 0,100, new Buff("Greater Intelligence Potion", "Modifier", 0, 0, 0, 10, 0, 0, 0, 3, "Increases strength by 10% for 3 turns.")));
		potionz.add(new Potion("Modifier Strength Potion", 0,100, new Buff("Greater Strength Potion", "Modifier", 0, 0, 0, 10, 0, 0, 0, 3, "Increases strength by 10% for 3 turns.")));
		potionz.add(new Potion("Modifier Speed", 0,100, new Buff("Greater Speed", "Modifier", 0, 0, 0, 0, 0, 10, 0, 3, "Increases speed by 10% for 3 turns.")));
		potionz.add(new Potion("Modifier Health Potion", 0,100, new Buff("Modifier Health Potion", "Modifier", 0, 0, 0, 0, 0, 10, 0, 3, "Increases speed by 10% for 3 turns.")));
		potionz.add(new Potion("Modifier Mana Potion", 0,100, new Buff("Modifier Mana Potion", "Modifier", 0, 0, 0, 0, 0, 10, 0, 3, "Increases speed by 10% for 3 turns.")));
		potionz.add(new Potion("Defence and Accuracy Potion", 0,100, new Buff("Defence and Accuracy Potion", "Modifier", 0, 0, 0, 0, 0, 10, 0, 3, "Increases intelligence by 10% for 3 turns.")));
		potionz.add(new Potion("Attack and Intelligence Potion", 0,100, new Buff("Attack and Intelligence Potion", "Modifier", 0, 0, 0, 0, 0, 10, 0, 3, "Increases intelligence by 10% for 3 turns.")));
		potionz.add(new Potion("Strength and Speed Potion", 0,100, new Buff("Strength and Speed Potion", "Modifier", 0, 0, 0, 0, 0, 10, 0, 3, "Increases intelligence by 10% for 3 turns.")));
		potionz.add(new Potion("Health and Mana Potion", 0,100, new Buff("Health and Mana Potion", "Modifier", 0, 0, 0, 0, 0, 10, 0, 3, "Increases intelligence by 10% for 3 turns.")));
		potionz.add(new Potion("Heavenly Potion", 0,100, new Buff("Heavenly Potion", "Modifier", 50, 0, 0, 0, 0, 0, 0, 3, "Replenishes HP by 50%.")));

		skillz.add(new AttackSkill("Shattering Star", 50, "Modifier", 200, 50, "Attacks with 150% strength"));
		skillz.add(new BuffSkill("Sword Saint", 40,200, new Buff("Sword Saint", "Non", 0, 0, 0, 10, 0, 0, 0, 3, "Increases strength by 10%")));
		skillz.add(new BuffSkill("Faint Destroyer", 45,200, new Buff("Faint Destroyer", "Modifier", 0, 0, 0, 0, 10, 0, 0, 3, "Increases accuracy by 10%.")));
		skillz.add(new DebuffSkill("Earthquake", 35,200, new Buff("Earthquake", "Modifier", 0, 0, 0, 0, 0, -10, 0, 3, "Reduces enemy speed by 10%.")));
		skillz.add(new DebuffSkill("Meteor Shower", 30,200, new Buff("Meteor Shower", "Non", 0, 0, 0, -20, 0, 0, 0, 3, "Reduces enemy strength by 20 pointa.")));
		skillz.add(new BuffSkill("Water Pulse", 50,200, new Buff("Water Pulse", "Modifier", 50, 0, 0, 0, 10, 0, 0, 3, "Replenishes 50% HP.")));
		skillz.add(new BuffSkill("Winter Blast", 45,200, new Buff("Winter Blast", "Modifier", 30, 0, 0, 0, 0, 0, 0, 3, "Replenishes 30% HP.")));
		skillz.add(new AttackSkill("Chain Lightning", 50, "Modifier", 200, 50, "Attacks with 150% strength"));
		skillz.add(new AttackSkill("Onslaught", 50, "Modifier", 200, 50, "Attacks with 150% strength"));
		skillz.add(new BuffSkill("Erratic Wisp", 40,200, new Buff("Sword Saint", "Non", 0, 0, 0, 10, 0, 0, 0, 3, "Increases strength by 10%")));
		skillz.add(new BuffSkill("Supernova", 45,200, new Buff("Supernova", "Modifier", 0, 0, 0, 0, 10, 0, 0, 3, "Increases accuracy by 10%.")));
		skillz.add(new DebuffSkill("Grasp of the Starved", 35,200, new Buff("Grasp of the Starved", "Modifier", 0, 0, 0, 0, 0, -10, 0, 3, "Reduces enemy speed by 10%.")));
		skillz.add(new DebuffSkill("Gag Order", 30,200, new Buff("Gag Order", "Non", 0, 0, 0, -20, 0, 0, 0, 3, "Reduces enemy strength by 20 pointa.")));
		
	}
}
