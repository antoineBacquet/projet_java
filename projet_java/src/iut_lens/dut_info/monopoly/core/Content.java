package iut_lens.dut_info.monopoly.core;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.window.event.Event;

public abstract class Content {
	
	private Window window;
	
	
	public Content(){
		
	}
	
	public void setWindow(Window window){
		this.window = window;
	}
	
	
	public abstract void handleEvent(Event evt);
	
	public abstract void update(Time tau);
	
	public abstract void render(RenderTarget target);

}
