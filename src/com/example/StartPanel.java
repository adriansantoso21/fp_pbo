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

	public StartPanel(String imgg, JFrame frame, CardLayout cardLayout, JPanel mainPanel) {
		frame.setPreferredSize(new Dimension(1280, 750));
		this.imgg = new ImageIcon("images/StartPanel.jpg").getImage();
		ImageIcon Img = new ImageIcon("images/DiamondCastle.png");
		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(Img);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel.setBounds(440, 0, 350, 350);
		this.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel();
		lblNewLabel1.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel1.setBounds(280, 220, 570, 150);
		lblNewLabel1.setForeground(Color.ORANGE);
		this.add(lblNewLabel1);
		
		JButton Button1 = new JButton();
		Button1.setText("PLAY");
		Button1.setFocusable(false);
		Button1.setFocusPainted(false);
		Button1.setBackground(new Color(255, 238, 88));
		Button1.setForeground(Color.BLACK);
		Button1.setBounds(535, 400, 150, 51);
		this.add(Button1);
		
		Button1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	cardLayout.show(mainPanel, "characterSelect");
	         }
		});
		
		JButton Button3 = new JButton();
		Button3.setText("EXIT");
		Button3.setFocusable(false);
		Button3.setFocusPainted(false);
		Button3.setBackground(new Color(255, 238, 88));
		Button3.setForeground(Color.BLACK);
		Button3.setBounds(535, 470, 150, 51);
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
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imgg, -200, 0, null);
	}

}