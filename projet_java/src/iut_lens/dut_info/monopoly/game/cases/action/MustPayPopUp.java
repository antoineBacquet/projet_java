package iut_lens.dut_info.monopoly.game.cases.action;

import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.core.element.Button;
import iut_lens.dut_info.monopoly.game.Game;
import iut_lens.dut_info.monopoly.game.cases.Case;

import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.event.Event;

public class MustPayPopUp extends CaseFallOnActionPopUp implements ActionListener{

	
	private Button okButton;
	
	
	public MustPayPopUp(ActionListener actionListener, Vector2f pos,
			Vector2i windowSize, Vector2f size, Case caseSource, Game game,
			String message) {
		super(actionListener, pos, windowSize, size, caseSource, game, message);
		
		okButton = new Button(this,new Vector2f(150,50),"OK");
		okButton.setPositionRelativeToRectangle(super.rectangle, 0.8f, 0.5f);
		
	}

	@Override
	public void draw(RenderTarget target, RenderStates state) {
		target.draw(rectangle);
		target.draw(sprite);
		target.draw(text);
		okButton.render(target);
	}

	@Override
	public boolean handleEvent(Event evt) {
		okButton.handleEvent(evt);
		return false;
	}

	@Override
	public void update(Time tau) {
		okButton.update(tau);

	}

	@Override
	public void actionPerformed(Action action) {
		// TODO Auto-generated method stub
		
	}

}
