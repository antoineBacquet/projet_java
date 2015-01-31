package iut_lens.dut_info.monopoly.core;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

public class Window {
	
	private int width;
	private int height;
	
	
	private RenderWindow window;
	private String name;
	
	private Content content;
	
	private Time time;
	private Clock clock;
	private Vector2i mouse;
	
	private boolean contentToChange = false;
	private Content nextContent;
	
	public Window(int width, int height,String name){
		this.height = height;
		this.width = width;
		this.name = name;
		clock = new Clock();
		mouse = new Vector2i(0,0);
	}
	
	public void setContent(Content content){
		this.content = content;
		content.setWindow(this);
	}
	
	public void create(){
		window = new RenderWindow(new VideoMode(height,width),name,RenderWindow.TITLEBAR|RenderWindow.CLOSE);
		window.setFramerateLimit(60);
	}
	
	
	public void handleEvent() {
		for(Event evt:window.pollEvents()){
			if(evt.type == Event.Type.CLOSED){
				onClose();
			}
			else if(evt.type == Event.Type.MOUSE_MOVED){
				mouse = evt.asMouseEvent().position;
			}
			
			if(content!=null){
				content.handleEvent(evt);
				content.handleEventContent(evt);
			}
				
			
		}	
	}
	
	public void update() {
		time = clock.restart();
		if(content!=null){
			content.update(time);
			content.updateContent(time);
		}
	}
	
	public void render() {
		window.clear(Color.WHITE);
		
		if(content!=null){
			content.render(window);
			content.renderContent(window);			
		}
		
		window.display();
		
		if(contentToChange){
			setContent(nextContent);
			nextContent = null;
			contentToChange = false;
		}
	}
	
	
	public Vector2i getMousePos(){
		return mouse;
	}
	
	public void setSize(Vector2i size){
		this.height = size.x;
		this.width = size.y;
		window.create(new VideoMode(height,width),name,RenderWindow.TITLEBAR|RenderWindow.CLOSE);
		content.onCreate();
	}

	public Vector2f getSize() {
		return new Vector2f(this.window.getSize());
	}
	
	
	public void changeContent(Content c){
		contentToChange = true;
		nextContent = c;
	}
	
	public void onClose(){
		window.close();
		WindowManager.removeWindow(this);
	}
	

}
