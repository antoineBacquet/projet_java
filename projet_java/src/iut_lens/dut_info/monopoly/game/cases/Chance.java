package iut_lens.dut_info.monopoly.game.cases;

import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.game.Board;
import iut_lens.dut_info.monopoly.game.CaseFallOnActionPopUp;
import iut_lens.dut_info.monopoly.game.Game;

import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

public class Chance extends Case {

	public Chance(Board board, String name) {
		super(board, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(Action action) {
		// TODO Auto-generated method stub

	}

	@Override
	public CaseFallOnActionPopUp onFallOn(Vector2f size, Vector2i windowSize,
			Vector2f pos, Game game) {
		// TODO Auto-generated method stub
		return new FallOnChance(game.getListener(), pos, windowSize, size, this, game);
	}

}