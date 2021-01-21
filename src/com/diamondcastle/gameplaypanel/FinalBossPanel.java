package com.diamondcastle.gameplaypanel;

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

import com.diamondcastle.creature.Character;
import com.diamondcastle.creature.Creature;
import com.diamondcastle.cesspool.CessPool;
import com.diamondcastle.creature.Monster;
import com.diamondcastle.inventory.Inventory;
import com.diamondcastle.inventory.Potion;
import com.diamondcastle.main.Main;
import com.diamondcastle.map.Map;
import com.diamondcastle.skill.AttackSkill;
import com.diamondcastle.skill.BuffSkill;
import com.diamondcastle.skill.DebuffSkill;
import com.diamondcastle.skill.Skill;
import com.diamondcastle.skill.Buff;
import com.diamondcastle.video.CardsVideo;
import com.diamondcastle.video.VideoCredit;

public class FinalBossPanel extends JPanel {
	
	Character fighter = CessPool.selected;
	Monster fighted = CessPool.finalboss;
	int num;
	
	private CardLayout cardlayt = new CardLayout();
	private CardLayout cardlayt1 = new CardLayout();
	private JPanel potionPanel = new JPanel(cardlayt);
	private JPanel cards = new JPanel(cardlayt1);
	private JTextPane ta, te, tf;
	JButton fight, item, skill, chara;
	private JPanel skillButtonPanel, potionButtonPanel, charaPanel, tb, tc, td, full;
	CardsVideo c1, c2, c3, c4, c5;
	private BackgroundBattlePanel fights;
	private int apple = 1, sumn = 0, vid = 0;
	
	public FinalBossPanel(JFrame frame) {
		fighter = CessPool.selected;
		fighted = CessPool.finalboss;
		
		full = new JPanel();
		full.setLayout(new BorderLayout());

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
		
		ImageIcon Img1 = new ImageIcon("resource/images/null1.png");
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
        
		Image img = new ImageIcon("resource/button/fight.jpg").getImage();
		fight = new JButton();
		fight.setIcon(new ImageIcon(img));
		
		Image img2 = new ImageIcon("resource/button/item.jpg").getImage();
		item = new JButton("Item");
		item.setIcon(new ImageIcon(img2));
		
		Image img3 = new ImageIcon("resource/button/skill.jpg").getImage();
		skill = new JButton("Skill");
		skill.setIcon(new ImageIcon(img3));
		
		Image img4 = new ImageIcon("resource/button/chara.jpg").getImage();
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
    					fighted = CessPool.finalboss;
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
         
        fights.addButton(fight, item, skill);
        
        setLayout(new BorderLayout());
        
		full.add(BorderLayout.SOUTH, panel);
		full.add(BorderLayout.NORTH, tb);
		full.add(BorderLayout.CENTER, panel1);
		
		panel.setPreferredSize(new Dimension(500, 80));
		tb.setPreferredSize(new Dimension(300, 60));
		fights.startIdleThread();
		
		c1 = new CardsVideo(frame, 0, cards, cardlayt1);
		c2 = new CardsVideo(frame, 1, cards, cardlayt1);
		c3 = new CardsVideo(frame, 2, cards, cardlayt1);
		c4 = new CardsVideo(frame, 3, cards, cardlayt1);
		c5 = new CardsVideo(frame, 4, cards, cardlayt1);
		
		cards.add(full, "full");
		cards.add(c1, "0");
		cards.add(c2, "1");
		cards.add(c3, "2");
		cards.add(c4, "3");
		cards.add(c5, "4");
		
		cardlayt1.show(cards, "full");
		
		this.add(cards);
		
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
				chatz.add(new String("  M. . . S h e ' s  n o t  t h e r e"));
				chatz.add(new String("   .   .   .   .   ."));
				chatz.add(new String("  S h e ' l l  n e v e r  c o m e  b a c k "));
				
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
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fight.setEnabled(true);
				item.setEnabled(true);
				skill.setEnabled(true);
				chara.setEnabled(true);
				ta.setText("");
				
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
		updateBar();
		
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
			Main.frame.dispose();
			
		}
		else if (dead instanceof Monster) {
			fighted.healHealth(300);
			enemyTurn(fighted);
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
				potionButtonPanel.removeAll();
				addCharaLabel(charaPanel);
				addSkillButtons(skillButtonPanel);
				updateBar();
				fight.setEnabled(false);
				item.setEnabled(false);
				skill.setEnabled(false);
				chara.setEnabled(false);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cardlayt1.show(cards, "0");
				c1.startVideoThread();	
				fight.setEnabled(true);
				item.setEnabled(true);
				skill.setEnabled(true);
				chara.setEnabled(true);
			}
		};
		midThread.start();
		fighter.decreaseDuration(ta);
		fighted.decreaseDuration(ta);
		
	}

	public void enemyTurn(Monster turn) {
		fighted = CessPool.finalboss;
		if (fighted.currHP <= 300 && apple ==1) {
			ArrayList<String> chatz = new ArrayList<String>();
			chatz.add(new String(" S T O P  R E S I S T I N G"));
			chatz.add(new String(" I  K N O W  Y O U  D O N ' T  W A N T  T O  L E A V E"));
			chatz.add(new String(" I ' L L  S H O W  Y O U"));
			chatsThread(chatz);
			apple = 0;
			midThread();
		}
		else if (apple ==0) {
			Thread aThread = new Thread() {
				public void run() {
					ArrayList<String> chatz = new ArrayList<String>();
					chatz.add(new String(" T H E  W O R L D  I S  C R U E L "));
					chatz.add(new String(" I T  I S  H O S T I L E  "));
					chatz.add(new String(" T H E  W O R L D  W I L L  N O T  B E  K I N D "));
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
					updateBar();
					while(sumn == 0) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					cardlayt1.show(cards, "1");
					c2.startVideoThread();	
				}
			};
			aThread.start();
		}
		else if (apple ==-1) {
			Thread aThread = new Thread() {
				public void run() {
					ArrayList<String> chatz = new ArrayList<String>();
					chatz.add(new String(" I F  Y O U  L E A V E , Y O U  W I L L  N E V E R  F E E L  H A P P I N E S S "));
					chatz.add(new String(" L I F E  H E R E  W O U L D  B E  P E A C E F U L "));
					chatz.add(new String(" L I F E  H E R E  W I L L  B E  K I N D "));
					chatz.add(new String(" ... a t  l e a s t  w e  c a n  b e  w i t h  s i s  h e r e . "));
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
					updateBar();
					while(sumn == 0) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					cardlayt1.show(cards, "2");
					c3.startVideoThread();	
				}
			};
			aThread.start();
		}
		else if (apple ==-2) {
			Thread aThread = new Thread() {
				public void run() {
					ArrayList<String> chatz = new ArrayList<String>();
					chatz.add(new String(" w h a t ' s  t h e  p o i n t "));
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
					updateBar();
					while(sumn == 0) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					cardlayt1.show(cards, "3");
					c4.startVideoThread();
				}
			};
			aThread.start();
		}
		else if (apple == -3) {
			Thread aThread = new Thread() {
				public void run() {
					ArrayList<String> chatz = new ArrayList<String>();
					chatz.add(new String(" p l e a s e"));
					chatz.add(new String(" i  d o n ' t  w a n t  t o  l e a v e "));
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
					updateBar();
					while(sumn == 0) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					cardlayt1.show(cards, "4");
					c5.startVideoThread();
					fighter.skills.add(new BuffSkill("Wake Up", 0,0, new Buff("Wake Up", "Salvation", 0, 0, 0, 0, 0, 0, 0, 0, "Wake up to the cruel world.")));
					fighter.skills.add(new BuffSkill("Stay", 0,0, new Buff("Stay", "Salvation", 0, 0, 0, 0, 0, 0, 0, 0, "Stay here in this kind world.")));
					addSkillButtons(skillButtonPanel);
				}
			};
			aThread.start();
		}
		else if (apple == -4) {
			
		}
		else {
			monsterAttack(fighted, fighter);
			fighter.decreaseDuration(ta);
			fighted.decreaseDuration(ta);
		}
		addCharaLabel(charaPanel);
		addSkillButtons(skillButtonPanel);
		updateBar();
	}
	
	//----------------------POTION AND SKILLS PANEL METHODS----------------------//
	
	private JPanel createPotionPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        potionButtonPanel = new ButtonPanel(new GridLayout(3, 3, 10, 10), 0);
        potionButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        potionButtonPanel.setBackground(new Color(0, 0, 102));
        
        addPotionButtons(potionButtonPanel);

        panel.add(potionButtonPanel, BorderLayout.CENTER);
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
                    	if(skill.name.equals("Wake Up")) {
                    		Main.frame.setContentPane(new VideoCredit());
                    		Main.frame.pack();
                    	}
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
    
    
    public void chatsThread(ArrayList<String> chatzz) {
    	sumn = 0;
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
				if(apple!=-4) {
					fight.setEnabled(true);
					item.setEnabled(true);
					chara.setEnabled(true);
				}
				skill.setEnabled(true);
				sumn = 1;
			}
    	};
    	chatsThread.start();
    }
    
    void updateBar() {
    	te.setText("<html><div style=\"color: rgb(0, 255, 255);\"><center><h3>HP : "+ fighter.currHP +" / "+ fighter.healthPoint + "</center><br>"
				+"MP :" + fighter.currMana + " / " + fighter.mana + "</h3></div></html>");
		tf.setText("<html><div style=\"color: rgb(0, 255, 255);\"><center><h3>HP : " + fighted.currHP + " / "+ fighted.healthPoint + "</center><br>"
        		+ "MP : " + fighted.currMana + " / " + fighted.mana + "</h3></div></html>");
    }
   
}