package ui.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.io.File;

import javax.swing.JPanel;

public class PathPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public TextField textField = new TextField();

	public PathPanel(String text) {
		setLayout(new FlowLayout());
		textField.setPreferredSize(new Dimension(400, 25));
		textField.setText(getInitialPath());
		add(textField);
	}
	

	private String getInitialPath() {
		String path = new File(".").getAbsolutePath();
		return path.substring(0, path.length() - 1);
	}
}
