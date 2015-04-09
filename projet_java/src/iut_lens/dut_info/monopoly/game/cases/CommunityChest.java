package iut_lens.dut_info.monopoly.game.cases;

import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.game.Board;
import iut_lens.dut_info.monopoly.game.Game;
import iut_lens.dut_info.monopoly.game.cases.action.CaseFallOnActionPopUp;
import iut_lens.dut_info.monopoly.game.cases.action.FallOnChance;

import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

public class CommunityChest extends Case {

	

	public CommunityChest(Board board, String name) {
		super(board, name);
	}

	@Override
	public void actionPerformed(Action action) {

	}

	@Override
	public CaseFallOnActionPopUp onFallOn(Vector2f size, Vector2i windowSize,
			Vector2f pos, Game game) {
		return new FallOnChance(game.getListener(), pos, windowSize, size, this, game);
	}
}
