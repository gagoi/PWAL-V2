package fr.gagoi.pwal.v2.example;

import java.awt.Color;

import fr.gagoi.pwal.v2.app.core.Application;
import fr.gagoi.pwal.v2.app.graphics.elements.scaled.PWAL_S_Label;
import fr.gagoi.pwal.v2.app.graphics.elements.unscaled.PWAL_Label;

public class gameTest {

	public static void main(String args[]) {
		Application app = new Application("Test", 1280, 720, 4.0f);
		PWAL_Label lbl = new PWAL_Label("Bonjour !", 0.1f, 0.1f, Color.RED);

		PWAL_S_Label lbl2 = new PWAL_S_Label("Bonjour !", 200, 111, Color.GREEN);
		app.addRender(lbl);
		app.addScaledRender(lbl2);
	
	}
}
