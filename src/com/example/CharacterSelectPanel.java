package com.example;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class CharacterSelectPanel extends JPanel {
	
	public Image imgg;
	public Font CharSelect;
	
	public CharacterSelectPanel(String imgg, JFrame frame) {
		try {
			CharSelect = Font.createFont(Font.TRUETYPE_FONT, new File("font/AfternoonCoffee-GOqyO.ttf")).deriveFont(22f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("font/AfternoonCoffee-GOqyO.ttf")));
			
	   }
	   catch(IOException | FontFormatException e) {
	    
	   }
		
		JButton Button4 = new JButton();
		Image img4 = new ImageIcon("button/choose.png").getImage();
		Button4.setIcon(new ImageIcon(img4));
		Button4.setFocusable(false);
		Button4.setFocusPainted(false);
		Button4.setBounds(400, 20, 500, 86);
		this.add(Button4);
		
		this.setLayout(null);
		this.imgg = new ImageIcon("images/StartPanel3.jpg").getImage();
		
		//Wizard Character
		ImageIcon Img = new ImageIcon("creature/wizard.png");
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(Img);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel.setBounds(150, 117, 230, 252);
		this.add(lblNewLabel);
		
	    SimpleAttributeSet wiz = new SimpleAttributeSet();
	    StyleConstants.setForeground(wiz, Color.white);
	    StyleConstants.setBold(wiz, true);
		
		JTextPane ta = new JTextPane();
        ta.setEditable(false);
        ta.setFont(CharSelect);
        ta.setCharacterAttributes(wiz, true);
        ta.setText("· Name : Wizard \n"
		  +"· Very Good in magic \n"
		  + "· High Mana \n"
		  + "· Low Defence\n");
        ta.setBackground(Color.black);
        ta.setBounds(150, 400, 200, 117);
        
        this.add(ta);
		
        Image img = new ImageIcon("button/confirm.jpg").getImage();
		
		JButton Button1 = new JButton();
		Button1.setIcon(new ImageIcon(img));
		Button1.setFocusable(false);
		Button1.setFocusPainted(false);
		Button1.setBounds(178, 550, 145, 42);
		this.add(Button1);
		
		Button1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	int choice = JOptionPane.YES_OPTION;
	            choice = JOptionPane.showConfirmDialog(null, "Are you sure want to choose wizard ?",
	                            "Confirmation", JOptionPane.YES_NO_OPTION);

	            if (choice == JOptionPane.YES_OPTION) {
	                System.out.println("Wizard is chosen.");
	                CessPool.selected = new Character("Wizard", 2000, 150, 50, 10, 50, 25, 25, 30, "The Wizard is a magical man that wears a hooded cloak, a leather belt with a golden buckle, and matching boots.\r\n"
	                		+ "The Wizard is a ranged unit, meaning that he can shoot over Walls. He shoots fireballs or energy blasts that do high damage but requires support as he has relatively low hit points and"
	                		+ " can easily be killed by point defenses.");
	                CessPool.selected.addAttackImage(new ImageIcon("character/Wizard/attack_001.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Wizard/attack_002.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Wizard/attack_003.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Wizard/attack_004.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Wizard/attack_005.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Wizard/attack_006.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Wizard/attack_007.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Wizard/attack_008.png").getImage());
	                CessPool.selected.addIdleImage(new ImageIcon("character/Wizard/idle_001.png").getImage());
	                CessPool.selected.addIdleImage(new ImageIcon("character/Wizard/idle_002.png").getImage());
	                CessPool.selected.addIdleImage(new ImageIcon("character/Wizard/idle_003.png").getImage());
	                CessPool.selected.addIdleImage(new ImageIcon("character/Wizard/idle_004.png").getImage());
	                CessPool.selected.addIdleImage(new ImageIcon("character/Wizard/idle_005.png").getImage());
	                CessPool.selected.addIdleImage(new ImageIcon("character/Wizard/idle_006.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Wizard/spell_001.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Wizard/spell_002.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Wizard/spell_003.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Wizard/spell_004.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Wizard/spell_005.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Wizard/spell_006.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Wizard/spell_007.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Wizard/spell_008.png").getImage());
	                CessPool.selected.skills.add(CessPool.skillz.get(7));
	                CessPool.selected.inventory.add(CessPool.potionz.get(4));
	                CessPool.selected.inventory.add(CessPool.potionz.get(6));
	                CessPool.selected.potionA = 2;
	               
	                StartPanel.music.stopMusic();
	                Main.frame.setContentPane(new VideoCharacterSelectPanel(frame));
	                frame.pack();
	            }
	         }
		});
		
		//Warrior Character
		ImageIcon Img2 = new ImageIcon("creature/warrior.png");
		this.setLayout(null);
		JLabel lblNewLabel2 = new JLabel();
		lblNewLabel2.setIcon(Img2);
		lblNewLabel2.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel2.setBounds(540, 150, 200, 232);
		this.add(lblNewLabel2);
		
		JTextPane tb = new JTextPane();
        tb.setEditable(false);
        tb.setFont(CharSelect);
        tb.setCharacterAttributes(wiz, true);
        tb.setText("· Name : Warrior \n"
        		+"· Very Good in strength \n"
        		+ "· High Defence \n"
        		+ "· Low Mana \n");
        tb.setBackground(Color.black);
        tb.setBounds(540, 400, 200, 117);
        this.add(tb);
		
		JButton Button2 = new JButton();
		Button2.setIcon(new ImageIcon(img));
		Button2.setFocusable(false);
		Button2.setFocusPainted(false);
		Button2.setBounds(568, 550, 145, 42);
		this.add(Button2);
		
		Button2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	int choice = JOptionPane.YES_OPTION;
	            choice = JOptionPane.showConfirmDialog(null, "Are you sure want to choose warrior ?",
	                            "Confirmation", JOptionPane.YES_NO_OPTION);

	            if (choice == JOptionPane.YES_OPTION) {
	            	System.out.println("Warrior is chosen.");
	                CessPool.selected = new Character("Warrior", 500, 50, 10, 40, 50, 30, 50, 50,"The Barbarian King is a larger, stronger, more aggressive, more impressive, "
	                		+ "and more powerful Barbarian. He is automatically summoned once the Barbarian King Altar is constructed, which costs 10,000 Dark Elixir. The Dark "
	                		+ "Elixir Storage is required to get him.\r\n");
	                CessPool.selected.addAttackImage(new ImageIcon("character/Warrior/Individual Sprite/Attack/Warrior_Attack_1.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Warrior/Individual Sprite/Attack/Warrior_Attack_2.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Warrior/Individual Sprite/Attack/Warrior_Attack_3.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Warrior/Individual Sprite/Attack/Warrior_Attack_4.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Warrior/Individual Sprite/Attack/Warrior_Attack_5.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Warrior/Individual Sprite/Attack/Warrior_Attack_6.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Warrior/Individual Sprite/Attack/Warrior_Attack_7.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Warrior/Individual Sprite/Attack/Warrior_Attack_8.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Warrior/Individual Sprite/Attack/Warrior_Attack_9.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Warrior/Individual Sprite/Attack/Warrior_Attack_10.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Warrior/Individual Sprite/Attack/Warrior_Attack_11.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Warrior/Individual Sprite/Attack/Warrior_Attack_12.png").getImage());
	                CessPool.selected.addIdleImage(new ImageIcon("character/Warrior/Individual Sprite/idle/Warrior_Idle_1.png").getImage());
	                CessPool.selected.addIdleImage(new ImageIcon("character/Warrior/Individual Sprite/idle/Warrior_Idle_2.png").getImage());
	                CessPool.selected.addIdleImage(new ImageIcon("character/Warrior/Individual Sprite/idle/Warrior_Idle_3.png").getImage());
	                CessPool.selected.addIdleImage(new ImageIcon("character/Warrior/Individual Sprite/idle/Warrior_Idle_4.png").getImage());
	                CessPool.selected.addIdleImage(new ImageIcon("character/Warrior/Individual Sprite/idle/Warrior_Idle_5.png").getImage());
	                CessPool.selected.addIdleImage(new ImageIcon("character/Warrior/Individual Sprite/idle/Warrior_Idle_6.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Warrior/Individual Sprite/Dash-Attack_noDust/Warrior_Dash-Attack_1.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Warrior/Individual Sprite/Dash-Attack_noDust/Warrior_Dash-Attack_2.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Warrior/Individual Sprite/Dash-Attack_noDust/Warrior_Dash-Attack_3.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Warrior/Individual Sprite/Dash-Attack_noDust/Warrior_Dash-Attack_4.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Warrior/Individual Sprite/Dash-Attack_noDust/Warrior_Dash-Attack_5.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Warrior/Individual Sprite/Dash-Attack_noDust/Warrior_Dash-Attack_6.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Warrior/Individual Sprite/Dash-Attack_noDust/Warrior_Dash-Attack_7.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Warrior/Individual Sprite/Dash-Attack_noDust/Warrior_Dash-Attack_8.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Warrior/Individual Sprite/Dash-Attack_noDust/Warrior_Dash-Attack_9.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Warrior/Individual Sprite/Dash-Attack_noDust/Warrior_Dash-Attack_10.png").getImage());
	                CessPool.selected.skills.add(CessPool.skillz.get(1));
	                CessPool.selected.inventory.add(CessPool.potionz.get(0));
	                CessPool.selected.inventory.add(CessPool.potionz.get(1));
	                CessPool.selected.potionA = 2;
	                StartPanel.music.stopMusic();
	                Main.frame.setContentPane(new Map(frame));
	                Main.frame.setContentPane(new VideoCharacterSelectPanel(frame));
	                frame.pack();
	            }
	         }
		});
		
		//Rogue Character
		ImageIcon Img3 = new ImageIcon("creature/rogue.png");
		this.setLayout(null);
		JLabel lblNewLabel3 = new JLabel();
		lblNewLabel3.setIcon(Img3);
		lblNewLabel3.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel3.setBounds(930, 120, 200, 277);
		this.add(lblNewLabel3);
		
		JTextPane tc = new JTextPane();
        tc.setEditable(false);
        tc.setFont(CharSelect);
        tc.setCharacterAttributes(wiz, true);
        tc.setText("· Name : Rogue \n"
        		+"· Very Good in speed \n"
        		+ "· High Accuracy \n"
        		+ "· Low Defence \n");
        tc.setBackground(Color.black);
        tc.setBounds(930, 400, 200, 117);
        this.add(tc);
		
		JButton Button3 = new JButton();
		Button3.setIcon(new ImageIcon(img));
		Button3.setFocusable(false);
		Button3.setFocusPainted(false);
		Button3.setBounds(957, 550, 145, 42);
		this.add(Button3);
		
		Button3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	int choice = JOptionPane.YES_OPTION;
	            choice = JOptionPane.showConfirmDialog(null, "Are you sure want to choose rogue ?",
	                            "Confirmation", JOptionPane.YES_NO_OPTION);

	            if (choice == JOptionPane.YES_OPTION) {
	            	System.out.println("Rogue is chosen.");
	                CessPool.selected = new Character("Rogue", 750, 100, 35, 35, 50, 50, 20, 20, "The Goblin is the fourth troop unlocked in the Barracks.\r\n"
	                		+ "Goblins prioritize resource buildings above all other targets, and will bypass all other types of enemy buildings and troops while any resource buildings remain on the battlefield."
	                		+ " This is true even if they are under attack by enemy Clan Castle troops, heroes or Skeleton Trap skeletons");
	                CessPool.selected.addAttackImage(new ImageIcon("character/Rogue/attack1.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Rogue/attack2.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Rogue/attack3.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Rogue/attack4.png").getImage());
	                CessPool.selected.addAttackImage(new ImageIcon("character/Rogue/attack5.png").getImage());
	                CessPool.selected.addIdleImage(new ImageIcon("character/Rogue/idle1.png").getImage());
	                CessPool.selected.addIdleImage(new ImageIcon("character/Rogue/idle2.png").getImage());
	                CessPool.selected.addIdleImage(new ImageIcon("character/Rogue/idle3.png").getImage());
	                CessPool.selected.addIdleImage(new ImageIcon("character/Rogue/idle4.png").getImage());
	                CessPool.selected.addIdleImage(new ImageIcon("character/Rogue/idle5.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Rogue/potion1.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Rogue/potion2.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Rogue/potion3.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Rogue/potion4.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Rogue/potion5.png").getImage());
	                CessPool.selected.addSpellImage(new ImageIcon("character/Rogue/potion6.png").getImage());
	                CessPool.selected.skills.add(CessPool.skillz.get(7));
	                CessPool.selected.inventory.add(CessPool.potionz.get(3));
	                CessPool.selected.inventory.add(CessPool.potionz.get(7));
	                CessPool.selected.potionA = 2;
	                StartPanel.music.stopMusic();
	                Main.frame.setContentPane(new VideoCharacterSelectPanel(frame));
	                frame.pack();
	            }
	         }
		});
		
	}	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imgg, 0, 0, null);
	}
}