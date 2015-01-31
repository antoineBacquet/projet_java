package iut_lens.dut_info.monopoly.core.element;

import iut_lens.dut_info.monopoly.core.Content;
import iut_lens.dut_info.monopoly.core.FontManager;
import iut_lens.dut_info.monopoly.core.Util;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Text;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Mouse;
import org.jsfml.window.event.Event;

public class Selector extends Element{

	
	private static Color defaultColor = new Color(56,101,135);
	private static Color hoverColor = new Color(80,150,190);
	
	enum Etat {CLIC,NORMAL,HOVER};
	enum EventSelector{NONE,CLICK,MOVED};
	
	Etat etat = Etat.NORMAL;
	EventSelector event = EventSelector.NONE;
	
	
	private String[] option;
	
	private int nbrOption;
	
	boolean isDeployed;
	
	private int actual;
	
	private Vector2f 				pos;
	private Vector2f 				size;
	
	private RectangleShape[] 			rects;
	private RectangleShape 				actualRect;
	
	private Text[] 						texts;
	private Text 						actualText;
	
	public Selector(Content content,String[] option,Vector2f size, Vector2f pos, int actual){
		super(content);
		this.pos = pos;
		this.size = size;
		this.option = option;
		this.actual = actual;
		nbrOption = option.length;
		isDeployed = false;
		
		
		rects = new RectangleShape[nbrOption];
		texts = new Text[nbrOption];
		for (int i=0 ; i<nbrOption ; i++){
			rects[i]= new RectangleShape(size);
			rects[i].setFillColor(defaultColor);
			rects[i].setPosition(pos.x,pos.y+size.y*i+size.y);
			
			
			texts[i] = new Text(option[i],FontManager.getFont("arial"),20);
			Util.centerTextRect(rects[i],texts[i]);
			texts[i].setColor(Color.BLACK);
			
			
		}
		
		actualRect= new RectangleShape(size);
		actualRect.setFillColor(defaultColor);
		actualRect.setPosition(pos.x,pos.y);
		
		actualText = new Text(option[actual],FontManager.getFont("arial"),20);
		Util.centerTextRect(actualRect,actualText);
		actualText.setColor(Color.BLACK);
	}
	
	
	public void setPositionRelative(Vector2f windowSize,float posX, float posY){
		pos = new Vector2f(windowSize.x*posX - (this.size.x/2), windowSize.y*posY - (this.size.y/2));
		
		for (int i=0 ; i<nbrOption ; i++){
			rects[i].setPosition(pos.x,pos.y+size.y*i+size.y);
			Util.centerTextRect(rects[i],texts[i]);
		}
		actualRect.setPosition(pos.x,pos.y);
		Util.centerTextRect(actualRect,actualText);
	}
	
	


	@Override
	public void handleEvent(Event evt) {
		if(isDisabled)return;
		if(evt.type==Event.Type.MOUSE_MOVED)
			event = EventSelector.MOVED;
		

	    if(evt.type==Event.Type.MOUSE_BUTTON_PRESSED){
	        if (evt.asMouseButtonEvent().button== Mouse.Button.LEFT){
	        	event = EventSelector.CLICK;
	        }
	        
	    }
	    
	    
		
	}
	
	@Override
	public void update(Time tau) {
		if(event == EventSelector.MOVED){
			if(Util.intersects(content.getMousePos(), actualRect)){
				actualRect.setFillColor(hoverColor);
			}
			else{
				actualRect.setFillColor(defaultColor);
			}
			if(isDeployed){
				for(RectangleShape r:rects)
					if(Util.intersects(content.getMousePos(), r)){
						r.setFillColor(hoverColor);
					}
					else{
						r.setFillColor(defaultColor);
					}
			}
			event = EventSelector.NONE;
		}
		
		
		if(event == EventSelector.CLICK){
			event = EventSelector.NONE;
			
			if(isDeployed){
				if(Util.intersects(content.getMousePos(), actualRect))
					isDeployed = false;
				else{
					for(int i=0 ; i< rects.length ; i++){
						if(Util.intersects(content.getMousePos(), rects[i])){
							actual = i;
							majActual();
							isDeployed = false;
						}
							
					}
				}
			}
			else{
				if(Util.intersects(content.getMousePos(), actualRect))
					isDeployed = true;
			}
		}
		
	}
	
	@Override
	public void render(RenderTarget window) {
		window.draw(actualRect);
		window.draw(actualText);
		
		if(isDeployed){
			for( int i=0 ; i<nbrOption ; i++){
				window.draw(rects[i]);
				window.draw(texts[i]);
			}
		}
		
	}
	
	public void majActual(){
		actualText.setString(option[actual]);
	}
	
	
	public int getChoix(){
		return actual;
	}


	@Override
	public void disabled() {
		isDisabled = true;
		isDeployed = false;
		event = EventSelector.NONE;
		
	}


	@Override
	public void enable() {
		isDisabled = false;
		
	}


	
	

}
