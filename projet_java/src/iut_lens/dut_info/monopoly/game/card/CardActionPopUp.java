package iut_lens.dut_info.monopoly.game.card;

import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.core.element.Button;
import iut_lens.dut_info.monopoly.game.ActionPopUp;
import iut_lens.dut_info.monopoly.game.Game;

import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.event.Event;

public class CardActionPopUp extends ActionPopUp implements ActionListener {

	private Game game;
	
	private Card card;
	
	private Button okButton;

	public CardActionPopUp(ActionListener actionListener, Vector2f pos,
			Vector2i windowSize, Vector2f size, String texturePath,
			String message, Game game, Card card) {
		super(actionListener, pos, windowSize, size, texturePath, message);
		this.card = card;
		this.game = game;
		this.okButton = new Button(this,new Vector2f(150,50), "OK");
		
	}

	@Override
	public void draw(RenderTarget target, RenderStates states) {
		super.renderFlou(target, states);
		
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

	@Override
	public void actionPerformed(Action action) {
		if(action.getSource() == this.okButton){
			card.doAction();
		}
		
	}

}
