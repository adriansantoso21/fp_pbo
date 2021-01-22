package com.diamondcastle.inventorypanel;

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

import com.diamondcastle.cesspool.CessPool;
import com.diamondcastle.main.Main;
import com.diamondcastle.map.Map;

public class ShopPanel extends JPanel{

	public ShopPanel(JFrame frame, int choose, char hmm){	
		Map.music2.musicLoop();
		GridLayout total = new GridLayout(1,2);
		GridLayout grdLayout = new GridLayout(1, 5);
		
		JPanel item = new JPanel();
		JPanel kiri = new JPanel();
		JPanel kanan = new JPanel();
		JPanel kiri_atas = new JPanel(new GridLayout(1,3));
		
		CardLayout cardlay = new CardLayout();
		JPanel kanan_bawah = new JPanel(cardlay);
		
		//Currently Hp
	     ImageIcon Img1 = new ImageIcon("resource/images/hp.png");   
	     JButton cuhp = new JButton("  HP is : " + CessPool.selected.currHP, Img1);
	     cuhp.setBounds(140, 0, 250, 50);
	     cuhp.setBackground(Color.white);
	     
	     //Currently Gold
	     ImageIcon Img = new ImageIcon("resource/images/coin.png");     
	     JButton cugo = new JButton("     Gold is : " + CessPool.selected.gold, Img);
	     cugo.setBounds(140, 50, 250, 50);
	     cugo.setBackground(new Color(173, 78, 5));
	     cugo.setForeground(Color.yellow);
	     
	     //Currently Mana
	     ImageIcon Img2 = new ImageIcon("resource/images/mana.png"); 
	     JButton cumana = new JButton("       Mana is : " + CessPool.selected.currMana, Img2);
	     cumana.setBounds(140, 100, 250, 50);
	     cumana.setBackground(new Color(0, 0, 102));
	     cumana.setForeground(new Color(0, 255, 255));

	     kiri_atas.add(cuhp);
	     kiri_atas.add(cugo);
	     kiri_atas.add(cumana);
		
		kiri.setLayout(new BorderLayout());
		ImageIcon Img4 = new ImageIcon("resource/images/shopPane2.jpg");
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(Img4);
		
		kiri.add(kiri_atas, BorderLayout.NORTH);
		kiri.add(lblNewLabel,BorderLayout.CENTER);
		
		JPanel ArmorPanel = new ArmorPanel(frame, hmm);
		JButton armor = new JButton("Armor");
		armor.setPreferredSize(new Dimension(128, 60));
		armor.setBackground(Color.black);
		armor.setForeground(Color.white);
		kanan_bawah.add(ArmorPanel, "armorpane");
		
		armor.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					cardlay.show(kanan_bawah, "armorpane");
    				}
    			}
    	);
		
		JPanel WeaponPanel = new WeaponPanel(frame, hmm);
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
		
		JPanel PotionPanel = new PotionPanel(frame, hmm);
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
		
		JPanel SkillPanel = new SkillPanel(frame, hmm);
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
	        	Map.music2.stopMusic();
	        	Main.frame.setContentPane(new Map(frame));
	        	Main.frame.pack();
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
        
      //1 for armor, 2 for weapon, 3 for potion, 4 for skill
  		if(choose == 1) cardlay.show(kanan_bawah, "armorpane");
  		else if (choose == 2) cardlay.show(kanan_bawah, "weaponpane");
  		else if (choose == 3) cardlay.show(kanan_bawah, "potionpane");
  		else if (choose == 4) cardlay.show(kanan_bawah, "skillpane");
        
        kanan.add(BorderLayout.NORTH, item);
        kanan.add(BorderLayout.CENTER, kanan_bawah);
        kiri.setPreferredSize(new Dimension(640, 375));
        kanan.setPreferredSize(new Dimension(640, 375));
	}
}
