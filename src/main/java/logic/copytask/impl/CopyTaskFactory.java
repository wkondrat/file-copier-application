package logic.copytask.impl;

import java.io.File;

import logic.copytask.CopyTask;

public class CopyTaskFactory {	
	public CopyTask getCopyTask(File fileToCopy, File destination) {
		return new CopyTaskImpl(fileToCopy, destination);
	}
}
