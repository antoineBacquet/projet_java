package iut_lens.dut_info.monopoly.game.cases;

import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.game.CaseFallOnActionPopUp;
import iut_lens.dut_info.monopoly.game.Game;

import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

public class FallOnNoActionCase extends CaseFallOnActionPopUp {

	public FallOnNoActionCase(ActionListener actionListener, Vector2f pos,
			Vector2f windowSize, Vector2f size, Case caseSource, Game game) {
		super(actionListener, pos, windowSize, size, caseSource, game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(RenderTarget arg0, RenderStates arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean handleEvent(Event evt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(Time tau) {
		// TODO Auto-generated method stub
		
	}



}
