package buttons;

import javax.swing.JButton;

import events.CopyFile;

public class Select extends JButton{

	private static final long serialVersionUID = 1L;

	public Select (String text) {
		this.addActionListener(new CopyFile());
		this.setText(text);
	}
}
