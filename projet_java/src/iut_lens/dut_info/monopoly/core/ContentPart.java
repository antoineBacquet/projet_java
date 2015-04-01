package iut_lens.dut_info.monopoly.core;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.event.Event;

public abstract class ContentPart {
	
	
	
	protected Vector2f size;
	
	protected Vector2f pos;

	protected Vector2i contentSize;
	
	

	
	
	
	public ContentPart(Vector2i contentSize, Vector2f size, Vector2f pos) {
		this.size = size;
		this.pos = pos;
		this.contentSize = contentSize;
	}
	
	public void resize(Vector2i contentSize, Vector2f size){
		this.contentSize = contentSize;
		this.size = size;
		this.onResize();
	}




	public abstract void onResize();
	
	public abstract void handleEvent(Event evt);
	
	public abstract void update(Time tau);
	
	public abstract void render(RenderTarget target);
}
