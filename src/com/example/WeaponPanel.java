package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class WeaponPanel extends JPanel{

	public WeaponPanel(JFrame frame) {
		
		GridLayout item_sold = new GridLayout(4,1);
		this.setLayout(item_sold);
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		for(Weapon b : CessPool.weaponz) {
			JPanel a1 = new JPanel();
			a1.setLayout(new BorderLayout());
			
			ImageIcon Img = new ImageIcon(b.image);
			JLabel lblNewLabel = new JLabel();
			lblNewLabel.setIcon(Img);
			lblNewLabel.setPreferredSize(new Dimension(213,160));
			
			JTextPane weapon = new JTextPane();
			weapon.setEditable(false);
			weapon.setContentType("text/html");
			weapon.setText("<html><h3 style=\"color:white;\">· Name :"+ b.name +"<br>"
					+"· Strength : "+ b.strength+ "<br>"
	        		+"· Intelligence : "+ b.accuracy + "<br>"
	        		+ "· Accuracy : "+ b.accuracy + "<br>"
	        		+ "· Speed : "+ b.speed + "<br>"
	        		+ "· Weight : "+b.weight + "<br>" 
	        		+ "· Price : "+b.price +"</h3> </html>");	
			weapon.setBackground(new Color(51, 0, 16));
			weapon.setPreferredSize(new Dimension(313,20));
			
			JButton Button = new JButton();
			if(CessPool.selected.gold >= b.price) {
				Button.setText("Buy");
				Button.setEnabled(true);
			}
			else {
				Button.setText("No Money");
				Button.setEnabled(false);
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
	    					Main.frame.setContentPane(new ShopPanel(frame));
	    					Main.frame.pack();
	    				}
	    			}
	    	);
			
			a1.add(lblNewLabel, BorderLayout.WEST);
			a1.add(weapon, BorderLayout.CENTER);
			a1.add(Button, BorderLayout.EAST);
			this.add(a1);
		}
	}
	
	public WeaponPanel(int test, JFrame frame) {
		
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        addSkillButtons(buttonPanel);

        this.add(buttonPanel);
//        this.add(buttonPanel, BorderLayout.CENTER);
	}
	
	private void addSkillButtons(JPanel panel) {
        panel.removeAll();

        GridLayout sold = new GridLayout(1,3);
                
        for (Inventory weapon : CessPool.selected.inventory) {
        	if(weapon instanceof Weapon) {
        		JPanel skill_panel = new JPanel();
            	skill_panel.setLayout(new BorderLayout());
            	
            	ImageIcon Img = new ImageIcon(((Weapon) weapon).image);
    			JLabel lblNewLabel = new JLabel();
    			lblNewLabel.setIcon(Img);
    			lblNewLabel.setPreferredSize(new Dimension(213,156));
    			
    			Weapon weapon1= (Weapon) weapon;
    			
    			JTextPane desc = new JTextPane();
				desc.setEditable(false);
				desc.setContentType("text/html");
				desc.setText("<html><h3 style=\"color:white;\">· Name :"+ weapon1.name +"<br>"
						+"· Strength : "+ weapon1.strength+ "<br>"
		        		+"· Intelligence : "+ weapon1.accuracy + "<br>"
		        		+ "· Accuracy : "+ weapon1.accuracy + "<br>"
		        		+ "· Speed : "+ weapon1.speed + "<br>"
		        		+ "· Weight : "+weapon1.weight +"</h3> </html>");	
				desc.setBackground(new Color(51, 0, 16));
				desc.setPreferredSize(new Dimension(313,20));
            	
    			JButton Button = new JButton();
    			Button.setText("Use");
    			Button.setFocusable(false);
    			Button.setFocusPainted(false);
    			Button.setBackground(new Color(61, 61, 92));
    			Button.setPreferredSize(new Dimension(120,20));
    			Button.setForeground(Color.white);
                
                Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	if(!Objects.isNull(CessPool.selected.equippedWeapon) ) {
							Weapon WeaponChar = CessPool.selected.equippedWeapon;
							CessPool.selected.unequipWeapon(WeaponChar);
						}
                    	
    					CessPool.selected.equipWeapon(weapon1);
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
