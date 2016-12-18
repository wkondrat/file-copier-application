package ui.buttons;

import javax.swing.JButton;

import ui.listeners.CopyFileListener;

public class SelectFileBtn extends JButton{

	private static final long serialVersionUID = 1L;

	public SelectFileBtn (String text) {
		this.addActionListener(new CopyFileListener());
		this.setText(text);
	}
}
