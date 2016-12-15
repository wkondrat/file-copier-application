package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PathPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public TextField textField = new TextField();
	public static JLabel label = new JLabel("");

	public PathPanel(String text) {
		setLayout(new FlowLayout());

		textField.setPreferredSize(new Dimension(400, 25));

		textField.setText(setPath());

		add(new JLabel(text));
		add(textField);
		add(label);
	}
	
	public static void sayFileSelected() {
		label.setText("Fle Selected !");
		label.setForeground(Color.GREEN);
	}

	private String setPath() {
		String path = "";
		path = new File(".").getAbsolutePath();
		return path.substring(0, path.length() - 1);
	}
}
