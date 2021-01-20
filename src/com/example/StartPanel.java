package com.example;

import javax.swing.*;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel{
	private Container contain;
	private Image imgg;
	public JPanel CharacaterSelected;
	static musicPlay music = new musicPlay();

	public StartPanel(String imgg, JFrame frame) {
		music.playMusic("resource/song/title.wav");
		music.musicLoop();
		frame.setPreferredSize(new Dimension(1280, 750));
		this.imgg = new ImageIcon("resource/images/StartPanel3.jpg").getImage();
		
		ImageIcon Img = new ImageIcon("resource/images/DiamondCastle2.png");
		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(Img);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel.setBounds(440, -30, 350, 350);
		this.add(lblNewLabel);
		
		JButton Button1 = new JButton();
		Image img = new ImageIcon("resource/button/start_button.jpg").getImage();
		Button1.setIcon(new ImageIcon(img));
		Button1.setFocusable(false);
		Button1.setFocusPainted(false);
		Button1.setBounds(500, 450, 231, 57);
		this.add(Button1);
		
		Button1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	Main.frame.setContentPane(new CharacterSelectPanel(imgg, frame));
	        	frame.pack();
	         }
		});
		
		JButton Button2 = new JButton();
		Image img2 = new ImageIcon("resource/button/team.png").getImage();
		Button2.setIcon(new ImageIcon(img2));
		Button2.setFocusable(false);
		Button2.setFocusPainted(false);
		Button2.setBounds(1081, 663, 180, 48);
		this.add(Button2);
		
		JButton Button3 = new JButton();
		Image img3 = new ImageIcon("resource/button/exit_button.jpg").getImage();
		Button3.setIcon(new ImageIcon(img3));
		Button3.setFocusable(false);
		Button3.setFocusPainted(false);
		Button3.setBounds(500, 520, 231, 57);
		this.add(Button3);
		
		Button3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	int choice = JOptionPane.YES_OPTION;
	            choice = JOptionPane.showConfirmDialog(null, "Are you sure to Exit Application",
	                            "Confirmation", JOptionPane.YES_NO_OPTION);

	            if (choice == JOptionPane.YES_OPTION) {
	                System.out.println("Exit Button Clicked.");
	                frame.setVisible(false);
	                frame.dispose();
	            }
	         }
		});
		
		JButton Button4 = new JButton();
		Image img4 = new ImageIcon("resource/button/diamondCastle.png").getImage();
		Button4.setIcon(new ImageIcon(img4));
		Button4.setFocusable(false);
		Button4.setFocusPainted(false);
		Button4.setBounds(428, 295, 375, 98);
		this.add(Button4);
		
		JButton Button5 = new JButton();
		Image img5 = new ImageIcon("resource/button/version.png").getImage();
		Button5.setIcon(new ImageIcon(img5));
		Button5.setFocusable(false);
		Button5.setFocusPainted(false);
		Button5.setBounds(0, 0, 120, 42);
		this.add(Button5);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imgg, 0, 0, null);
	}

}