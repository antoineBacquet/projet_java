package iut_lens.dut_info.monopoly.vue;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

import iut_lens.dut_info.monopoly.core.Content;
import iut_lens.dut_info.monopoly.core.Window;
import iut_lens.dut_info.monopoly.core.WindowManager;
import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.Button;

public class Menu extends Content {
	
	
	private Button gameButton;
	private Button optionButton;
	
	public Menu(){
		super();
		
		gameButton = new Button(this,new Vector2f(200,50),"game");
		addElement(gameButton);
		
		optionButton = new Button(this,new Vector2f(200,50),"option");
		addElement(optionButton);
	}

	@Override
	public void handleEvent(Event evt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Time tau) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(RenderTarget target) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(Action action) {
		if(action.getSource() == optionButton){
			super.window.changeContent(new OptionContent());
		}
		if(action.getSource() == gameButton){
			super.window.changeContent(new GameCreationContent());
		}
		
	}

	@Override
	protected void onCreate() {
		gameButton.setPositionRelative(super.window.getSize(), 0.5f, 0.1f);
		optionButton.setPositionRelative(super.window.getSize(), 0.5f, 0.3f);
		
	}
	
	//TODO creer un main un peu plus elaborer
	
	public static void main(String[] args) {
		Window w = new Window(600,800,"test temporaire");
		w.create();
		w.setContent(new Menu());
		WindowManager.addWindow(w);
		
		WindowManager.loop();
	}

}
