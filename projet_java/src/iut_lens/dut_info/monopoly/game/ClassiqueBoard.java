package iut_lens.dut_info.monopoly.game;

import iut_lens.dut_info.monopoly.core.Content;
import iut_lens.dut_info.monopoly.core.TextureManager;
import iut_lens.dut_info.monopoly.core.element.Action;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

public class ClassiqueBoard extends Board {

	
	
	
	
	
	public ClassiqueBoard(Content content, Vector2f size, Vector2f pos) {
		super(content,size,pos,TextureManager.getTexture("board"));
	}

	@Override
	public void createCase() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onCreate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleEvent(Event evt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Time tau) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(RenderTarget target) {
		render.clear(Color.WHITE);
		render.draw(rect);
		
		render.draw(boardSprite);
		
		render.display();
		
		sprite.setTexture(render.getTexture());
		
		target.draw(sprite);
		
	}

}
