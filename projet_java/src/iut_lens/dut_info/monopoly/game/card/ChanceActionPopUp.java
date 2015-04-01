package iut_lens.dut_info.monopoly.game.card;

import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.game.CaseFallOnActionPopUp;
import iut_lens.dut_info.monopoly.game.Game;
import iut_lens.dut_info.monopoly.game.cases.Case;

import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.event.Event;

public class ChanceActionPopUp extends CaseFallOnActionPopUp {

	public ChanceActionPopUp(ActionListener actionListener, Vector2f pos,
			Vector2i windowSize, Vector2f size, Case caseSource, Game game,
			String message) {
		super(actionListener, pos, windowSize, size, caseSource, game, message);
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
