package logic.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import logic.CopyTask;

class CopyTaskImpl implements CopyTask {
	
	private static final Logger logger = LogManager.getLogger(CopyTaskImpl.class);
	
	private File source;
	private File destinationFolder;
	
	public CopyTaskImpl(File source, File destinationFolder) {
		this.source = source;
		this.destinationFolder = destinationFolder;
	}
	
	public void perform() {
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

            if (inStream != null) inStream.close();
            if (outStream != null) outStream.close();
            logger.debug("File successfully copied");
		} catch (IOException e) {
				e.toString();
			}
		}
}
