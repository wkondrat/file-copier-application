package panels;

import javax.swing.JPanel;

import buttons.Select;

public class ButtonsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public Select select = new Select("SELECT FILE");

	public ButtonsPanel() {
		add(select);
	}
}
