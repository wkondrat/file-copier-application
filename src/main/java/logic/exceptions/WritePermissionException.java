package logic.exceptions;

import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WritePermissionException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(WritePermissionException.class);
	private static final String ERROR_MESSAGE = "Denied write permission ";
	
	public WritePermissionException(Path directoryPath) {
		LOGGER.error(ERROR_MESSAGE + directoryPath);
	}
}
