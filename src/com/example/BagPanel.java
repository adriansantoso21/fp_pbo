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

	public BagPanel(JFrame frame, CardLayout cardLayout, JPanel mainPanel){
		GridLayout total = new GridLayout(1,2);
		GridLayout kiri1 = new GridLayout(2,1);
		GridLayout grdLayout = new GridLayout(1, 4);
		
		JPanel item = new JPanel();
		JPanel kiri = new JPanel();
		JPanel kanan = new JPanel();
		JPanel kanan_bawah = new JPanel();

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
		armor.setPreferredSize(new Dimension(160, 60));
		
		armor.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					for (Inventory a : CessPool.selected.inventory) {
    						if(a instanceof Armor) {
    						
    						}
    					}
    				}
    			}
    	);
		
		JButton weapon = new JButton("Weapon");
		weapon.setPreferredSize(new Dimension(160, 60));

		weapon.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					
    				}
    			}
    	);
		
		JButton potion = new JButton("Potion");
		potion.setPreferredSize(new Dimension(160, 60));
		
		potion.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					
    				}
    			}
    	);
		
        JButton skill = new JButton("Skill");
        skill.setPreferredSize(new Dimension(160, 60));
        
        skill.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					
    				}
    			}
    	);
        

        item.setLayout(grdLayout);
        item.add(armor);
        item.add(weapon);
        item.add(potion);
        item.add(skill);
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
