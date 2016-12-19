package logic.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsableSpaceException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(UsableSpaceException.class);
	private static final String ERROR_MESSAGE = "Not enough space!";

	public UsableSpaceException(long source, long destination) {
		String errorDescription = String.join(" ", ERROR_MESSAGE, "Source file has size ", Long.toString(source),
				"bytes ", "when in destination is ", Long.toString(destination), "bytes of usable space");
		LOGGER.error(errorDescription);
	}
}
