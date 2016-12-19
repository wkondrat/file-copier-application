package main;

import javax.swing.JFrame;

import ui.panels.MainPanel;

public class MainFrame {
	

	public static void main(String[] args) {
		MainPanel mainPanel = new MainPanel();
		String frameName = "File Copier";
		JFrame frame = new JFrame(frameName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		frame.add(mainPanel);
		frame.pack();

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
