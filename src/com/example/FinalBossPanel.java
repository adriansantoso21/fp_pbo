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

public class FinalBossPanel extends JPanel {
	
	Character fighter = CessPool.selected;
	Monster fighted;
	int num;
	
	private CardLayout cardlayt = new CardLayout();
	private JPanel potionPanel = new JPanel(cardlayt);
	private JTextPane ta, te, tf;
	JButton fight, item, skill, chara;
	private JPanel skillButtonPanel, charaPanel, tb, tc, td;
	private BackgroundBattlePanel fights;
	private int apple = 1, sumn = 0;
	
	public FinalBossPanel(JFrame frame) {

		fighted = new Monster("I Don't Want to Go Back", 1200, 100, 50, 50, 50, 50, 50, 50);
		
		num=0;
        
		this.setBackground(new Color(204, 153, 0));
		
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
        
        GridLayout layout1 = new GridLayout(1,2, 10, 1000);
        
        fights.setLayout(layout1);
        
        ImageIcon Img = new ImageIcon(fighted.image);
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(Img);
		
		ImageIcon Img1 = new ImageIcon("images/null1.png");
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
		
		Thread startChatThread = new Thread() {
			public void run() {
				fight.setEnabled(false);
				item.setEnabled(false);
				skill.setEnabled(false);
				chara.setEnabled(false);
				ArrayList<String> chatz = new ArrayList<String>();
				chatz.add(new String("  D o  y o u  h a v e  t o  g o  b a c k ? ? ?"));
				chatz.add(new String("  I s n ' t  t h i s  p l a c e  a  l o t  b e t t e r ?"));
				chatz.add(new String("   .   .   .   .   ."));
				chatz.add(new String("  Y o u  d o n ' t  w a n t  t o  s t a y ?"));
				chatz.add(new String("   .   .   .   .   ."));
				chatz.add(new String("  T H E N  I ' L L  M A K E  S U R E  Y O U  D O N ' T"));
				
				for(String chats : chatz) {
					for (int i = 0; i < chats.length(); i++){
					    String c = String.valueOf(chats.charAt(i));        
					    StyledDocument doc = ta.getStyledDocument();
					    try {
							doc.insertString(doc.getLength(), c, null);
						} catch (BadLocationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    try {
							Thread.sleep(20);
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
				}
				fight.setEnabled(true);
				item.setEnabled(true);
				skill.setEnabled(true);
				chara.setEnabled(true);
				
			}
		};
		startChatThread.start();
		
		
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
					doc.insertString(doc.getLength(), "� "+crit+"You received " + damage + " damage from "+attacker.name+".\n", null);
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
			
			else {
				try {
					doc.insertString(doc.getLength(), "� You dodged.\n", null);
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			num++;
			te.setText("<html><div style=\"color: rgb(0, 255, 255);\"><center><h3>HP : "+ fighter.currHP +" / "+ fighter.healthPoint + "</center><br>"
					+"MP :" + fighter.currMana + " / " + fighter.mana + "</h3></div></html>");
			tf.setText("<html><div style=\"color: rgb(0, 255, 255);\"><center><h3>HP : " + fighted.currHP + " / "+ fighted.healthPoint + "</center><br>"
	        		+ "MP : " + fighter.currMana + " / " + fighter.mana + "</h3></div></html>");
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
				doc.insertString(doc.getLength(), "� "+crit+"You dealt " + damage + " damage to "+attacked.name+".\n", null);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else {
			try {
				doc.insertString(doc.getLength(), "� You missed.\n", null);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		num++;
		te.setText("<html><div style=\"color: rgb(0, 255, 255);\"><center><h3>HP : "+ fighter.currHP +" / "+ fighter.healthPoint + "</center><br>"
				+"MP :" + fighter.currMana + " / " + fighter.mana + "</h3></div></html>");
		tf.setText("<html><div style=\"color: rgb(0, 255, 255);\"><center><h3>HP : " + fighted.currHP + " / "+ fighted.healthPoint + "</center><br>"
        		+ "MP : " + fighter.currMana + " / " + fighter.mana + "</h3></div></html>");
		
		addCharaLabel(charaPanel);
		addSkillButtons(skillButtonPanel);
		if (attacked.isDead()) {
			someoneDead(attacker, attacked);
		}
		
		else {
			enemyTurn(fighted);
		}
			}
		};
		youAttackThread.start();
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
			Main.frame.setContentPane(new Map(null));
			Main.frame.pack();
		}
	}
	
	public void midThread() {
		Thread midThread = new Thread() {
			public void run() {
				while(sumn == 0) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				StyledDocument doc = ta.getStyledDocument();
				try {
					doc.insertString(doc.getLength(), "� YOU?? casted the debuff skill 'Don't Leave' on you : All your stats are limited to 5\n", null);
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fighter.healthPoint = 5;
				fighter.currHP = 5;
				fighter.currMana = 5;
				fighter.mana = 5;
				fighter.intelligence = 5;
				fighter.strength = 5;
				fighter.accuracy = 5;
				fighter.speed = 5;
				fighter.defence = 5;
				if(!Objects.isNull(fighter.equippedArmor)) {
					fighter.unequipArmor(fighter.equippedArmor);
				}
				if(!Objects.isNull(fighter.equippedWeapon)) {
					fighter.unequipWeapon(fighter.equippedWeapon);
				}
				fighter.skills.clear();
				fighter.inventory.clear();
			}
		};
		midThread.start();
		fighter.decreaseDuration(ta);
		fighted.decreaseDuration(ta);
	}

	public void enemyTurn(Monster turn) {
		if (fighted.currHP <= 600 && apple ==1) {
			ArrayList<String> chatz = new ArrayList<String>();
			chatz.add(new String(" S T O P  R E S I S T I N G"));
			chatz.add(new String(" I  K N O W  Y O U  D O N ' T  W A N T  T O  L E A V E"));
			chatz.add(new String(" I ' L L  S H O W  Y O U"));
			chatsThread(chatz);
			apple = 0;
			midThread();
		}
		else if (apple ==0) {
			ArrayList<String> chatz = new ArrayList<String>();
			chatz.add(new String(" THE WORLD IS CRUEL"));
			chatz.add(new String(" IT IS HOSTILE"));
			chatz.add(new String(" THE WORLD WILL NOT BE KIND"));
			chatsThread(chatz);
			apple = -1;
			StyledDocument doc = ta.getStyledDocument();
			fighter.damaged(1);
			try {
				doc.insertString(doc.getLength(), "� You received 1 damage from "+fighted.name+".\n", null);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (apple ==-1) {
			ArrayList<String> chatz = new ArrayList<String>();
			chatz.add(new String(" IF YOU LEAVE, YOU WILL NEVER FEEL HAPPINESS"));
			chatz.add(new String(" LIFE HERE WOULD BE PEACEFUL"));
			chatz.add(new String(" LIFE HERE WILL BE KIND"));
			chatsThread(chatz);
			apple = -2;
			StyledDocument doc = ta.getStyledDocument();
			fighter.damaged(1);
			try {
				doc.insertString(doc.getLength(), "� You received 1 damage from "+fighted.name+".\n", null);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (apple ==-2) {
			ArrayList<String> chatz = new ArrayList<String>();
			chatz.add(new String(" S  T  A  Y  "));
			chatz.add(new String(" .  .  .  .  .  .  ."));
			chatz.add(new String(" please"));
			chatz.add(new String(" i don't want to leave"));
			chatsThread(chatz);
			apple = -3;
			StyledDocument doc = ta.getStyledDocument();
			fighter.damaged(1);
			try {
				doc.insertString(doc.getLength(), "� You received 1 damage from "+fighted.name+".\n", null);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (apple == -3) {
			ArrayList<String> chatz = new ArrayList<String>();
			chatz.add(new String(" just succumb to the bliss"));
			chatsThread(chatz);
			apple = -4;
			StyledDocument doc = ta.getStyledDocument();
			fighter.damaged(1);
			try {
				doc.insertString(doc.getLength(), "� You received 1 damage from "+fighted.name+".\n", null);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fight.setEnabled(false);
			item.setEnabled(false);
			chara.setEnabled(false);
			fighter.skills.add(new BuffSkill("Wake up", 0,0, new Buff("Wake up", "Salvation", 0, 0, 0, 0, 0, 0, 0, 0, "Wake up to the cruel world.")));
			fighter.skills.add(new BuffSkill("Wake up", 0,0, new Buff("Stay", "Salvation", 0, 0, 0, 0, 0, 0, 0, 0, "Stay here in this kind world.")));
		}
		else {
			monsterAttack(fighted, fighter);
			fighter.decreaseDuration(ta);
			fighted.decreaseDuration(ta);
		}
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
		            			doc.insertString(doc.getLength(), "� You used the "+potion.name+"\n", null);
		            		} catch (BadLocationException a) {
		            			// TODO Auto-generated catch block
		            			a.printStackTrace();
		            		}
		            		num++;
		            		
		            		enemyTurn(fighted);
		            		addCharaLabel(charaPanel);
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
                        System.out.println("Exit Button Clicked.");
                        if(skill instanceof BuffSkill) {
                    		((BuffSkill) skill).unleash(fighter);
                    		text = "� You used the buff skill "+skill.name+", "+desc+"\n";
                    	}
                    	else if(skill instanceof DebuffSkill) {
                    		((DebuffSkill) skill).unleash(fighted, fighter);
                    		text = "� You used the debuff skill "+skill.name+", "+desc+"\n";
                    	}
                    	else if(skill instanceof AttackSkill) {
                    		float damage = ((AttackSkill) skill).unleash(fighter, fighted);
                    		text = "� You used the attack skill "+skill.name+" dealing " + damage +" damage\n";
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
    
    
    public void chatsThread(ArrayList<String> chatzz) {
    	Thread chatsThread = new Thread() {
			public void run() {
				fight.setEnabled(false);
				item.setEnabled(false);
				skill.setEnabled(false);
				chara.setEnabled(false);
				ta.setText("<html><h2 style=\"color:white;\">");
				for(String chats : chatzz) {
					for (int i = 0; i < chats.length(); i++){
					    String c = String.valueOf(chats.charAt(i));        
					    StyledDocument doc = ta.getStyledDocument();
					    try {
							doc.insertString(doc.getLength(), c, null);
						} catch (BadLocationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    try {
							Thread.sleep(20);
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
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ta.setText("");
				fight.setEnabled(true);
				item.setEnabled(true);
				skill.setEnabled(true);
				chara.setEnabled(true);
				sumn = 1;
				monsterAttack(fighted, fighter);
			}
    	};
    	chatsThread.start();
    }
   
}