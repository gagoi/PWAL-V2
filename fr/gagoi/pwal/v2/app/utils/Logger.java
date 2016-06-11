package fr.gagoi.pwal.v2.app.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Calendar;

public class Logger {

	private File folder;
	private File logFile;
	private OutputStreamWriter out;
	private static Calendar cal = Calendar.getInstance();
	
	public Logger(String path, String fileName) {
		System.out.println(path);
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
		
		try {
			out = new OutputStreamWriter(new FileOutputStream(logFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void log(String type, String message){
		try {
			out.write(cal.getTime() + "::<" + type.toLowerCase() + ">: " + message);
			out.flush();
		} catch (IOException e) {
			System.err.println("Impossible to write on log file, you should run in administrator...");
			e.printStackTrace();
		}
	}
}
