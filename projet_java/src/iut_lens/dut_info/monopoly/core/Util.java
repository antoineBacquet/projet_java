package iut_lens.dut_info.monopoly.core;

import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2i;

public class Util {
	
	public static boolean intersects(Vector2i point, RectangleShape rect){

	    return ((point.x>rect.getPosition().x) && (point.x<rect.getPosition().x+rect.getSize().x) && 
	    		(point.y>rect.getPosition().y) && (point.y<rect.getPosition().y+rect.getSize().y));
	}
	
	
	public static int getTextWidth(Text text){
	    int width = 0;
	    if(text.getString().isEmpty())
	        return width;

	    width += text.getFont().getGlyph(text.getString().charAt(0), text.getCharacterSize(), false).advance;
	    if(text.getString().length() == 1)
	        return width;

	    for(int i = 1; i < text.getString().length(); i++)
	    {
	        width += text.getFont().getGlyph(text.getString().charAt(i), text.getCharacterSize(), false).advance;
	        width += text.getFont().getKerning(text.getString().charAt(i), text.getString().charAt(i), text.getCharacterSize());
	    }

	    return width;
	}

}
