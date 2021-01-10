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
	public static StartPanel start;
	public static CharacterSelectPanel characterSelect;
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			 public void run() {
				 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 new CessPool();
				 start = new StartPanel("images/StartPanel.jpg", frame, cardLayout, mainPanel);
				 characterSelect = new CharacterSelectPanel("images/StartPanel.jpg", frame, cardLayout, mainPanel);
				 
				 mainPanel.add(start, "start");
			     mainPanel.add(characterSelect, "characterSelect");
			     
			     frame.add(mainPanel);
			     cardLayout.show(mainPanel, "start");

//			     frame.setContentPane(new BattlePanel(frame));
//			     frame.setContentPane(new ShopPanel(frame, 0));			     
//			     frame.setContentPane(new RestPanel());
			     
			     frame.pack();
			     frame.setLocationRelativeTo(null);
			     frame.setResizable(false);
			     frame.setVisible(true);
			    }
		});
	}
}