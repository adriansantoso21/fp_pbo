package com.example;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterSelectPanel extends JPanel {
	
	public Image imgg;
	
	public CharacterSelectPanel(String imgg, JFrame frame, CardLayout cardLayout, JPanel mainPanel) {
		frame.setPreferredSize(new Dimension(1280, 750));
		JLabel label1 = new JLabel("Choose Your Own Character !!");
		label1.setFont(new Font("Verdana", Font.BOLD, 30));
		label1.setBounds(375, 0, 600, 100);
		label1.setForeground (Color.WHITE);
		this.add(label1);
		this.setLayout(null);
		this.imgg = new ImageIcon("images/StartPanel.jpg").getImage();
		
		//Wizard Character
		ImageIcon Img = new ImageIcon("creature/wizard.png");
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(Img);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel.setBounds(150, 150, 230, 252);
		this.add(lblNewLabel);
		
		JTextPane ta = new JTextPane();
        ta.setEditable(false);
        ta.setContentType("text/html");
        ta.setText("<html><h3 style=\"color:white;\">· Name : Wizard <br>"
        		+"· Very Good in magic <br>"
        		+ "· High Mana <br>"
        		+ "· Low Defence</h3> </html>");
        ta.setBackground(Color.black);
        ta.setBounds(150, 400, 200, 117);
        this.add(ta);
		
		JButton Button1 = new JButton();
		Button1.setText("CHOOSE");
		Button1.setFocusable(false);
		Button1.setFocusPainted(false);
		Button1.setBackground(new Color(255, 238, 88));
		Button1.setForeground(Color.WHITE);
		Button1.setBounds(200, 550, 100, 50);
		this.add(Button1);
		
		Button1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	int choice = JOptionPane.YES_OPTION;
	            choice = JOptionPane.showConfirmDialog(null, "Are you sure want to choose wizard ?",
	                            "Confirmation", JOptionPane.YES_NO_OPTION);

	            if (choice == JOptionPane.YES_OPTION) {
	                System.out.println("Wizard is chosen.");
	                CessPool.selected = new Character("Wizard", 200, 200, 50, 10, 50, 25, 25, 30, "The Wizard is a magical man that wears a hooded cloak, a leather belt with a golden buckle, and matching boots.\r\n"
	                		+ "The Wizard is a ranged unit, meaning that he can shoot over Walls. He shoots fireballs or energy blasts that do high damage but requires support as he has relatively low hit points and"
	                		+ " can easily be killed by point defenses.");
	                Main.frame.setContentPane(new Map(frame));
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
        tb.setContentType("text/html");
        tb.setText("<html><h3 style=\"color:white;\">· Name : Warrior <br>"
        		+"· Very Good in strength <br>"
        		+ "· High Defence <br>"
        		+ "· Low Mana</h3> </html>");
        tb.setBackground(Color.black);
        tb.setBounds(540, 400, 200, 117);
        this.add(tb);
		
		JButton Button2 = new JButton();
		Button2.setText("CHOOSE");
		Button2.setFocusable(false);
		Button2.setFocusPainted(false);
		Button2.setBackground(new Color(255, 238, 88));
		Button2.setForeground(Color.WHITE);
		Button2.setBounds(590, 550, 100, 50);
		this.add(Button2);
		
		Button2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	int choice = JOptionPane.YES_OPTION;
	            choice = JOptionPane.showConfirmDialog(null, "Are you sure want to choose warrior ?",
	                            "Confirmation", JOptionPane.YES_NO_OPTION);

	            if (choice == JOptionPane.YES_OPTION) {
	            	System.out.println("Warrior is chosen.");
	                CessPool.selected = new Character("Warrior", 4001, 50, 10, 50, 50, 30, 50, 50,"The Barbarian King is a larger, stronger, more aggressive, more impressive, "
	                		+ "and more powerful Barbarian. He is automatically summoned once the Barbarian King Altar is constructed, which costs 10,000 Dark Elixir. The Dark "
	                		+ "Elixir Storage is required to get him.\r\n");
	                Main.frame.setContentPane(new Map(frame));
	                frame.pack();
	            }
	         }
		});
		
		//Rogue Character
		ImageIcon Img3 = new ImageIcon("images/rogue1.png");
		this.setLayout(null);
		JLabel lblNewLabel3 = new JLabel();
		lblNewLabel3.setIcon(Img3);
		lblNewLabel3.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel3.setBounds(930, 120, 200, 277);
		this.add(lblNewLabel3);
		
		JTextPane tc = new JTextPane();
        tc.setEditable(false);
        tc.setContentType("text/html");
        tc.setText("<html><h3 style=\"color:white;\">· Name : Rogue <br>"
        		+"· Very Good in speed <br>"
        		+ "· High Accuracy <br>"
        		+ "· Low Defence</h3> </html>");
        tc.setBackground(Color.black);
        tc.setBounds(930, 400, 200, 117);
        this.add(tc);
		
		JButton Button3 = new JButton();
		Button3.setText("CHOOSE");
		Button3.setFocusable(false);
		Button3.setFocusPainted(false);
		Button3.setBackground(new Color(255, 238, 88));
		Button3.setForeground(Color.WHITE);
		Button3.setBounds(980, 550, 100, 50);
		this.add(Button3);
		
		Button3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	int choice = JOptionPane.YES_OPTION;
	            choice = JOptionPane.showConfirmDialog(null, "Are you sure want to choose rogue ?",
	                            "Confirmation", JOptionPane.YES_NO_OPTION);

	            if (choice == JOptionPane.YES_OPTION) {
	            	System.out.println("Rogue is chosen.");
	                CessPool.selected = new Character("Rogue", 300, 100, 30, 20, 50, 50, 20, 20, "The Goblin is the fourth troop unlocked in the Barracks.\r\n"
	                		+ "Goblins prioritize resource buildings above all other targets, and will bypass all other types of enemy buildings and troops while any resource buildings remain on the battlefield."
	                		+ " This is true even if they are under attack by enemy Clan Castle troops, heroes or Skeleton Trap skeletons");
	                Main.frame.setContentPane(new Map(frame));
	                frame.pack();
	            }
	         }
		});
		
	}	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imgg, -200, 0, null);
	}
}