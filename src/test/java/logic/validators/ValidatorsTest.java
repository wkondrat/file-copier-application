package logic.validators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import logic.exceptions.DirectoryDoesNotExistException;
import logic.exceptions.FileDoesNotExistException;

public class ValidatorsTest {

	@Rule
    public TemporaryFolder folder = new TemporaryFolder();

	File testFile;
	
	@After
	public void afterEach() {
		testFile.delete();
	}

	@Test(expected = FileDoesNotExistException.class)
	public void testShouldThrowFileDoesNotExistExceptionWhenFileDoesNotExist() throws FileDoesNotExistException {
		//given
		String wrongPath = "wrongPath";
		testFile = new File(wrongPath);
		//when
		Validators.existFileValidator(testFile);
	}
	
	@Test
	public void testShouldReturnTrueWhenFileExist() throws FileDoesNotExistException {
		//given
		boolean expectedResult = true;
		boolean actualResult;
		String temporaryFile = "temporaryFile";
		try {
			testFile = folder.newFile(temporaryFile);
		} catch (IOException e) {
			fail("File Does Not Exist");
		}
		//when
		actualResult = Validators.existFileValidator(testFile);
		//then 
		assertEquals(expectedResult,actualResult);
	}
	
	@Test(expected = DirectoryDoesNotExistException.class)
	public void testShouldThrowDirectoryDoesNotExistExceptionWhenIsDirectory() throws DirectoryDoesNotExistException {
		//given
		String wrongPath = "wrongPath";
		testFile = new File(wrongPath);
		//when
		Validators.existDirectoryValidator(testFile);
	}
	
	@Test
	public void testShouldReturnTrueWhenDirectoryExist() throws DirectoryDoesNotExistException {
		//given
		boolean expectedResult = true;
		boolean actualResult;
		String temporaryFolder = "temporaryFolder";
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
