package fr.gagoi.pwal.v2.app.core;

import fr.gagoi.pwal.v2.app.graphics.Window;
import fr.gagoi.pwal.v2.app.utils.Logger;

public class Application {

	private final String NAME;
	private final int WIDTH;
	private final int HEIGHT;
	private final float SCALE;
	
	private static final Logger window_logger = new Logger(System.getProperty("user.dir"), "window.log");
	private static final Logger update_logger = new Logger(System.getProperty("user.dir"), "updater.log");
	
	private int fps = 120;
	private int ups = 120;
	

	public Application(String name, int width, int height, float scale) {
		this.NAME = name;
		this.WIDTH = width;
		this.HEIGHT = height;
		this.SCALE = scale;
		
		new Window(name, width, height, scale);
		
		
		System.out.println("App started");
	}
	
	
	public void updateAll() {
	}
	
	public void render(){
		
	}
	
	public void setFps(int fps){
		this.fps = fps;
	}
	
	public void setUps(int ups){
		this.ups = ups;
	}

	public int getUps() {
		return this.ups;
	}

	public int getFps() {
		return this.fps;
	}

	public static Logger getUpdateLogger(){
		return update_logger;
	}
	

}
