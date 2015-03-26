package frontend;

import java.awt.Color;

import backend.FontUtil;

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
}
