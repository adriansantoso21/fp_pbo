package com.example;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	public static CardLayout cardLayout = new CardLayout();
	public static JPanel mainPanel = new JPanel(cardLayout);
	public static JFrame frame = new JFrame("Diamond Castle");
	static public BattlePanel battlepane;
	public static StartPanel start;
	public static CharacterSelectPanel characterSelect;
	public static Map map;
	static public ShopPanel shoppane;
	static public BagPanel bagpane;
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			 public void run() {
				 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 new CessPool();
				 battlepane = new BattlePanel(frame);
				 start = new StartPanel("images/StartPanel.jpg", frame, cardLayout, mainPanel);
				 characterSelect = new CharacterSelectPanel("images/StartPanel.jpg", frame, cardLayout, mainPanel);
				 map = new Map("images/map.jpg", frame, cardLayout, mainPanel);
				 shoppane = new ShopPanel(frame, cardLayout, mainPanel);
				 bagpane = new BagPanel(frame, cardLayout, mainPanel);
				 
				 mainPanel.add(start, "start");
			     mainPanel.add(characterSelect, "characterSelect");
			     mainPanel.add(map, "map");
			     mainPanel.add(battlepane, "battlepane");
			     mainPanel.add(shoppane, "shoppane");
			     mainPanel.add(bagpane, "bagpane");
			     
			     frame.add(mainPanel);
			     cardLayout.show(mainPanel, "start");
			     
			     frame.pack();
			     frame.setLocationRelativeTo(null);
			     frame.setResizable(false);
			     frame.setVisible(true);
			    }
			   });
			 }
			}