package com.example;

import java.awt.CardLayout;
import java.awt.Color;
<<<<<<< HEAD
import java.awt.Dimension;
=======
>>>>>>> ddb312c0513f2ae37f26da060e681f734d4f774e
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
=======
>>>>>>> ddb312c0513f2ae37f26da060e681f734d4f774e

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class Map extends JPanel{
 
 private Image imgg;
// private int areaWidth;
// private int areaHeight;
// private String text;
// private String text2;
 
 public Map (JFrame frame) {
  
//  this.areaWidth = 1280;
//  this.areaHeight = 750;
//  this.setPreferredSize(new Dimension(areaWidth, areaHeight));
//  this.text = "Lakukan sesuatu menggunakan mouse...";
//  this.text2 = "Mouse Position...";
  
//  this.addMouseMotionListener(this);
//  this.addMouseListener(this);
//  this.setFocusable(true);
  
//  frame.setPreferredSize(new Dimension(1000, 1016));
  this.imgg = new ImageIcon("images/map.jpg").getImage();
  this.setLayout(null);
  
  JButton a_1a = new JButton();
     a_1a.setBounds(615, 628, 25, 25);
     a_1a.setBackground(Color.RED);
     this.add(a_1a);
     
     a_1a.addActionListener(
       new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
        	Main.frame.setContentPane(new BattlePanel(frame));
        	Main.frame.pack();
        }
       }
      );
     
     JButton a_1b = new JButton();
     a_1b.setBounds(681, 565, 25, 25);
     a_1b.setBackground(Color.RED);
     this.add(a_1b);
     
     a_1b.addActionListener(
    	       new ActionListener() {
    	        @Override
    	        public void actionPerformed(ActionEvent event) {
    	        	Main.frame.setContentPane(new BattlePanel(frame));
    	        	Main.frame.pack();
    	        }
    	       }
    	      );

     JButton a_2 = new JButton();
     a_2.setBounds(553, 569, 25, 25);
     a_2.setBackground(Color.RED);
     this.add(a_2);
     
     JButton a_3 = new JButton();
     a_3.setBounds(493, 513, 25, 25);
     a_3.setBackground(Color.RED);
     this.add(a_3);
     
     JButton a_4 = new JButton();
     a_4.setBounds(443, 456, 25, 25);
     a_4.setBackground(Color.RED);
     this.add(a_4);
     
     JButton a_5 = new JButton();
     a_5.setBounds(393, 393, 25, 25);
     a_5.setBackground(Color.RED);
     this.add(a_5);
     
     JButton a_6 = new JButton();
     a_6.setBounds(457, 321, 25, 25);
     a_6.setBackground(Color.RED);
     this.add(a_6);
     
     JButton ab_1 = new JButton();
     ab_1.setBounds(734, 497, 30, 30);
     ab_1.setBackground(Color.RED);
     this.add(ab_1);
     
     ab_1.addActionListener(
       new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
         Main.frame.setContentPane(new ShopPanel(frame));
         Main.frame.pack();
        }
       }
      );
     
     JButton ab_1a = new JButton();
     ab_1a.setBounds(666, 447, 30, 30);
     ab_1a.setBackground(Color.RED);
     this.add(ab_1a);
     
     JButton ab_2a = new JButton();
     ab_2a.setBounds(621, 396, 25, 25);
     ab_2a.setBackground(Color.RED);
     this.add(ab_2a);
     
     JButton ab_3a = new JButton();
     ab_3a.setBounds(623, 332, 25, 25);
     ab_3a.setBackground(Color.RED);
     this.add(ab_3a);
     
     JButton ab_1b = new JButton();
     ab_1b.setBounds(726, 431, 25, 25);
     ab_1b.setBackground(Color.RED);
     this.add(ab_1b);
     
     JButton ab_2b = new JButton();
     ab_2b.setBounds(717, 362, 25, 25);
     ab_2b.setBackground(Color.RED);
     this.add(ab_2b);
     
     JButton ab_3b = new JButton();
     ab_3b.setBounds(693, 317, 25, 25);
     ab_3b.setBackground(Color.RED);
     this.add(ab_3b);
     
     JButton b_1 = new JButton();
     b_1.setBounds(795, 611, 25, 25);
     b_1.setBackground(Color.RED);
     this.add(b_1);
     
     JButton b_2 = new JButton();
     b_2.setBounds(860, 566, 25, 25);
     b_2.setBackground(Color.RED);
     this.add(b_2);
     
     JButton b_3 = new JButton();
     b_3.setBounds(914, 504, 25, 25);
     b_3.setBackground(Color.RED);
     this.add(b_3);
     
     JButton b_4 = new JButton();
     b_4.setBounds(909, 374, 25, 25);
     b_4.setBackground(Color.RED);
     this.add(b_4);
     
     JButton b_5 = new JButton();
     b_5.setBounds(853, 328, 25, 25);
     b_5.setBackground(Color.RED);
     this.add(b_5);
     
     JButton b_6 = new JButton();
     b_6.setBounds(805, 295, 25, 25);
     b_6.setBackground(Color.RED);
     this.add(b_6);
     
     JButton boss_besar = new JButton();
     boss_besar.setBounds(600, 120, 75, 75);
     boss_besar.setBackground(Color.RED);
     this.add(boss_besar);
     
     JButton cuhp = new JButton();
     cuhp.setBounds(300, 120, 200, 75);
     cuhp.setText("HP is currently " + CessPool.selected.currHP);
     cuhp.setBackground(Color.RED);
     this.add(cuhp);
     
 }
 
 public void paintComponent(Graphics g) {
  super.paintComponent(g);
  g.drawImage(this.imgg, 140, 0, null);
//  g.drawString(this.text, 0, this.areaHeight / 2);
//  g.drawString(this.text2, 0, this.areaHeight / 30);
 }
 
// public void mouseClicked(MouseEvent e) {
//  this.text = "Tombol mouse diklik pada posisi X: " + e.getX() +" Y: " + e.getY();
//  repaint();
// }
// public void mousePressed(MouseEvent e) {
//  this.text = "Tombol mouse ditekan pada posisi X: " + e.getX() +" Y: " + e.getY();
//  repaint();
// }
// public void mouseReleased(MouseEvent e) {
//  this.text = "Tombol mouse dilepas pada posisi X: " + e.getX() +" Y: " + e.getY();
//  repaint();
// }
// public void mouseEntered(MouseEvent e) {
//  this.text = "Mouse memasuki area MousePanel";
//  repaint();
// }
// public void mouseExited(MouseEvent e) {
//  this.text = "Mouse meninggalkan area MousePanel";
//  repaint();
// }
// @Override
// public void mouseDragged(MouseEvent e) {
//  this.text2 = "Position X: " + e.getX() + " Y: " + e.getY() + " Dragged";
//  repaint();
// }
// @Override
// public void mouseMoved(MouseEvent e) {
//  this.text2 = "Position X: " + e.getX() + " Y: " + e.getY();
//  repaint();
// }
}
