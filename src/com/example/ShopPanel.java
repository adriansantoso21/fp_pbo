package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class ShopPanel extends JPanel{

 public ShopPanel(JFrame frame){
  GridLayout total = new GridLayout(1,2);
  GridLayout grdLayout = new GridLayout(1, 4);
  GridLayout item_sold = new GridLayout(4, 1);
  
  JPanel item = new JPanel();
  JPanel kiri = new JPanel();
  JPanel kanan = new JPanel();
  JPanel kanan_bawah = new JPanel();
  
  JButton armor = new JButton("Armor");
  armor.setPreferredSize(new Dimension(160, 60));
  
  armor.addActionListener(
       new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
         JTextPane ta = new JTextPane();
               ta.setEditable(false);
               ta.setContentType("text/html");
               ta.setText("<html><h3 style=\"color:white;\">· Name : Wizard <br>"
                 +"· Very Good in magic <br>"
                 + "· High Mana <br>"
                 + "· Low Defence</h3> </html>");
               ta.setBackground(Color.black);
               ta.setBounds(150, 400, 200, 117);
//               this.add(ta);
         Armor a1 = new Armor("Sunlight armor", 30, 60, 45, 15, 20);
         
        }
       }
     );
  
  JButton weapon = new JButton("Weapon");
  weapon.setPreferredSize(new Dimension(160, 60));
  
  weapon.addActionListener(
       new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
        }
       }
     );
  
  JButton potion = new JButton("Potion");
  potion.setPreferredSize(new Dimension(160, 60));
  
  potion.addActionListener(
       new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
        }
       }
     );
  
        JButton skill = new JButton("Skill");
        skill.setPreferredSize(new Dimension(160, 60));
        
        skill.addActionListener(
       new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
        }
       }
     );
        
  kanan_bawah.setLayout(item_sold);
        item.setLayout(grdLayout);
        item.add(armor);
        item.add(weapon);
        item.add(potion);
        item.add(skill);
        kanan.add(item);
        kanan.add(kanan_bawah);
        
        
        
        this.setLayout(total);
        this.add(kiri);
        this.add(kanan);
        
        kanan.add(BorderLayout.NORTH, item);
        kanan.add(BorderLayout.CENTER, kanan_bawah);
        kiri.setPreferredSize(new Dimension(640, 375));
        kanan.setPreferredSize(new Dimension(640, 375));
 }
}