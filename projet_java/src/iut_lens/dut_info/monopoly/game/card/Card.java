package iut_lens.dut_info.monopoly.game.card;

import iut_lens.dut_info.monopoly.game.Game;

public class Card {
	
	
	
	private CardStrategy onDrawStrat;
	
	
	public Card(CardStrategy onDrawStrat) {
		this.onDrawStrat = onDrawStrat;
	}
	
	public void onDraw(Game game){
		onDrawStrat.onDraw(game);
	}

}
