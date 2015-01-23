package iut_lens.dut_info.monopoly.core;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

import org.jsfml.graphics.Font;

public class FontManager {

	private static HashMap<String,Font> fonts = new HashMap<String,Font>();
	private final static String font_path = "src/font/";


	public static Font getFont(String fontName){
		
		
		
	    if(fonts.containsKey(fontName) ){
	        return fonts.get(fontName);
	    }
	    Font font = new Font();
	    
	    try {
			font.loadFromFile(Paths.get(font_path + fontName + ".ttf"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	    
	    fonts.put(fontName,font);
	    return font;


	}

}
