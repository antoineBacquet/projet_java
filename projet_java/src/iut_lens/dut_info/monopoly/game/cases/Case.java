package iut_lens.dut_info.monopoly.game.cases;

import iut_lens.dut_info.monopoly.core.TextureManager;
import iut_lens.dut_info.monopoly.game.Player;

import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;


//TODO implémenter toute les sous classes #hf
public abstract class Case implements Drawable{
	
	
	private String name;
	private final int SIZE_X = 80; 
	private final int SIZE_Y = 200;
	
	protected final String textureName;
	
	protected Texture texture;
	protected Sprite sprite;
	
	private Player owner = null;
	private Vector2f size;
	
	
	
	public Case(String textureName) {
		this.textureName = textureName;	
		
		texture  = TextureManager.getTexture(textureName);
		
		sprite = new Sprite();
		sprite.setTexture(texture);
		sprite.setScale(new Vector2f(SIZE_X/texture.getSize().x,SIZE_Y/texture.getSize().y));
		
		
	}
	
	public void setSize(Vector2f size){
		this.size = size;
	}

	@Override
	public void draw(RenderTarget target, RenderStates state) {
		target.draw(sprite,state);
		
	}
	

}
