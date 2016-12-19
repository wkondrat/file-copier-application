package ui.buttons;

import javax.swing.JButton;

import ui.listeners.CopyFileListener;

public class SelectFileButton extends JButton{

	private static final long serialVersionUID = 1L;

	public SelectFileButton (String text) {
		this.addActionListener(new CopyFileListener());
		this.setText(text);
	}
}
