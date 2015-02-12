package iut_lens.dut_info.monopoly.vue;


import org.jsfml.graphics.Color;
import org.jsfml.graphics.Image;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.graphics.TextureCreationException;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.event.Event;

import iut_lens.dut_info.monopoly.core.Content;
import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.Action.ActionType;
import iut_lens.dut_info.monopoly.core.element.Button;
import iut_lens.dut_info.monopoly.core.element.Selector;
import iut_lens.dut_info.monopoly.core.popUp.OptionPopUpContent;
import iut_lens.dut_info.monopoly.core.popUp.PopUpOppener;
import iut_lens.dut_info.monopoly.core.popUp.PopUpWindow;

public class OptionContent extends Content implements PopUpOppener{

	
	private Selector resSelector;
	
	private Button saveButton;
	private Button cancelButton;
	OptionPopUpContent popUp = null;
	
	private Image imageFlou;
	Texture textureFlou = new Texture();
	Sprite spriteFlou = new Sprite();
	
	private Vector2f oldRes ;
	
	
	String[] res = {"800:600","1024:600","1400:1050","1600:900","1920:1080"};
	public OptionContent() {
		super();
		
		resSelector = new Selector(this,res,new Vector2f(200,50),new Vector2f(0,0),0);
		super.addElementNoRender(resSelector);
		
		saveButton = new Button(this,new Vector2f(200,50),"save");
		super.addElementNoRender(saveButton);
		cancelButton = new Button(this,new Vector2f(200,50),"cancel");
		super.addElementNoRender(cancelButton);
		
		imageFlou = new Image();
		imageFlou.create(1920, 1080, new Color(10,10,10));
		
		
		try {
			textureFlou.loadFromImage(imageFlou);
		} catch (TextureCreationException e) {
			e.printStackTrace();
		}
		spriteFlou.setTexture(textureFlou);
		spriteFlou.setColor(new Color(10,10,10,128));
	}	
	@Override
	public void actionPerformed(Action action) {
		if(action.getSource() == cancelButton)
			super.window.changeContent(new Menu());
		else if(action.getSource() == saveButton){
			oldRes = super.getWindow().getSize();//TODO a changer avec les option de fenetre
			String[] tmp = res[resSelector.getChoix()].split(":");
			super.window.setSize(new Vector2i(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1])));
			popUp = new OptionPopUpContent(this);
			disableAll();
		}
		
		else if(action.getSource() == popUp){
			popUp = null;
			enableAll();
			if(action.getActionType() == ActionType.CANCEL){
				super.window.setSize(new Vector2i(oldRes));
			}
		}
		
	}
	
	

	@Override
	public void handleEvent(Event evt) {
		if(popUp!=null)
			popUp.handleEvent(evt);
		
	}

	@Override
	public void update(Time tau) {
		if(popUp!=null)
			popUp.update(tau);
		
	}

	@Override
	public void render(RenderTarget target) {
		cancelButton.render(target);
		saveButton.render(target);
		resSelector.render(target);
		if(popUp!=null){
			target.draw(spriteFlou);
			popUp.render(target);
		}
		
	}

	@Override
	protected void onCreate() {
		resSelector.setPositionRelative(super.window.getSize(),0.5f, 0.1f);
		saveButton.setPositionRelative(super.window.getSize(), 0.2f, 0.8f);
		cancelButton.setPositionRelative(super.window.getSize(), 0.8f, 0.8f);
	}
	@Override
	public void onPopClose(PopUpWindow popUpWindow) {
		// TODO Auto-generated method stub
		
	}
	
	public void enableAll(){
		cancelButton.enable();
		resSelector.enable();
		saveButton.enable();
	}
	
	public void disableAll(){
		cancelButton.disabled();
		resSelector.disabled();
		saveButton.disabled();
	}

}
