package logic.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DirectoryDoesNotExistException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(DirectoryDoesNotExistException.class);
	private static final String ERROR_MESSAGE = "Directory does not exist ";
	
	public DirectoryDoesNotExistException(String directoryPath) {
		LOGGER.error(ERROR_MESSAGE + directoryPath);
	}
}
