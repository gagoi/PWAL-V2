package fr.gagoi.pwal.v2.app.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class GameCanvas extends Canvas {
	
	Screen screen;
	int[] pixels;
	private BufferedImage img;
	
	public GameCanvas(Screen screen) {
		this.screen = screen;
		this.img = new BufferedImage(screen., arg1, arg2);
	}

	public synchronized void visualUpdate() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) { 
			createBufferStrategy(3);
			return;
		}

		screen.clear(0);
		screen.renderMap(x, y);
		
		screen.convertPixels(pixels);

		Graphics g = bs.getDrawGraphics(); // On r�cup�re les graphics de notre
		// canvas.
		g.setColor(Color.BLACK); // On met la couleur en noire pour ...
		g.fillRect(0, 0, getWidth(), getHeight()); // ... vider l'�cran.
		g.drawImage(bufferedImage, 0, 0, imageRenderedWidth, imageRenderedHeight, null); // Puis
		// on
		// dessine
		// notre
		// image.

		// ClientChampion c = new
		// ClientChampion(Game_Frame.GAME.serverGame.getChampion(0));
		// BaseSprite s = SpritesList.getSpriteFromID(c.getSprite());
		// float cx = c.getServerChamp().getServerPosX();
		// int cy = 0;
		// g.drawImage(s.getImage(), (int)cx, cy, 64, 64, null);
		g.setFont(new Font("Arial Black", Font.BOLD, 20)); // Choix de la police
		// de caract�re.
		g.setColor(Color.BLUE);
		// g.drawString("x:" + cx + "(" + c.getServerPosX() + ")", 100, 40);
		// g.drawString("y:" + cy, 100, 60);

		hud.refreshGraphics(g, imageRenderedWidth, imageRenderedHeight);
		if (optionFrame.isVisible()) optionFrame.refresh(g);

		if (debug) { // Si le debug est activ�. On affiche les options de debug.
			// (A modifier plus tard pour avoir plus bel affichage).
			g.setColor(Color.WHITE); // Couleur blanche.
			g.fillRect(10, 10, 200, 100); // Pour dessiner l'arri�re plan.
			g.setColor(Color.BLACK); // Ecriture noire.
			g.setFont(new Font("Arial Black", Font.BOLD, 20)); // Choix de la
			// police de
			// caract�re.
			g.drawString("FPS : " + actualFPS, 25, 40); // Affichage des FPS.
			g.drawString("UPS : " + actualUPS, 25, 60); // Affichage des UPS.
		}
		g.dispose(); // On d�truit notre objet graphique. Pour lib�rer la ram
		// pour la prochaine image.
		bs.show(); // On affiche notre buffered Image.
	}
}
