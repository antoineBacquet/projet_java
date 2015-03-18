package iut_lens.dut_info.monopoly.core;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

import org.jsfml.graphics.Texture;

public class TextureManager {
	
	private static HashMap<String,Texture> textures = new HashMap<String,Texture>();
	private final static String texturePath = "src/texture/";// texture des cases ?


	public static Texture getTexture(String textureName){
		
		
		
	    if(textures.containsKey(textureName) ){
	        return textures.get(textureName);
	    }
	    Texture texture = new Texture();
	    
	    try {
	    	texture.loadFromFile(Paths.get(texturePath + textureName + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	    
	    textures.put(textureName,texture);
	    return texture;


	}

}
