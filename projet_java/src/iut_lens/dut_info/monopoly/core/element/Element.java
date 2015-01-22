package iut_lens.dut_info.monopoly.core.element;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.window.event.Event;

public interface Element {
	

	public void handleEvent(Event evt);
	
	public void update(Time tau);
	
	public void render(RenderTarget target);

}
