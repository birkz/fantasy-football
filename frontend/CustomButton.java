package is.hi.f2a.frontend;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class CustomButton extends JButton{
	private static final long serialVersionUID = 1L;
	
	private Color hoverBackgroundColor;
    private Color pressedBackgroundColor;
    private Color fontColor;
    private Color backupcolor;
	private Color hoverFontColor;
	private boolean isToggled = false;
	private boolean tempHoverTextChangeAllowed = false;
	private String tempHoverText = "";
	private String savedText;

    public CustomButton() {
        this(null);
    }

    public CustomButton(String text) {
        super(text);
        super.setContentAreaFilled(false);
    }
    
    public void changeText(String text) {
    	super.setText(text);
    	this.tempHoverTextChangeAllowed = false;
    }
    
    public void changeTextOnHover(String text) {
    	this.savedText = getText();
    	this.tempHoverText = text;
    	this.tempHoverTextChangeAllowed = true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(pressedBackgroundColor);
        } else if (getModel().isRollover()) {
            g.setColor(hoverBackgroundColor);
            setForeground(this.hoverFontColor);
            if(tempHoverTextChangeAllowed) {
            	super.setText(this.tempHoverText);
            }
        } else {
        	if(tempHoverTextChangeAllowed) {
        		super.setText(this.savedText);
        	}
            g.setColor(getBackground());
            setForeground(this.fontColor);
        }
        g.fillRect(0, 0, getWidth(), getHeight()-2);
        super.paintComponent(g);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
    }
    
    public void toggleON() {
    	if(!this.isToggled){
	    	this.backupcolor = this.fontColor;
	    	this.setBackground(this.hoverBackgroundColor);
	    	this.setFontColor(this.hoverFontColor);
	    	this.isToggled = true;
    	}
    }
    
    public void toggleOFF() {
    	if(this.isToggled) {
	    	this.setBackground(null);
	    	this.setFontColor(this.backupcolor);
	    	this.isToggled = false;
    	}
    	
    }
    
    public void setFontColor(Color color) {
    	this.fontColor = color;
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

