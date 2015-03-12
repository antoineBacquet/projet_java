package iut_lens.dut_info.monopoly.game;

import iut_lens.dut_info.monopoly.core.SousContent;
import iut_lens.dut_info.monopoly.game.cases.Case;
import iut_lens.dut_info.monopoly.vue.GameContent;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

public abstract class Board extends SousContent {

	protected Case[] cases;
	protected Sprite boardSprite;
	protected RectangleShape rect; // TODO a enlever plus tard

	private GameContent gameContent;

	private final int NB_CASE;
	private Game game;
	

	public Board(GameContent content,Game game, Vector2f size, Vector2f pos, Texture texture, int nbCase) {
		super(content, size, pos);
		this.game = game;
		this.NB_CASE = nbCase;
		this.gameContent = content;
		this.boardSprite = new Sprite();
		boardSprite.setTexture(texture);

		float tmp = size.x > size.y ? size.y : size.x;
		rect = new RectangleShape(size);
		rect.setOutlineColor(Color.BLACK);
		rect.setOutlineThickness(2);

		boardSprite.setScale(new Vector2f(tmp / texture.getSize().x, tmp / texture.getSize().y));

	}

	public abstract void createCase();

	public void onMouseClick() {
		for (Case c : cases)
			c.onMouseClick();
	}

	public void onMouseMove(Vector2i mouse) {
		Vector2i casePos = new Vector2i((int) (mouse.x - super.pos.x), (int) (mouse.y - super.pos.y));
		for (Case c : cases)
			c.onMouseMove(casePos);

	}

	public void onClickOnCase(String name) {
		gameContent.onClickOnCase(name);

	}

	public Case movePlayer(Player player, int nbCase) {
		player.setPosition((player.getPosition() + nbCase) % this.NB_CASE);
		return cases[player.getPosition()];

	}

	public Game getGame() {
		return game;
	}

}
