package com.diamondcastle.inventorypanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import com.diamondcastle.cesspool.CessPool;
import com.diamondcastle.main.Main;
import com.diamondcastle.skill.AttackSkill;
import com.diamondcastle.skill.BuffSkill;
import com.diamondcastle.skill.DebuffSkill;
import com.diamondcastle.skill.Skill;

public class SkillPanel extends JPanel{
	
	static ArrayList<Skill> sumn;
	
		public SkillPanel(JFrame frame, char hm) {
			
			GridLayout item_sold = new GridLayout(7,1);
			this.setLayout(item_sold);
			this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));				
			int sum = 0;
			
			if(hm == 'y') {
				Collections.shuffle(CessPool.skillz);
				
				sumn = new ArrayList<Skill>();
				
				
				for(Skill a : CessPool.skillz) {
					if(sum>6) {
						break;
					}
					if(CessPool.selected.skills.contains(a)) {
						continue;
					}
					
					sumn.add(a);
					sum++;
				}
			}
			
			for(Skill b : sumn) {
				
					JPanel a1 = new JPanel();
					a1.setLayout(new BorderLayout());
	
					ImageIcon Img = new ImageIcon(b.image);
					JLabel lblNewLabel = new JLabel();
					lblNewLabel.setIcon(Img);
					lblNewLabel.setPreferredSize(new Dimension(84,87));
					
					JTextPane skill = new JTextPane();
					skill.setEditable(false);
					skill.setContentType("text/html");
					if(b instanceof AttackSkill) {
						AttackSkill c = (AttackSkill) b;
						skill.setText("<html><h3 style=\"color:white;\">· Name :"+ b.name +"<br>"
								+"· Desc : "+ c.desc +"<br>"
								+"· Mana Cost : "+ b.manaCost+ " || " + " Price : "+ b.price+"</h3> </html>");	
					}
					else if (b instanceof BuffSkill){
						BuffSkill d = (BuffSkill) b;
						skill.setText("<html><h3 style=\"color:white;\">· Name :"+ b.name +"<br>"
								+"· Desc : "+ d.buff.desc +"<br>"
								+"· Mana Cost : "+ b.manaCost+ " || " +" Price : "+ b.price+"</h3> </html>");
					}
					else {
						DebuffSkill e = (DebuffSkill) b;
						skill.setText("<html><h3 style=\"color:white;\">· Name :"+ b.name +"<br>"
								+"· Price : "+ e.debuff.desc +"<br>"
								+"· Mana Cost : "+ b.manaCost+" || "+" Price : "+ b.price+"</h3> </html>");
					}
					
					skill.setBackground(new Color(51, 0, 16));
					skill.setPreferredSize(new Dimension(313,20));
					
					
					
					JButton Button = new JButton();
					if(CessPool.selected.getGold() >= b.price) {
	    				Button.setText("Buy");
	    				Button.setEnabled(true);
	    			}
	    			else {
	    				Button.setText("No Money");
	    				Button.setEnabled(false);
	    			}
					if(CessPool.selected.skills.size()>6) {
						Button.setText("Mind Full");
	    				Button.setEnabled(false);
					}
					
					for(Skill b1 : CessPool.selected.skills) {
						if(b1.equals(b)) {
							Button.setText("Sold Out!!");
							Button.setEnabled(false);
						}
					}
					
					Button.setFocusable(false);
					Button.setFocusPainted(false);
					Button.setBackground(new Color(61, 61, 92));
					Button.setForeground(Color.WHITE);
					Button.setPreferredSize(new Dimension(120,20));
					
					Button.addActionListener(
			    			new ActionListener() {
			    				@Override
			    				public void actionPerformed(ActionEvent event) {
			    					Button.setEnabled(false);
			    					CessPool.selected.skills.add(b);
			    					CessPool.selected.setGold(CessPool.selected.getGold() - b.price);
			    					Main.frame.setContentPane(new ShopPanel(frame, 4, 'n'));
			    			        Main.frame.pack();
			    				}
			    			}
			    	);

					a1.add(lblNewLabel, BorderLayout.WEST);
					a1.add(skill, BorderLayout.CENTER);
					a1.add(Button, BorderLayout.EAST);
					this.add(a1);
					sum++;
			}
		}
		
		public SkillPanel(int test, JFrame frame) {
			this.setBackground(new Color(0, 26, 0));
	        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	        
	        JPanel buttonPanel = new JPanel(new GridLayout(8, 1));
	        buttonPanel.setBackground(new Color(0, 26, 0));
	        addSkillButtons(buttonPanel, frame);
	        this.add(buttonPanel);
	        this.add(buttonPanel, BorderLayout.CENTER);
		}
		
		private void addSkillButtons(JPanel panel, JFrame frame) {
	        panel.removeAll();
	                
	        for (Skill skill : CessPool.selected.skills) {
	        	JPanel skill_panel = new JPanel();
	        	skill_panel.setLayout(new BorderLayout());
	        	
	        	ImageIcon Img = new ImageIcon(skill.image);
				JLabel lblNewLabel = new JLabel();
				lblNewLabel.setIcon(Img);
				lblNewLabel.setPreferredSize(new Dimension(84,87));
				
				JTextPane desc = new JTextPane();
				desc.setEditable(false);
				desc.setContentType("text/html");
				if(skill instanceof AttackSkill) {
					AttackSkill c = (AttackSkill) skill;
					desc.setText("<html><h3 style=\"color:white;\">· Name :"+ skill.name +"<br>"
							+"· Desc : "+ c.desc +"<br>"
							+"· Mana Cost : "+ skill.manaCost+"</h3> </html>");	
				}
				else if (skill instanceof BuffSkill){
					BuffSkill d = (BuffSkill) skill;
					desc.setText("<html><h3 style=\"color:white;\">· Name :"+ skill.name +"<br>"
							+"· Desc : "+ d.buff.desc +"<br>"
							+"· Mana Cost : "+ skill.manaCost+"</h3> </html>");
				}
				else {
					DebuffSkill e = (DebuffSkill) skill;
					desc.setText("<html><h3 style=\"color:white;\">· Name :"+ skill.name +"<br>"
							+"· Price : "+ e.debuff.desc +"<br>"
							+"· Mana Cost : "+ skill.manaCost+"</h3> </html>");
				}	
				desc.setBackground(new Color(51, 0, 16));
				desc.setPreferredSize(new Dimension(431,20));
	        	
				JButton Button = new JButton();
				Button.setText("Can't use");
			
				Button.setEnabled(false);
				if(skill instanceof BuffSkill) {
    				if(((BuffSkill) skill).buff.currHP > 0 || ((BuffSkill) skill).buff.currMana > 0) {
    					if(CessPool.selected.currMana >= skill.manaCost) {
    						Button.setText("Use");
    						Button.setEnabled(true);
    					}
    					else {
    						Button.setText("No Mana");
    						Button.setEnabled(false);
    					}
    					
    				}
    				else {
    					Button.setText("Can't use");
    					Button.setEnabled(false);
    				}
    			}
				
				Button.setFocusable(false);
				Button.setFocusPainted(false);
				Button.setBackground(new Color(61, 61, 92));
    			Button.setPreferredSize(new Dimension(120,20));
    			Button.setForeground(Color.white);
	            Button.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	if (skill instanceof BuffSkill) {
	                		((BuffSkill) skill).unleash(CessPool.selected);
	                	}
	            
	                	Main.frame.setContentPane(new BagPanel(frame, 4));
	                    Main.frame.pack();
	                }
	            });
	            
	            skill_panel.add(lblNewLabel, BorderLayout.WEST);
                skill_panel.add(desc, BorderLayout.CENTER);
                skill_panel.add(Button, BorderLayout.EAST);
	            panel.add(skill_panel);
	        }
	    }
}
