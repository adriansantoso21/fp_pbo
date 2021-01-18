//package com.example;
//
//public class credit {
//	
//	
//	//animasi credit naik dari bawah panel
//	public void startThread() {
//		Thread creditThread = new Thread() {
//			public void run() {
//				while(true) {
//					heightLabel -= 1;
//					creditLabel.setBounds(0,heightLabel,800,600); //ndek sini naik e, creditLabel itu text mu.
//					try {
//						if(heightLabel <= -600) {
//							backButton.setVisible(true);
//							return;
//						}
//						Thread.sleep(10);
//					}
//					catch (InterruptedException ex) { }
//				}
//			}
//		};
//		creditThread.start();
//	}
//
//
//
//	//timer utk animation text
//	Timer timer = new Timer(75, new ActionListener() {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			String labelText = narationLabel.getText();
//			if(text.charAt(charIndex) == '<') {
//				while(text.charAt(charIndex) != '>') {
//					labelText += text.charAt(charIndex);
//					charIndex++;
//				}
//			}
//			else if(text.charAt(charIndex) == '&') {
//				while(text.charAt(charIndex) != 'p') {
//					labelText += text.charAt(charIndex);
//					charIndex++;
//				}
//			}
//			labelText += text.charAt(charIndex);
//			narationLabel.setText(labelText);
//			charIndex += 1;
//			if (charIndex >= text.length()) {
//				nextLabel.setVisible(true);
//				((Timer) e.getSource()).stop();
//			}
//		}
//	});
//	timer.start();
//}
