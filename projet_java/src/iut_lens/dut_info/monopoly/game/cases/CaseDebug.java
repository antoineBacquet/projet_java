package iut_lens.dut_info.monopoly.game.cases;

import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.game.Board;
import iut_lens.dut_info.monopoly.game.CaseFallOnActionPopUp;
import iut_lens.dut_info.monopoly.game.Game;

import org.jsfml.system.Vector2f;

public class CaseDebug extends Case{

	public CaseDebug(Board board, String name) {
		super(board,name);
	}

	@Override
	public CaseFallOnActionPopUp onFallOn(Vector2f size, Vector2f windowSize, Vector2f pos, Game game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actionPerformed(Action action) {
		// TODO Auto-generated method stub
		
	}

}
