package frontend;

import java.awt.*;

import javax.swing.*;

public class AddImage extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image img;
	private int height;
	private int width;

	public AddImage(Image img) {
	    this.img = img;
	    this.height = Main.getFrameSize().height-20;
	    this.width = Main.getFrameSize().width/2;
	}

	public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	}
	  
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(this.width, this.height);
	}
}
