package iut_lens.dut_info.monopoly.core;

import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.core.element.Element;

import java.util.LinkedList;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2i;
import org.jsfml.window.event.Event;

public abstract class Content implements ActionListener{
	
	private Window window;
	private LinkedList<Element> elements;
	private LinkedList<Element> elementsNoRender;
	
	private WindowOption windowOption;
	
	public Content(WindowOption windowOption,Window window){
		this.window = window;
		this.windowOption = windowOption;
		elements = new LinkedList<Element>();
		elementsNoRender = new LinkedList<Element>();
	}
	
	public Vector2i getMousePos(){
		return windowOption.getMousePos();
	}
	
	public void addElement(Element e){
		elements.add(e);
	}
	
	public void addElementNoRender(Element e){
		elementsNoRender.add(e);
	}
	
	public void handleEventContent(Event evt){
		for(Element e:elements)
			e.handleEvent(evt);
		for(Element e:elementsNoRender)
			e.handleEvent(evt);
	}
	
	public void updateContent(Time tau){
		for(Element e:elements)
			e.update(tau);
		for(Element e:elementsNoRender)
			e.update(tau);
	}
	
	public void renderContent(RenderTarget target){
		for(Element e:elements)
			e.render(target);
	}
	
	
	protected abstract void onCreate();
	
	public abstract void handleEvent(Event evt);
	
	public abstract void update(Time tau);
	
	public abstract void render(RenderTarget target);

	public WindowOption getWindowOption() {
		return windowOption;
	}

	public Window getWindow() {
		// TODO Auto-generated method stub
		return this.window;
	}
	
}
