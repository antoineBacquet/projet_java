package iut_lens.dut_info.monopoly.game.card;

import iut_lens.dut_info.monopoly.game.Game;

import java.util.LinkedList;

public interface CardBuilder {
	
	
	public LinkedList<Card> getCards(Game game);

}
