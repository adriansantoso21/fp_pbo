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
		
		weaponz.add(new Weapon("Killer", 100, 100, 100, 100, 100, 400));
		weaponz.add(new Weapon("Ancient Sword", 10, 40, 25, 25, 30, 600));
		weaponz.add(new Weapon("Sword of the Warzone", 40, 60, 70, 30, 15, 700));
		weaponz.add(new Weapon("Sunlight Sword", 30, 60, 45, 15, 20, 800));
		weaponz.add(new Weapon("Lost Prayer to the Wind", 30, 60, 45, 15, 20, 800));
		
		potionz.add(new Potion("Defence Potion", 0, 100, new Buff("Defence Potion", "Non", 0, 0, 0, 0, 0, 0, 30, 3, "Increases defense by 30 points for 3 turns.")));
		potionz.add(new Potion("Attack Potion", 0,100, new Buff("Attack Potion", "Non", 0, 0, 0, 10, 0, 0, 0, 3, "Increases attack by 10 points for 3 turns.")));
		potionz.add(new Potion("Accuracy Potion", 0,100, new Buff("Accuracy Potion", "Modifier", 0, 0, 0, 0, 10, 0, 0, 3, "Increases accuracy by 10% for 3 turns.")));
		potionz.add(new Potion("Speed Potion", 0,100, new Buff("Speed Potion", "Modifier", 0, 0, 0, 0, 0, 10, 0, 3, "Increases speed by 10% for 3 turns.")));
		potionz.add(new Potion("Mana Potion", 0,100, new Buff("Mana Potion", "Non", 0, 40, 0, 10, 0, 0, 0, 3, "Replenishes mana by 40 points.")));
		potionz.add(new Potion("Strength Potion", 0,100, new Buff("Strength Potion", "Modifier", 0, 0, 0, 10, 0, 0, 0, 3, "Increases strength by 10% for 3 turns.")));
		potionz.add(new Potion("Intelligence Potion", 0,100, new Buff("Intelligence Potion", "Modifier", 0, 0, 0, 0, 0, 10, 0, 3, "Increases intelligence by 10% for 3 turns.")));
		potionz.add(new Potion("Health Potion", 0,100, new Buff("Health Potion", "Modifier", 50, 0, 0, 0, 0, 0, 0, 3, "Replenishes HP by 50%.")));
		
		skillz.add(new AttackSkill("Shattering Star", 50, "Modifier", 200, 50, "Attacks with 150% strength"));
		skillz.add(new BuffSkill("Sword Saint", 40,200, new Buff("Sword Saint", "Non", 0, 0, 0, 10, 0, 0, 0, 3, "Increases strength by 10%")));
		skillz.add(new BuffSkill("Faint Destroyer", 45,200, new Buff("Faint Destroyer", "Modifier", 0, 0, 0, 0, 10, 0, 0, 3, "Increases accuracy by 10%.")));
		skillz.add(new DebuffSkill("Earthquake", 35,200, new Buff("Earthquake", "Modifier", 0, 0, 0, 0, 0, -10, 0, 3, "Reduces enemy speed by 10%.")));
		skillz.add(new DebuffSkill("Meteor Shower", 30,200, new Buff("Meteor Shower", "Non", 0, 0, 0, -20, 0, 0, 0, 3, "Reduces enemy strength by 20 pointa.")));
		skillz.add(new BuffSkill("Water Pulse", 50,200, new Buff("Water Pulse", "Modifier", 50, 0, 0, 0, 10, 0, 0, 3, "Replenishes 50% HP.")));
		skillz.add(new BuffSkill("Winter Blast", 45,200, new Buff("Winter Blast", "Modifier", 30, 0, 0, 0, 0, 0, 0, 3, "Replenishes 30% HP.")));
		
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
