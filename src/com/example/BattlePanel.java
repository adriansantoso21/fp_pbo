package com.example;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
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
	Monster fighted;
	int num, sumn;
	
	private CardLayout cardlayt = new CardLayout();
	private JPanel potionPanel = new JPanel(cardlayt);
	private JTextPane ta, te, tf;
	private JPanel skillButtonPanel, charaPanel, tb, tc, td;
	JButton fight, item, skill, chara;
	private BackgroundBattlePanel fights;
	
	public BattlePanel(JFrame frame) {
		
		Map.music2.musicLoop();
		Random rand = new Random();
		int a = rand.nextInt(CessPool.monsterz.size());
		fighted = CessPool.monsterz.get(a);
		
		fighted.healHP();
		num=0;
        
		this.setBackground(new Color(204, 153, 0));
		
        ta = new JTextPane();
        ta.setEditable(false);
        ta.setContentType("text/html");
        ta.setText("<html><h3 style=\"color:white;\">");
        
        ta.setBackground(Color.black);
        potionPanel.add(ta, "text");
        potionPanel.add(createPotionPanel(), "potion");
        potionPanel.add(addSkillPanel(), "skill");
        potionPanel.add(addCharaPanel(), "chara");
        cardlayt.show(potionPanel, "text");
        
        tb = new ButtonPanel(new GridLayout(1,2), 3);
        
        te = new JTextPane();
        te.setEditable(false);
        te.setContentType("text/html");
        te.setOpaque(false);
        te.setFont(new Font("Verdana", Font.BOLD, 13));
        te.setText("<html><div style=\"color: rgb(0, 255, 255);\"><center><h3>HP : "+ fighter.currHP +" / "+ fighter.healthPoint + "</center><br>"
        					+"MP :" + fighter.currMana + " / " + fighter.mana + "</h3></div></html>");
        
        tf = new JTextPane();
        tf.setEditable(false);
        tf.setContentType("text/html");
        tf.setForeground(new Color(0, 255, 255));
        tf.setFont(new Font("Verdana", Font.BOLD, 13));
        tf.setOpaque(false);
        tf.setText("<html><div style=\"color: rgb(0, 255, 255);\"><center><h3>HP : " + fighted.currHP + " / "+ fighted.healthPoint + "</center><br>"
        		+ "MP : " + fighter.currMana + " / " + fighter.mana + "</h3></div></html>");
        
        tb.add(te);
        tb.add(tf);
        
        GridLayout layout = new GridLayout(2, 1);
        
        JPanel panel1 = new JPanel(layout);
        panel1.setLayout(layout);
        JPanel panel2 = new JPanel();
        fights = new BackgroundBattlePanel(fighter);
        
        GridLayout layout1 = new GridLayout(1,2, 10, 50);
        
        fights.setLayout(layout1);
        
        ImageIcon Img = new ImageIcon(fighted.image);
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(Img);
		
		ImageIcon Img1 = new ImageIcon("images/null.png");
		JLabel lblNewLabel1 = new JLabel();
		lblNewLabel1.setIcon(Img1);
		
		
		fights.add(lblNewLabel1);
		fights.add(lblNewLabel);
		
		panel2.add(fights);
		panel2.setBackground(Color.black);
		
        panel1.add(panel2);
        panel1.add(potionPanel);
		panel1.setBackground(Color.black);
        

        JPanel panel = new JPanel();
        
		Image img = new ImageIcon("button/fight.jpg").getImage();
		fight = new JButton();
		fight.setIcon(new ImageIcon(img));
		
		Image img2 = new ImageIcon("button/item.jpg").getImage();
		item = new JButton("Item");
		item.setIcon(new ImageIcon(img2));
		
		Image img3 = new ImageIcon("button/skill.jpg").getImage();
		skill = new JButton("Skill");
		skill.setIcon(new ImageIcon(img3));
		
		Image img4 = new ImageIcon("button/chara.jpg").getImage();
        chara = new JButton("Char");
        chara.setIcon(new ImageIcon(img4));
        
        GridLayout grdLayout = new GridLayout(1, 4, 50, 50);
        
        panel.setLayout(grdLayout);
        
        panel.add(fight);
        panel.add(item);
        panel.add(skill);
        panel.add(chara);
        panel.setBackground(new Color(0, 0, 77));
        
        fight.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					fights.startAttackThread();
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
        fights.addButton(fight, item, skill);
        
		this.add(BorderLayout.SOUTH, panel);
		this.add(BorderLayout.NORTH, tb);
		this.add(BorderLayout.CENTER, panel1);
		panel.setPreferredSize(new Dimension(500, 80));
		tb.setPreferredSize(new Dimension(300, 60));
		fights.startIdleThread();
		
	}
	
	//----------------------BATTLE RELATED----------------------//
	
	public void monsterAttack(Monster attacker, Character attacked) {
		
		Thread monsterAttackThread = new Thread() {
			public void run() {
				
				while(fights.getCurrent()!=0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
			StyledDocument doc = ta.getStyledDocument();
			
			if(attacker.dodgeChance(attacked)) {
				String crit = "";
				float damage = attacker.attack(attacked);
				if (attacker.crit()) {
					crit = "Critical Damage! ";
					damage *= 2;
				}
				attacked.damaged(damage);
				try {
					doc.insertString(doc.getLength(), "· "+crit+"You received " + damage + " damage from "+attacker.name+".\n", null);
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
			updateBar();
			if (attacked.isDead()) {
				someoneDead(attacker, attacked);
			}
			}
		};
		monsterAttackThread.start();
	}
	
	public void youAttack(Character attacker, Monster attacked) {
		cardlayt.show(potionPanel, "text");
		if (num>3) {
			ta.setText("");
			num=0;
		}
		
		Thread youAttackThread = new Thread() {
			public void run() {
				
				while(fights.getCurrent()!=0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
		StyledDocument doc = ta.getStyledDocument();

		
		if(attacker.dodgeChance(attacked)) {
			String crit = "";
			float damage = attacker.attack(attacked);
			if (attacker.crit()) {
				crit = "Critical Damage! ";
				damage *= 2;
			}
			attacked.damaged(damage);
			try {
				doc.insertString(doc.getLength(), "· "+crit+"You dealt " + damage + " damage to "+attacked.name+".\n", null);
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
		updateBar();
		
		if (attacked.isDead()) {
			someoneDead(attacker, attacked);
		}
		
		else {
			enemyTurn(fighted);
		}
		addCharaLabel(charaPanel);
			}
		};
		youAttackThread.start();
	}
	
	public void monsterSkill(Skill skill) {
		String desc, text = "";
    	if(skill instanceof AttackSkill) {
			AttackSkill c = (AttackSkill) skill;
			desc = c.desc;
			
		}
		else if (skill instanceof BuffSkill){
			BuffSkill d = (BuffSkill) skill;
			desc = d.buff.desc;
		}
		else {
			DebuffSkill ee = (DebuffSkill) skill;
			desc = ee.debuff.desc;
		}
            if(skill instanceof BuffSkill) {
        		((BuffSkill) skill).unleash(fighted);
        		text = "· "+fighted.name+" used the buff skill "+skill.name+", "+desc+"\n";
        	}
        	else if(skill instanceof DebuffSkill) {
        		((DebuffSkill) skill).unleash(fighter, fighted);
        		text = "· "+fighted.name+" used the debuff skill "+skill.name+", "+desc+"\n";
        	}
        	else if(skill instanceof AttackSkill) {
        		float damage = ((AttackSkill) skill).unleash(fighted, fighter);
        		text = "· "+fighted.name+" used the attack skill "+skill.name+" dealing " + damage +" damage\n";
        	}
            cardlayt.show(potionPanel, "text");
            
    		StyledDocument doc = ta.getStyledDocument();
    		
    		try {
    			doc.insertString(doc.getLength(), text, null);
    		} catch (BadLocationException a) {
    			// TODO Auto-generated catch block
    			a.printStackTrace();
    		}
    		
    		updateBar();
    		num++;
	}
	
	public void someoneDead(Creature living, Creature dead) {
		if (dead instanceof Character) {
			JFrame frame = new JFrame("Sorry");
			JLabel label = new JLabel("<html><center><p style style=\"background-color:red; color: blue;\"> YOU DIED LOSER </p>");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			JOptionPane.showMessageDialog(frame, label, "Sorry man", JOptionPane.PLAIN_MESSAGE);
			Map.music2.stopMusic();
			Main.frame.dispose();
			
		}
		else if (dead instanceof Monster) {
			Thread winThread = new Thread() {
				public void run() {
					chatsThread(CessPool.endingz.get(showChat()));
					while(sumn==0) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
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
					else if (chance <=5 && fighter.potionA < 7) {
						int chances = rand.nextInt(6);
						fighter.inventory.add(CessPool.potionz.get(chances));
						reward += "· "+ CessPool.potionz.get(chances).name + "<br>";
						fighter.potionA += 1;
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
					
					fights.setCurrent(10);
					Map.music2.stopMusic();
					Main.frame.setContentPane(new Map(frame));
					Main.frame.pack();	
				}
			};
			winThread.start();
		}
	}

	public void enemyTurn(Monster turn) {
		Random ski = new Random();
		int randomness = ski.nextInt(101);
		if(randomness < fighted.skillChance) {
			int testo = 1;
			ArrayList<Skill> usable = new ArrayList<Skill>();
			for (Skill check : fighted.skills) {
				if (fighted.currMana>check.manaCost) {
					testo = 0;
					usable.add(check);
				}
			}
			if(testo == 0) {
				Collections.shuffle(usable);
				monsterSkill(usable.get(0));
			}
			else {
				monsterAttack(fighted, fighter);
			}
		}
		else {
			monsterAttack(fighted, fighter);
		}
		fighter.decreaseDuration(ta);
		fighted.decreaseDuration(ta);
	}
	
	//----------------------POTION AND SKILLS PANEL METHODS----------------------//
	
	private JPanel createPotionPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        ButtonPanel buttonPanel = new ButtonPanel(new GridLayout(3, 3, 10, 10), 0);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(new Color(0, 0, 102));
        
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
	            button.setBackground(new Color(0, 51, 51));
	            button.setForeground(new Color(77, 255, 255));
	            button.setFont(new Font("Verdana", Font.BOLD, 15));
	            button.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	int choice = JOptionPane.YES_OPTION;
	                	Potion aa = (Potion) potion;
	                    choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to use this skill : " + aa.buff.desc,
	                                    "Confirmation", JOptionPane.YES_NO_OPTION);

	                    if (choice == JOptionPane.YES_OPTION) {
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
		            		updateBar();
		            		fights.startSpellThread();
		                    }
	                }
	            });
	            panel.add(button);
        	}
        }
    }
    
    private JPanel addSkillPanel() {
    	JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        skillButtonPanel = new ButtonPanel(new GridLayout(3, 3, 10, 10), 0);
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
            button.setBackground(new Color(51, 0, 51));
            button.setForeground(new Color(255, 128, 255));
            button.setFont(new Font("Verdana", Font.BOLD, 15));
            if(fighter.currMana<skill.manaCost) {
            	button.setEnabled(false);
            }
            button.addActionListener(new ActionListener() {
            	String text;
                @Override
                public void actionPerformed(ActionEvent e) {
                	String desc;
                	if(skill instanceof AttackSkill) {
						AttackSkill c = (AttackSkill) skill;
						desc = c.desc;
						
					}
					else if (skill instanceof BuffSkill){
						BuffSkill d = (BuffSkill) skill;
						desc = d.buff.desc;
					}
					else {
						DebuffSkill ee = (DebuffSkill) skill;
						desc = ee.debuff.desc;
					}
                	int choice = JOptionPane.YES_OPTION;
                    choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to use this skill : " + desc,
                                    "Confirmation", JOptionPane.YES_NO_OPTION);

                    if (choice == JOptionPane.YES_OPTION) {
                        if(skill instanceof BuffSkill) {
                    		((BuffSkill) skill).unleash(fighter);
                    		text = "· You used the buff skill "+skill.name+", "+desc+"\n";
                    	}
                    	else if(skill instanceof DebuffSkill) {
                    		((DebuffSkill) skill).unleash(fighted, fighter);
                    		text = "· You used the debuff skill "+skill.name+", "+desc+"\n";
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
                		updateBar();
                		fights.startSpellThread();
                    }
                    
                }
            });
            panel.add(button);
        }
    }
    
    private JPanel addCharaPanel() {
    	JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        charaPanel = new ButtonPanel(new GridLayout(5, 4, 5, 5), 1);
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
		name.setFont(new Font("Verdana", Font.BOLD, 13));
//		name.setBackground(new Color(0, 0, 102));
		name.setForeground(new Color(26, 163, 255));
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
		hp.setForeground(new Color(26, 163, 255));
		hp.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.add(hp);
		
		JLabel acc = new JLabel();
		float intdif = (fighter.showAccuracy() - fighter.accuracy);
		String indif = ""+intdif;
		if (intdif>0) {
			indif = "+"+intdif;
		}
    	acc.setText("Accuracy : " + fighter.accuracy + " (" + indif + ")" );
		acc.setFocusable(false);
//		acc.setBackground(new Color(26, 163, 255));
		acc.setForeground(new Color(26, 163, 255));
		acc.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.add(acc);
		
		JLabel weapon = new JLabel();
		if(Objects.isNull(fighter.equippedWeapon)) {
			weapon.setText("No weapon equipped");
		}
		else {
			weapon.setText("Weapon " + fighter.equippedWeapon.name + " equipped");
		}
		weapon.setFocusable(false);
//		weapon.setBackground(new Color(26, 163, 255));
		weapon.setForeground(new Color(26, 163, 255));
		weapon.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.add(weapon);
		
		JLabel mana = new JLabel();
    	mana.setText("Max Mana : " + fighter.mana);
		mana.setFocusable(false);
//		mana.setBackground(new Color(26, 163, 255));
		mana.setForeground(new Color(26, 163, 255));
		mana.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.add(mana);
		
		JLabel spd = new JLabel();
		intdif = (fighter.showSpeed() - fighter.speed);
		indif = ""+intdif;
		if (intdif>0) {
			indif = "+"+intdif;
		}
    	spd.setText("Speed : " + fighter.speed + " (" + indif + ")" );
		spd.setFocusable(false);
//		spd.setBackground(new Color(26, 163, 255));
		spd.setForeground(new Color(26, 163, 255));
		spd.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.add(spd);
		
		JLabel armor = new JLabel();
		if(Objects.isNull(fighter.equippedArmor)) {
			armor.setText("No armor equipped");
		}
		else {
			armor.setText("Armor " + fighter.equippedArmor.name + " equipped");
		}
		armor.setFocusable(false);
//		armor.setBackground(new Color(26, 163, 255));
		armor.setForeground(new Color(26, 163, 255));
		armor.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.add(armor);
		
		JLabel inte = new JLabel();
		intdif = (fighter.showIntelligence() - fighter.intelligence);
		indif = ""+intdif;
		if (intdif>0) {
			indif = "+"+intdif;
		}
    	inte.setText("Intelligence : " + fighter.intelligence + " (" + indif + ")" );
		inte.setFocusable(false);
//		inte.setBackground(new Color(26, 163, 255));
		inte.setForeground(new Color(26, 163, 255));
		inte.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.add(inte);
		
		JLabel def = new JLabel();
		intdif = (fighter.showDefence() - fighter.defence);
		indif = ""+intdif;
		if (intdif>0) {
			indif = "+"+intdif;
		}
    	def.setText("Defence : " + fighter.defence + " (" + indif + ")" );
		def.setFocusable(false);
//		def.setBackground(new Color(26, 163, 255));
		def.setFont(new Font("Verdana", Font.BOLD, 13));
		def.setForeground(new Color(26, 163, 255));
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
//		str.setBackground(new Color(26, 163, 255));
		str.setForeground(new Color(26, 163, 255));
		str.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.add(str);
		
		
		JLabel wei = new JLabel();
    	wei.setText("Weight :" + fighter.weight);
		wei.setFocusable(false);
//		wei.setBackground(new Color(26, 163, 255));
		wei.setForeground(new Color(26, 163, 255));
		wei.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.add(wei);
		
		JTextArea buff = new JTextArea();
//		buff.setBackground(new Color(26, 163, 255));
		buff.setForeground(new Color(26, 163, 255));
		buff.setEditable(false);
		buff.setText("Current buffs/debuffs: ");
		for(Buff buffz : fighter.buffs) {
			buff.append("\n"+buffz.name+" ends in "+buffz.duration);
		}
		buff.setFont(new Font("Verdana", Font.BOLD, 13));
		panel.add(buff);
    }
    
    void updateBar() {
    	te.setText("<html><div style=\"color: rgb(0, 255, 255);\"><center><h3>HP : "+ fighter.currHP +" / "+ fighter.healthPoint + "</center><br>"
				+"MP :" + fighter.currMana + " / " + fighter.mana + "</h3></div></html>");
		tf.setText("<html><div style=\"color: rgb(0, 255, 255);\"><center><h3>HP : " + fighted.currHP + " / "+ fighted.healthPoint + "</center><br>"
        		+ "MP : " + fighted.currMana + " / " + fighted.mana + "</h3></div></html>");
    }
    
    public void chatsThread(String chatzz) {
    	Thread chatsThread = new Thread() {
			public void run() {
				fight.setEnabled(false);
				item.setEnabled(false);
				skill.setEnabled(false);
				chara.setEnabled(false);
				ta.setText("<html><h2 style=\"color:white;\">");
					for (int i = 0; i < chatzz.length(); i++){
					    String c = String.valueOf(chatzz.charAt(i));        
					    StyledDocument doc = ta.getStyledDocument();
					    try {
							doc.insertString(doc.getLength(), c, null);
						} catch (BadLocationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    try {
							Thread.sleep(250);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					StyledDocument doc = ta.getStyledDocument();
					try {
						doc.insertString(doc.getLength(), "\n", null);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ta.setText("");
				sumn = 1;
			}
    	};
    	chatsThread.start();
    }
    
    public int showChat() {
    	int a = Map.last;
    	if(Map.last == 0 || Map.last == 1 || Map.last == 2) {
    		return a;
    	}
    	else if (Map.last == 7 || Map.last == 4) {
    		return 3;
    	}
    	else if (Map.last == 5 || Map.last == 8) {
    		return 4;
    	}
    	else if (Map.last == 12) {
    		return 5;
    	}
    	else if (Map.last == 13) {
    		return 6;
    	}
    	else if (Map.last == 16 || Map.last == 18) {
    		return 7;
    	}
    	else if (Map.last == 21) {
    		return 8;
    	}
    	else if (Map.last == 9) {
    		return 9;
    	}
    	else {
    		return 10;
    	}
    }
   
}
