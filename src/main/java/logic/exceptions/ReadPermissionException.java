package logic.exceptions;

import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReadPermissionException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(ReadPermissionException.class);
	private static final String ERROR_MESSAGE = "Denied read permission ";
	
	public ReadPermissionException(Path filePath) {
		logger.error(ERROR_MESSAGE + filePath);
	}
}