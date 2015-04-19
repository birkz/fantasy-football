package is.hi.f2a.frontend;

import java.awt.Color;

import is.hi.f2a.backend.FontUtil;

public class DesignedButton {

	public static CustomButton orangeStyle(String text, int style, float size) {

		Color backgroundcolor = null;
		Color fontcolor = new Color(255, 85, 28);
		Color hoverbackcolor = new Color(255, 85, 28);
		Color hoverfontcolor = Color.WHITE;
		Color pressedbackcolor = Color.BLACK;
		
		return newButton(text, style, size, "kalinga", backgroundcolor, fontcolor, hoverbackcolor, hoverfontcolor, pressedbackcolor);
	}
	
	public static CustomButton deleteStyle(String text, int style, float size) {

		Color backgroundcolor = null;
		Color fontcolor = new Color(235, 20, 20);
		Color hoverbackcolor = new Color(255, 0, 0);
		Color hoverfontcolor = Color.WHITE;
		Color pressedbackcolor = Color.BLACK;
		
		return newButton(text, style, size, "kalinga", backgroundcolor, fontcolor, hoverbackcolor, hoverfontcolor, pressedbackcolor);
	}
	
	public static CustomButton endStyle(String text, int style, float size) {
		
		Color backgroundcolor = new Color(255, 85, 28);
		Color fontcolor = Color.WHITE;
		Color hoverbackcolor = new Color(212,32,32);
		Color hoverfontcolor = Color.WHITE;
		Color pressedbackcolor = Color.BLACK;
		
		return newButton(text, style, size, "kalinga", backgroundcolor, fontcolor, hoverbackcolor, hoverfontcolor, pressedbackcolor);
		
	}
	
	public static CustomButton newStyle(String text, int style, float size) {
		
		Color backgroundcolor = new Color(10, 125, 10);
		Color fontcolor = Color.WHITE;
		Color hoverbackcolor = new Color(212,32,32);
		Color hoverfontcolor = Color.WHITE;
		Color pressedbackcolor = Color.BLACK;
		
		return newButton(text, style, size, "kalinga", backgroundcolor, fontcolor, hoverbackcolor, hoverfontcolor, pressedbackcolor);
	}
	
	public static CustomButton buyStyle(int style, float size) {
		CustomButton button = new CustomButton();
		button.setBorder(null);
		button.setFont(FontUtil.getFont("kalinga", style, size));
		button.setBackground(new Color(10, 150, 10));
		button.setFontColor(Color.WHITE);
		button.setHoverBackgroundColor(new Color(212,32,32));
		button.setHoverFontColor(Color.WHITE);
		button.setPressedBackgroundColor(Color.BLACK);
		button.setFocusPainted(false);
		
		return button;
	}
	
	private static CustomButton newButton(String text, int style, float size, String fontname, Color backgroundcolor, Color fontcolor, Color hoverbackcolor, Color fonthovercolor, Color pressedbackcolor) {
		CustomButton button = new CustomButton(text);
		button.setBorder(null);
		button.setFont(FontUtil.getFont(fontname, style, size));
		button.setBackground(backgroundcolor);
		button.setFontColor(fontcolor);
		button.setHoverBackgroundColor(hoverbackcolor);
		button.setHoverFontColor(fonthovercolor);
		button.setPressedBackgroundColor(pressedbackcolor);
		button.setFocusPainted(false);
		
		return button;
	}
}
