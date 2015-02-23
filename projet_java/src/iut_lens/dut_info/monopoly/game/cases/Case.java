package iut_lens.dut_info.monopoly.game.cases;

import iut_lens.dut_info.monopoly.core.TextureManager;
import iut_lens.dut_info.monopoly.core.Util;
import iut_lens.dut_info.monopoly.game.Player;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

//TODO changer pour faire en sorte qu'une case posséde carte (ou pas)
//TODO implémenter toute les sous classes #hf
public abstract class Case implements Drawable{
	
	
	private String name;
	private final int SIZE_X = 80; 
	private final int SIZE_Y = 200;
	
	private final static Color DEFAULT_COLOR = Color.BLACK;
	private final static Color HOVER_COLOR = new Color(1,1,1,50);
	
	protected final String textureName;
	
	protected Texture texture;
	protected Sprite sprite;
	
	private Player owner = null;
	private Vector2f size;
	
	private RectangleShape rect;
	
	
	
	public Case(String textureName) {
		this.textureName = textureName;	
		
		texture  = TextureManager.getTexture(textureName);
		
		sprite = new Sprite();
		sprite.setTexture(texture);
		sprite.setScale(new Vector2f(SIZE_X/texture.getSize().x,SIZE_Y/texture.getSize().y));
		
		rect = new RectangleShape();
		rect.setOutlineColor(DEFAULT_COLOR);
		rect.setOutlineThickness(2);
		rect.setFillColor(Color.TRANSPARENT);
		
	}
	
	public void onMouseMove(Vector2i mouse){
		if(Util.intersects(mouse, rect)){
			rect.setFillColor(HOVER_COLOR);
		}
		else{
			rect.setFillColor(Color.TRANSPARENT);
		}
	}
	
	public void setSize(Vector2f size){
		this.size = size;
		rect.setSize(new Vector2f(size.x-4,size.y-4));
	}

	@Override
	public void draw(RenderTarget target, RenderStates state) {
		//target.draw(sprite,state);
		target.draw(rect);
		
	}
	
	public void setOwner(Player player){
		this.owner = player;
		this.setColor(player.getColor());
		
	}
	
	
	
	private void setColor(Color color) {
		
		
	}
	//TODO a coder
	public void setPos(Vector2f pos) {
		rect.setPosition(new Vector2f(pos.x+2,pos.y+2));
		
	}
	

}
