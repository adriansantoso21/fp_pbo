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

public class ArmorPanel extends JPanel{

	public ArmorPanel() {
		
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
			
		JTextPane armor1 = new JTextPane();
		armor1.setEditable(false);
		armor1.setContentType("text/html");
		armor1.setText("<html><h3 style=\"color:white;\">· Name :"+ CessPool.armorz.get(0).name +"<br>"
        		+"· Health Point : "+ CessPool.armorz.get(0).healthPoint+ "<br>"
        		+"· Defence : "+ CessPool.armorz.get(0).defence + "<br>"
        		+ "· Accuracy : "+ CessPool.armorz.get(0).accuracy + "<br>"
        		+ "· Speed : "+CessPool.armorz.get(0).speed +"</h3> </html>");	
		armor1.setBackground(Color.black);
		
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
    					CessPool.selected.inventory.add(CessPool.armorz.get(0));
    				}
    			}
    	);
		
		a1.add(lblNewLabel);
		a1.add(armor1);
		a1.add(Button1);
	    this.add(a1);
		
		ImageIcon Img2 = new ImageIcon("images/shopPane.jpg");
		JLabel lblNewLabel2 = new JLabel();
		lblNewLabel2.setIcon(Img2);
		lblNewLabel2.setPreferredSize(new Dimension(213,160));
			
		JTextPane armor2 = new JTextPane();
		armor2.setEditable(false);
		armor2.setContentType("text/html");
		armor2.setText("<html><h3 style=\"color:white;\">· Name :"+ CessPool.armorz.get(1).name +"<br>"
        		+"· Health Point : "+ CessPool.armorz.get(1).healthPoint+ "<br>"
        		+"· Defence : "+ CessPool.armorz.get(1).defence + "<br>"
        		+ "· Accuracy : "+ CessPool.armorz.get(1).accuracy + "<br>"
        		+ "· Speed : "+CessPool.armorz.get(1).speed +"</h3> </html>");
		
		armor2.setBackground(Color.black);
		
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
    					CessPool.selected.inventory.add(CessPool.armorz.get(1));
    				}
    			}
    	);
       
		a2.add(lblNewLabel2);
		a2.add(armor2);
		a2.add(Button2);
		this.add(a2);
        
		ImageIcon Img3 = new ImageIcon("images/shopPane.jpg");
		JLabel lblNewLabel3 = new JLabel();
		lblNewLabel3.setIcon(Img3);
		lblNewLabel3.setPreferredSize(new Dimension(213,160));
		
        JTextPane armor3 = new JTextPane();
		armor3.setEditable(false);
		armor3.setContentType("text/html");
		armor3.setText("<html><h3 style=\"color:white;\">· Name :"+ CessPool.armorz.get(2).name +"<br>"
        		+"· Health Point : "+ CessPool.armorz.get(2).healthPoint+ "<br>"
        		+"· Defence : "+ CessPool.armorz.get(2).defence + "<br>"
        		+ "· Accuracy : "+ CessPool.armorz.get(2).accuracy + "<br>"
        		+ "· Speed : "+CessPool.armorz.get(2).speed +"</h3> </html>");
		armor3.setBackground(Color.black);
		
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
    					CessPool.selected.inventory.add(CessPool.armorz.get(2));
    				}
    			}
    	);
		
		a3.add(lblNewLabel3);
		a3.add(armor3);
		a3.add(Button3);
		this.add(a3);
        
		ImageIcon Img4 = new ImageIcon("images/shopPane.jpg");
		JLabel lblNewLabel4 = new JLabel();
		lblNewLabel4.setIcon(Img4);
		lblNewLabel4.setPreferredSize(new Dimension(213,160));
		
        JTextPane armor4 = new JTextPane();
		armor4.setEditable(false);
		armor4.setContentType("text/html");
		armor4.setText("<html><h3 style=\"color:white;\">· Name :"+ CessPool.armorz.get(3).name +"<br>"
        		+"· Health Point : "+ CessPool.armorz.get(3).healthPoint+ "<br>"
        		+"· Defence : "+ CessPool.armorz.get(3).defence + "<br>"
        		+ "· Accuracy : "+ CessPool.armorz.get(3).accuracy + "<br>"
        		+ "· Speed : "+CessPool.armorz.get(3).speed +"</h3> </html>");
		armor4.setBackground(Color.black);

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
    					CessPool.selected.inventory.add(CessPool.armorz.get(3));
    				}
    			}
    	);
        
		a4.add(lblNewLabel4);
		a4.add(armor4);
		a4.add(Button4);
		this.add(a4);
	}
}
