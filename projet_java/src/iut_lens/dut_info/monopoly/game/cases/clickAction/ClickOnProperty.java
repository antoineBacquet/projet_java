package iut_lens.dut_info.monopoly.game.cases.clickAction;

import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.core.element.Button;
import iut_lens.dut_info.monopoly.game.Game;
import iut_lens.dut_info.monopoly.game.cases.Property;

import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.event.Event;

public class ClickOnProperty extends ClickAction {

	
	private Button okButton;
	private Button mortgageButton;
	private Property property;
	
	
	public ClickOnProperty(ActionListener actionListener, Vector2f pos,
			Vector2i windowSize, Vector2f size, String caseName, Game game, Property property) {
		super(actionListener, pos, windowSize, size, caseName, game);
		
		this.property = property;
		
		okButton = new Button(this,new Vector2f(150,50),"OK");
		okButton.setPositionRelativeToRectangle(super.rectangle, 0.2f, 0.8f);
		if(property.isMortage())
			mortgageButton = new Button(this,new Vector2f(150,50),"déhypothéque");
		else
			mortgageButton = new Button(this,new Vector2f(150,50),"hypothéque");
		mortgageButton.setPositionRelativeToRectangle(super.rectangle, 0.8f, 0.8f);
	}


	@Override
	public void draw(RenderTarget target, RenderStates states) {
		super.renderFlou(target, states);
		okButton.render(target);
		mortgageButton.render(target);

	}

	@Override
	public boolean handleEvent(Event evt) {
		okButton.handleEvent(evt);
		mortgageButton.handleEvent(evt);
		return false;
	}

	@Override
	public void update(Time tau) {
		okButton.update(tau);
		mortgageButton.update(tau);

	}




	@Override
	public void actionPerformed(Action action) {
		if(action.getSource() == this.okButton)
			super.actionListener.actionPerformed(new Action(this));
		else if(action.getSource() == this.mortgageButton){
			if(property.isMortage())
				game.unMortageProperty(property);
			else
				game.mortageProperty(property);
			super.actionListener.actionPerformed(new Action(this));
		}
			
		
	}

}
