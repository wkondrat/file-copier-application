package ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import logic.CopyTask;
import logic.impl.CopyTaskFactory;

public class CopyFileListener implements ActionListener {

	private static final Logger logger = LogManager.getLogger(CopyFileListener.class);

	private File chooseSourceFile() {
		JFileChooser fileChooser = new JFileChooser();
		int valueOfSelectedFileOption = fileChooser.showDialog(null, "Select File");
		if (valueOfSelectedFileOption == JFileChooser.CANCEL_OPTION) {
			logger.debug("Canceled choice of file");
			JOptionPane.showMessageDialog(null, "Canceled choice of file");
			System.exit(0);
		}
		
		if (valueOfSelectedFileOption == JFileChooser.APPROVE_OPTION) {
			String filePath = fileChooser.getSelectedFile().getAbsolutePath();
			return new File(filePath);
		}
		
		return null;
	}
	
	private File chooseDirectory() {
		JFileChooser destinationDirectory = new JFileChooser();
		destinationDirectory.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		int valueOfSelectedDirectoryOption = destinationDirectory.showDialog(null, "Select Folder");
		if (valueOfSelectedDirectoryOption == JFileChooser.CANCEL_OPTION) {
			logger.debug("Canceled choice of directory");
			JOptionPane.showMessageDialog(null, "Canceled choice of directory");
			System.exit(0);
		}
		
		if (valueOfSelectedDirectoryOption == JFileChooser.APPROVE_OPTION) {
			String destinationPath = destinationDirectory.getSelectedFile().getAbsolutePath();
			return new File(destinationPath);
		}
		
		return null;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		File source = chooseSourceFile();
		
		if (source != null) {
			File directory = chooseDirectory();
			if (directory != null) {
				File target = new File(directory, "copy-" + source.getName());
				CopyTask copyTask = new CopyTaskFactory().getCopyTask(source, target);
				copyTask.perform();
			}	
		}	
	}
}
