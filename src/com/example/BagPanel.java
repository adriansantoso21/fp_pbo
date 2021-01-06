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
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class BagPanel extends JPanel{

	public BagPanel(JFrame frame){
		GridLayout total = new GridLayout(1,2);
		GridLayout kiri1 = new GridLayout(2,1);
		GridLayout grdLayout = new GridLayout(1, 5);
		CardLayout cardlay = new CardLayout();
		
		JPanel item = new JPanel();
		JPanel kiri = new JPanel();
		JPanel kanan = new JPanel();
		JPanel kanan_bawah = new JPanel(cardlay);

		ImageIcon Img = new ImageIcon("images/shopPane.jpg");
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(Img);
		lblNewLabel.setPreferredSize(new Dimension(213,160));
		
		JTextPane armor1 = new JTextPane();
		armor1.setEditable(false);
		armor1.setContentType("text/html");
		armor1.setText("<html><h3 style=\"color:white;\">· Name :"+ CessPool.selected.name +"<br>"
        		+"· Health Point : "+ CessPool.selected.healthPoint+ "<br>"
        		+"· Defence : "+ CessPool.selected.defence + "<br>"
        		+ "· Accuracy : "+ CessPool.selected.accuracy + "<br>"
        		+ "· Intelligence : "+ CessPool.selected.intelligence + "<br>"
        		+ "· Mana : "+ CessPool.selected.mana + "<br>"
        		+ "· Strength : "+ CessPool.selected.strength + "<br>"
        		+ "· Speed : "+CessPool.selected.speed +"</h3> </html>");	
		armor1.setBackground(Color.black);
		
		kiri.setLayout(kiri1);
		kiri.add(lblNewLabel);
		kiri.add(armor1);
		this.add(kiri);
		
		JButton armor = new JButton("Armor");
		armor.setPreferredSize(new Dimension(128, 60));
		armor.setBackground(Color.black);
		armor.setForeground(Color.white);
		
		armor.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					JPanel ArmorPanel = new ArmorPanel(1);
    					kanan_bawah.add(ArmorPanel, "armorpane");
    					cardlay.show(kanan_bawah, "armorpane");
    				}
    			}
    	);
		
		JButton weapon = new JButton("Weapon");
		weapon.setPreferredSize(new Dimension(128, 60));
		weapon.setBackground(Color.black);
		weapon.setForeground(Color.white);

		weapon.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					JPanel WeaponPanel = new WeaponPanel(1);
    					kanan_bawah.add(WeaponPanel, "weaponpane");
    					cardlay.show(kanan_bawah, "weaponpane");
    				}
    			}
    	);
		
		JButton potion = new JButton("Potion");
		potion.setPreferredSize(new Dimension(128, 60));
		potion.setBackground(Color.black);
		potion.setForeground(Color.white);
		
		potion.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					JPanel PotionPanel = new PotionPanel(1);
    					kanan_bawah.add(PotionPanel, "potionpane");
    					cardlay.show(kanan_bawah, "potionpane");
    				}
    			}
    	);
		
        JButton skill = new JButton("Skill");
        skill.setPreferredSize(new Dimension(128, 60));
        skill.setBackground(Color.black);
        skill.setForeground(Color.white);
        
        skill.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					JPanel SkillPanel = new SkillPanel(1);
    					kanan_bawah.add(SkillPanel, "skillpane");
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
