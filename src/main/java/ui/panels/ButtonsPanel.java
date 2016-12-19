package ui.panels;

import javax.swing.JPanel;

import ui.buttons.SelectFileButton;

public class ButtonsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public SelectFileButton select = new SelectFileButton("SELECT FILE");

	public ButtonsPanel() {
		add(select);
	}
}
