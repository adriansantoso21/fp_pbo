package com.example;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class ItemsPanel extends JPanel {

	public ItemsPanel() {
		GridLayout potionGrid = new GridLayout(4, 4);
		this.setLayout(potionGrid);
		for(Inventory po : CessPool.selected.inventory) {
			if (po instanceof Potion) {
				JButton sumn = new JButton();
				sumn.setText(po.name);
				this.add(sumn);
			}
		}
	}
	
}
