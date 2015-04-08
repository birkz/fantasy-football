package is.hi.f2a.frontend;

import java.awt.Color;

import is.hi.f2a.backend.FontUtil;

public class DesignedButton {

	public static CustomButton orangeStyle(String text, int style, float size) {
		CustomButton button = new CustomButton(text);
		button.setBorder(null);
		button.setFont(FontUtil.getFont("kalinga", style, size));
		button.setFontColor(new Color(255, 85, 28));
		button.setHoverBackgroundColor(new Color(255, 85, 28));
		button.setHoverFontColor(Color.WHITE);
		button.setPressedBackgroundColor(Color.BLACK);
		
		return button;
	}
	
	public static CustomButton deleteStyle(String text, int style, float size) {
		CustomButton button = new CustomButton(text);
		button.setBorder(null);
		button.setFont(FontUtil.getFont("kalinga", style, size));
		button.setFontColor(new Color(235, 20, 20));
		button.setHoverBackgroundColor(new Color(255, 0, 0));
		button.setHoverFontColor(Color.WHITE);
		button.setPressedBackgroundColor(Color.BLACK);
		
		return button;
	}
}
