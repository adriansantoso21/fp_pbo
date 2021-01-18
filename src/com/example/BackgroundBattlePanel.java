package com.example;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BackgroundBattlePanel extends JPanel {
	Image imgg = new ImageIcon("images/battlegrounds2.jpg").getImage();
	private Character fighter;
	private int current;
	JButton a, b, c;
	
	public BackgroundBattlePanel(Character fighter) {
		this.fighter = fighter;
	}
	
	public void addButton(JButton a, JButton b, JButton c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public int getCurrent() {
		return current;
	}
	
	public void disableButtons() {
		a.setEnabled(false);
		b.setEnabled(false);
		c.setEnabled(false);
	}
	
	public void enableButtons() {
		a.setEnabled(true);
		b.setEnabled(true);
		c.setEnabled(true);
	}
	
	public void startAttackThread() {
		Thread animThread = new Thread() {
			public void run() {
				fighter.now = 0;
				current = 1;
				disableButtons();
				for(int i = 0; i<fighter.getAttackImageSize(); i++) {
					fighter.AttackAnimation();
					repaint();
					try {
						Thread.sleep(170);
					} catch (InterruptedException ex) {}
				}
				current = 0;
				startIdleThread();
				enableButtons();
			}
		};
		animThread.start();
	}
	
	public void startIdleThread() {
		Thread idleThread = new Thread() {
			public void run() {
				fighter.idlenow = 0;
				while(current == 0) {
					fighter.IdleAnimation();
					repaint();
					try {
						Thread.sleep(220);
					} catch (InterruptedException ex) {}
				}
			}
		};
		idleThread.start();
	}
	
	public void startSpellThread() {
		Thread spellThread = new Thread() {
			public void run() {
				fighter.spellnow = 0;
				current = 2;
				disableButtons();
				for(int i = 0; i<fighter.getSpellImageSize(); i++) {
					fighter.SpellAnimation();
					repaint();
					try {
						Thread.sleep(170);
					} catch (InterruptedException ex) {}
				}
				current = 0;
				startIdleThread();
				enableButtons();
			}
		};
		spellThread.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imgg, -200, -300, null);
		fighter.draw(g);
	}
}
