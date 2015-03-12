package iut_lens.dut_info.monopoly.game.cases;

import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.core.element.Button;
import iut_lens.dut_info.monopoly.game.CaseFallOnActionPopUp;

import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

public class FallOnFreeProperty extends CaseFallOnActionPopUp implements ActionListener {
	
	private Button buyButton;

	public FallOnFreeProperty(ActionListener actionListener, Vector2f pos,
			Vector2f windowSize, Vector2f size, Property caseSource) {
		super(actionListener, pos, windowSize, size, caseSource);


		buyButton = new Button(this,new Vector2f(200,50),"acheter");
	}

	@Override
	public void draw(RenderTarget target, RenderStates states) {
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

	@Override
	public void actionPerformed(Action action) {
		// TODO Auto-generated method stub
		
	}

}
