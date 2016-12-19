package logic.validators;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import logic.exceptions.DirectoryDoesNotExistException;
import logic.exceptions.FileDoesNotExistException;
import logic.exceptions.ReadPermissionException;
import logic.exceptions.UsableSpaceException;
import logic.exceptions.WritePermissionException;

public class Validators {
	
	public static boolean existFileValidator (File fileToValidate) throws FileDoesNotExistException{
		if (!fileToValidate.exists() || !fileToValidate.isFile()) {
			throw new FileDoesNotExistException(fileToValidate.getAbsolutePath());
		}
		return true;
	}
	
	public static boolean existDirectoryValidator (File directoryToValidate) throws DirectoryDoesNotExistException {
		if (!directoryToValidate.exists() || !directoryToValidate.isDirectory()) {
			throw new DirectoryDoesNotExistException(directoryToValidate.getAbsolutePath());
		}
		return true;
	}
	
	public static boolean isDirectoryWrittable (Path directoryPath) throws WritePermissionException {
		if(!Files.isWritable(directoryPath)){
			throw new WritePermissionException(directoryPath);
		}
		return true;
	}
	
	public static boolean isFileReadable (Path filePath) throws ReadPermissionException {
		if(!Files.isReadable(filePath)){
			throw new ReadPermissionException(filePath);
		}
		return true;
	}
	
	public static boolean isEnoughSpace (File source, File destination) throws UsableSpaceException {
		long sourceSize = source.length();
		long destinationUsableSpaceSize = destination.getUsableSpace();
		if (sourceSize >= destinationUsableSpaceSize) {
			throw new UsableSpaceException(sourceSize, destinationUsableSpaceSize);
		}
		return true;
	}
}
