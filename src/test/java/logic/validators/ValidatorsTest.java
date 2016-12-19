package logic.validators;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import logic.exceptions.DirectoryDoesNotExistException;
import logic.exceptions.FileDoesNotExistException;

public class ValidatorsTest {

	@Rule
    public TemporaryFolder folder = new TemporaryFolder();

	@Test(expected = FileDoesNotExistException.class)
	public void testShouldThrowFileDoesNotExistExceptionWhenFileDoesNotExist() throws FileDoesNotExistException {
		//given
		String wrongPath = "wrongPath";
		File testFile = new File(wrongPath);
		//when
		Validators.existFileValidator(testFile);
	}
	
	@Test(expected = DirectoryDoesNotExistException.class)
	public void testShouldThrowDirectoryDoesNotExistExceptionWhenIsDirectory() throws DirectoryDoesNotExistException {
		//given
		String wrongPath = "wrongPath";
		File testFile = new File(wrongPath);
		//when
		Validators.existDirectoryValidator(testFile);
	}
	
	@Test
	public void testShouldReturnTrueWhenDirectoryExist() throws DirectoryDoesNotExistException {
		//given
		boolean expectedResult = true;
		boolean actualResult;
		String temporaryFolder = "temporaryFolder";
		File testFile = null;
		try {
			testFile = folder.newFolder(temporaryFolder);
		} catch (IOException e) {
			fail("Directory Does Not Exist");
		}
		//when
		actualResult = Validators.existDirectoryValidator(testFile);
		//then 
		assertEquals(expectedResult,actualResult);
	}

}
