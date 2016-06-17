package fr.gagoi.pwal.v2.app.core;

import java.util.Vector;

import fr.gagoi.pwal.v2.app.game_access.Render;
import fr.gagoi.pwal.v2.app.game_access.Render_Scaled;
import fr.gagoi.pwal.v2.app.game_access.Updater;
import fr.gagoi.pwal.v2.app.graphics.Window;
import fr.gagoi.pwal.v2.app.utils.Logger;

public class Application {

	private final String NAME;
	private final int WIDTH;
	private final int HEIGHT;
	private final float SCALE;
	
	private static final Logger window_logger = new Logger(System.getProperty("user.dir"), "window.log");
	private static final Logger update_logger = new Logger(System.getProperty("user.dir"), "updater.log");
	
	private static int fps = 120;
	private static int ups = 120;
	
	private static Updater updater = new Updater("App");
	
	private static Vector<Render_Scaled> renders_scaled = new Vector<>();
	private static Vector<Render> renders = new Vector<>();
	
	public Application(String name, int width, int height, float scale) {
		this.NAME = name;
		this.WIDTH = width;
		this.HEIGHT = height;
		this.SCALE = scale;
		
		new Window(this.NAME, this.WIDTH, this.HEIGHT, this.SCALE);
		System.out.println("App started");
	}
	
	
	public void updateAll() {
	}
	
	public void render(){
	}
	
	public static void setFps(int fps){
		Application.fps = fps;
	}
	
	public static void setUps(int ups){
		Application.ups = ups;
	}

	public static int getUps() {
		return Application.ups;
	}

	public static int getFps() {
		return Application.fps;
	}

	public static Logger getUpdateLogger(){
		return update_logger;
	}

	public static Logger getWindowLogger() {
		return window_logger;
	}


	public static Vector<Render_Scaled> getScaledRenders() {
		return renders_scaled;
	}
	
	public static Vector<Render> getRenders() {
		return renders;
	}


	public static Updater getUpdater() {
		return updater;
	}
	
	public void addRender(Render render){
		getRenders().add(render);
	}
	
	public void addScaledRender(Render_Scaled render){
		getScaledRenders().add(render);
	}
	
	
}
