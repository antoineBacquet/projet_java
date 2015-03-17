package iut_lens.dut_info.monopoly.game.cases;

import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.core.element.Button;
import iut_lens.dut_info.monopoly.game.CaseFallOnActionPopUp;
import iut_lens.dut_info.monopoly.game.Game;

import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

public class OnFallOnOwnedProperty extends CaseFallOnActionPopUp implements ActionListener {
	
	private Button okButton;

	public OnFallOnOwnedProperty(ActionListener actionListener, Vector2f pos,
			Vector2f windowSize, Vector2f size, Case caseSource, Game game) {
		super(actionListener, pos, windowSize, size, caseSource, game);
		okButton = new Button(this,new Vector2f(150,50),new Vector2f(0,0),"ok");
	}

	@Override
	public void draw(RenderTarget target, RenderStates states) {
		target.draw(rectangle, states);
		target.draw(super.sprite, states);
		
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
		if(action.getSource() == okButton){
			super.actionListener.actionPerformed(new Action(this));
		}
	}

}
