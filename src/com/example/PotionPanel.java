package com.example;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class PotionPanel extends JPanel{

	public PotionPanel() {
		
		GridLayout item_sold = new GridLayout(7,1);
		this.setLayout(item_sold);
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		for(Potion b : CessPool.potionz) {
			JPanel a1 = new JPanel();
			a1.setLayout(new BorderLayout());

			ImageIcon Img = new ImageIcon(b.image);
			JLabel lblNewLabel = new JLabel();
			lblNewLabel.setIcon(Img);
			lblNewLabel.setPreferredSize(new Dimension(84,87));
			
			JTextPane potion = new JTextPane();
			potion.setEditable(false);
			potion.setContentType("text/html");
			potion.setText("<html><h3 style=\"color:white;\">· Name :"+ b.name +"<br></h3> </html>");
//					+"· Defence : "+ b.buff.defence+ "<br>"
//	        		+"· Intelligence : "+ b.buff.intelligence + "<br>"
//	        		+ "· Accuracy : "+ b.buff.accuracy + "<br>"
//	        		+ "· Speed : "+ b.buff.speed + "<br>"
//	        		+ "· Weight : "+b.weight +"</h3> </html>");	
			potion.setBackground(new Color(51, 0, 16));
			potion.setPreferredSize(new Dimension(313,20));
			
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
	    					CessPool.selected.inventory.add((Inventory)b);
	    				}
	    			}
	    	);
			
			a1.add(lblNewLabel, BorderLayout.WEST);
			a1.add(potion, BorderLayout.CENTER);
			a1.add(Button, BorderLayout.EAST);
			this.add(a1);
		}
	}
	
	public PotionPanel(int test) {
		
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JPanel buttonPanel = new JPanel(new GridLayout(7, 1));
//        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));


        addSkillButtons(buttonPanel);
        this.add(buttonPanel);
//        this.add(buttonPanel, BorderLayout.CENTER);
	}
	
	private void addSkillButtons(JPanel panel) {
        panel.removeAll();
                
        for (Inventory potion : CessPool.selected.inventory) {
        	if(potion instanceof Potion) {
        		JPanel skill_panel = new JPanel();
        		skill_panel.setLayout(new BorderLayout());
            	
        		Potion potion1= (Potion) potion;
        		
            	ImageIcon Img = new ImageIcon(potion1.image);
    			JLabel lblNewLabel = new JLabel();
    			lblNewLabel.setIcon(Img);
    			lblNewLabel.setPreferredSize(new Dimension(84,87));
    			
    			JTextPane desc = new JTextPane();
				desc.setEditable(false);
				desc.setContentType("text/html");
				desc.setText("<html><h3 style=\"color:white;\">· Name :"+ potion1.name +"<br></h3> </html>");
//						+"· Defence : "+ potion1.buff.defence+ "<br>"
//		        		+"· Intelligence : "+ potion1.buff.intelligence + "<br>"
//		        		+ "· Accuracy : "+ potion1.buff.accuracy + "<br>"
//		        		+ "· Speed : "+ potion1.buff.speed + "<br>"
//		        		+ "· Weight : "+potion1.weight +"</h3> </html>");	
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
                    	CessPool.selected.usePotion(potion1);
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
}
