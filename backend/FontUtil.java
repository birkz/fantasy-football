package is.hi.f2a.backend;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FontUtil {
	
	private static final Font SERIF_FONT = new Font("serif", Font.PLAIN, 24);
	private static final Map<String, Font> fonts = new HashMap<String, Font>();

	public static Font getFont(String name, int style, float size) {
		Font font = null;
		
	    if (name == null) {
	        return SERIF_FONT;
	    }
	    
	    try {
	    	
	    	// Checked if font has been loaded before
	    	if (fonts != null && (font = (Font) fonts.get(name)) != null) {
	    		//System.out.println("font preload success");
	    		font = font.deriveFont(style, size);
	            return font;
	        }
	    	
	        String fName = "src/font/" + name + ".ttf";
	        File fontFile = new File(fName);
	        font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
	        font = font.deriveFont(style, size);
	        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	        ge.registerFont(font);
	        fonts.put(name, font);

	    } catch (Exception ex) {
	        System.out.println(name + " not loaded.  Using serif font.");
	        font = SERIF_FONT;
	    }
	    return font;
	}

}
