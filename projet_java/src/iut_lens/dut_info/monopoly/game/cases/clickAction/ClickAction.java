package iut_lens.dut_info.monopoly.game.cases.clickAction;

import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.game.ActionPopUp;
import iut_lens.dut_info.monopoly.game.Game;

import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

public abstract class ClickAction extends ActionPopUp implements ActionListener{
	
	private static final String texturePath = "/photosPlateau/";
	protected Game game;

	public ClickAction(ActionListener actionListener, Vector2f pos,
			Vector2i windowSize, Vector2f size, String caseName, Game game) {
		super(actionListener, pos, windowSize, size, texturePath+caseName, "");
		this.game = game;
	}
}
