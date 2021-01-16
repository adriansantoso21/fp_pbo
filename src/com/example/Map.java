package com.example;

import java.awt.CardLayout; 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class Map extends JPanel implements MouseListener, MouseMotionListener{
 
 private Image imgg;
 ArrayList <Map_Button> buttons = new ArrayList<Map_Button>();
 public int last = CessPool.location.get(CessPool.location.size()-1);
 private int areaWidth;
 private int areaHeight;
 private String text;
 private String text2;

 
 public Map (JFrame frame) {
  
	  this.areaWidth = 1280;
	  this.areaHeight = 750;
	  this.setPreferredSize(new Dimension(areaWidth, areaHeight));
	  
	  this.text = "Lakukan sesuatu menggunakan mouse...";
	  this.text2 = "Mouse Position...";
	  
	  this.addMouseMotionListener(this);
	  this.addMouseListener(this);
	  
	  this.setFocusable(true);

	 
	  this.imgg = new ImageIcon("images/map.jpg").getImage();
	  this.setLayout(null);
	  
	  buttons.add(new Map_Button(1058, 690, 2, false));
	  buttons.add(new Map_Button(993 , 684, 2, false));
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
	  buttons.add(new Map_Button(536, 377, 2, false));
	  buttons.add(new Map_Button(455, 440, 2, false));
	  buttons.add(new Map_Button(516, 436, 2, false));
	  buttons.add(new Map_Button(573, 366, 1, false));//shop
	  buttons.add(new Map_Button(681, 380, 2, false));
	  buttons.add(new Map_Button(716, 336, 3, false));//rest
	  buttons.add(new Map_Button(633, 134, 2, false));
	  
	  for(Map_Button a : buttons) {
		  this.add(a);
	  }
	  
	  for(Map_Button a : buttons) {
		  if(a.type == 1) {
			  a.addActionListener(
		    	       new ActionListener() {
		    	        @Override
		    	        public void actionPerformed(ActionEvent event) {
		    	        	int b = buttons.indexOf(a);
		    	        	CessPool.location.add(b);
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
		    	        	int b = buttons.indexOf(a);
		    	        	CessPool.location.add(b);
		    	        	Main.frame.setContentPane(new BattlePanel(frame));
		    			    Main.frame.pack();
		    	        }
		    	       }
		    );
		  }
		  
		  else if (a.type == 3) {
			  a.addActionListener(
		    	       new ActionListener() {
		    	        @Override
		    	        public void actionPerformed(ActionEvent event) {
		    	        	int b = buttons.indexOf(a);
		    	        	CessPool.location.add(b);
		    	        	Main.frame.setContentPane(new RestPanel(frame));
		    			    Main.frame.pack();
		    	        }
		    	       }
		    );
		  }
	  }
    
	  //Enable Map Battle
	  if(this.last == -1 || this.last == 0 ||this.last == 1 || this.last == 4 || this.last == 5 || this.last == 7 || this.last == 8 || 
			  this.last == 9 || this.last == 10 || this.last == 12 || this.last == 13 || this.last == 14 || this.last == 16 ||
					  this.last == 18 || this.last == 20 || this.last == 21 || this.last == 22 ) {
		  buttons.get(this.last + 1).setEnabled(true);
	  }
	  else if (this.last == 2 || this.last == 3){
		  buttons.get(3).setEnabled(true);
		  buttons.get(4).setEnabled(true);
		  buttons.get(7).setEnabled(true);
	  }
	  else if(this.last == 6 || this.last == 11) {
		  buttons.get(12).setEnabled(true);
	  }
	  else if(this.last == 15) {
		  buttons.get(16).setEnabled(true);
		  buttons.get(18).setEnabled(true);
	  }
	  else if(this.last == 17 || this.last == 19) {
		  buttons.get(20).setEnabled(true);
	  }
	  
	  for(Integer a : CessPool.location) {
		  if(a !=-1) {
			  buttons.get(a).setOpaque(true);
			  buttons.get(a).setFont(new Font("Arial", Font.BOLD, 11));
			  buttons.get(a).setText("x");
			  buttons.get(a).setForeground(Color.white);
		  }
	  }
	  

     //Currently Hp
     ImageIcon Img1 = new ImageIcon("images/hp.png");   
     JButton cuhp = new JButton("    HP is currently " + CessPool.selected.currHP, Img1);
     cuhp.setBounds(0, 0, 250, 50);
     cuhp.setBackground(Color.white);
     this.add(cuhp);
     
     //Currently Gold
     ImageIcon Img = new ImageIcon("images/coin.png");     
     JButton cugo = new JButton("       Gold is currently " + CessPool.selected.gold, Img);
     cugo.setBounds(0, 50, 250, 50);
     cugo.setBackground(new Color(173, 78, 5));
     cugo.setForeground(Color.yellow);
     this.add(cugo);
     
     //Currently Mana
     ImageIcon Img2 = new ImageIcon("images/mana.png"); 
     JButton cumana = new JButton("         Mana is currently " + CessPool.selected.currMana, Img2);
     cumana.setBounds(0, 100, 250, 50);
     cumana.setBackground(new Color(0, 0, 102));
     cumana.setForeground(new Color(0, 255, 255));
     this.add(cumana);
     
     //Bag
     ImageIcon Img3 = new ImageIcon("images/bag.png"); 
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
         Main.frame.setContentPane(new BagPanel(frame, -1));
         Main.frame.pack();
        }
       }
      );
     
 }
 
	 public void paintComponent(Graphics g) {
	  super.paintComponent(g);
	  g.drawImage(this.imgg, 0, 0, null);
	  g.drawString(this.text, 0, this.areaHeight / 2);
	  g.drawString(this.text2, 0, this.areaHeight / 3);
	 }
	 
	 public void mouseClicked(MouseEvent e) {
			this.text = "Tombol mouse diklik pada posisi X: " + e.getX() +" Y: " + e.getY();
			repaint();
		}
		public void mousePressed(MouseEvent e) {
			this.text = "Tombol mouse ditekan pada posisi X: " + e.getX() +" Y: " + e.getY();
			repaint();
		}
		public void mouseReleased(MouseEvent e) {
			this.text = "Tombol mouse dilepas pada posisi X: " + e.getX() +" Y: " + e.getY();
			repaint();
		}
		public void mouseEntered(MouseEvent e) {
			this.text = "Mouse memasuki area MousePanel";
			repaint();
		}
		public void mouseExited(MouseEvent e) {
			this.text = "Mouse meninggalkan area MousePanel";
			repaint();
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			this.text2 = "Position X: " + e.getX() + " Y: " + e.getY() + " Dragged";
			repaint();
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			this.text2 = "Position X: " + e.getX() + " Y: " + e.getY();
			repaint();
		}
}
