package iut_lens.dut_info.monopoly.game;

import iut_lens.dut_info.monopoly.core.TextureManager;
import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.core.element.Button;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.event.Event;

public class CaseActionPopUp extends ActionPopUp implements ActionListener {

	
	
	private Texture texture;
	private Sprite sprite;
	
	private RectangleShape rectangle;
	
	private Button buttonOk;

	public CaseActionPopUp(String textureName,ActionListener actionListener,Vector2f relativePos, Vector2i vector2i, Vector2f size) {
		super(actionListener,vector2i,size);
		Vector2f pos = new Vector2f(vector2i.x*0.5f,vector2i.y*0.2f);
		this.texture = TextureManager.getTexture(textureName);
		
		this.sprite = new Sprite();
		sprite.setTexture(texture);
		
		float scale = (float)(size.y/sprite.getTexture().getSize().y*0.6);
		sprite.setScale(scale, scale);	

		
		
		rectangle = new RectangleShape(size);
		rectangle.setPosition(pos.x-size.x/2,pos.y);
		rectangle.setFillColor(new Color(32,32,32));
		rectangle.setOutlineColor(Color.BLACK);
		rectangle.setOutlineThickness(5);
		
		sprite.setPosition(new Vector2f(rectangle.getPosition().x+(rectangle.getSize().x/2)-(texture.getSize().x*scale/2),pos.y+10));
		
		
		buttonOk = new Button(this,new Vector2f(200,50),"OK");
		buttonOk.setPositionRelative(vector2i, 0.5f, 0.7f);
		
		
	}
	
	
	
	@Override
	public void draw(RenderTarget target, RenderStates states) {
		super.renderFlou(target, states);
		target.draw(rectangle,states);
		target.draw(sprite,states);
		buttonOk.render(target);
	}

	@Override
	public boolean handleEvent(Event evt) {
		buttonOk.handleEvent(evt);
		return false;
	}

	@Override
	public void update(Time tau) {
		buttonOk.update(tau);

	}



	@Override
	public void actionPerformed(Action action) {
		if(action.getSource() == buttonOk)super.actionListener.actionPerformed(new Action(this));
		
	}

}
