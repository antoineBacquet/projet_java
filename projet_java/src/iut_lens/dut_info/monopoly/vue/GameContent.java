package iut_lens.dut_info.monopoly.vue;

import iut_lens.dut_info.monopoly.core.Content;
import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.game.Game;
import iut_lens.dut_info.monopoly.game.Player;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.window.event.Event;

public class GameContent extends Content{

	
	Game game;
	
	GameContent(Player[] players){
		game = new Game(players,this);
		
	}
	
	@Override
	public void actionPerformed(Action action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onCreate() {
		game.init();
		
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
		game.getBoard().render(target);
		
	}

}
