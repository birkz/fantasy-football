package backend;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

public class FontUtil {
	
	private static final Font SERIF_FONT = new Font("serif", Font.PLAIN, 24);

	public static Font getFont(String name, int style, float size) {
	    Font font = null;
	    if (name == null) {
	        return SERIF_FONT;
	    }

	    try {
	        String fName = "src/font/" + name + ".ttf";
	        File fontFile = new File(fName);
	        font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
	        font = font.deriveFont(style, size);
	        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	        ge.registerFont(font);

	    } catch (Exception ex) {
	        System.out.println(name + " not loaded.  Using serif font.");
	        font = SERIF_FONT;
	    }
	    return font;
	}

}
