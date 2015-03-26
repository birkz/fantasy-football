package frontend;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class CustomButton extends JButton{
	private static final long serialVersionUID = 1L;
	
	private Color hoverBackgroundColor;
    private Color pressedBackgroundColor;
    private Color fontColor;
	private Color hoverFontColor;

    public CustomButton() {
        this(null);
    }

    public CustomButton(String text) {
        super(text);
        super.setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(pressedBackgroundColor);
        } else if (getModel().isRollover()) {
            g.setColor(hoverBackgroundColor);
            setForeground(this.hoverFontColor);
        } else {
            g.setColor(getBackground());
            setFontColor(this.fontColor);
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
    }
    
    public void setFontColor(Color color) {
    	this.fontColor = color;
    	setForeground(color);
    }
    
    public Color getFontColor() {
    	return fontColor;
    }

    public Color getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public void setHoverBackgroundColor(Color hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }
    
    public Color getHoverFontColor() {
        return hoverFontColor;
    }
    
    public void setHoverFontColor(Color hoverFontColor) {
    	this.hoverFontColor = hoverFontColor;
    }

    public Color getPressedBackgroundColor() {
        return pressedBackgroundColor;
    }

    public void setPressedBackgroundColor(Color pressedBackgroundColor) {
        this.pressedBackgroundColor = pressedBackgroundColor;
    }
}

