package fr.gagoi.pwal.v2.app.game_access;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import fr.gagoi.pwal.v2.app.core.Application;

public class Updater {

	private static Timer t;

	public Updater(String name) {
		t = new Timer(name, true);
	}

	public void update(TimerTask task, String event_code, String message) {
		Application.getUpdateLogger().log(event_code, message);
		task.run();
	}

	public void updateAtFixedRate(TimerTask task, int delay, int period, String event_code, String message) {
		Application.getUpdateLogger().log(event_code, message);
		t.scheduleAtFixedRate(task, delay, period);
	}

	public void updateAfter(TimerTask task, int delay, String event_code, String message) {
		Application.getUpdateLogger().log(event_code, message);
		t.schedule(task, delay);
	}

	public void updateAt(TimerTask task, Date date, String event_code, String message) {
		Application.getUpdateLogger().log(event_code, message);
		t.schedule(task, date);
	}

	public void updateAtFixedRate(TimerTask task, Date date, int period, String event_code, String message) {
		Application.getUpdateLogger().log(event_code, message);
		t.schedule(task, date, period);
	}
}
