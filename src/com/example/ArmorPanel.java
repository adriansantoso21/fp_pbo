package com.example;

import java.awt.BorderLayout;
import java.util.Objects;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class ArmorPanel extends JPanel{

	Image image;
	//For Shop
	public ArmorPanel(JFrame frame) {
		GridLayout item_sold = new GridLayout(4,1);
		this.setLayout(item_sold);
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		for(Armor b : CessPool.armorz) {
				JPanel a1 = new JPanel();
				a1.setLayout(new BorderLayout());
				
				ImageIcon Img = new ImageIcon(b.image);
				JLabel lblNewLabel = new JLabel();
				lblNewLabel.setIcon(Img);
				lblNewLabel.setPreferredSize(new Dimension(213,160));
				
				JTextPane armor = new JTextPane();
				armor.setEditable(false);
				armor.setContentType("text/html");
				armor.setText("<html><h3 style=\"color:white;\">· Name :"+ b.name +"<br>"
						+"· Defence : "+ b.defence+ "<br>"
		        		+"· Intelligence : "+ b.accuracy + "<br>"
		        		+ "· Accuracy : "+ b.healthPoint + "<br>"
		        		+ "· Speed : "+ b.speed + "<br>"
		        		+ "· Weight : "+b.weight + "<br>"
		        		+ "· Price : "+b.price+"</h3> </html>");	
				armor.setBackground(new Color(51, 0, 16));
				armor.setPreferredSize(new Dimension(313,20));
				
				JButton Button = new JButton();
				if(CessPool.selected.gold >= b.price) {
    				Button.setText("Buy");
    				Button.setEnabled(true);
    			}
    			else {
    				Button.setText("No Money");
    				Button.setEnabled(false);
    			}
				
				for(Inventory b1 : CessPool.selected.inventory) {
					if(b1 instanceof Armor) {
						Armor b2 = (Armor)b1;
						if(b2.equals(b)) {
							Button.setText("Sold Out!!");
							Button.setEnabled(false);
						}
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
		    					CessPool.selected.inventory.add((Inventory)b);
		    					CessPool.selected.gold -= b.price;
		    					Main.frame.setContentPane(new ShopPanel(frame, 1));
		    			        Main.frame.pack();
		    				}
		    			}
		    	);
				
				a1.add(lblNewLabel, BorderLayout.WEST);
				a1.add(armor, BorderLayout.CENTER);
				a1.add(Button, BorderLayout.EAST);
				this.add(a1);
		}
	}
	
	//For Bag
	public ArmorPanel(int test, JFrame frame) {
		
		this.setBackground(new Color(0, 26, 0));
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
        buttonPanel.setBackground(new Color(0, 26, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        addSkillButtons(buttonPanel, frame);
        this.add(buttonPanel);
//        this.add(buttonPanel, BorderLayout.CENTER);
	}
	
	private void addSkillButtons(JPanel panel, JFrame frame) {
        panel.removeAll();
                
        for (Inventory armor : CessPool.selected.inventory) {
        	if(armor instanceof Armor) {
        		JPanel skill_panel = new JPanel();
            	skill_panel.setLayout(new BorderLayout());
            	
            	ImageIcon Img = new ImageIcon(((Armor) armor).image);
    			JLabel lblNewLabel = new JLabel();
    			lblNewLabel.setIcon(Img);
    			lblNewLabel.setPreferredSize(new Dimension(213,156));
    			
    			Armor armor1= (Armor) armor;
    			
    			JTextPane desc = new JTextPane();
				desc.setEditable(false);
				desc.setContentType("text/html");
				desc.setText("<html><h3 style=\"color:white;\">· Name :"+ armor1.name +"<br>"
						+"· Defence : "+ armor1.defence+ "<br>"
		        		+"· Intelligence : "+ armor1.accuracy + "<br>"
		        		+ "· Accuracy : "+ armor1.healthPoint + "<br>"
		        		+ "· Speed : "+ armor1.speed + "<br>"
		        		+ "· Weight : "+armor1.weight + "</h3> </html>");	
				desc.setBackground(new Color(51, 0, 16));
				desc.setPreferredSize(new Dimension(313,20));
            	
    			JButton Button = new JButton();
    			if (Objects.isNull(CessPool.selected.equippedArmor)) {
    				Button.setText("Equip");
    				Button.setEnabled(true);
    			}
    			else {
    				Button.setText("Equip");
    				Button.setEnabled(false);
    				Armor ArmorChar2 = CessPool.selected.equippedArmor;
    				if(armor1.equals(ArmorChar2)) {
    					Button.setText("Unequip");
        				Button.setEnabled(true);
    				}
    			}

    			Button.setFocusable(false);
    			Button.setFocusPainted(false);
    			Button.setBackground(new Color(61, 61, 92));
    			Button.setForeground(Color.white);
    			Button.setPreferredSize(new Dimension(120,20));
                
                Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	if(!Objects.isNull(CessPool.selected.equippedArmor) ) {
							Armor ArmorChar = CessPool.selected.equippedArmor;
							CessPool.selected.unequipArmor(ArmorChar);
						}
                    	else {
                    		CessPool.selected.equipArmor(armor1);
                    	}

    					Main.frame.setContentPane(new BagPanel(frame,1));
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

}
