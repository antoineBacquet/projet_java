package iut_lens.dut_info.monopoly.vue;

import iut_lens.dut_info.monopoly.core.Content;
import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.Button;
import iut_lens.dut_info.monopoly.game.ActionPopUp;
import iut_lens.dut_info.monopoly.game.CaseActionPopUp;
import iut_lens.dut_info.monopoly.game.CaseFallOnActionPopUp;
import iut_lens.dut_info.monopoly.game.Game;

import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

public class GameContent extends Content{

	
	private Game game;
	
	private Button diceButton;
	
	private ActionPopUp popUp = null;
	
	
	
	GameContent(String[] players){
		game = new Game(players,this);
		
		diceButton = new Button(this,new Vector2f(200,50),"lancer");
		super.addElementNoRender(diceButton);
		
	}
	
	@Override
	public void actionPerformed(Action action) {
		if(action.getSource() == popUp)popUp = null;
		if(action.getSource() == this.diceButton)game.playTurn();
		
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
		
		if(evt.type == Event.Type.MOUSE_BUTTON_PRESSED && evt.asMouseButtonEvent().button == org.jsfml.window.Mouse.Button.LEFT){
			game.onMouseClick();
		}
		if(popUp !=null)popUp.handleEvent(evt);
		
	}

	@Override
	public void update(Time tau) {
		if(popUp !=null)popUp.update(tau);
		
	}

	@Override
	public void render(RenderTarget target) {
		
		game.getBoard().render(target);
		game.drawPlayer(target, RenderStates.DEFAULT);
		diceButton.render(target);
		
		if(popUp !=null)target.draw(popUp, RenderStates.DEFAULT);
		
		
	}

	public void onClickOnCase(String name) {
		Vector2f pos = new Vector2f(0.5f,0.2f);
		Vector2f size = new Vector2f(400,400);
		
		popUp = new CaseActionPopUp("case_"+name, this, pos, super.window.getSize(), size);
		
	}

	public void onFallOnCase(CaseFallOnActionPopUp popUp) {
		this.popUp = popUp;
		
	}

}
