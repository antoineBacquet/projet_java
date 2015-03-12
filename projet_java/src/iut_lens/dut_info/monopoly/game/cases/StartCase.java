package iut_lens.dut_info.monopoly.game.cases;

import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.game.Board;
import iut_lens.dut_info.monopoly.game.CaseFallOnActionPopUp;

public class StartCase extends Case {
	
	private CaseFallOnActionPopUp popUp = null;

	public StartCase(Board board, String name) {
		super(board, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(Action action) {
		// TODO Auto-generated method stub

	}

	@Override
	public CaseFallOnActionPopUp onFallOn() {
		// TODO Auto-generated method stub
		return null;
	}

}
