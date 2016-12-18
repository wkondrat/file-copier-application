package ui.panels;

import javax.swing.JPanel;

import ui.buttons.SelectFileBtn;

public class ButtonsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public SelectFileBtn select = new SelectFileBtn("SELECT FILE");

	public ButtonsPanel() {
		add(select);
	}
}
