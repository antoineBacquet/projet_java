package iut_lens.dut_info.monopoly.game;

import iut_lens.dut_info.monopoly.core.FontManager;
import iut_lens.dut_info.monopoly.core.TextureManager;
import iut_lens.dut_info.monopoly.core.Util;
import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.game.cases.Case;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Text;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

public abstract class CaseFallOnActionPopUp extends ActionPopUp {
	
	protected Case caseSource;
	
	protected Sprite sprite;

	protected RectangleShape rectangle;
	
	protected Game game;
	
	protected Text text;

	public CaseFallOnActionPopUp(ActionListener actionListener, Vector2f pos,
			Vector2i windowSize, Vector2f size, Case caseSource, Game game, String message) {
		super(actionListener, windowSize, size);
		this.caseSource = caseSource;
		this.game= game;
		
		
		Texture texture = TextureManager.getTexture("photosPlateau/"+caseSource.getName());
		
		
		this.sprite = new Sprite();
		sprite.setTexture(texture);
		
		float scale = (float)(size.y/sprite.getTexture().getSize().y*0.6);
		sprite.setScale(scale, scale);
		
		rectangle = new RectangleShape(size);
		rectangle.setPosition(windowSize.x*pos.x-size.x/2,windowSize.y*pos.y-size.y/2);
		rectangle.setFillColor(new Color(32,32,32));
		rectangle.setOutlineColor(Color.BLACK);
		rectangle.setOutlineThickness(5);
		
		sprite.setPosition(new Vector2f(rectangle.getPosition().x+rectangle.getSize().x*pos.x-texture.getSize().x*scale/2,rectangle.getPosition().y+50));
		
		
		text = new Text(message,FontManager.getFont("arial"),30);
		text.setPosition(new Vector2f(0,rectangle.getPosition().y+10));
		Util.centerTextRectInX(rectangle, text);
		
		
	}

}
