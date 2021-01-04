package com.example;

import java.awt.BorderLayout;
<<<<<<< HEAD
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

=======
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
>>>>>>> ddb312c0513f2ae37f26da060e681f734d4f774e
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
	
	public BattlePanel(JFrame frame) {
		
		fighted.healHP();
		num=0;
		//what if inside the cardlayout, we always call a new itemPane
        
        ta = new JTextPane();
        ta.setEditable(false);
        ta.setContentType("text/html");
        ta.setText("<html><h2 style=\"color:white;\">");
        
        ta.setBackground(Color.black);
        potionPanel.add(ta, "text");
        potionPanel.add(createPotionPanel(), "potion");
        potionPanel.add(addSkillPanel(), "skill");
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
    					youAttack(fighter, fighted, ta, tb);
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
        
        setLayout(new BorderLayout());     
        
		this.add(BorderLayout.SOUTH, panel);
		this.add(BorderLayout.NORTH, tb);
		this.add(BorderLayout.CENTER, panel1);
		panel.setPreferredSize(new Dimension(500, 80));
		tb.setPreferredSize(new Dimension(300, 60));
	}
	
	public void monsterAttack(Monster attacker, Character attacked, JTextPane ta, JTextPane tb) {
		float damage = attacker.attack();
		attacked.damaged(damage);
		if (num>5) {
			ta.setText("");
			num=0;
		}
		StyledDocument doc = ta.getStyledDocument();
		try {
			doc.insertString(doc.getLength(), "� You received " + damage + " damage.\n", null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num++;
		tb.setText("<html><h3>~~~~~~~~~~~HP:"+fighter.currHP+"/"+fighter.healthPoint+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~HP: "+fighted.currHP+"/"+fighted.healthPoint+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>~~~~~~~~~~~MP:"+fighter.currMana+"/"+fighter.mana+"</h3></html>");
		if (attacked.isDead()) {
			someoneDead(attacker, attacked);
		}
	}
	
	public void youAttack(Character attacker, Monster attacked, JTextPane ta, JTextPane tb) {
		cardlayt.show(potionPanel, "text");
		float damage = attacker.attack();
		attacked.damaged(damage);
		if (num>5) {
			ta.setText("");
			num=0;
		}
		StyledDocument doc = ta.getStyledDocument();
		try {
			doc.insertString(doc.getLength(), "� You dealt " + damage + " damage.\n", null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num++;
		tb.setText("<html><h3>~~~~~~~~~~~HP:"+fighter.currHP+"/"+fighter.healthPoint+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~HP: "+fighted.currHP+"/"+fighted.healthPoint+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>~~~~~~~~~~~MP:"+fighter.currMana+"/"+fighter.mana+"</h3></html>");
		if (attacked.isDead()) {
			someoneDead(attacker, attacked);
		}
		
		else {
			enemyTurn(fighted, ta, tb);
		}
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
			JFrame frame = new JFrame("CONGRATS!");
			JLabel label = new JLabel("<html><center><p style style=\"background-color:powderblue; color: blue;\">YOU WON!!!</p>");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			JOptionPane.showMessageDialog(frame, label, "CONGRATS!!", JOptionPane.PLAIN_MESSAGE);
			Main.frame.setContentPane(new Map(frame));
			Main.frame.pack();
		}
	}
	
	public void enemyTurn(Monster turn, JTextPane ta, JTextPane tb) {
		monsterAttack(fighted, fighter, ta, tb);
		System.out.println("Strength: "+fighted.showStrength()+"\n buff: "+fighted.buffs.get(0).strength);
	}
	
	//           POTION AND SKILLS PANEL METHODS                   //
	
	private JPanel createPotionPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel buttonPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        addPotionButtons(buttonPanel);

        panel.add(buttonPanel, BorderLayout.CENTER);

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
	                }
	            });
	            panel.add(button);
        	}
        }
    }
    
    private JPanel addSkillPanel() {
    	
    	JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel buttonPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        addSkillButtons(buttonPanel);
        
        panel.add(buttonPanel, BorderLayout.CENTER);

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
                		text = "� You used the buff skill "+skill.name+"\n";
                	}
                	else if(skill instanceof DebuffSkill) {
                		((DebuffSkill) skill).unleash(fighted, fighter);
                		text = "� You used the debuff skill "+skill.name+"\n";
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
            		enemyTurn(fighted, ta, tb);
            		addSkillButtons(panel);
                }
            });
            panel.add(button);
    }
    }
    
    public class PotionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            JButton button = (JButton) event.getSource();
            int index = Integer.valueOf(button.getActionCommand());
            CessPool.selected.inventory.remove(index);
            button.setEnabled(false);
            cardlayt.show(potionPanel, "text");
        }

    }
}
