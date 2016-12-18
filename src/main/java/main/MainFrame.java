package main;

import javax.swing.JFrame;

import ui.panels.MainPanel;

public class MainFrame {
	
	public static MainPanel mainPanel = new MainPanel();

	public static void main(String[] args) {
		JFrame f = new JFrame("File Copier");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		f.add(mainPanel);
		f.pack();

		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
