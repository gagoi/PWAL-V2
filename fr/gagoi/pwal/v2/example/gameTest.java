package fr.gagoi.pwal.v2.example;

import java.awt.Color;

import fr.gagoi.pwal.v2.app.core.Application;
import fr.gagoi.pwal.v2.app.graphics.elements.PWAL_Label;

public class gameTest {

	public static void main(String args[]) {
		Application app = new Application("Test", 700, 400, 2.0f);
		PWAL_Label lbl = new PWAL_Label("Bonjour !", 0.1f, 0.1f, Color.RED);
		
		app.addRender(lbl);
	
	}
}
