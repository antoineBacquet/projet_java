package iut_lens.dut_info.monopoly.core;

import iut_lens.dut_info.monopoly.core.element.Element;

import java.util.LinkedList;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2i;
import org.jsfml.window.event.Event;

public abstract class Content {
	
	private Window window;
	
	private LinkedList<Element> elements;
	
	public Content(){
		elements = new LinkedList<Element>();
	}
	
	public void setWindow(Window window){
		this.window = window;
	}
	
	public Vector2i getMousePos(){
		return window.getMousePos();
	}
	
	public void addElement(Element e){
		elements.add(e);
	}
	
	public void handleEventContent(Event evt){
		for(Element e:elements)
			e.handleEvent(evt);
	}
	
	public void updateContent(Time tau){
		for(Element e:elements)
			e.update(tau);
	}
	
	public void renderContent(RenderTarget target){
		for(Element e:elements)
			e.render(target);
	}
	
	
	public abstract void handleEvent(Event evt);
	
	public abstract void update(Time tau);
	
	public abstract void render(RenderTarget target);

}
