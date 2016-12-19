package logic.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileDoesNotExistException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(FileDoesNotExistException.class);
	private static final String ERROR_MESSAGE = "File does not exist ";
	
	public FileDoesNotExistException(String filePath) {
		logger.error(ERROR_MESSAGE + filePath);
	}
}
