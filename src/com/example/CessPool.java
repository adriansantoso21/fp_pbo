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
		
		monsterz.add(new Monster("Abyss-step", 200, 90, 50, 10, 30, 20, 20, 20, 70)); //wizard type
		monsterz.add(new Monster("Ancurantus", 250, 20, 10, 40, 30, 20, 40, 30, 100)); //warrior type
		monsterz.add(new Monster("Blightsnare", 150, 50, 30, 30, 50, 50, 10, 30, 50)); // rogue type
		monsterz.add(new Monster("Bonelich", 200, 60, 45, 10, 35, 35, 20, 30, 40)); // healing type
		monsterz.add(new Monster("Duskfiend", 100, 10, 70, 10, 10, 5, 5, 30, 33)); //High attack
		monsterz.add(new Monster("Hell Vengeance", 400, 10, 10, 10, 10, 70, 70, 30, 0)); //high defence speed
		monsterz.add(new Monster("Nethermask", 200, 150, 20, 5, 20, 20, 20, 30, 50)); // regenerator
		monsterz.add(new Monster("Phasebrute", 200, 40, 20, 20, 20, 20, 20, 20, 50)); //invincible skill
		monsterz.add(new Monster("Plaguechild", 280, 90, 30, 10, 30, 30, 20, 30, 50)); //debuff wizard
		monsterz.add(new Monster("ShapePod", 200, 50, 30, 30, 30, 30, 30, 30, 40)); //warrior wizard
		monsterz.add(new Monster("Venomtooth", 200, 90, 30, 10, 20, 20, 20, 30, 50)); //buff wizard
		monsterz.add(new Monster("Warpwings", 300, 10, 10, 60, 20, 20, 40, 30, 0)); //pure warrior
		monsterz.add(new Monster("Astralvind", 200, 60, 10, 30, 40, 40, 20, 30, 40)); //rogue
		monsterz.get(0).skills.add(new DebuffSkill("Earthquake", 15, 200, new Buff("Earthquake", "Modifier", 0, 0, 0, 0, 0, -20, 0, 3, "Reduces enemy speed by 20%.")));
		monsterz.get(0).skills.add(new BuffSkill("Blessed Mind", 20, 200, new Buff("Blessed Mind", "Modifier", 0, 0, 20, 0, 0, 0, 0, 3, "Increases intelligence by 20%.")));
		monsterz.get(0).skills.add(new AttackSkill("Shattering Star", 20, "Modifier", 200, 50, 1, "Attacks with 150% intelligence."));
		monsterz.get(0).skills.add(new DebuffSkill("Dazing Bolt", 15, 200, new Buff("Dazing Bolt", "Non", 0, 0, 0, 0, -10, 0, 0, 3, "Reduces enemy accuracy by 10 points.")));
		monsterz.get(1).skills.add(new BuffSkill("Bloodlust", 20, 200, new Buff("Bloodlust", "Modifier", 0, 0, 20, 0, 0, 0, 0, 3, "Increases strength by 20%.")));
		monsterz.get(2).skills.add(new BuffSkill("Erratic Wisp", 15, 200, new Buff("Erratic Wisp", "Modifier", 0, 0, 0, 0, 25, 0, 0, 3, "Increases accuracy by 25%.")));
		monsterz.get(2).skills.add(new BuffSkill("Evasive Aura", 15, 200, new Buff("Evasive Aura", "Non", 0, 0, 0, 0, 0, 15, 0, 3, "Increases speed by 15 points.")));
		monsterz.get(2).skills.add(new AttackSkill("Shattering Star", 20, "Modifier", 150, 50, 0, "Attacks with 150% strength."));
		monsterz.get(3).skills.add(new BuffSkill("Soothing Cold", 15, 200, new Buff("Soothing Cold", "Modifier", 0, 30, 0, 0, 0, 0, 0, 3, "Replenishes 30% mana.")));
		monsterz.get(3).skills.add(new BuffSkill("Cleanse Wounds", 15, 200, new Buff("Cleanse Wounds", "Modifier", 30, 0, 0, 0, 0, 0, 0, 3, "Replenishes 30% HP.")));
		monsterz.get(3).skills.add(new BuffSkill("Armor of Frost", 20, 200, new Buff("Armor of Frost", "Modifier", 0, 0, 0, 0, 0, 0, 50, 3, "Increases defense by 50%.")));
		monsterz.get(4).skills.add(new BuffSkill("Duskfiend's Dawn", 10, 200, new Buff("Duskfiend's Dawn", "Modifier", 80, 0, 0, 0, 0, 0, 0, 3, "Replenishes 80% HP.")));
		monsterz.get(6).skills.add(new BuffSkill("Drawing Nether's Energy", 10, 200, new Buff("Drawing Nether's Energy", "Modifier", 30, 0, 0, 0, 0, 0, 0, 3, "Replenishes 30% HP.")));
		monsterz.get(7).skills.add(new BuffSkill("Dimensional Phasing", 20, 200, new Buff("Dimensional Phasing", "Non", 0, 0, 0, 0, 0, 0, 100, 2, "Increases defense by 100 points.")));
		monsterz.get(8).skills.add(new DebuffSkill("Deep Freeze", 15, 200, new Buff("Deep Freeze", "Modifier", 0, 0, 0, 0, -20, -20, 0, 3, "Reduces enemy accuracy and speed by 20%.")));
		monsterz.get(8).skills.add(new DebuffSkill("Epidemic of Fire", 15, 200, new Buff("Epidemic of Fire", "Modifier", 0, 0, -20, -20, 0, 0, 0, 3, "Reduces enemy strength and intelligence by 20%.")));
		monsterz.get(8).skills.add(new DebuffSkill("Maddening Song", 15, 200, new Buff("Maddening Song", "Modifier", 0, 0, 0, 0, 0, 0, -30, 3, "Reduces enemy defence by 30%.")));
		monsterz.get(9).skills.add(new BuffSkill("Enrage", 20, 200, new Buff("Enrage", "Modifier", 0, 0, 0, 30, 0, 0, 0, 3, "Increases intelligence by 30% for 3 turns.")));
		monsterz.get(9).skills.add(new AttackSkill("Shattering Star", 15, "Modifier", 175, 50, 0, "Attacks with 175% strength."));
		monsterz.get(10).skills.add(new BuffSkill("Terrifying Cruelty", 15, 200, new Buff("Terrifying Cruelty", "Modifier", 0, 0, 0, 0, 25, 25, 0, 3, "Increases speed and accuracy by 25%.")));
		monsterz.get(10).skills.add(new BuffSkill("Oily Carapace", 15, 200, new Buff("Oily Carapace", "Modifier", 0, 0, 0, 0, 0, 25, 25, 3, "Increases defense and speed by 25%.")));
		monsterz.get(10).skills.add(new BuffSkill("Flaming Crescendo", 15, 200, new Buff("Flaming Crescendo", "Modifier", 0, 0, 25, 0, 0, 25, 0, 3, "Increases intelligence and defense by 25%.")));
		monsterz.get(10).skills.add(new BuffSkill("Door to Eternity", 20, 200, new Buff("Door to Eternity", "Modifier", 0, 0, 33, 0, 0, 0, 0, 3, "Increases intelligence by 33%.")));
		monsterz.get(12).skills.add(new DebuffSkill("Dominate Mind", 10, 200, new Buff("Dominate Mind", "Modifier", 0, 0, 0, 0, 25, 0, 0, 3, "Decreases accuracy by 25%.")));
		monsterz.get(12).skills.add(new BuffSkill("Evasive Aura", 15, 200, new Buff("Favorable Wind", "Modifier", 0, 0, 0, 0, 25, 25, 0, 3, "Increases speed and accuracy by 25%.")));
		monsterz.get(12).skills.add(new AttackSkill("Fan of Knives", 20, "Modifier", 220, 50, 0, "Attacks with 220% strength."));
		
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
		weaponz.add(new Weapon("dragon's corroded fang", 10, 40, 25, 25, 30, 600));
		weaponz.add(new Weapon("dragonwrath", 40, 60, 70, 30, 15, 700));
		weaponz.add(new Weapon("katana Sword", 30, 60, 45, 15, 20, 800));
		weaponz.add(new Weapon("Tarecgosa's Rest", 30, 60, 45, 15, 20, 800));
		
		potionz.add(new Potion("Defence Potion", 0, 100, new Buff("Defence Potion", "Non", 0, 0, 0, 0, 0, 0, 30, 3, "Increases defense by 30 points for 3 turns.")));
		potionz.add(new Potion("Attack Potion", 0,100, new Buff("Attack Potion", "Non", 0, 0, 0, 10, 0, 0, 0, 3, "Increases attack by 10 points for 3 turns.")));
		potionz.add(new Potion("Accuracy Potion", 0,100, new Buff("Accuracy Potion", "Modifier", 0, 0, 0, 0, 10, 0, 0, 3, "Increases accuracy by 10% for 3 turns.")));
		potionz.add(new Potion("Speed Potion", 0,100, new Buff("Speed Potion", "Modifier", 0, 0, 0, 0, 0, 10, 0, 3, "Increases speed by 10% for 3 turns.")));
		potionz.add(new Potion("Mana Potion", 0,100, new Buff("Mana Potion", "Non", 0, 40, 0, 10, 0, 0, 0, 3, "Replenishes mana by 40 points.")));
		potionz.add(new Potion("Strength Potion", 0,100, new Buff("Strength Potion", "Modifier", 0, 0, 0, 10, 0, 0, 0, 3, "Increases strength by 10% for 3 turns.")));
		potionz.add(new Potion("Intelligence Potion", 0,100, new Buff("Intelligence Potion", "Modifier", 0, 0, 0, 0, 0, 10, 0, 3, "Increases intelligence by 10% for 3 turns.")));
		potionz.add(new Potion("Health Potion", 0,100, new Buff("Health Potion", "Modifier", 50, 0, 0, 0, 0, 0, 0, 3, "Replenishes HP by 50%.")));
		
		skillz.add(new AttackSkill("Shattering Star", 50, "Modifier", 200, 50, 0, "Attacks with 150% strength"));
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
