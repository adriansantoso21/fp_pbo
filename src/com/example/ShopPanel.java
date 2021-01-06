package com.example;

import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class ShopPanel extends JPanel{

	public ShopPanel(JFrame frame){
		
		GridLayout total = new GridLayout(1,2);
		GridLayout grdLayout = new GridLayout(1, 5);
		
		JPanel item = new JPanel();
		JPanel kiri = new JPanel();
		JPanel kanan = new JPanel();
		
		CardLayout cardlay = new CardLayout();
		JPanel kanan_bawah = new JPanel(cardlay);
		
		JPanel ArmorPanel = new ArmorPanel();
		JButton armor = new JButton("Armor");
		armor.setPreferredSize(new Dimension(128, 60));
		armor.setBackground(Color.black);
		armor.setForeground(Color.white);
	    
		kanan_bawah.add(ArmorPanel, "armorpane");
		
		ImageIcon Img = new ImageIcon("images/shopPane2.jpg");
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(Img);
		kiri.add(lblNewLabel);
		
		armor.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					cardlay.show(kanan_bawah, "armorpane");
    				}
    			}
    	);
		
		JPanel WeaponPanel = new WeaponPanel();
		JButton weapon = new JButton("Weapon");
		weapon.setBackground(Color.black);
		weapon.setForeground(Color.white);
		weapon.setPreferredSize(new Dimension(128, 60));
		kanan_bawah.add(WeaponPanel, "weaponpane");

		weapon.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					cardlay.show(kanan_bawah, "weaponpane");
    				}
    			}
    	);
		
		JPanel PotionPanel = new PotionPanel();
		JButton potion = new JButton("Potion");
		potion.setBackground(Color.black);
		potion.setForeground(Color.white);
		potion.setPreferredSize(new Dimension(128, 60));
		kanan_bawah.add(PotionPanel, "potionpane");
		
		potion.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					cardlay.show(kanan_bawah, "potionpane");
    				}
    			}
    	);
		
		JPanel SkillPanel = new SkillPanel();
        JButton skill = new JButton("Skill");
        skill.setBackground(Color.black);
        skill.setForeground(Color.white);
        skill.setPreferredSize(new Dimension(128, 60));
        kanan_bawah.add(SkillPanel, "skillpane");
        
        skill.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					cardlay.show(kanan_bawah, "skillpane");
    				}
    			}
    	);
        
        JButton Button1 = new JButton();
        Button1.setPreferredSize(new Dimension(128, 60));
		Button1.setText("Back");
		Button1.setFocusable(false);
		Button1.setFocusPainted(false);
		Button1.setBackground(Color.red);
		Button1.setForeground(Color.WHITE);
		
		Button1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	Main.frame.setContentPane(new Map(frame));
	        	frame.pack();
	         }
		});

        item.setLayout(grdLayout);
        item.add(armor);
        item.add(weapon);
        item.add(potion);
        item.add(skill);
        item.add(Button1);
        kanan.add(item);
        kanan.add(kanan_bawah);
        
        this.setLayout(total);
        this.add(kiri);
        this.add(kanan);
        
        kanan.add(BorderLayout.NORTH, item);
        kanan.add(BorderLayout.CENTER, kanan_bawah);
        kiri.setPreferredSize(new Dimension(640, 375));
        kanan.setPreferredSize(new Dimension(640, 375));
	}
}
