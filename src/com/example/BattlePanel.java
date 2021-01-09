package com.example;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class BattlePanel extends JPanel {
	
	Character fighter = CessPool.selected;
	Monster fighted = CessPool.monsterz.get(0);
	int num;
	
	private CardLayout cardlayt = new CardLayout();
	private JPanel potionPanel = new JPanel(cardlayt);
	private JTextPane ta, tb;
	private JPanel skillButtonPanel, charaPanel;
	
	public BattlePanel(JFrame frame) {
		
		fighted.healHP();
		num=0;
        
        ta = new JTextPane();
        ta.setEditable(false);
        ta.setContentType("text/html");
        ta.setText("<html><h2 style=\"color:white;\">");
        
        ta.setBackground(Color.black);
        potionPanel.add(ta, "text");
        potionPanel.add(createPotionPanel(), "potion");
        potionPanel.add(addSkillPanel(), "skill");
        potionPanel.add(addCharaPanel(), "chara");
        cardlayt.show(potionPanel, "text");
        
        tb = new JTextPane();
        tb.setEditable(false);
        tb.setContentType("text/html");
        tb.setText("<html><h3>~~~~~~~~~~~HP:"+fighter.currHP+"/"+fighter.healthPoint+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~HP: "+fighted.currHP+"/"+fighted.healthPoint+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>~~~~~~~~~~~MP:"+fighter.currMana+"/"+fighter.mana+"</h3></html>");
        
        
        GridLayout layout = new GridLayout(2, 1);
        
        JPanel panel1 = new JPanel(layout);
        panel1.setLayout(layout);
        JPanel panel2 = new JPanel();
        JPanel fights = new JPanel();
        
        GridLayout layout1 = new GridLayout(1,2, 10, 50);
        
        fights.setLayout(layout1);
        
        ImageIcon Img = new ImageIcon("images/enemy.png");
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(Img);
		
		ImageIcon Img1 = new ImageIcon("images/hero.png");
		JLabel lblNewLabel1 = new JLabel();
		lblNewLabel1.setIcon(Img1);
		
		
		fights.add(lblNewLabel1);
		fights.add(lblNewLabel);
		
		
		panel2.add(fights);
		
        panel1.add(panel2);
        panel1.add(potionPanel);
        
        
        JPanel panel = new JPanel();
		JButton fight = new JButton("Fight");
		fight.setPreferredSize(new Dimension(200, 60));
		JButton item = new JButton("Item");
		item.setPreferredSize(new Dimension(200, 60));
		JButton skill = new JButton("Skill");
		skill.setPreferredSize(new Dimension(200, 60));
        JButton chara = new JButton("Char");
        chara.setPreferredSize(new Dimension(200, 60));
        
        GridLayout grdLayout = new GridLayout(1, 4, 50, 50);
        
        panel.setLayout(grdLayout);
        
        panel.add(fight);
        panel.add(item);
        panel.add(skill);
        panel.add(chara);
        
        fight.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					youAttack(fighter, fighted);
    				}
    			}
    		);
        
        item.addActionListener(
        	       new ActionListener() {
        	        @Override
        	        public void actionPerformed(ActionEvent event) {
        	        	cardlayt.show(potionPanel, "potion");
        	        }
        	    }
        	);
        
        skill.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					cardlayt.show(potionPanel, "skill");
    				}
    			}
    		);
        
        chara.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					cardlayt.show(potionPanel, "chara");
    				}
    			}
    		);
        
        setLayout(new BorderLayout());     
        
		this.add(BorderLayout.SOUTH, panel);
		this.add(BorderLayout.NORTH, tb);
		this.add(BorderLayout.CENTER, panel1);
		panel.setPreferredSize(new Dimension(500, 80));
		tb.setPreferredSize(new Dimension(300, 60));
	}
	
	//----------------------BATTLE RELATED----------------------//
	
	public void monsterAttack(Monster attacker, Character attacked) {
		if (num>5) {
			ta.setText("");
			num=0;
		}
		
		StyledDocument doc = ta.getStyledDocument();
		
		if(attacker.dodgeChance(attacked)) {
			float damage = attacker.attack(attacked);
			attacked.damaged(damage);
			try {
				doc.insertString(doc.getLength(), "· You received " + damage + " damage from "+attacker.name+".\n", null);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else {
			try {
				doc.insertString(doc.getLength(), "· You dodged.\n", null);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		num++;
		tb.setText("<html><h3>~~~~~~~~~~~HP:"+fighter.currHP+"/"+fighter.healthPoint+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~HP: "+fighted.currHP+"/"+fighted.healthPoint+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>~~~~~~~~~~~MP:"+fighter.currMana+"/"+fighter.mana+"</h3></html>");
		if (attacked.isDead()) {
			someoneDead(attacker, attacked);
		}
	}
	
	public void youAttack(Character attacker, Monster attacked) {
		cardlayt.show(potionPanel, "text");
		if (num>5) {
			ta.setText("");
			num=0;
		}
		
		StyledDocument doc = ta.getStyledDocument();
		
		if(attacker.dodgeChance(attacked)) {
			float damage = attacker.attack(attacked);
			attacked.damaged(damage);
			try {
				doc.insertString(doc.getLength(), "· You dealt " + damage + " damage to "+attacked.name+".\n", null);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else {
			try {
				doc.insertString(doc.getLength(), "· You missed.\n", null);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		num++;
		tb.setText("<html><h3>~~~~~~~~~~~HP:"+fighter.currHP+"/"+fighter.healthPoint+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~HP: "+fighted.currHP+"/"+fighted.healthPoint+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>~~~~~~~~~~~MP:"+fighter.currMana+"/"+fighter.mana+"</h3></html>");
	
		
		if (attacked.isDead()) {
			someoneDead(attacker, attacked);
		}
		
		else {
			enemyTurn(fighted);
		}
		addCharaLabel(charaPanel);
	}
	
	public void someoneDead(Creature living, Creature dead) {
		if (dead instanceof Character) {
			JFrame frame = new JFrame("Sorry");
			JLabel label = new JLabel("<html><center><p style style=\"background-color:red; color: blue;\"> YOU DIED LOSER </p>");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			JOptionPane.showMessageDialog(frame, label, "Sorry man", JOptionPane.PLAIN_MESSAGE);
			Main.frame.dispose();
			
		}
		else if (dead instanceof Monster) {
			String reward;
			Random rand = new Random();
			int int_random = rand.nextInt(100)+100; 
			fighter.gold += int_random;
			
			reward = "· "+int_random+" gold<br>";
			int chance = rand.nextInt(10);
			if(chance<=1) {
				int chances = rand.nextInt(5)+10;
				fighter.healHealth(fighter.healthPoint*chances/100);
				reward += "· "+ fighter.healthPoint*chances/100 + " HP healed<br>";
			}
			else if (chance<=3) {
				int chances = rand.nextInt(5)+10;
				fighter.healMana(fighter.mana*chances/100);
				reward += "· "+ fighter.mana*chances/100 + " mana healed<br>";
			}
			else if (chance <=5) {
				int chances = rand.nextInt(6);
				fighter.inventory.add(CessPool.potionz.get(chances));
				reward += "· "+ CessPool.potionz.get(chances).name + "<br>";
			}
			int attPoint = rand.nextInt(1)+2;
			JFrame frame = new JFrame("CONGRATS!");
			reward += "· "+ attPoint + " attribute points<br>";
			fighter.attributeP += attPoint;
			JLabel label = new JLabel("<html><center><p style style=\"background-color:powderblue; color: blue;\">YOU WON!!!<br> Loot : <br> "+ reward +"</p>");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			JOptionPane.showMessageDialog(frame, label, "CONGRATS!!", JOptionPane.PLAIN_MESSAGE);
			fighter.buffs.clear();
			fighted.buffs.clear();
			Main.frame.setContentPane(new Map(frame));
			Main.frame.pack();
		}
	}

	public void enemyTurn(Monster turn) {
		monsterAttack(fighted, fighter);
		fighter.decreaseDuration();
		fighted.decreaseDuration();

	}
	
	//----------------------POTION AND SKILLS PANEL METHODS----------------------//
	
	private JPanel createPotionPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel buttonPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        addPotionButtons(buttonPanel);

        panel.add(buttonPanel, BorderLayout.CENTER);
        
        panel.setBackground(Color.LIGHT_GRAY);

        return panel;
    }

    private void addPotionButtons(JPanel panel) {
        panel.removeAll();
        
        for (Inventory potion : CessPool.selected.inventory) {
        	if (potion instanceof Potion) {
	            JButton button = new JButton(potion.name);
	            button.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	CessPool.selected.usePotion((Potion)potion);
	                    button.setEnabled(false);
	                    cardlayt.show(potionPanel, "text");
	                    if (num>5) {
	            			ta.setText("");
	            			num=0;
	            		}
	            		StyledDocument doc = ta.getStyledDocument();
	            		try {
	            			doc.insertString(doc.getLength(), "· You used the "+potion.name+"\n", null);
	            		} catch (BadLocationException a) {
	            			// TODO Auto-generated catch block
	            			a.printStackTrace();
	            		}
	            		num++;
	            		
	            		enemyTurn(fighted);
	            		addCharaLabel(charaPanel);
	                }
	            });
	            panel.add(button);
        	}
        }
    }
    
    private JPanel addSkillPanel() {
    	JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        skillButtonPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        skillButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        addSkillButtons(skillButtonPanel);
        
        panel.add(skillButtonPanel, BorderLayout.CENTER);
        
        panel.setBackground(Color.LIGHT_GRAY);

        return panel;
        
    }
    
    private void addSkillButtons(JPanel panel) {
        panel.removeAll();
        
        for (Skill skill : CessPool.selected.skills) {
            JButton button = new JButton(skill.name);
            if(fighter.currMana<skill.manaCost) {
            	button.setEnabled(false);
            }
            button.addActionListener(new ActionListener() {
            	String text;
                @Override
                public void actionPerformed(ActionEvent e) {
                	if(skill instanceof BuffSkill) {
                		((BuffSkill) skill).unleash(fighter);
                		text = "· You used the buff skill "+skill.name+"\n";
                	}
                	else if(skill instanceof DebuffSkill) {
                		((DebuffSkill) skill).unleash(fighted, fighter);
                		text = "· You used the debuff skill "+skill.name+"\n";
                	}
                	else if(skill instanceof AttackSkill) {
                		float damage = ((AttackSkill) skill).unleash(fighter, fighted);
                		text = "· You used the attack skill "+skill.name+" dealing " + damage +" damage\n";
                	}
                    cardlayt.show(potionPanel, "text");
                    if (num>5) {
            			ta.setText("");
            			num=0;
            		}
                    
            		StyledDocument doc = ta.getStyledDocument();
            		
            		try {
            			doc.insertString(doc.getLength(), text, null);
            		} catch (BadLocationException a) {
            			// TODO Auto-generated catch block
            			a.printStackTrace();
            		}
            		num++;
            		enemyTurn(fighted);
            		addSkillButtons(panel);
            		addCharaLabel(charaPanel);
                }
            });
            panel.add(button);
        }
    }
    
    private JPanel addCharaPanel() {
    	JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        charaPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        charaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        addCharaLabel(charaPanel);
        
        panel.add(charaPanel, BorderLayout.CENTER);
        
        panel.setBackground(Color.LIGHT_GRAY);

        return panel;
        
    }
    
    private void addCharaLabel(JPanel panel) {
    	panel.removeAll();
    	
    	JLabel name = new JLabel();
    	name.setText("Name : " + fighter.name);
		name.setFocusable(false);
		name.setBackground(new Color(255, 238, 88));
		name.setForeground(Color.BLACK);
		panel.add(name);
		
		JLabel empt = new JLabel();
		empt.setFocusable(false);
		panel.add(empt);
		
		JLabel empt2 = new JLabel();
		empt2.setFocusable(false);
		panel.add(empt2);
		
		JLabel hp = new JLabel();
    	hp.setText("Max HP : " + fighter.healthPoint);
		hp.setFocusable(false);
		hp.setBackground(new Color(255, 238, 88));
		hp.setForeground(Color.BLACK);
		panel.add(hp);
		
		JLabel acc = new JLabel();
		float intdif = (fighter.showAccuracy() - fighter.accuracy);
		String indif = ""+intdif;
		if (intdif>0) {
			indif = "+"+intdif;
		}
    	acc.setText("Accuracy : " + fighter.accuracy + " (" + indif + ")" );
		acc.setFocusable(false);
		acc.setBackground(new Color(255, 238, 88));
		acc.setForeground(Color.BLACK);
		panel.add(acc);
		
		JLabel weapon = new JLabel();
		if(Objects.isNull(fighter.equippedWeapon)) {
			weapon.setText("No weapon equipped");
		}
		else {
			weapon.setText("Weapon " + fighter.equippedWeapon.name + " equipped");
		}
		weapon.setFocusable(false);
		weapon.setBackground(new Color(255, 238, 88));
		weapon.setForeground(Color.BLACK);
		panel.add(weapon);
		
		JLabel mana = new JLabel();
    	mana.setText("Max Mana : " + fighter.mana);
		mana.setFocusable(false);
		mana.setBackground(new Color(255, 238, 88));
		mana.setForeground(Color.BLACK);
		panel.add(mana);
		
		JLabel spd = new JLabel();
		intdif = (fighter.showSpeed() - fighter.speed);
		indif = ""+intdif;
		if (intdif>0) {
			indif = "+"+intdif;
		}
    	spd.setText("Speed : " + fighter.speed + " (" + indif + ")" );
		spd.setFocusable(false);
		spd.setBackground(new Color(255, 238, 88));
		spd.setForeground(Color.BLACK);
		panel.add(spd);
		
		JLabel armor = new JLabel();
		if(Objects.isNull(fighter.equippedWeapon)) {
			armor.setText("No armor equipped");
		}
		else {
			armor.setText("Armor " + fighter.equippedArmor.name + " equipped");
		}
		armor.setFocusable(false);
		armor.setBackground(new Color(255, 238, 88));
		armor.setForeground(Color.BLACK);
		panel.add(armor);
		
		JLabel inte = new JLabel();
		intdif = (fighter.showIntelligence() - fighter.intelligence);
		indif = ""+intdif;
		if (intdif>0) {
			indif = "+"+intdif;
		}
    	inte.setText("Intelligence : " + fighter.intelligence + " (" + indif + ")" );
		inte.setFocusable(false);
		inte.setBackground(new Color(255, 238, 88));
		inte.setForeground(Color.BLACK);
		panel.add(inte);
		
		JLabel def = new JLabel();
		intdif = (fighter.showDefence() - fighter.defence);
		indif = ""+intdif;
		if (intdif>0) {
			indif = "+"+intdif;
		}
    	def.setText("Defence : " + fighter.defence + " (" + indif + ")" );
		def.setFocusable(false);
		def.setBackground(new Color(255, 238, 88));
		def.setForeground(Color.BLACK);
		panel.add(def);
		
		JLabel empty = new JLabel();
		def.setFocusable(false);
		panel.add(empty);
		
		JLabel str = new JLabel();
		intdif = (fighter.showStrength() - fighter.strength);
		indif = ""+intdif;
		if (intdif>0) {
			indif = "+"+intdif;
		}
    	str.setText("Strength : " + fighter.strength + " (" + indif + ")" );
		str.setFocusable(false);
		str.setBackground(new Color(255, 238, 88));
		str.setForeground(Color.BLACK);
		panel.add(str);
		
		
		JLabel wei = new JLabel();
    	wei.setText("Weight :" + fighter.weight);
		wei.setFocusable(false);
		wei.setBackground(new Color(255, 238, 88));
		wei.setForeground(Color.BLACK);
		panel.add(wei);
		
		JTextArea buff = new JTextArea();
		buff.setEditable(false);
		buff.setText("Current buffs/debuffs: ");
		for(Buff buffs : fighter.buffs) {
			buff.append("\n"+buffs.type);
		}
		panel.add(buff);
    }
   
}
