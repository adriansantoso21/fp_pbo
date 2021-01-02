package com.example;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SkillsPanel extends JPanel {
	
	public SkillsPanel() {
		GridLayout potionGrid = new GridLayout(4, 4);
		this.setLayout(potionGrid);
		
		for(Skill po : CessPool.selected.skills) {
			JButton sumn = new JButton();
			sumn.setText(po.name);
			this.add(sumn);
		}
	}

}
