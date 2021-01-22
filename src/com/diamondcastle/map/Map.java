package com.diamondcastle.map;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.diamondcastle.cesspool.CessPool;
import com.diamondcastle.gameplaypanel.BattlePanel;
import com.diamondcastle.gameplaypanel.FinalBossPanel;
import com.diamondcastle.gameplaypanel.RestPanel;
import com.diamondcastle.inventorypanel.BagPanel;
import com.diamondcastle.inventorypanel.ShopPanel;
import com.diamondcastle.main.Main;
import com.diamondcastle.music.musicPlay;

public class Map extends JPanel{
 
 private Image imgg;
 ArrayList <Map_Button> buttons = new ArrayList<Map_Button>();
 public static int last = CessPool.location.get(CessPool.location.size()-1);
 private int areaWidth;
 private int areaHeight;
 public static musicPlay music2 = new musicPlay();
 
 public Map (JFrame frame) {
	 music2.playMusic("map.wav");
	 music2.musicLoop();
	  this.areaWidth = 1280;
	  this.areaHeight = 750;
	  this.setPreferredSize(new Dimension(areaWidth, areaHeight));
	  this.setFocusable(true);

	  this.imgg = new ImageIcon("resource/images/map.jpg").getImage();
	  this.setLayout(null);
	  
	  buttons.add(new Map_Button(1050, 674, 2, false));
	  buttons.add(new Map_Button(986 , 670, 2, false));
	  buttons.add(new Map_Button(924, 637, 2,false));
	  buttons.add(new Map_Button(857, 584, 1, false));//shop
	  buttons.add(new Map_Button(771, 501, 2, false));
	  buttons.add(new Map_Button(693, 473, 2, false));
	  buttons.add(new Map_Button(572, 491, 3, false));//rest
	  buttons.add(new Map_Button(819, 583, 2,false));
	  buttons.add(new Map_Button(769, 637, 2, false));
	  buttons.add(new Map_Button(678, 652, 2, false));
	  buttons.add(new Map_Button(620, 636, 2, false));
	  buttons.add(new Map_Button(545 , 567, 1, false));//shop
	  buttons.add(new Map_Button(503, 555, 2, false));
	  buttons.add(new Map_Button(402, 551, 2, false));
	  buttons.add(new Map_Button(392, 495, 3, false));//rest
	  buttons.add(new Map_Button(348, 411, 1,false));//shop
	  buttons.add(new Map_Button(418, 388, 2, false));
	  buttons.add(new Map_Button(536, 377, 3, false));
	  buttons.add(new Map_Button(455, 440, 2, false));
	  buttons.add(new Map_Button(516, 436, 2, false));
	  buttons.add(new Map_Button(573, 366, 1, false));//shop
	  buttons.add(new Map_Button(681, 380, 2, false));
	  buttons.add(new Map_Button(716, 336, 3, false));//rest
	  buttons.add(new Map_Button(633, 134, 2, false));
	  
	  for(Map_Button a : buttons) {
		  this.add(a);
	  }
	  
	  last = CessPool.location.get(CessPool.location.size()-1);
	  
	  //Enable Map Battle
	  if(Map.last == -1 || Map.last == 0 ||Map.last == 1 || Map.last == 4 || Map.last == 5 || Map.last == 7 || Map.last == 8 || 
			  Map.last == 9 || Map.last == 10 || Map.last == 12 || Map.last == 13 || Map.last == 14 || Map.last == 16 ||
					  Map.last == 18 || Map.last == 20 || Map.last == 21 || Map.last == 22 ) {
		  buttons.get(Map.last + 1).setEnabled(true);
	  }
	  else if (Map.last == 2 || Map.last == 3){
		  buttons.get(3).setEnabled(true);
		  buttons.get(4).setEnabled(true);
		  buttons.get(7).setEnabled(true);
	  }
	  else if(Map.last == 6 || Map.last == 11) {
		  buttons.get(12).setEnabled(true);
	  }
	  else if(Map.last == 15) {
		  buttons.get(16).setEnabled(true);
		  buttons.get(18).setEnabled(true);
	  }
	  else if(Map.last == 17 || Map.last == 19) {
		  buttons.get(20).setEnabled(true);
	  }
	  
	  Image img = new ImageIcon("resource/button/x.png").getImage();
		
	  for(Integer a : CessPool.location) {
		  if(a !=-1) {
			  buttons.get(a).setOpaque(true);
			  buttons.get(a).setIcon(new ImageIcon(img));
		  }
	  }
	  
	  for(Map_Button a : buttons) {
		  if(a.type == 1) {
			  a.addActionListener(
		    	       new ActionListener() {
		    	        @Override
		    	        public void actionPerformed(ActionEvent event) {
		    	        	music2.stopMusic();
		    	        	int b = buttons.indexOf(a);
		    	        	CessPool.location.add(b);
		    	        	music2.playMusic("resource/song/bag_shop_rest.wav");
		    	        	Main.frame.setContentPane(new ShopPanel(frame, -1, 'y'));
		    			    Main.frame.pack();
		    	        }
		    	       }
		    );
		  }
		  
		  else if (a.type == 2) {
			  a.addActionListener(
		    	       new ActionListener() {
		    	        @Override
		    	        public void actionPerformed(ActionEvent event) {
		    	        	music2.stopMusic();
		    	        	int b = buttons.indexOf(a);
		    	        	CessPool.location.add(b);
		    	        	
		    	        	Random rand = new Random();
		    	        	int int_random = rand.nextInt(3);
		    	        	
		    	        	if(int_random == 0) {
		    	        		music2.playMusic("battle1.wav");
		    	        	}
		    	        	
							if(int_random == 1) {
								music2.playMusic("battle2.wav");
		    	        	}
							
							if(int_random == 2) {
								music2.playMusic("battle3.wav");
		    	        	}
		    	        	
		    	        	if(Map.last == 22) {
		    	        		music2.stopMusic();
		    	        		music2.playMusic("finalbattle.wav");
		    	        		Main.frame.setContentPane(new FinalBossPanel(frame));
			    			    Main.frame.pack();
		    	        	}
		    	        	else {
		    	        		Main.frame.setContentPane(new BattlePanel(frame));
			    			    Main.frame.pack();
		    	        	}
							
		    	        }
		    	       }
		    );
		  }
		  
		  else if (a.type == 3) {
			  a.addActionListener(
		    	       new ActionListener() {
		    	        @Override
		    	        public void actionPerformed(ActionEvent event) {
		    	        	music2.stopMusic();
		    	        	int b = buttons.indexOf(a);
		    	        	CessPool.location.add(b);
		    	        	music2.playMusic("resource/song/bag_shop_rest.wav");
		    	        	last = CessPool.location.get(CessPool.location.size()-1);
		    	        	Main.frame.setContentPane(new RestPanel(frame));
		    			    Main.frame.pack();
		    	        }
		    	       }
		    );
		  }
	  }
    

	  

     //Current Hp
     ImageIcon Img1 = new ImageIcon("resource/images/hp.png");   
     JButton cuhp = new JButton("    HP is currently " + CessPool.selected.currHP, Img1);
     cuhp.setBounds(0, 0, 250, 50);
     cuhp.setBackground(Color.white);
     this.add(cuhp);
     
     //Current Gold
     ImageIcon Img = new ImageIcon("resource/images/coin.png");     
     JButton cugo = new JButton("       Gold is currently " + CessPool.selected.gold, Img);
     cugo.setBounds(0, 50, 250, 50);
     cugo.setBackground(new Color(173, 78, 5));
     cugo.setForeground(Color.yellow);
     this.add(cugo);
     
     //Current Mana
     ImageIcon Img2 = new ImageIcon("resource/images/mana.png"); 
     JButton cumana = new JButton("         Mana is currently " + CessPool.selected.currMana, Img2);
     cumana.setBounds(0, 100, 250, 50);
     cumana.setBackground(new Color(0, 0, 102));
     cumana.setForeground(new Color(0, 255, 255));
     this.add(cumana);
     
     //Bag
     ImageIcon Img3 = new ImageIcon("resource/images/bag.png"); 
     JButton Bag = new JButton("Your Bag", Img3);
     Bag.setForeground(Color.white);
     Bag.setBackground(new Color(51, 0, 16));
     Bag.setForeground(new Color(255, 153, 0));
     Bag.setBounds(0, 665, 150, 50);
     this.add(Bag);
     
     Bag.addActionListener(
       new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
        	music2.stopMusic();
        	music2.playMusic("song/bag_shop_rest.wav");
        	Main.frame.setContentPane(new BagPanel(frame, -1));
        	Main.frame.pack();
        }
       }
      );
     
 }
 
	 public void paintComponent(Graphics g) {
	  super.paintComponent(g);
	  g.drawImage(this.imgg, 0, 0, null);
	 }
	 
}
