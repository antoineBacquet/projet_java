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
			rects[i].setOutlineThickness(1);
			rects[i].setOutlineColor(Color.BLACK);
			rects[i].setPosition(pos.x,pos.y+size.y*i+size.y);
			
			
			texts[i] = new Text(option[i],FontManager.getFont("arial"),20);
			Util.centerTextRect(rects[i],texts[i]);
			texts[i].setColor(Color.BLACK);
			
			
		}
		
		actualRect= new RectangleShape(size);
		actualRect.setOutlineThickness(1);
		actualRect.setOutlineColor(Color.BLACK);
		actualRect.setPosition(pos.x,pos.y);
		
		actualText = new Text(option[actual],FontManager.getFont("arial"),20);
		Util.centerTextRect(actualRect,actualText);
		actualText.setColor(Color.BLACK);
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

	@Override
	public void handleEvent(Event evt) {



	    if(evt.type==Event.Type.MOUSE_BUTTON_PRESSED){
	        if (evt.asMouseButtonEvent().button== Mouse.Button.LEFT){
	        	if(Util.intersects(content.getMousePos(), actualRect)){
	        		isDeployed = !isDeployed;
	        	}
	        	else if(isDeployed){
	        		for(int i=0 ; i<nbrOption ; i++){
	    	        	if(Util.intersects(content.getMousePos(), actualRect)){
	    	        		actual = i;
	    	        		majActual();
	    	        		isDeployed = false;
	    	        	}
	    	        }
	        	}
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
	public void update(Time tau) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
