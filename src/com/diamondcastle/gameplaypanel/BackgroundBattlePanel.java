package com.diamondcastle.gameplaypanel;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.diamondcastle.creature.Character;

import com.diamondcastle.cesspool.CessPool;

public class BackgroundBattlePanel extends JPanel {
	private ArrayList<Image> backgrounds = new ArrayList<Image>();
	Image imgg = new ImageIcon("images/battlegrounds2.jpg").getImage();
	private Character fighter;
	private int current, bg;
	JButton a, b, c;
	
	public BackgroundBattlePanel(Character fighter) {
		this.fighter = fighter;
		backgrounds.add(new ImageIcon("resource/images/battlegrounds2.jpg").getImage());
		backgrounds.add(new ImageIcon("resource/images/bg2.jpg").getImage());
		backgrounds.add(new ImageIcon("resource/images/bg3.jpg").getImage());
		backgrounds.add(new ImageIcon("resource/images/finalboss.jpg").getImage());
		this.bg = CessPool.location.get(CessPool.location.size()-1);
		
		if(bg<8) {
			this.imgg = backgrounds.get(0);
		}
		else if(bg<15) {
			this.imgg = backgrounds.get(1);
		}
		else if(bg<22) {
			this.imgg = backgrounds.get(2);
		}
		else if(bg==22) {
			this.imgg = backgrounds.get(3);
		}
	}
	
	public void addButton(JButton a, JButton b, JButton c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public int getCurrent() {
		return current;
	}
	
	public void setCurrent(int eyh) {
		this.current = eyh;
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
		disableButtons();
		Thread animThread = new Thread() {
			public void run() {
				fighter.now = 0;
				current = 1;
				for(int i = 0; i<fighter.getAttackImageSize(); i++) {
					fighter.AttackAnimation();
					repaint();
					try {
						Thread.sleep(170);
					} catch (InterruptedException ex) {}
				}
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
				current = 0;
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
				startIdleThread();
				enableButtons();
			}
		};
		spellThread.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(bg>=8 && bg<16) {
			g.drawImage(this.imgg, 0, 0, null);
		}
		else if(bg == 22) {
			g.drawImage(this.imgg, -50, -500, null);
		}
		else {
			g.drawImage(this.imgg, -200, -300, null);
		}
		fighter.draw(g);
	}
}
