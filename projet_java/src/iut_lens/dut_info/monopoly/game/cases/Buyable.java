package iut_lens.dut_info.monopoly.game.cases;

import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

import iut_lens.dut_info.monopoly.game.Board;
import iut_lens.dut_info.monopoly.game.Game;
import iut_lens.dut_info.monopoly.game.Player;
import iut_lens.dut_info.monopoly.game.cases.action.CaseFallOnActionPopUp;
import iut_lens.dut_info.monopoly.game.cases.action.FallOnFreeProperty;
import iut_lens.dut_info.monopoly.game.cases.action.FallOnNoActionCase;
import iut_lens.dut_info.monopoly.game.cases.action.OnFallOnOwnedProperty;

public abstract class Buyable extends Case{
	
	protected Player owner = null;
	
	public Buyable(Board board, String name) {
		super(board, name);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public CaseFallOnActionPopUp onFallOn(Vector2f size, Vector2i windowSize, Vector2f pos, Game game) {
		if(owner == null)
			return new FallOnFreeProperty(game.getListener(), pos, windowSize, size, this, game);
		if(owner == board.getGame().getActualPlayer())
			return new FallOnNoActionCase(game.getListener(), pos, windowSize, size, this, game, "C'est votre propriéter");
		return new OnFallOnOwnedProperty(game.getListener(), pos, windowSize, size, this, game);
	}
	
	public abstract int getRent();
	public abstract Player getOwner();
	public abstract void setOwner(Player owner);
	public abstract int getPrice();
	

}
