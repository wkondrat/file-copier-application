package ui.panels;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final String PATH_PREFIX = "File PATH: ";
	
	public PathPanel namePanel = new PathPanel(PATH_PREFIX);
	public ButtonsPanel buttonsPanel = new ButtonsPanel();
	
	public MainPanel() {
		setBackground(new Color(200,200,200));
		setLayout(new BorderLayout());
		
		add(namePanel, BorderLayout.NORTH);
		add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	
}
