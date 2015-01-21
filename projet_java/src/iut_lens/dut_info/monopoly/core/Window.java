package iut_lens.dut_info.monopoly.core;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Time;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

public class Window {
	
	private int width;
	private int height;
	
	
	private RenderWindow window;
	private String name;
	
	public Window(int width, int height,String name){
		this.height = height;
		this.width = width;
		this.name = name;
	}
	
	public void create(){
		window = new RenderWindow(new VideoMode(height,width),name);
	}
	
	
	public void handleEvent() {
		for(Event evt:window.pollEvents()){
			if(evt.type == Event.Type.CLOSED){
				window.close();
				WindowManager.removeWindow(this);
			}
		}
	}
	
	public void update() {
		
	}
	
	public void render() {
		window.clear(Color.WHITE);
		//TODO a faire
		window.display();
	}
	
	
	

}
