package fr.gagoi.pwal.v2.app.core;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

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
	
	private int fps = 120;
	private int ups = 120;
	
	private static Updater updater = new Updater("App");
	
	private static Vector<Render_Scaled> render = new Vector<>();
	
	public Application(String name, int width, int height, float scale) {
		this.NAME = name;
		this.WIDTH = width;
		this.HEIGHT = height;
		this.SCALE = scale;
		
		new Window(name, width, height, scale);
		render.addElement(new Render_Scaled() {
			@Override
			public void render(Graphics g) {
				g.setColor(Color.BLUE);
				g.fillRect(20, 20, 40, 40);
			}
		});
		
		
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

	public static Logger getWindowLogger() {
		return window_logger;
	}


	public static Vector<Render_Scaled> getRenders() {
		return render;
	}


	public static Updater getUpdater() {
		return updater;
	}
}
