package iut_lens.dut_info.monopoly.game.card;

import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.game.Game;

import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

public class Card {

	private CardStrategy onDrawStrat;

	private Game game;

	private String texturePath;

	private String message;

	public Card(CardStrategy onDrawStrat, String texturePath, Game game) {
		this.game = game;
		this.onDrawStrat = onDrawStrat;
		this.texturePath = texturePath;
	}

	public Card(CardStrategy onDrawStrat, String texturePath, String message, Game game) {
		this.game = game;
		this.onDrawStrat = onDrawStrat;
		this.texturePath = texturePath;
		this.message = message;
	}
	
	public CardActionPopUp onDraw(ActionListener actionListener, Vector2f pos,Vector2i windowSize,Vector2f size) {
		return new CardActionPopUp(actionListener, pos, windowSize, size, this.texturePath, message, game, this);

	}

	public void doAction() {
		onDrawStrat.onDraw(game);

	}

}
