package fantasy_football;

import java.awt.*;
import javax.swing.*;

public class AddImage extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image img;

	  public AddImage(String img) {
	    this(new ImageIcon(img).getImage());
	  }

	  public AddImage(Image img) {
	    this.img = img;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	  }

	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }
}
