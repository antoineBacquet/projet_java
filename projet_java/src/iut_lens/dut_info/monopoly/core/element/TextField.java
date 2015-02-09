package iut_lens.dut_info.monopoly.core.element;

import iut_lens.dut_info.monopoly.core.Content;
import iut_lens.dut_info.monopoly.core.FontManager;
import iut_lens.dut_info.monopoly.core.Util;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.RenderTexture;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Text;
import org.jsfml.graphics.TextureCreationException;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;
import org.jsfml.window.event.Event;

public class TextField extends Element {
	
	
	enum EventTextField{NONE,CLICK,RELEASED};
	
	EventTextField event = EventTextField.NONE;
	
	private static final Color outlineColor = new Color(56,101,135);
	private static final Color fillColor = new Color(90,150,170);
	
	
	private Vector2f pos;
	private Vector2f size;
	private RectangleShape rect;
	private Text text;
	private StringBuffer chaine;
	boolean isFocus;
	private RectangleShape curseur;
	private boolean curseurClig = false;
	private Time curseurTime;
	private RenderTexture texture;
	private Sprite sprite;
	private int decalage;
	
	private int maxChar;

	private int textSize;



	
	
	
	public TextField(Content content, Vector2f size, String defaultText) {
		super(content);
		pos = new Vector2f(0,0);
		
		//rectangle setting
		rect = new RectangleShape(size);
		rect.setFillColor(fillColor);
		rect.setOutlineColor(outlineColor);
		rect.setOutlineThickness(1);
		//
				
		//text setting
		textSize = (int)(size.y*0.8);
		this.text = new Text(defaultText, FontManager.getFont("arial"), textSize);
		this.text.setColor(Color.BLACK);
		//curseur setting
		curseur = new RectangleShape(new Vector2f(0,size.y-6));
		curseur.setOutlineThickness(1);
		curseur.setOutlineColor(Color.BLACK);
				
				
		this.chaine = new StringBuffer(defaultText);
		this.text.setString(chaine.toString());	
		isFocus = false;
		curseurTime = Time.ZERO;
				
		//test
		texture = new RenderTexture();
		try {
			texture.create((int)size.x-2, (int)size.y,false);
		} catch (TextureCreationException e) {
			e.printStackTrace();
		}		
		sprite = new Sprite();

		sprite.setColor(fillColor);
		decalage = 0;
		this.size = size;
		
		maxChar = 100;
	}
	
	
	
	public void setPositionRelative(Vector2f windowSize,float posX, float posY){
		pos = new Vector2f(windowSize.x*posX - (this.size.x/2), windowSize.y*posY - (this.size.y/2));
		
		this.text.setPosition(2,((size.y-textSize)/2-3));

		curseur.setPosition(new Vector2f(pos.x+2,pos.y+3));
		rect.setPosition(pos);

		sprite.setPosition(new Vector2f(pos.x+2,pos.y));
		majText();
	}
	
	
	public void majText(){
		text.setString(chaine.toString());
		if(Util.getTextWidth(text)>(int)(size.x)-10){
			decalage = (int) (size.x-Util.getTextWidth(text)-10);
		}
		else{
			decalage = 0;
		}
		curseur.setPosition(Util.getTextWidth(text)+3+pos.x + decalage, curseur.getPosition().y);
		text.setPosition(decalage,text.getPosition().y);
	}
	
	public void setMaxChar(int max){
		this.maxChar = max;
	}
	
	public String getString(){
		return chaine.toString();
	}

	@Override
	public boolean handleEvent(Event evt) {
		if(evt.type == Event.Type.MOUSE_BUTTON_PRESSED){
			if(evt.asMouseButtonEvent().button == Mouse.Button.LEFT && Util.intersects(content.getMousePos(), rect)){
				event = EventTextField.CLICK;
				return true;
					
			}
		}
		if(isFocus && evt.type == Event.Type.TEXT_ENTERED){
			
			char tmp = evt.asTextEvent().character;
			if((int)tmp != 8 && (int)tmp != 13 && chaine.length()<maxChar){
				chaine.append(tmp);
				majText();
			}
			else if((int)tmp==8 && chaine.length()>0){
				chaine.deleteCharAt(chaine.length()-1);
				majText();
			}
		}
		return false;

	}

	@Override
	public void update(Time tau) {
		if(event == EventTextField.CLICK){
			event = EventTextField.NONE;
			isFocus = true;
		}
		
		
		curseurTime = Time.add(tau, curseurTime);
		if(curseurTime.asMilliseconds()>500){
			curseurTime = Time.ZERO;
			curseurClig=!curseurClig;
		}

	}

	@Override
	public void render(RenderTarget target) {
		target.draw(rect);
		
		texture.clear(Color.WHITE);
		texture.draw(text);
		texture.display();
		sprite.setTexture(texture.getTexture());
		target.draw(sprite);
		if(curseurClig && isFocus)target.draw(curseur);

	}

	@Override
	public void disabled() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enable() {
		// TODO Auto-generated method stub

	}

}