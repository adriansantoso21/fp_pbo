package com.diamondcastle.main;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.diamondcastle.beginningpanel.CharacterSelectPanel;
import com.diamondcastle.beginningpanel.StartPanel;
import com.diamondcastle.cesspool.CessPool;
import com.diamondcastle.gameplaypanel.FinalBossPanel;

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
				 
//			     frame.setContentPane(new StartPanel("resource/images/StartPanel.jpg", frame));
			     frame.setContentPane(new FinalBossPanel(frame));
			     
			     frame.pack();
			     frame.setLocationRelativeTo(null);
			     frame.setResizable(false);
			     frame.setVisible(true);
			    }
		});
	}
}