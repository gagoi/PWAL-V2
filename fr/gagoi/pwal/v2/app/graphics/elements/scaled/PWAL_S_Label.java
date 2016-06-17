package fr.gagoi.pwal.v2.app.graphics.elements.scaled;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import fr.gagoi.pwal.v2.app.core.Application;
import fr.gagoi.pwal.v2.app.game_access.Render;
import fr.gagoi.pwal.v2.app.game_access.Render_Scaled;

public class PWAL_S_Label implements Render_Scaled {

	private String text = "";
	private Color color = Color.BLACK;
	private Font font = Font.getFont("Arial");
	private float x = 0, y = 0;

	public PWAL_S_Label(String text) {
		this.setText(text);
	}

	public PWAL_S_Label(String text, Color color) {
		this.setText(text);
		this.setColor(color);
	}

	public PWAL_S_Label(String text, int colorCode) {
		this.setText(text);
		this.setColorFromCode(colorCode);
	}

	public PWAL_S_Label(String text, float posX, float posY) {
		this.setText(text);
		this.setPosition(posX, posY);
	}

	public PWAL_S_Label(String text, float posX, float posY, int colorCode) {
		this.setText(text);
		this.setPosition(posX, posY);
		this.setColorFromCode(colorCode);
	}

	public PWAL_S_Label(String text, float posX, float posY, Color color) {
		this.setText(text);
		this.setPosition(posX, posY);
		this.setColor(color);
	}

	public PWAL_S_Label(String text, Font font) {
		this.setText(text);
		this.setFont(font);
	}

	public PWAL_S_Label(String text, Color color, Font font) {
		this.setText(text);
		this.setColor(color);
		this.setFont(font);
	}

	public PWAL_S_Label(String text, int colorCode, Font font) {
		this.setText(text);
		this.setColorFromCode(colorCode);
		this.setFont(font);
	}

	public PWAL_S_Label(String text, float posX, float posY, Font font) {
		this.setText(text);
		this.setPosition(posX, posY);
		this.setFont(font);
	}

	public PWAL_S_Label(String text, float posX, float posY, int colorCode, Font font) {
		this.setText(text);
		this.setPosition(posX, posY);
		this.setColorFromCode(colorCode);
		this.setFont(font);
	}

	public PWAL_S_Label(String text, float posX, float posY, Color color, Font font) {
		this.setText(text);
		this.setPosition(posX, posY);
		this.setColor(color);
		this.setFont(font);
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(getColor());
		g.setFont(getFont());
		g.drawString(getText(), (int) (getPosX()), (int) (getPosY()));
	}

	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getPosX() {
		return this.x;
	}

	public float getPosY() {
		return this.y;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setColorFromCode(int code) {
		if (code > 16_581_375 || code < 0) {
			Application.getWindowLogger().log("ERROR", "Color code error, plz check it...");
			code = 0;
		}
		setColor(new Color(code, false));
	}

	public Color getColor() {
		return this.color;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Font getFont() {
		return this.font;
	}

	public void setFont(Font font) {
		this.font = font;
	}
}
