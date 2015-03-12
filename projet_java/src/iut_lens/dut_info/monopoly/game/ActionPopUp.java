package iut_lens.dut_info.monopoly.game;

import iut_lens.dut_info.monopoly.core.element.ActionListener;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

public abstract class ActionPopUp implements Drawable {
	
	
	private final static Color FLOU_COLOR = new Color(50,50,50,50);
	
	private RectangleShape fuzzyRectangle;
	
	protected ActionListener actionListener;
	
	public ActionPopUp(ActionListener actionListener, Vector2f windowSize, Vector2f size) {
		this.actionListener = actionListener;
		fuzzyRectangle = new RectangleShape(windowSize);
		fuzzyRectangle.setPosition(0,0);
		fuzzyRectangle.setFillColor(FLOU_COLOR);
		
	}
	
	public void renderFlou(RenderTarget target, RenderStates states){
		target.draw(fuzzyRectangle,states);
	}
	
	
	
	public abstract boolean handleEvent(Event evt);
	
	public abstract void update(Time tau);
	

}
