package com.example;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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

public class PotionPanel extends JPanel{
	static ArrayList<Potion> sumn;

	public PotionPanel(JFrame frame, char hm) {
		
		GridLayout item_sold = new GridLayout(7,1);
		this.setLayout(item_sold);
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		
		if(hm == 'y') {
			Collections.shuffle(CessPool.potionz);
			
			sumn = new ArrayList<Potion>();
			
			int sum = 0;
			
			for(Potion a : CessPool.potionz) {
				if(sum>6) {
					break;
				}
				
				sumn.add(a);
				sum++;
			}
		}
		
		for(Potion b : sumn) {
			JPanel a1 = new JPanel();
			a1.setLayout(new BorderLayout());

			ImageIcon Img = new ImageIcon(b.image);
			JLabel lblNewLabel = new JLabel();
			lblNewLabel.setIcon(Img);
			lblNewLabel.setPreferredSize(new Dimension(84,87));
			
			JTextPane potion = new JTextPane();
			potion.setEditable(false);
			potion.setContentType("text/html");
			potion.setText("<html><h3 style=\"color:white;\">· Name : "+ b.name +"<br>"
					+"· Price : "+b.price+"<br>"
					+"· Desc : "+ b.buff.desc + "</h3> </html>");
			potion.setBackground(new Color(51, 0, 16));
			potion.setPreferredSize(new Dimension(313,20));
			
			JButton Button = new JButton();
			if(CessPool.selected.gold >= b.price) {
				Button.setText("Buy");
				Button.setEnabled(true);
			}
			else {
				Button.setText("No Money");
				Button.setEnabled(false);
			}
			
	        if(CessPool.selected.potionA == 7) {
	        	Button.setText("No Space");
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
	    					CessPool.selected.inventory.add(new Potion(b));
	    					CessPool.selected.gold -= b.price;
	    					CessPool.selected.potionA += 1;
	    					Main.frame.setContentPane(new ShopPanel(frame, 3, 'n'));
	    			         Main.frame.pack();
	    				}
	    			}
	    	);
			
			a1.add(lblNewLabel, BorderLayout.WEST);
			a1.add(potion, BorderLayout.CENTER);
			a1.add(Button, BorderLayout.EAST);
			this.add(a1);
		}
	}
	
	public PotionPanel(int test, JFrame frame) {
		this.setBackground(new Color(0, 26, 0));
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        JPanel buttonPanel = new JPanel(new GridLayout(8, 1));
        buttonPanel.setBackground(new Color(0, 26, 0));
        addSkillButtons(buttonPanel, frame);
        this.add(buttonPanel);
//        this.add(buttonPanel, BorderLayout.CENTER);
	}
	
	private void addSkillButtons(JPanel panel,JFrame frame) {
        panel.removeAll();
        JLabel showing = new JLabel();
        showing.setText("Potion Capacity : " + CessPool.selected.potionA+"/7");
        panel.add(showing);
                
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
				desc.setText("<html><h3 style=\"color:white;\">· Name : "+ potion1.name + "<br>"
						+ "· Desc : "+ potion1.buff.desc+"</h3> </html>");
				desc.setBackground(new Color(51, 0, 16));
				desc.setPreferredSize(new Dimension(429,20));
            	
    			JButton Button = new JButton();
    			Button.setText("Use");
    			Button.setFocusable(false);
    			Button.setFocusPainted(false);
    			Button.setBackground(new Color(61, 61, 92));
    			Button.setPreferredSize(new Dimension(120,20));
    			Button.setForeground(Color.white);
    			Button.setEnabled(false);
                
    			if(potion1.buff.currHP > 0 || potion1.buff.currMana>0) {
    				Button.setEnabled(true);
    				Button.setText("Use");
    			}
    			else {
    				Button.setEnabled(false);
    				Button.setText("Can't Use");
    			}
    			
                Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	CessPool.selected.usePotion(potion1);
                    	Main.frame.setContentPane(new BagPanel(frame, 3));
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
