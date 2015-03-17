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

public class FallOnFreeProperty extends CaseFallOnActionPopUp implements ActionListener {
	
	private Button buyButton;
	private Button notBuyButton;

	public FallOnFreeProperty(ActionListener actionListener, Vector2f pos,
			Vector2f windowSize, Vector2f size, Property caseSource, Game game) {
		super(actionListener, pos, windowSize, size, caseSource, game);


		buyButton = new Button(this,new Vector2f(150,50),new Vector2f(0,0),"acheter");
		buyButton.setPositionRelativeToRectangle(super.rectangle, 0.2f, 0.9f);
		notBuyButton = new Button(this,new Vector2f(150,50),new Vector2f(0,150),"ne pas acheter");
		notBuyButton.setPositionRelativeToRectangle(super.rectangle, 0.8f, 0.9f);
	}

	@Override
	public void draw(RenderTarget target, RenderStates states) {
		target.draw(rectangle, states);
		target.draw(super.sprite, states);
		buyButton.render(target);
		notBuyButton.render(target);

	}

	@Override
	public boolean handleEvent(Event evt) {
		// TODO Auto-generated method stub
		buyButton.handleEvent(evt);
		notBuyButton.handleEvent(evt);
		return false;
	}

	@Override
	public void update(Time tau) {
		// TODO Auto-generated method stub
		buyButton.update(tau);
		notBuyButton.update(tau);
	}

	@Override
	public void actionPerformed(Action action) {
		if(action.getSource() == this.buyButton){
			game.buyProperty((Property)super.caseSource);
			actionListener.actionPerformed(new Action(this));
			System.out.println("lel");
		}
		if(action.getSource() == this.notBuyButton){
			actionListener.actionPerformed(new Action(this));
		}
		
		
	}

}
