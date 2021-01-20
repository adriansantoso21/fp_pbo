package com.diamondcastle.inventorypanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import com.diamondcastle.cesspool.CessPool;
import com.diamondcastle.inventory.Inventory;
import com.diamondcastle.inventory.Weapon;
import com.diamondcastle.main.Main;

public class WeaponPanel extends JPanel{
	
	static ArrayList<Weapon> sumn;

	public WeaponPanel(JFrame frame, char hm) {
		
		GridLayout item_sold = new GridLayout(4,1);
		this.setLayout(item_sold);
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		int sum = 0;
		
		if(hm == 'y') {
			Collections.shuffle(CessPool.armorz);
			
			sumn = new ArrayList<Weapon>();
			
			
			for(Weapon a : CessPool.weaponz) {
				if(sum>3) {
					break;
				}
				if(CessPool.selected.inventory.contains(a)) {
					continue;
				}
				
				sumn.add(a);
				sum++;
			}
		}
		
		for(Weapon b : sumn) {
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
			
			if(CessPool.selected.weaponA > 3) {
				Button.setText("No Space");
				Button.setEnabled(false);
			}
			
			for(Inventory b1 : CessPool.selected.inventory) {
				if(b1 instanceof Weapon) {
					Weapon b2 = (Weapon)b1;
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
	    					CessPool.selected.weaponA += 1;
	    					Main.frame.setContentPane(new ShopPanel(frame, 2, 'n'));
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
		this.setBackground(new Color(0, 26, 0));
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(new Color(0, 26, 0));
        addSkillButtons(buttonPanel, frame);

        this.add(buttonPanel);
//        this.add(buttonPanel, BorderLayout.CENTER);
	}
	
	private void addSkillButtons(JPanel panel, JFrame frame) {
        panel.removeAll();
        
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
    			
    			if (Objects.isNull(CessPool.selected.equippedWeapon)) {
    				Button.setText("Equip");
    				Button.setEnabled(true);
    			}
    			else {
    				Button.setText("Equip");
    				Button.setEnabled(false);
    				Weapon WeaponChar2 = CessPool.selected.equippedWeapon;
    				if(weapon1.equals(WeaponChar2)) {
    					Button.setText("Unequip");
        				Button.setEnabled(true);
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
                    	
                    	if(!Objects.isNull(CessPool.selected.equippedWeapon) ) {
							Weapon WeaponChar = CessPool.selected.equippedWeapon;
							CessPool.selected.unequipWeapon(WeaponChar);
						}
                    	else {
                    		CessPool.selected.equipWeapon(weapon1);
                    	}

    					Main.frame.setContentPane(new BagPanel(frame,2));
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
