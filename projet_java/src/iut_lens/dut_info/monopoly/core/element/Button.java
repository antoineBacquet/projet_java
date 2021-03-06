package iut_lens.dut_info.monopoly.core.element;

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

public class Button extends Element {
	
	enum Etat {CLIC,NORMAL,HOVER};
	enum EventButton{NONE,CLICK,RELEASED};
	
	private RectangleShape rectangle;
	
	private Vector2f size;
	private Vector2f pos;
	
	private Etat etat;
	private EventButton event;

	private Text text;

	private boolean wasClicked;
	
	private Vector2i mouse = new Vector2i(0,0);



	public Button(ActionListener actionListener, Vector2f size, Vector2f pos, String s) {
		super(actionListener);
		this.pos = pos;
		this.size = size;
		
		
		rectangle = new RectangleShape(size);
		rectangle.setFillColor(new Color(100,100,100));

		rectangle.setPosition(pos);

	    event = EventButton.NONE;
	    etat = Etat.NORMAL;

	    text = new Text();

	    text.setCharacterSize(20);
	    text.setFont(FontManager.getFont("arial"));
	    text.setColor(Color.WHITE);
	    text.setString(s);

	    centerText();
	}
	
	public Button(ActionListener actionListener, Vector2f size, String s) {
		this(actionListener,size,new Vector2f(0,0),s);
	}
	
	public void setPositionRelative(Vector2i windowSize,float posX, float posY){
		pos = new Vector2f(windowSize.x*posX - (this.size.x/2), windowSize.y*posY - (this.size.y/2));
		
		rectangle.setPosition(pos);
		centerText();
	}
	
	public void setPositionRelativeToRectangle(RectangleShape rect,float posX, float posY){
		pos = new Vector2f(rect.getPosition().x + rect.getSize().x*posX - (this.size.x/2), rect.getPosition().y + rect.getSize().y*posY - (this.size.y/2));
		
		rectangle.setPosition(pos);
		centerText();
	}

	@Override
	public boolean handleEvent(Event evt) {
		if(isDisabled)return false;
		
		if(evt.type == Event.Type.MOUSE_MOVED)mouse = evt.asMouseEvent().position;
	    if(evt.type==Event.Type.MOUSE_BUTTON_PRESSED && (Util.intersects(mouse,rectangle))){
	        if (evt.asMouseButtonEvent().button== Mouse.Button.LEFT){
	            event = EventButton.CLICK;
	            return true;
	        }
	    }
	    if(evt.type==Event.Type.MOUSE_BUTTON_RELEASED){
	        if (evt.asMouseButtonEvent().button== Mouse.Button.LEFT){
	            event = EventButton.RELEASED;
	        }
	    }
	    return false;

	}

	@Override
	public void update(Time tau) {
		if(event == EventButton.RELEASED ){
	        wasClicked=false;
	        if( Util.intersects(mouse,rectangle) && etat == Etat.CLIC ){
	        	actionListener.actionPerformed(new Action(this));
	            event = EventButton.NONE;
	            return ;
	        }

	    }

	    else if(wasClicked ||((event == EventButton.CLICK)  )){
	        etat = Etat.CLIC;
	        wasClicked=true;
	        event = EventButton.NONE;
	        return ;
	    }

	    else if(!isDisabled && Util.intersects(mouse,rectangle)){
	        etat=Etat.HOVER;
	        rectangle.setFillColor(new Color(80,150,190));
	        return ;
	    }

		rectangle.setFillColor(new Color(56,101,135));
	    etat = Etat.NORMAL;
	    event = EventButton.NONE;

	}

	@Override
	public void render(RenderTarget target) {
		target.draw(rectangle);
		target.draw(text);

	}










	/*
	void center(float windowWidth)
	{
	    int decalage = 4;
	    this->pos = sf::Vector2f(windowWidth/2-(this->size.x/2),pos.y);
	    rectExt.setPosition(windowWidth/2-(this->size.x/2),this->pos.y);
	    rectInt.setPosition(windowWidth/2-(this->size.x/2)+decalage/2,this->pos.y+decalage/2);
	    centerText();
	}*/

	
	private void centerText()	{
	    text.setPosition(new Vector2f((size.x-Util.getTextWidth(text))/2+pos.x,(size.y-text.getCharacterSize())/2+pos.y));
	}

	@Override
	public void disabled() {
		isDisabled = true;
		event = EventButton.NONE;
		wasClicked=false;
		
	}


	@Override
	public void enable() {
		isDisabled = false;
		
	}

}
