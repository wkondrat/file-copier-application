package ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import logic.CopyTask;
import logic.exceptions.DirectoryDoesNotExistException;
import logic.exceptions.FileDoesNotExistException;
import logic.exceptions.ReadPermissionException;
import logic.exceptions.WritePermissionException;
import logic.impl.CopyTaskFactory;
import logic.validators.Validators;

public class CopyFileListener implements ActionListener {

	private static final Logger logger = LogManager.getLogger(CopyFileListener.class);
	private static final String PREFIX = "copy-";
	private static final String COPY_ERROR_MESSAGE = "Sorry, can't copy file";
	
	public void actionPerformed(ActionEvent arg0) {
		File source = chooseSourceFile();
		validateFile(source);

		if (source != null) {
			File directory = chooseDirectory();
			validateDirectory(directory);
			
			if (directory != null) {
				File target = new File(directory, PREFIX + source.getName());
				CopyTask copyTask = new CopyTaskFactory().getCopyTask(source, target);
				copyTask.perform();
			}
		}
	}

	private void validateDirectory(File directory) {
		try {
			Validators.existDirectoryValidator(directory);
			Validators.isDirectoryWrittable(directory.toPath());
		} catch (DirectoryDoesNotExistException e) {
			JOptionPane.showMessageDialog(null, COPY_ERROR_MESSAGE);
			System.exit(0);
		} catch (WritePermissionException e) {
			JOptionPane.showMessageDialog(null, COPY_ERROR_MESSAGE);
			System.exit(0);
		}
	}

	private void validateFile(File source) {
		try {
			Validators.existFileValidator(source);
			Validators.isFileReadable(source.toPath());
		} catch (FileDoesNotExistException e) {
			JOptionPane.showMessageDialog(null, COPY_ERROR_MESSAGE);
			System.exit(0);
		} catch (ReadPermissionException e) {
			JOptionPane.showMessageDialog(null, COPY_ERROR_MESSAGE);
			System.exit(0);
		}
	}
	
	private File chooseSourceFile() {
		JFileChooser fileChooser = new JFileChooser();
		int valueOfSelectedFileOption = fileChooser.showDialog(null, "Select File");
		if (valueOfSelectedFileOption == JFileChooser.CANCEL_OPTION) {
			String CanceledChoice = "Canceled choice of file";
			logger.info(CanceledChoice);
			JOptionPane.showMessageDialog(null, CanceledChoice);
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
			String CanceledChoice = "Canceled choice of directory";
			logger.info(CanceledChoice);
			JOptionPane.showMessageDialog(null, CanceledChoice);
			System.exit(0);
		}
		
		if (valueOfSelectedDirectoryOption == JFileChooser.APPROVE_OPTION) {
			String destinationPath = destinationDirectory.getSelectedFile().getAbsolutePath();
			return new File(destinationPath);
		}
		
		return null;
	}
}
