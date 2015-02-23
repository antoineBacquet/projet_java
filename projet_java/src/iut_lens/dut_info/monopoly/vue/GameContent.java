package iut_lens.dut_info.monopoly.vue;

import iut_lens.dut_info.monopoly.core.Content;
import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.Button;
import iut_lens.dut_info.monopoly.game.Game;

import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

public class GameContent extends Content{

	
	private Game game;
	
	private Button diceButton;
	
	GameContent(String[] players){
		game = new Game(players,this);
		
		diceButton = new Button(this,new Vector2f(200,50),"lancer");
		super.addElementNoRender(diceButton);
		
	}
	
	@Override
	public void actionPerformed(Action action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onCreate() {
		game.init();
		
		diceButton.setPositionRelative(super.getWindow().getSize(), 0.1f, 0.9f);
		
		
		
	}

	@Override
	public void handleEvent(Event evt) {

		if(evt.type == Event.Type.MOUSE_MOVED){
			game.onMouseMove(evt.asMouseEvent().position);
		}
		
	}

	@Override
	public void update(Time tau) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(RenderTarget target) {
		game.getBoard().render(target);
		game.drawPlayer(target, RenderStates.DEFAULT);
		diceButton.render(target);
		
	}

}
