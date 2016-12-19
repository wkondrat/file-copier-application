package logic.validators;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mockito.Mockito;

import logic.exceptions.DirectoryDoesNotExistException;
import logic.exceptions.FileDoesNotExistException;
import logic.exceptions.ReadPermissionException;
import logic.exceptions.UsableSpaceException;
import logic.exceptions.WritePermissionException;

public class ValidatorsTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	File testFile;

	@After
	public void afterEach() {
		testFile.delete();
	}

	@Test(expected = FileDoesNotExistException.class)
	public void testShouldThrowExceptionWhenFileDoesNotExist() throws FileDoesNotExistException {
		// given
		String wrongPath = "wrongPath";
		testFile = new File(wrongPath);
		// when
		Validators.existFileValidator(testFile);
	}

	@Test
	public void testShouldReturnTrueWhenFileExist() throws FileDoesNotExistException, IOException {
		// given
		boolean expectedResult = true;
		boolean actualResult;
		String temporaryFile = "temporaryFile";
		testFile = folder.newFile(temporaryFile);
		// when
		actualResult = Validators.existFileValidator(testFile);
		// then
		assertEquals(expectedResult, actualResult);
	}

	@Test(expected = DirectoryDoesNotExistException.class)
	public void testShouldThrowExceptionWhenDirectoryDoesNotExist() throws DirectoryDoesNotExistException {
		// given
		String wrongPath = "wrongPath";
		testFile = new File(wrongPath);
		// when
		Validators.existDirectoryValidator(testFile);
	}

	@Test(expected = DirectoryDoesNotExistException.class)
	public void testShouldThrowExceptionWhenFileIsDirectory() throws DirectoryDoesNotExistException, IOException {
		// given
		String temporaryFile = "temporaryFile";
		testFile = folder.newFile(temporaryFile);
		// when
		Validators.existDirectoryValidator(testFile);
	}

	@Test
	public void testShouldReturnTrueWhenDirectoryExist() throws DirectoryDoesNotExistException, IOException {
		// given
		boolean expectedResult = true;
		boolean actualResult;
		String temporaryFolder = "temporaryFolder";
		testFile = folder.newFolder(temporaryFolder);
		// when
		actualResult = Validators.existDirectoryValidator(testFile);
		// then
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testShouldReturnTrueIfFileIsReadable() throws ReadPermissionException, IOException {
		// given
		boolean expectedResult = true;
		boolean actualResult;
		String temporaryFile = "temporaryFile";
		testFile = folder.newFile(temporaryFile);
		// when
		actualResult = Validators.isFileReadable(testFile.toPath());
		// then
		assertEquals(expectedResult, actualResult);
	}

	@Test(expected = ReadPermissionException.class)
	public void testShouldThrowExceptionWhenFileIsNotReadable() throws ReadPermissionException, IOException {
		// given
		String temporaryFile = "temporaryFile";
		boolean readable = false;
		testFile = new File(temporaryFile);
		testFile.setReadable(readable);
		// when
		Validators.isFileReadable(testFile.toPath());
	}

	@Test
	public void testShouldReturnTrueIfDirectoryIsWritable() throws WritePermissionException, IOException {
		// given
		boolean expectedResult = true;
		boolean actualResult;
		String temporaryFolder = "temporaryFolder";
		testFile = folder.newFolder(temporaryFolder);
		// when
		actualResult = Validators.isFileWritable(testFile.toPath());
		// then
		assertEquals(expectedResult, actualResult);
	}

	@Test(expected = WritePermissionException.class)
	public void testShouldThrowExceptionWhenFileIsNotWritable() throws WritePermissionException, IOException {
		// given
		String temporaryFile = "temporaryFile";
		boolean writable = false;
		testFile = new File(temporaryFile);
		testFile.setWritable(writable);
		// when
		Validators.isFileWritable(testFile.toPath());
	}

	@Test
	public void testShouldRetutnTrueIfIsEnoughSpaceOnDisc() throws UsableSpaceException, IOException {
		// given
		boolean expectedResult = true;
		boolean actualResult;
		String temporaryFile = "temporaryFile";
		String temporaryDirectory = "temporaryDirectory";
		testFile = folder.newFile(temporaryFile);
		File testDirectory = folder.newFolder(temporaryDirectory);
		// when
		actualResult = Validators.isEnoughSpace(testFile, testDirectory);
		// then
		assertEquals(expectedResult, actualResult);
	}
	
	@Test(expected = UsableSpaceException.class)
	public void testShouldThrowExceptionIfIsNotEnoughSpaceOnDisc() throws UsableSpaceException, IOException {
		// given
		Long usableSpace = 0L;
		String temporaryFile = "temporaryFile";
		File directoryMock = Mockito.mock(File.class);
		Mockito.when(directoryMock.getUsableSpace()).thenReturn(usableSpace);
		testFile = folder.newFile(temporaryFile);
		// when
		Validators.isEnoughSpace(testFile, directoryMock);
	}

}
