package logic.copytask.impl;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import logic.copytask.CopyTask;

public class CopyTaskImplTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	File testFile;
	File testDirectory;

	@After
	public void afterEach() {
		testFile.delete();
		testDirectory.delete();
	}

	@Test(expected = IOException.class)
	public void shouldThrowExceptionWhenCopyFailed() throws IOException {
		//given
		String directoryName = "temporaryDirectory";
		String wrongPath = "pathDoesNotExist";
		testFile = folder.newFile(wrongPath);
		testDirectory = new File(directoryName);
		CopyTask copyTask = new CopyTaskFactory().getCopyTask(testFile, testDirectory);
		//when
		copyTask.perform();
	}
	
	@Test
	public void shouldNotThrowExceptionWhenCopyFileIsSuccess() throws IOException {
		//given
		String directoryName = "temporaryDirectory";
		String fileName = "temporaryFile";
		testFile = folder.newFile(fileName);
		testDirectory = folder.newFolder(directoryName);
		CopyTask copyTask = new CopyTaskFactory().getCopyTask(testFile, testDirectory);
		//when
		copyTask.perform();
		//then
		assertTrue(true);
	}

}
