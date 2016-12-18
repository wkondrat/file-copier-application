package factory.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import events.CanNotCopyFileException;
import factory.Factory;

public class CopyFileFactory implements Factory{
	
	private static final Logger logger = LogManager.getLogger(CopyFileFactory.class);
	
	private File source;
	private File destinationFolder;
	
	public CopyFileFactory(File source, File destinationFolder) {
		this.source = source;
		this.destinationFolder = destinationFolder;
	}
	
	public void perform() {
		InputStream inStream = null;
        OutputStream outStream = null;
		try {
			System.out.println(destinationFolder.getAbsolutePath()); // do zmiany
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
			try {
				throw new CanNotCopyFileException();
			} catch (CanNotCopyFileException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
