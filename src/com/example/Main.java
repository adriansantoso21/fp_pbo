package com.example;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	public static JFrame frame = new JFrame("Diamond Castle");
	public static StartPanel start;
	public static CharacterSelectPanel characterSelect;
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			 public void run() {
				 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 new CessPool();
				 frame.setPreferredSize(new Dimension(1280, 750));
				 
			     Main.frame.setContentPane(new StartPanel("images/StartPanel.jpg", frame));
//			     Main.frame.setContentPane(new VideoCredit());
//				 Main.frame.setContentPane(new VideoCharacterSelectPanel(frame));
			     
			     frame.pack();
			     frame.setLocationRelativeTo(null);
			     frame.setResizable(false);
			     frame.setVisible(true);
			    }
		});
	}
}