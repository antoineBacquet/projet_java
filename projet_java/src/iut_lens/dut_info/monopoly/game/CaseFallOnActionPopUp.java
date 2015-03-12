package iut_lens.dut_info.monopoly.game;

import iut_lens.dut_info.monopoly.core.TextureManager;
import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.game.cases.Case;

import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

public abstract class CaseFallOnActionPopUp extends ActionPopUp {
	
	protected Case caseSource;
	
	protected Sprite sprite;

	public CaseFallOnActionPopUp(ActionListener actionListener, Vector2f pos,
			Vector2f windowSize, Vector2f size, Case caseSource) {
		super(actionListener, windowSize, size);
		this.caseSource = caseSource;
		
		
		Texture texture = TextureManager.getTexture(caseSource.getName());
		
		
		this.sprite = new Sprite();
		sprite.setTexture(texture);
		
		float scale = (float)(size.y/sprite.getTexture().getSize().y*0.6);
		sprite.setScale(scale, scale);
	}

}
