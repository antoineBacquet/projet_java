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
	
	



	public Button(Content content, Vector2f size, Vector2f pos, String s) {
		super(content);
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
	
	public Button(Content content, Vector2f size, String s) {
		this(content,size,new Vector2f(0,0),s);
	}
	
	public void setPositionRelative(Vector2f windowSize,float posX, float posY){
		pos = new Vector2f(windowSize.x*posX - (this.size.x/2), windowSize.y*posY - (this.size.y/2));
		
		rectangle.setPosition(pos);
		centerText();
	}

	@Override
	public void handleEvent(Event evt) {

	    if(evt.type==Event.Type.MOUSE_BUTTON_PRESSED){
	        if (evt.asMouseButtonEvent().button== Mouse.Button.LEFT){
	            event = EventButton.CLICK;
	        }
	    }
	    if(evt.type==Event.Type.MOUSE_BUTTON_RELEASED){
	        if (evt.asMouseButtonEvent().button== Mouse.Button.LEFT){
	            event = EventButton.RELEASED;
	        }
	    }

	}

	@Override
	public void update(Time tau) {
		if(event == EventButton.RELEASED ){
	        wasClicked=false;
	        if( Util.intersects(content.getMousePos(),rectangle) && etat == Etat.CLIC ){
	        	content.actionPerformed(new Action(this));
	            event = EventButton.NONE;
	            return ;
	        }

	    }

	    else if(wasClicked ||((event == EventButton.CLICK) && (Util.intersects(content.getMousePos(),rectangle)))){
	        etat = Etat.CLIC;
	        wasClicked=true;
	        event = EventButton.NONE;
	        return ;
	    }

	    else if(Util.intersects(content.getMousePos(),rectangle)){
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


	/*
	int Button::getTextWidth(sf::Text text)
	{
	    int width = 0;
	    if(text.getString().isEmpty())
	        return width;

	    width += text.getFont()->getGlyph(text.getString()[0], text.getCharacterSize(), false).advance;
	    if(text.getString().getSize() == 1)
	        return width;

	    for(int i = 1; i < text.getString().getSize(); i++)
	    {
	        width += text.getFont()->getGlyph(text.getString()[i], text.getCharacterSize(), false).advance;
	        width += text.getFont()->getKerning(text.getString()[i-1], text.getString()[i], text.getCharacterSize());
	    }

	    return width;
	}*/

}
