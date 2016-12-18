package logic.validators;

import java.io.File;

public class Validators {
	
	static boolean existFileValidator (File fileToValidate) {
		boolean value = false;
		if (fileToValidate.exists() && fileToValidate.isFile()) {
			value = true;
		}
		return value;
	}
	
	static boolean existDirectoryValidator (File directoryToValidate) {
		boolean value = false;
		if (directoryToValidate.exists() && directoryToValidate.isDirectory()) {
			value = true;
		}
		return value;
	}
}
