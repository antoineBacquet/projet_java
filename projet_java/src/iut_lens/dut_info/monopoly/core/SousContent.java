package iut_lens.dut_info.monopoly.core;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.RenderTexture;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.graphics.TextureCreationException;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.event.Event;

public abstract class SousContent {
	
	
	protected Content content;
	

	protected Vector2f size;
	protected RenderTexture render;
	protected Texture texture;
	protected Sprite sprite;
	protected Vector2f pos;
	
	public SousContent(Content content, Vector2f size, Vector2f pos){
		this.size = size;
		this.pos = pos;
		
		render = new RenderTexture();
		try {
			render.create((int)size.x, (int)size.y);
		} catch (TextureCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		texture = new Texture();
		sprite = new Sprite();
		sprite.setPosition(pos);
		
	}

	public Vector2i getMousePos(){
		return content.getWindow().getMousePos();
	}
	
	protected Vector2f getSize(){
		return size;
	}
	
	
	protected abstract void onCreate();
	
	public abstract void handleEvent(Event evt);
	
	public abstract void update(Time tau);
	
	public abstract void render(RenderTarget target);

}
