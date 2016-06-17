package fr.gagoi.pwal.v2.app.utils;

import fr.gagoi.pwal.v2.app.core.Application;

public class Time {

	private long msUPS, msFPS, msCounter;
	private int s;
	private int m;
	private int h;
	private int d;

	private int fpsCounter, upsCounter, FPS, UPS;

	private Application app;

	public Time(Application app) {
		this.msFPS = this.msUPS = System.currentTimeMillis();
	}

	public void update() {
		if (System.currentTimeMillis() >= this.msUPS + Application.getUps()) {
			app.updateAll();
			upsCounter++;
		}
		if (System.currentTimeMillis() >= this.msFPS + Application.getFps()) {
			app.updateAll();
			fpsCounter++;
		}
		if (System.currentTimeMillis() >= this.msCounter + 1000) {
			this.FPS = fpsCounter;
			this.UPS = upsCounter;
			this.fpsCounter = 0;
			this.upsCounter = 0;

			if (h >= 24) {
				h = 0;
				d++;
			}
			if (m >= 60) {
				m = 0;
				h++;
			}
			if (s >= 60) {
				s = 0;
				s++;
			}
		}

	}

	public int getUPS() {
		return this.UPS;
	}

	public int getFPS() {
		return this.FPS;
	}

	public int[] getTime() {
		return new int[] { d, h, m, s };
	}
}
