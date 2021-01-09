package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class RestPanel extends JPanel {
	private Image imgg;
	
	public RestPanel() {
		this.imgg = new ImageIcon("images/restpanel.png").getImage();
		
		JButton Button1 = new JButton();
		Button1.setText("Rest (30% HP)");
		Button1.setFocusable(false);
		Button1.setFocusPainted(false);
		Button1.setBackground(new Color(255, 238, 88));
		Button1.setForeground(Color.BLACK);
		Button1.setBounds(535, 400, 150, 51);
		this.add(Button1);
		
		Button1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	CessPool.selected.healHealth(CessPool.selected.healthPoint/100*30);
	         }
		});
		
		JButton Button2 = new JButton();
		Button2.setText("Meditate (5 Attribute Points)");
		Button2.setFocusable(false);
		Button2.setFocusPainted(false);
		Button2.setBackground(new Color(255, 238, 88));
		Button2.setForeground(Color.BLACK);
		Button2.setBounds(535, 600, 150, 51);
		this.add(Button2);
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imgg, -200, 0, null);
	}
}
