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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class SkillPanel extends JPanel{
		public SkillPanel() {
			
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
							+"· Mana Cost : "+ b.manaCost+"</h3> </html>");	
					skill.setBackground(new Color(51, 0, 16));
					skill.setPreferredSize(new Dimension(313,20));
					
					JButton Button = new JButton();
					Button.setText("Use");
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
			    				}
			    			}
			    	);

					a1.add(lblNewLabel, BorderLayout.WEST);
					a1.add(skill, BorderLayout.CENTER);
					a1.add(Button, BorderLayout.EAST);
					this.add(a1);
			}
		}
		
		public SkillPanel(int test) {
			
	        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	        JPanel buttonPanel = new JPanel(new GridLayout(7, 1));
//	        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	        addSkillButtons(buttonPanel);
	        this.add(buttonPanel);
//	        this.add(buttonPanel, BorderLayout.CENTER);
		}
		
		private void addSkillButtons(JPanel panel) {
	        panel.removeAll();
	                
	        for (Skill skill : CessPool.selected.skills) {
	        	JPanel skill_panel = new JPanel();
	        	skill_panel.setLayout(new BorderLayout());
	        	
	        	ImageIcon Img = new ImageIcon(skill.image);
				JLabel lblNewLabel = new JLabel();
				lblNewLabel.setIcon(Img);
				lblNewLabel.setPreferredSize(new Dimension(84,90));
				
				JTextPane desc = new JTextPane();
				desc.setEditable(false);
				desc.setContentType("text/html");
				desc.setText("<html><h3 style=\"color:white;\">· Name :"+ skill.name +"<br>"
						+"· Mana Cost : "+ skill.manaCost+"</h3> </html>");	
				desc.setBackground(new Color(51, 0, 16));
				desc.setPreferredSize(new Dimension(429,20));
	        	
				JButton Button = new JButton();
				Button.setText("Use");
				Button.setFocusable(false);
				Button.setFocusPainted(false);
				Button.setBackground(new Color(61, 61, 92));
    			Button.setPreferredSize(new Dimension(120,20));
	            
	            Button.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	CessPool.selected.skills.remove(skill);
	                	addSkillButtons(panel);
	                }
	            });
	            
	            skill_panel.add(lblNewLabel, BorderLayout.WEST);
                skill_panel.add(desc, BorderLayout.CENTER);
                skill_panel.add(Button, BorderLayout.EAST);
	            panel.add(skill_panel);
	        }
	    }
}
