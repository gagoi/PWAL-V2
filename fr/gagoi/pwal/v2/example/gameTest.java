package fr.gagoi.pwal.v2.example;

import java.awt.Color;
import java.awt.Graphics;
import java.util.TimerTask;

import fr.gagoi.pwal.v2.app.core.Application;
import fr.gagoi.pwal.v2.app.game_access.Render;
import fr.gagoi.pwal.v2.app.game_access.Render_Scaled;
import fr.gagoi.pwal.v2.app.graphics.elements.PWAL_Label;

public class gameTest {

	private static int r, v;
	public static void main(String args[]) {
		Application app = new Application("Test", 700, 400, 2.0f);
		PWAL_Label lbl = new PWAL_Label("Bonjour !", 0.1f, 0.1f, Color.RED);

		app.addScaledRender(new Render_Scaled() {
			@Override
			public void render(Graphics g) {
				g.fillOval(r, v, 20, 20);
			}
		});
		
//		app.addRender(new Render() {
//			
//			@Override
//			public void render(Graphics g, int width, int height) {
//				g.setColor(Color.BLUE);
//				g.fillRect(r, v, 50, 50);
//			}
//		});
		
		Application.getUpdater().updateAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				r++;
				v++;
				
			}
		}, 0, 10, "EEEEE", "fEEFEFFEEF");
		app.addRender(lbl);
	
	}
}
