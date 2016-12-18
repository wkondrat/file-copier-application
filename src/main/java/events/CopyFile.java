package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import factory.Factory;
import factory.impl.CopyFileFactory;
import main.MainFrame;
import panels.PathPanel;

public class CopyFile implements ActionListener {
	
	private static final Logger logger = LogManager.getLogger(CopyFile.class);
	
	Factory copyFileFactory;
	
	public void actionPerformed(ActionEvent arg0) {

		String filePath = MainFrame.mainPanel.namePanel.textField.getText();
		String destinationPath = "";

//		try {
				JFileChooser selectedFile = new JFileChooser();
				JFileChooser destinationDirectory = new JFileChooser();
				int valueOfSelectedFileOption = selectedFile.showDialog(null, "Select File");
				if (valueOfSelectedFileOption == JFileChooser.CANCEL_OPTION) {
					logger.debug("Canceled choice of file");
					JOptionPane.showMessageDialog(null, "Canceled choice of file");
					System.exit(0);
				}
				if (valueOfSelectedFileOption == JFileChooser.APPROVE_OPTION) {
					PathPanel.sayFileSelected();
					filePath = selectedFile.getSelectedFile().getAbsolutePath();
					destinationDirectory.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int valueOfSelectedDirectoryOption = destinationDirectory.showDialog(null, "Select Folder");
					if (valueOfSelectedDirectoryOption == JFileChooser.CANCEL_OPTION) {
						logger.debug("Canceled choice of directory");
						JOptionPane.showMessageDialog(null, "Canceled choice of directory");
						System.exit(0);
					}
					destinationPath = destinationDirectory.getSelectedFile().getAbsolutePath();
					File source = new File(filePath);
					File destinationFolder = new File(destinationPath, source.getName());
					
					
					copyFileFactory = new CopyFileFactory(source, destinationFolder);
					copyFileFactory.perform();
					
				}
				
				MainFrame.mainPanel.namePanel.textField.setText(filePath);
				
//		} catch (CanNotCopyFileException e) {
//			logger.debug("Can't copy file");
//			JOptionPane.showMessageDialog(null, "Sorry, can't copy that file");
//			System.exit(0);
//		}
	}

	public void copy(File source, File destinationFolder) throws CanNotCopyFileException {
		InputStream inStream = null;
        OutputStream outStream = null;
		try {
			
			inStream = new FileInputStream(source);
            outStream = new FileOutputStream(destinationFolder);
            
            byte[] buffer = new byte[1024];

            int length;
            while ((length = inStream.read(buffer)) > 0){
                outStream.write(buffer, 0, length);
            }

            if (inStream != null)inStream.close();
            if (outStream != null)outStream.close();
            logger.debug("File successfully copied");
		} catch (IOException e) {
			System.out.println(source.getAbsolutePath()); // do zmiany
			System.out.println(destinationFolder.getAbsolutePath()); // do zmiany
			throw new CanNotCopyFileException();
		}
	}
}
