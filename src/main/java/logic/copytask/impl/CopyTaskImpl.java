package logic.copytask.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import logic.copytask.CopyTask;

class CopyTaskImpl implements CopyTask {

	private static final Logger LOGGER = LogManager.getLogger(CopyTaskImpl.class);
	private static final String SUCCESS = "File successfully copied";
	private static final String ERROR = "Error occurred when copying the file ";
	private static final String PREFIX = "copy-";
	
	private File source;
	private File destinationFolder;

	public CopyTaskImpl(File source, File destinationFolder) {
		this.source = source;
		this.destinationFolder = new File(destinationFolder, PREFIX + source.getName());
	}

	public void perform() throws IOException {
		InputStream inStream = null;
		OutputStream outStream = null;

		try {
			inStream = new FileInputStream(source);
			outStream = new FileOutputStream(destinationFolder);

			byte[] buffer = new byte[1024];

			int length;
			while ((length = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, length);
			}

			if (inStream != null)
				inStream.close();
			if (outStream != null)
				outStream.close();

			String successMessage = String.join(" ", SUCCESS, "From", source.getAbsolutePath(), "to",
					destinationFolder.getParent(), "and saved as", destinationFolder.getName() );

			LOGGER.info(successMessage);
		} catch (IOException e) {
			LOGGER.error(ERROR + e.getMessage());
			throw new IOException();
		}
	}
}
