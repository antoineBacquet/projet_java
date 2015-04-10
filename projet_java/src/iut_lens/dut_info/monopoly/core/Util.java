package iut_lens.dut_info.monopoly.core;

import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;
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


	public static void centerTextRect(RectangleShape rect, Text text) {
		text.setPosition(new Vector2f(	(rect.getSize().x-Util.getTextWidth(text))/2+rect.getPosition().x,
										(rect.getSize().y-text.getCharacterSize())/2+rect.getPosition().y));
		
	}
	
	public static void centerTextRectInX(RectangleShape rect, Text text) {
		text.setPosition(new Vector2f(	(rect.getSize().x-Util.getTextWidth(text))/2+rect.getPosition().x,
										(text.getPosition().y)));
		
	}
	
	
	public static String[] cutTable(String[]  tab, int start, int end){
		if(end<=start)throw new IllegalArgumentException("end plus petit que start");
		if(end> tab.length || start >tab.length )throw new IllegalArgumentException("plus grand que le tableau");
		String[]  tmp = new String[end-start];
		for(int i=start ; i<end ; i++){
			tmp[i-start] = tab[i];
		}
		return tmp;
	}


	public static boolean intersects(Vector2f point, RectangleShape rect) {
		 return ((point.x>rect.getPosition().x) && (point.x<rect.getPosition().x+rect.getSize().x) && 
		    		(point.y>rect.getPosition().y) && (point.y<rect.getPosition().y+rect.getSize().y));
	}
	
	public static int longToInt(long l) {
	    if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
	        throw new IllegalArgumentException
	            (l + " cannot be cast to int without changing its value.");
	    }
	    return (int) l;
	}
	
	public static float getDiag(RectangleShape rect) {
		return (float) Math.sqrt((
					((rect.getPosition().x+rect.getSize().x) - rect.getPosition().x)*
					((rect.getPosition().x+rect.getSize().x) - rect.getPosition().x)
				)+(
						((rect.getPosition().x+rect.getSize().y) - rect.getPosition().y)*
						((rect.getPosition().x+rect.getSize().y) - rect.getPosition().y)
				)
				);
	}

}
