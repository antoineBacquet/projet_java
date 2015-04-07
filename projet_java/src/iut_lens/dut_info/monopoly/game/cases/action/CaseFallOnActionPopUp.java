package iut_lens.dut_info.monopoly.game.cases.action;

import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.game.ActionPopUp;
import iut_lens.dut_info.monopoly.game.Game;
import iut_lens.dut_info.monopoly.game.cases.Case;

import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

public abstract class CaseFallOnActionPopUp extends ActionPopUp {
	
	protected Case caseSource;
	protected Game game;
	
	public CaseFallOnActionPopUp(ActionListener actionListener, Vector2f pos,
			Vector2i windowSize, Vector2f size, Case caseSource, Game game, String message) {
		super(actionListener,pos, windowSize, size,"photosPlateau/"+ caseSource.getName(), message);
		this.caseSource = caseSource;
		this.game  = game;
		
		
		
		
	}

}
