package com.example;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class AttributePanel extends JPanel {
	private Image imgg = new ImageIcon("resource/images/attpanelimage.jpg").getImage();
	
	public AttributePanel(int test, JFrame frame) {
		this.setBackground(new Color(0, 26, 0));
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        JPanel buttonPanel = new JPanel(new GridLayout(8, 1));
        buttonPanel.setBackground(new Color(0, 26, 0));
        addSkillButtons(buttonPanel, frame);
        this.add(buttonPanel);
//        this.add(buttonPanel, BorderLayout.CENTER);
	}
	
	private void addSkillButtons(JPanel panel, JFrame frame) {
		//Title
    	JLabel accuu = new JLabel();
    	accuu.setText("Current Attribute Points : " + CessPool.selected.attributeP);
		accuu.setFocusable(false);
		accuu.setHorizontalAlignment(SwingConstants.CENTER);
		accuu.setForeground(Color.WHITE);
		accuu.setBackground(new Color(51, 0, 16));
		accuu.setFont(new Font("Verdana", Font.BOLD, 20));
        panel.add(accuu);
        
        //Max hp
    	JPanel skill_panel = new JPanel();
    	skill_panel.setLayout(new BorderLayout());
		
    	JLabel hp = new JLabel();
    	hp.setText("Max HP : " + CessPool.selected.healthPoint);
		hp.setForeground(Color.WHITE);
		hp.setHorizontalAlignment(SwingConstants.CENTER);
		hp.setBackground(new Color(51, 26, 0));
		hp.setOpaque(true);
		hp.setPreferredSize(new Dimension(440, 75));
    	
		JButton Button = new JButton();
		Button.setEnabled(true);
		Button.setText("Increase 10");
		if(CessPool.selected.attributeP<1) {
			Button.setText("No Points");
			Button.setEnabled(false);
		}
		
		Button.setFocusable(false);
		Button.setFocusPainted(false);
		Button.setBackground(new Color(153, 102, 0));
		Button.setForeground(Color.white);
		Button.setPreferredSize(new Dimension(100, 75));
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	CessPool.selected.healthPoint += 10;
            	CessPool.selected.currHP += 10;
            	CessPool.selected.attributeP -= 1;
        
            	Main.frame.setContentPane(new BagPanel(frame, 5));
                Main.frame.pack();
            }
        });
        
        skill_panel.add(hp, BorderLayout.CENTER);
        skill_panel.add(Button, BorderLayout.EAST);
        panel.add(skill_panel);
        
 
        //Max mana
        JPanel manaPanel = new JPanel();
    	manaPanel.setLayout(new BorderLayout());
		
    	JLabel mana = new JLabel();
    	mana.setText("Max Mana : " + CessPool.selected.mana);
		mana.setFocusable(false);
		mana.setHorizontalAlignment(SwingConstants.CENTER);
		mana.setOpaque(true);
		mana.setForeground(Color.WHITE);
		mana.setPreferredSize(new Dimension(440, 75));
		mana.setBackground(new Color(51, 26, 0));
    	
		JButton manaButton = new JButton();
		manaButton.setText("Can't use");
		manaButton.setEnabled(true);
		manaButton.setText("Increase 10");
		if(CessPool.selected.attributeP<1) {
			manaButton.setText("No Points");
			manaButton.setEnabled(false);
		}
		manaButton.setFocusable(false);
		manaButton.setFocusPainted(false);
		manaButton.setBackground(new Color(153, 102, 0));
		manaButton.setHorizontalAlignment(SwingConstants.CENTER);
		manaButton.setForeground(Color.white);
		manaButton.setPreferredSize(new Dimension(100, 75));
        manaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	CessPool.selected.mana += 10;
            	CessPool.selected.currMana += 10;
            	CessPool.selected.attributeP -= 1;
        
            	Main.frame.setContentPane(new BagPanel(frame, 5));
                Main.frame.pack();
            }
        });
        
        manaPanel.add(mana, BorderLayout.CENTER);
        manaPanel.add(manaButton, BorderLayout.EAST);
        panel.add(manaPanel);
        
        //Max Strength
        JPanel streng = new JPanel();
    	streng.setLayout(new BorderLayout());
		
    	JLabel strengthh = new JLabel();
    	strengthh.setText("Strength : " + CessPool.selected.strength);
		strengthh.setFocusable(false);
		strengthh.setHorizontalAlignment(SwingConstants.CENTER);
		strengthh.setOpaque(true);
		strengthh.setForeground(Color.WHITE);
		strengthh.setPreferredSize(new Dimension(440, 75));
		strengthh.setBackground(new Color(51, 26, 0));
    	
		JButton strButton = new JButton();
		strButton.setText("Can't use");
	
		strButton.setEnabled(true);
		strButton.setText("Increase 1  ");
		if(CessPool.selected.attributeP<1) {
			strButton.setText("No Points");
			strButton.setEnabled(false);
		}
		strButton.setFocusable(false);
		strButton.setFocusPainted(false);
		strButton.setBackground(new Color(153, 102, 0));
		strButton.setForeground(Color.white);
		strButton.setPreferredSize(new Dimension(100, 75));
        strButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	CessPool.selected.strength += 1;
            	CessPool.selected.attributeP -= 1;
        
            	Main.frame.setContentPane(new BagPanel(frame, 5));
                Main.frame.pack();
            }
        });
        
        streng.add(strengthh, BorderLayout.CENTER);
        streng.add(strButton, BorderLayout.EAST);
        panel.add(streng);
        
        //Max Intelligence
        JPanel intelligence = new JPanel();
    	intelligence.setLayout(new BorderLayout());
		
    	JLabel intelli = new JLabel();
    	intelli.setText("Intelligence : " + CessPool.selected.intelligence);
		intelli.setFocusable(false);
		intelli.setHorizontalAlignment(SwingConstants.CENTER);
		intelli.setOpaque(true);
		intelli.setForeground(Color.WHITE);
		intelli.setPreferredSize(new Dimension(440, 75));
		intelli.setBackground(new Color(51, 26, 0));
    	
		JButton intButton = new JButton();
		intButton.setText("Can't use");
		intButton.setPreferredSize(new Dimension(100, 75));
		intButton.setEnabled(true);
		intButton.setText("Increase 1  ");
		if(CessPool.selected.attributeP<1) {
			intButton.setText("No Points");
			intButton.setEnabled(false);
		}
		
		intButton.setFocusable(false);
		intButton.setFocusPainted(false);
		intButton.setBackground(new Color(153, 102, 0));
		intButton.setForeground(Color.white);
        intButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	CessPool.selected.intelligence += 1;
            	CessPool.selected.attributeP -= 1;
        
            	Main.frame.setContentPane(new BagPanel(frame, 5));
                Main.frame.pack();
            }
        });
        
        intelligence.add(intelli, BorderLayout.CENTER);
        intelligence.add(intButton, BorderLayout.EAST);
        panel.add(intelligence);
        
        //Max Accuracy
        JPanel accPanel = new JPanel();
    	accPanel.setLayout(new BorderLayout());
		
    	JLabel accu = new JLabel();
    	accu.setText("Accuracy : " + CessPool.selected.accuracy);
		accu.setFocusable(false);
		accu.setHorizontalAlignment(SwingConstants.CENTER);
		accu.setOpaque(true);
		accu.setForeground(Color.WHITE);
		accu.setPreferredSize(new Dimension(440, 75));
		accu.setBackground(new Color(51, 26, 0));
    	
		JButton accButton = new JButton();
		accButton.setText("Can't use");
	
		accButton.setEnabled(true);
		accButton.setText("Increase 1  ");
		if(CessPool.selected.attributeP<1) {
			accButton.setText("No Points");
			accButton.setEnabled(false);
		}
		
		accButton.setFocusable(false);
		accButton.setFocusPainted(false);
		accButton.setBackground(new Color(153, 102, 0));
		accButton.setForeground(Color.white);
		accButton.setPreferredSize(new Dimension(100, 75));
        accButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	CessPool.selected.accuracy += 1;
            	CessPool.selected.attributeP -= 1;
        
            	Main.frame.setContentPane(new BagPanel(frame, 5));
                Main.frame.pack();
            }
        });
        
        accPanel.add(accu, BorderLayout.CENTER);
        accPanel.add(accButton, BorderLayout.EAST);
        panel.add(accPanel);
        
        //Max Speed
        JPanel speedPanel = new JPanel();
    	speedPanel.setLayout(new BorderLayout());
		
    	JLabel sped = new JLabel();
    	sped.setText("Speed : " + CessPool.selected.accuracy);
		sped.setFocusable(false);
		sped.setHorizontalAlignment(SwingConstants.CENTER);
		sped.setOpaque(true);
		sped.setForeground(Color.WHITE);
		sped.setPreferredSize(new Dimension(440, 75));
		sped.setBackground(new Color(51, 26, 0));
    	
		JButton spedButton = new JButton();
		spedButton.setText("Can't use");
	
		spedButton.setEnabled(true);
		spedButton.setText("Increase 1  ");
		if(CessPool.selected.attributeP<1) {
			spedButton.setText("No Points");
			spedButton.setEnabled(false);
		}
		
		spedButton.setFocusable(false);
		spedButton.setFocusPainted(false);
		spedButton.setBackground(new Color(153, 102, 0));
		spedButton.setForeground(Color.white);
		spedButton.setPreferredSize(new Dimension(100, 75));
        spedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	CessPool.selected.speed += 1;
            	CessPool.selected.attributeP -= 1;
        
            	Main.frame.setContentPane(new BagPanel(frame, 5));
                Main.frame.pack();
            }
        });
        
        speedPanel.add(sped, BorderLayout.CENTER);
        speedPanel.add(spedButton, BorderLayout.EAST);
        panel.add(speedPanel);
    
        //Max defence
        JPanel defPanel = new JPanel();
    	defPanel.setLayout(new BorderLayout());
		
    	JLabel deff = new JLabel();
    	deff.setText("Defense : " + CessPool.selected.defence);
		deff.setFocusable(false);
		deff.setHorizontalAlignment(SwingConstants.CENTER);
		deff.setOpaque(true);
		deff.setForeground(Color.WHITE);
		deff.setPreferredSize(new Dimension(440, 75));
		deff.setBackground(new Color(51, 26, 0));
    	
		JButton defButton = new JButton();
		defButton.setText("Can't use");
		defButton.setEnabled(true);
		defButton.setText("Increase 1  ");
		defButton.setPreferredSize(new Dimension(100, 75));
		if(CessPool.selected.attributeP<1) {
			defButton.setText("No Points");
			defButton.setEnabled(false);
		}
		
		defButton.setFocusable(false);
		defButton.setFocusPainted(false);
		defButton.setBackground(new Color(153, 102, 0));
		defButton.setForeground(Color.white);
        defButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	CessPool.selected.accuracy += 1;
            	CessPool.selected.attributeP -= 1;
        
            	Main.frame.setContentPane(new BagPanel(frame, 5));
                Main.frame.pack();
            }
        });
        
        defPanel.add(deff, BorderLayout.CENTER);
        defPanel.add(defButton, BorderLayout.EAST);
        panel.add(defPanel);
    }
}
