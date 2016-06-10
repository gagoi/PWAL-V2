package fr.gagoi.pwal.v2.app.core;

public class Application {

	private final String NAME;
	private final int WIDTH;
	private final int HEIGHT;
	private final float SCALE;

	private int fps = 120;
	private int ups = 120;

	public Application(String name, int width, int height, float scale) {
		this.NAME = name;
		this.WIDTH = width;
		this.HEIGHT = height;
		this.SCALE = scale;
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

	

}
