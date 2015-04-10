package iut_lens.dut_info.monopoly.game.cases.clickAction;

import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.core.element.Button;
import iut_lens.dut_info.monopoly.game.Game;

import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.event.Event;

public class DefaultClickAction extends ClickAction {

	
	private Button okButton;
	
	public DefaultClickAction(ActionListener actionListener, Vector2f pos,
			Vector2i windowSize, Vector2f size, String caseName, Game game) {
		super(actionListener, pos, windowSize, size, caseName, game);
		
		okButton = new Button(this,new Vector2f(150,50),"OK");
		okButton.setPositionRelativeToRectangle(super.rectangle, 0.5f, 0.8f);
		
		
	}
	
	
	

	@Override
	public void draw(RenderTarget target, RenderStates states) {
		super.renderFlou(target, states);
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
		if(action.getSource() == this.okButton)
			super.actionListener.actionPerformed(new Action(this));
		
	}

}
