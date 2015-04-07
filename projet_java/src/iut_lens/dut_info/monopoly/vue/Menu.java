package iut_lens.dut_info.monopoly.vue;

import iut_lens.dut_info.monopoly.core.Content;
import iut_lens.dut_info.monopoly.core.TextureManager;
import iut_lens.dut_info.monopoly.core.Window;
import iut_lens.dut_info.monopoly.core.WindowOption;
import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.Button;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

public class Menu extends Content {
	
	
	private Button gameButton;
	private Button optionButton;
	private Sprite background;
	private Texture texture;
	
	public Menu(WindowOption windowOption, Window window){
		super( windowOption,  window);
		
		gameButton = new Button(this,new Vector2f(200,50),"Jouer");
		addElement(gameButton);
		
		optionButton = new Button(this,new Vector2f(200,50),"Option");
		addElement(optionButton);
		

		
		
		this.texture =TextureManager.getTexture("bg");
		
		
		background = new Sprite(texture);
		
		

		
		
	}
	
	@Override
	protected void onCreate() {
		//taille du background
		Vector2f scale = new Vector2f(((float)super.getWindowOption().getSize().x)/texture.getSize().x,	
				((float)super.getWindowOption().getSize().y)/texture.getSize().y);
		//System.out.println("Menu :: onCreate() :: scale : " + scale);
		background.setScale(scale);
		
		//position des boutton
		gameButton.setPositionRelative(super.getWindowOption().getSize(), 0.5f, 0.4f);
		optionButton.setPositionRelative(super.getWindowOption().getSize(), 0.5f, 0.5f);
	}
	
	
	@Override
	public void handleEvent(Event evt) {
	

	}

	@Override
	public void update(Time tau) {

	}

	@Override
	public void render(RenderTarget target) {
		target.draw(background);

	}

	@Override
	public void actionPerformed(Action action) {
		if(action.getSource() == optionButton){
			super.getWindow().changeContent(new OptionContent(super.getWindowOption(),super.getWindow()));
		}
		if(action.getSource() == gameButton){
			super.getWindow().changeContent(new GameCreationContent(super.getWindowOption(),super.getWindow()));
		}
		
	}
	
	

}
