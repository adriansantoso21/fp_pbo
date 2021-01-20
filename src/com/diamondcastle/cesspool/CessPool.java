package com.diamondcastle.cesspool;

import java.util.ArrayList;

import javax.swing.JFrame;
import com.diamondcastle.creature.Character;
import com.diamondcastle.creature.Monster;
import com.diamondcastle.inventory.Armor;
import com.diamondcastle.inventory.Potion;
import com.diamondcastle.inventory.Weapon;
import com.diamondcastle.skill.AttackSkill;
import com.diamondcastle.skill.Buff;
import com.diamondcastle.skill.BuffSkill;
import com.diamondcastle.skill.DebuffSkill;
import com.diamondcastle.skill.Skill;

public class CessPool {
	public static Character selected = new Character("Heroman", 300, 60, 20, 40, 40, 30, 30, 30," ");
	public static ArrayList<Monster> monsterz = new ArrayList<Monster>();
	public static ArrayList<Weapon> weaponz = new ArrayList<Weapon>();
	public static ArrayList<Armor> armorz = new ArrayList<Armor>();
	public static ArrayList<Potion> potionz = new ArrayList<Potion>();
	public static ArrayList<Skill> skillz = new ArrayList<Skill>();
	public static ArrayList<Integer> location = new ArrayList<Integer>();
	public static ArrayList<String> endingz = new ArrayList<String>();
	public int curloc;
	public static int currDif = 0;
	
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
		monsterz.get(12).skills.add(new DebuffSkill("Dominate Mind", 10, 200, new Buff("Dominate Mind", "Modifier", 0, 0, 0, 0, 25, 0, 0, 3, "Increases accuracy by 25%.")));
		monsterz.get(12).skills.add(new BuffSkill("Evasive Aura", 15, 200, new Buff("Evasive Aura", "Modifier", 0, 0, 0, 0, 25, 25, 0, 3, "Increases speed and accuracy by 25%.")));
		monsterz.get(12).skills.add(new AttackSkill("Fan of Knives", 20, "Modifier", 220, 50, 0, "Attacks with 220% strength."));
		
		armorz.add(new Armor("Sunlight Armor", 23, 40, 45, 15, 20, 750));
		armorz.add(new Armor("Ancient Armor", 24, 50, 50, 25, 30, 800));
		armorz.add(new Armor("Armor of the Warzone", 30, 60, 70, 30, 15, 900));
		armorz.add(new Armor("Death", 70, 90, 70, 70, 50, 1500));
		armorz.add(new Armor("Amberlite", 45, 80, 65, 50, 40, 1100));
		armorz.add(new Armor("Athena armor", 27, 55, 35, 25, 30, 850));
		armorz.add(new Armor("Death fire", 35, 60, 75, 30, 40, 925));
		armorz.add(new Armor("Feyweave Robe", 40, 70, 60, 39, 45, 1000));
		armorz.add(new Armor("Robe of the Oracle", 20, 35, 40, 10, 30, 650));
		
		weaponz.add(new Weapon("Killer", 30, 52, 38, 10, 10, 425));
		weaponz.add(new Weapon("Ancient Sword", 50, 70, 25, 17, 10, 600));
		weaponz.add(new Weapon("Sword of the Warzone", 40, 60, 70, 20, 15, 700));
		weaponz.add(new Weapon("Sunlight Sword", 35, 67, 55, 35, 20, 800));
		weaponz.add(new Weapon("Lost Prayer to the Wind", 38, 60, 70, 40, 26, 850));
		weaponz.add(new Weapon("Dragon's Corroded Fang", 47, 75, 63, 52, 38, 1000));
		weaponz.add(new Weapon("Dragonwrath", 43, 69, 60, 49, 33, 950));
		weaponz.add(new Weapon("Katana Sword", 41, 75, 42, 45, 28, 900));
		weaponz.add(new Weapon("Tarecgosa's Rest", 20, 60, 45, 15, 20, 550));
		
		potionz.add(new Potion("Defence Potion", 0, 100, new Buff("Defence Potion", "Non", 0, 0, 0, 0, 0, 0, 15, 3, "Increases defense by 15 points for 3 turns.")));
		potionz.add(new Potion("Attack Potion", 0,100, new Buff("Attack Potion", "Non", 0, 0, 0, 15, 0, 0, 0, 3, "Increases strength by 15 points for 3 turns.")));
		potionz.add(new Potion("Accuracy Potion", 0,100, new Buff("Accuracy Potion", "Modifier", 0, 0, 0, 0, 15, 0, 0, 3, "Increases accuracy by 15% for 3 turns.")));
		potionz.add(new Potion("Speed Potion", 0,100, new Buff("Speed Potion", "Modifier", 0, 0, 0, 0, 0, 15, 0, 3, "Increases speed by 15% for 3 turns.")));
		potionz.add(new Potion("Mana Potion", 0,100, new Buff("Mana Potion", "Non", 0, 15, 0, 0, 0, 0, 0, 3, "Replenishes mana by 15 points.")));
		potionz.add(new Potion("Strength Potion", 0,100, new Buff("Strength Potion", "Modifier", 0, 0, 0, 15, 0, 0, 0, 3, "Increases strength by 15% for 3 turns.")));
		potionz.add(new Potion("Intelligence Potion", 0,100, new Buff("Intelligence Potion", "Modifier", 0, 0, 15, 0, 0, 0, 0, 3, "Increases intelligence by 15% for 3 turns.")));
		potionz.add(new Potion("Health Potion", 0,100, new Buff("Health Potion", "Modifier", 15, 0, 0, 0, 0, 0, 0, 3, "Replenishes HP by 15%.")));
		
		potionz.add(new Potion("Greater Mana Potion", 0,150, new Buff("Greater Mana Potion", "Modifier", 0, 25, 0, 0, 0, 0, 0, 3, "Increases mana by 25% for 3 turns.")));
		potionz.add(new Potion("Modifier Defence Potion", 0,150, new Buff("Greater Defence Potion", "Modifier", 0, 0, 0, 0, 0, 25, 0, 3, "Increases defence by 25% for 3 turns.")));
		potionz.add(new Potion("Greater Health Potion", 0,150, new Buff("Greater Health Potion", "Non", 25, 0, 0, 0, 0, 0, 0, 3, "Increases HP by 25 points.")));
		potionz.add(new Potion("Modifier Attack Potion", 0,150, new Buff("Greater Attack Potion", "Non", 0, 0, 0, 25, 0, 0, 0, 3, "Increases strength by 25 points.")));
		potionz.add(new Potion("Modifier Intelligence Potion", 0,150, new Buff("Greater Intelligence Potion", "Modifier", 0, 0, 25, 0, 0, 0, 0, 3, "Increases intelligence by 25% for 3 turns.")));
		potionz.add(new Potion("Modifier Strength Potion", 0,175, new Buff("Greater Strength Potion", "Modifier", 0, 0, 0, 30, 0, 0, 0, 3, "Increases strength by 30% for 3 turns.")));
		potionz.add(new Potion("Modifier Speed Potion", 0,150, new Buff("Greater Speed", "Modifier", 0, 0, 0, 0, 0, 25, 0, 3, "Increases speed by 25% for 3 turns.")));
		potionz.add(new Potion("Modifier Health Potion", 0,150, new Buff("Modifier Health Potion", "Modifier", 25, 0, 0, 0, 0, 0, 0, 3, "Increases HP by 25% for 3 turns.")));
		potionz.add(new Potion("Modifier Mana Potion", 0,150, new Buff("Modifier Mana Potion", "Modifier", 0, 25, 0, 0, 0, 0, 0, 3, "Increases mana by 25% for 3 turns.")));
		
		potionz.add(new Potion("Defence and Accuracy Potion", 0,175, new Buff("Defence and Accuracy Potion", "Modifier", 0, 0, 0, 0, 15, 0, 15, 3, "Increases defence and accuracy by 15% for 3 turns.")));
		potionz.add(new Potion("Attack and Intelligence Potion", 0,175, new Buff("Attack and Intelligence Potion", "Modifier", 0, 0, 15, 15, 0, 0, 0, 3, "Increases attack and intelligence by 15% for 3 turns.")));
		potionz.add(new Potion("Strength and Speed Potion", 0,175, new Buff("Strength and Speed Potion", "Modifier", 0, 0, 0, 15, 0, 15, 0, 3, "Increases strength and speed  by 15% for 3 turns.")));
		potionz.add(new Potion("Health and Mana Potion", 0,175, new Buff("Health and Mana Potion", "Modifier", 15, 15, 0, 0, 0, 10, 0, 3, "Increases health and mana by 15% for 3 turns.")));
		potionz.add(new Potion("Heavenly Potion", 0,300, new Buff("Heavenly Potion", "Modifier", 15, 15, 15, 15, 15, 15, 15, 3, "Increasess all stats by 15% for 3 turns.")));

		skillz.add(new AttackSkill("Shattering Star", 20, "Modifier", 250, 60, 0, "Attacks with 150% strength."));
		skillz.add(new BuffSkill("Sword Saint", 20,150, new Buff("Sword Saint", "Non", 0, 0, 0, 10, 0, 0, 0, 3, "Increases strength by 10.")));
		skillz.add(new BuffSkill("Faint Destroyer", 20,180, new Buff("Faint Destroyer", "Modifier", 0, 0, 0, 0, 20, 0, 0, 3, "Increases accuracy by 20%.")));
		skillz.add(new DebuffSkill("Earthquake", 25,155, new Buff("Earthquake", "Modifier", 0, 0, 0, 0, 0, -25, 0, 3, "Reduces enemy speed by 25%.")));
		skillz.add(new DebuffSkill("Meteor Shower", 25,250, new Buff("Meteor Shower", "Non", 0, 0, 0, -20, 0, 0, 0, 3, "Reduces enemy strength by 20 points.")));
		skillz.add(new BuffSkill("Water Pulse", 27,270, new Buff("Water Pulse", "Non", 50, 0, 0, 0, 10, 0, 0, 3, "Replenishes 50 HP.")));
		skillz.add(new BuffSkill("Winter Blast", 30,300, new Buff("Winter Blast", "Modifier", 30, 0, 0, 0, 0, 0, 0, 3, "Replenishes 30% HP.")));
		skillz.add(new AttackSkill("Chain Lightning", 30, "Modifier", 300, 75, 1, "Attacks with 175% intelligence."));
		skillz.add(new AttackSkill("Onslaught", 20, "Modifier", 200, 40, 0, "Attacks with 140% strength."));
		skillz.add(new BuffSkill("Erratic Wisp", 22,200, new Buff("Erratic Wisp", "Non", 0, 0, 0, 25, 0, 0, 0, 3, "Increases strength by 25%")));
		skillz.add(new BuffSkill("Supernova", 22,250, new Buff("Supernova", "Modifier", 0, 18, 0, 0, 0, 0, 0, 3, "Increases mana by 18%.")));
		skillz.add(new DebuffSkill("Grasp of the Starved", 27,160, new Buff("Grasp of the Starved", "Modifier", 0, 0, 0, 0, 0, 0, -20, 3, "Reduces enemy defence by 20%.")));
		skillz.add(new DebuffSkill("Gag Order", 25,250, new Buff("Gag Order", "Non", 0, -20, 0, 0, 0, 0, 0, 3, "Reduces enemy mana by 20 points.")));
		skillz.add(new BuffSkill("Evasive Aura", 30, 350, new Buff("Evasive Aura", "Modifier", 0, 0, 0, 0, 25, 25, 0, 3, "Increases speed and accuracy by 25%.")));
		skillz.add(new DebuffSkill("Deep Freeze", 30, 350, new Buff("Deep Freeze", "Modifier", 0, 0, 0, 0, -20, -20, 0, 3, "Reduces enemy accuracy and speed by 20%.")));
		
		endingz.add(new String(" O . . m O . . R i . . "));
		endingz.add(new String(" w..here a..r.ee yo.. ma...r..i "));
		endingz.add(new String(" ..we'..re still yo..ng. we should d.rea.. big.."));
		endingz.add(new String(" zz..Watermelons ar.. the best part of summe..rr right.. om..ri? "));
		endingz.add(new String(" M..ari's c..ookies ha.e so much l.ve baked into the.. I could e... them forev..z...z "));
		endingz.add(new String(" a... w..ish? but what sh..ld i wi.h for? bz..z... I have everything I could want right her. "));
		endingz.add(new String(" th..is yea.r, yo..uu get just o..ne pre..sent.. from all four of ..u ..zz "));
		endingz.add(new String(" mari.... wh..y.. "));
		endingz.add(new String(" o..m.ori... ev..en.. if.. ma..r.'s gone.. rem..ember.. we... will "));
		endingz.add(new String(" F i g h t i n g   r e s t l e s s l y. . . T h a t ' s  j u s t  l i k e  y o u  o m ..... r..."));
		endingz.add(new String(" i .. m.i...ss. y..ou "));
	}
}
