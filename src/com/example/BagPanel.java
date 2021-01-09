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

	public BagPanel(JFrame frame, int choose){
		GridLayout total = new GridLayout(1,2);
		GridLayout grdLayout = new GridLayout(1, 5);
		CardLayout cardlay = new CardLayout();
		
		JPanel item = new JPanel();
		JPanel kiri = new JPanel(new GridLayout(2,1));
		JPanel kanan = new JPanel();
		JPanel kanan_bawah = new JPanel(cardlay);
		JPanel kiri_atas = new JPanel();
		JPanel kiri_bawah = new JPanel(new GridLayout(1,2));
		JPanel kiri_bawah_kiri = new JPanel(new BorderLayout());
		JPanel buton = new JPanel(new BorderLayout());
		
		
		ImageIcon Img1 = new ImageIcon("images/bg_rando.jpg");
		JLabel lblNewLabel1 = new JLabel();
		lblNewLabel1.setIcon(Img1);
		
		JTextPane player = new JTextPane();
		player.setEditable(false);
		player.setContentType("text/html");
		player.setText("<html><h3 style=\"color:white;\"><br>· Name :"+ CessPool.selected.name +"<br>"
        		+"· Health Point : "+ CessPool.selected.healthPoint+ "<br>"
        		+"· Defence : "+ CessPool.selected.defence + "<br>"
        		+ "· Accuracy : "+ CessPool.selected.accuracy + "<br>"
        		+ "· Intelligence : "+ CessPool.selected.intelligence + "<br>"
        		+ "· Mana : "+ CessPool.selected.mana + "<br>"
        		+ "· Strength : "+ CessPool.selected.strength + "<br>"
        		+ "· Speed : "+CessPool.selected.speed +"</h3> </html>");	
		player.setBackground(new Color(0, 0, 77));
		
		JTextPane player2 = new JTextPane();
		player2.setEditable(false);
		player2.setContentType("text/html");
		player2.setText("<html><h3 style=\"color:white;\"><br>· Name :"+ CessPool.selected.story+ "</h3> </html>");	
		player2.setBackground(new Color(0, 0, 77));
		
	     //Currently Hp
	     ImageIcon Img4 = new ImageIcon("images/hp_bag.png");   
	     JButton cuhp = new JButton("    HP is currently " + CessPool.selected.currHP, Img4);
	     cuhp.setBounds(0, 660, 150, 15);
	     cuhp.setBackground(Color.white);
	     buton.add(cuhp, BorderLayout.NORTH);
	     
	     //Currently Gold
	     ImageIcon Img5 = new ImageIcon("images/coin_bag.png");     
	     JButton cugo = new JButton("       Gold is currently " + CessPool.selected.gold, Img5);
	     cugo.setBounds(0, 690, 150, 15);
	     cugo.setBackground(new Color(173, 78, 5));
	     cugo.setForeground(Color.yellow);
	     buton.add(cugo,  BorderLayout.CENTER);
	     
	     //Currently Mana
	     ImageIcon Img6 = new ImageIcon("images/mana_bag.png"); 
	     JButton cumana = new JButton("         Mana is currently " + CessPool.selected.currMana, Img6);
	     cumana.setBounds(0, 720, 150, 15);
	     cumana.setBackground(new Color(0, 0, 102));
	     cumana.setForeground(new Color(0, 255, 255));
	     buton.add(cumana,  BorderLayout.SOUTH);
	     buton.setBackground(new Color(0, 0, 77));
	     kiri_bawah_kiri.setBackground(new Color(0, 0, 77));
	     
	    kiri_atas.add(lblNewLabel1);
		kiri_bawah_kiri.add(player, BorderLayout.NORTH);
		kiri_bawah_kiri.add(buton, BorderLayout.SOUTH);
		
		kiri_bawah.add(kiri_bawah_kiri);
		kiri_bawah.add(player2);
		kiri.add(kiri_atas);
		kiri.add(kiri_bawah);
		this.add(kiri);

		kanan.setBackground(new Color(0, 26, 0));
		
		JButton armor = new JButton("Armor");
		JPanel ArmorPanel = new ArmorPanel(1, frame);
		kanan_bawah.add(ArmorPanel, "armorpane");
		armor.setPreferredSize(new Dimension(128, 60));
		armor.setBackground(new Color(61, 61, 92));
		armor.setForeground(Color.white);
		
		armor.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					cardlay.show(kanan_bawah, "armorpane");
    				}
    			}
    	);
		
		JButton weapon = new JButton("Weapon");
		JPanel WeaponPanel = new WeaponPanel(1, frame);
		kanan_bawah.add(WeaponPanel, "weaponpane");
		weapon.setPreferredSize(new Dimension(128, 60));
		weapon.setBackground(new Color(61, 61, 92));
		weapon.setForeground(Color.white);

		weapon.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					cardlay.show(kanan_bawah, "weaponpane");
    				}
    			}
    	);
		
		JButton potion = new JButton("Potion");
		JPanel PotionPanel = new PotionPanel(1, frame);
		kanan_bawah.add(PotionPanel, "potionpane");
		potion.setPreferredSize(new Dimension(128, 60));
		potion.setBackground(new Color(61, 61, 92));
		potion.setForeground(Color.white);
		
		potion.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					cardlay.show(kanan_bawah, "potionpane");
    				}
    			}
    	);
		
        JButton skill = new JButton("Skill");
        JPanel SkillPanel = new SkillPanel(1, frame);
		kanan_bawah.add(SkillPanel, "skillpane");
        skill.setPreferredSize(new Dimension(128, 60));
        skill.setBackground(new Color(61, 61, 92));
        skill.setForeground(Color.white);
        
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
