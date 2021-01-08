package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class SkillPanel extends JPanel{
		public SkillPanel(JFrame frame) {
			
			GridLayout item_sold = new GridLayout(7,1);
			this.setLayout(item_sold);
			this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));				
			
			for(Skill b : CessPool.skillz) {
				
					JPanel a1 = new JPanel();
					a1.setLayout(new BorderLayout());
	
					ImageIcon Img = new ImageIcon(b.image);
					JLabel lblNewLabel = new JLabel();
					lblNewLabel.setIcon(Img);
					lblNewLabel.setPreferredSize(new Dimension(84,87));
					
					JTextPane skill = new JTextPane();
					skill.setEditable(false);
					skill.setContentType("text/html");
					skill.setText("<html><h3 style=\"color:white;\">· Name :"+ b.name +"<br>"
							+"· Price : "+ b.price+"</h3> </html>");	
					skill.setBackground(new Color(51, 0, 16));
					skill.setPreferredSize(new Dimension(313,20));
					
					JButton Button = new JButton();
					if(CessPool.selected.gold >= b.price) {
	    				Button.setText("Buy");
	    				Button.setEnabled(true);
	    			}
	    			else {
	    				Button.setText("No Money");
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
			    					CessPool.selected.gold -= b.price;
			    					Main.frame.setContentPane(new ShopPanel(frame));
			    			        Main.frame.pack();
			    				}
			    			}
			    	);

					a1.add(lblNewLabel, BorderLayout.WEST);
					a1.add(skill, BorderLayout.CENTER);
					a1.add(Button, BorderLayout.EAST);
					this.add(a1);
			}
		}
		
		public SkillPanel(int test, JFrame frame) {
			
	        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	        JPanel buttonPanel = new JPanel(new GridLayout(7, 1));
//	        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

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
				desc.setText("<html><h3 style=\"color:white;\">· Name :"+ skill.name +"<br>"
						+"· Mana Cost : "+ skill.manaCost+"</h3> </html>");	
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
	            
	                	Main.frame.setContentPane(new BagPanel(frame));
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
