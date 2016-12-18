package logic.impl;

import java.io.File;

import logic.CopyTask;

public class CopyTaskFactory {	
	public CopyTask getCopyTask(File fileToCopy, File destination) {
		return new CopyTaskImpl(fileToCopy, destination);
	}
}
