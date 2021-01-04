package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class WeaponPanel extends JPanel{

	public WeaponPanel() {
		
		GridLayout item_sold = new GridLayout(4,1);
		this.setLayout(item_sold);
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		GridLayout sold = new GridLayout(1,3);
		JPanel a1 = new JPanel();
		JPanel a2 = new JPanel();
		JPanel a3 = new JPanel();
		JPanel a4 = new JPanel();
		
		a1.setLayout(sold);
		a2.setLayout(sold);
		a3.setLayout(sold);
		a4.setLayout(sold);
		
		ImageIcon Img = new ImageIcon("images/shopPane.jpg");
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(Img);
		lblNewLabel.setPreferredSize(new Dimension(213,160));
			
		JTextPane weapon1 = new JTextPane();
		weapon1.setEditable(false);
		weapon1.setContentType("text/html");
		weapon1.setText("<html><h3 style=\"color:white;\">· Name :"+ CessPool.weaponz.get(0).name +"<br>"
        		+"· Weight : "+ CessPool.weaponz.get(0).weight+ "<br>"
        		+"· Strength : "+ CessPool.weaponz.get(0).strength + "<br>"
        		+ "· Intelligence : "+ CessPool.weaponz.get(0).intelligence + "<br>"
        		+ "· Accuracy : "+ CessPool.weaponz.get(0).intelligence + "<br>"
        		+ "· Speed : "+CessPool.weaponz.get(0).speed +"</h3> </html>");	
		weapon1.setBackground(Color.black);
		
        JButton Button1 = new JButton();
		Button1.setText("Buy");
		Button1.setFocusable(false);
		Button1.setFocusPainted(false);
		Button1.setBackground(new Color(255, 238, 88));
		Button1.setForeground(Color.WHITE);
		
		Button1.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					CessPool.selected.inventory.add(CessPool.weaponz.get(0));
    				}
    			}
    	);
		
		a1.add(lblNewLabel);
		a1.add(weapon1);
		a1.add(Button1);
	    this.add(a1);
		
		ImageIcon Img2 = new ImageIcon("images/shopPane.jpg");
		JLabel lblNewLabel2 = new JLabel();
		lblNewLabel2.setIcon(Img2);
		lblNewLabel2.setPreferredSize(new Dimension(213,160));
			
		JTextPane weapon2 = new JTextPane();
		weapon2.setEditable(false);
		weapon2.setContentType("text/html");
		weapon2.setText("<html><h3 style=\"color:white;\">· Name :"+ CessPool.weaponz.get(1).name +"<br>"
        		+"· Weight : "+ CessPool.weaponz.get(1).weight+ "<br>"
        		+"· Strength : "+ CessPool.weaponz.get(1).strength + "<br>"
        		+ "· Intelligence : "+ CessPool.weaponz.get(1).intelligence + "<br>"
        		+ "· Accuracy : "+ CessPool.weaponz.get(1).intelligence + "<br>"
        		+ "· Speed : "+CessPool.weaponz.get(1).speed +"</h3> </html>");	
		weapon2.setBackground(Color.black);
		
        JButton Button2 = new JButton();
		Button2.setText("Buy");
		Button2.setFocusable(false);
		Button2.setFocusPainted(false);
		Button2.setBackground(new Color(255, 238, 88));
		Button2.setForeground(Color.WHITE);
		
		Button2.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					CessPool.selected.inventory.add(CessPool.weaponz.get(1));
    				}
    			}
    	);
       
		a2.add(lblNewLabel2);
		a2.add(weapon2);
		a2.add(Button2);
		this.add(a2);
        
		ImageIcon Img3 = new ImageIcon("images/shopPane.jpg");
		JLabel lblNewLabel3 = new JLabel();
		lblNewLabel3.setIcon(Img3);
		lblNewLabel3.setPreferredSize(new Dimension(213,160));
		
		JTextPane weapon3 = new JTextPane();
		weapon3.setEditable(false);
		weapon3.setContentType("text/html");
		weapon3.setText("<html><h3 style=\"color:white;\">· Name :"+ CessPool.weaponz.get(2).name +"<br>"
        		+"· Weight : "+ CessPool.weaponz.get(2).weight+ "<br>"
        		+"· Strength : "+ CessPool.weaponz.get(2).strength + "<br>"
        		+ "· Intelligence : "+ CessPool.weaponz.get(2).intelligence + "<br>"
        		+ "· Accuracy : "+ CessPool.weaponz.get(2).intelligence + "<br>"
        		+ "· Speed : "+CessPool.weaponz.get(2).speed +"</h3> </html>");	
		weapon3.setBackground(Color.black);
		
		JButton Button3 = new JButton();
		Button3.setText("Buy");
		Button3.setFocusable(false);
		Button3.setFocusPainted(false);
		Button3.setBackground(new Color(255, 238, 88));
		Button3.setForeground(Color.WHITE);
		
		Button3.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					CessPool.selected.inventory.add(CessPool.weaponz.get(2));
    				}
    			}
    	);
		
		a3.add(lblNewLabel3);
		a3.add(weapon3);
		a3.add(Button3);
		this.add(a3);
        
		ImageIcon Img4 = new ImageIcon("images/shopPane.jpg");
		JLabel lblNewLabel4 = new JLabel();
		lblNewLabel4.setIcon(Img4);
		lblNewLabel4.setPreferredSize(new Dimension(213,160));
		
		JTextPane weapon4 = new JTextPane();
		weapon4.setEditable(false);
		weapon4.setContentType("text/html");
		weapon4.setText("<html><h3 style=\"color:white;\">· Name :"+ CessPool.weaponz.get(3).name +"<br>"
        		+"· Weight : "+ CessPool.weaponz.get(3).weight+ "<br>"
        		+"· Strength : "+ CessPool.weaponz.get(3).strength + "<br>"
        		+ "· Intelligence : "+ CessPool.weaponz.get(3).intelligence + "<br>"
        		+ "· Accuracy : "+ CessPool.weaponz.get(3).intelligence + "<br>"
        		+ "· Speed : "+CessPool.weaponz.get(3).speed +"</h3> </html>");	
		weapon4.setBackground(Color.black);

		JButton Button4 = new JButton();
		Button4.setText("Buy");
		Button4.setFocusable(false);
		Button4.setFocusPainted(false);
		Button4.setBackground(new Color(255, 238, 88));
		Button4.setForeground(Color.WHITE);
		
		Button4.addActionListener(
    			new ActionListener() {
    				@Override
    				public void actionPerformed(ActionEvent event) {
    					CessPool.selected.inventory.add(CessPool.weaponz.get(3));
    				}
    			}
    	);
        
		a4.add(lblNewLabel4);
		a4.add(weapon4);
		a4.add(Button4);
		this.add(a4);
	}
}
