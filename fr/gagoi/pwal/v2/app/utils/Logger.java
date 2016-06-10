package fr.gagoi.pwal.v2.app.utils;

import java.io.File;
import java.io.IOException;

public class Logger {

	private File folder;
	private File logFile;
	
	public Logger(String path, String fileName) {
		folder = new File(path);
		if (!folder.exists())
			folder.mkdirs();
		logFile = new File(path, fileName);
		if(!logFile.exists())
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Error while creating log file : " + logFile.getAbsolutePath());
				System.err.println("Program will stop....");
				System.exit(1);
			}
	}
	
	public void log(){
		
	}
}
