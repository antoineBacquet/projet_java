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

public class FallOnChance extends CaseFallOnActionPopUp implements ActionListener {

	
	private Button okButton;
	
	
	public FallOnChance(ActionListener actionListener, Vector2f pos,
			Vector2i windowSize, Vector2f size, Case caseSource, Game game) {
		super(actionListener, pos, windowSize, size, caseSource, game, "Vous tirez une carte chance");
		
		okButton = new Button(this,new Vector2f(150,50),"ok");
		okButton.setPositionRelativeToRectangle(super.rectangle, 0.5f, 0.8f);

		
	}

	@Override
	public void draw(RenderTarget target, RenderStates states) {
		target.draw(rectangle, states);
		target.draw(super.sprite, states);
		target.draw(super.text,states);
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
			actionListener.actionPerformed(new Action(this));
		}
			
		
	}

	

}
