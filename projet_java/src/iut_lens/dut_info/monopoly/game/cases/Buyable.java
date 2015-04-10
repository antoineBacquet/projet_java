package iut_lens.dut_info.monopoly.game.cases;

import iut_lens.dut_info.monopoly.core.Util;
import iut_lens.dut_info.monopoly.game.Board;
import iut_lens.dut_info.monopoly.game.Game;
import iut_lens.dut_info.monopoly.game.Player;
import iut_lens.dut_info.monopoly.game.cases.action.CaseFallOnActionPopUp;
import iut_lens.dut_info.monopoly.game.cases.action.FallOnFreeProperty;
import iut_lens.dut_info.monopoly.game.cases.action.FallOnNoActionCase;
import iut_lens.dut_info.monopoly.game.cases.action.OnFallOnOwnedProperty;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

public abstract class Buyable extends Case{
	
	protected Player owner = null;
	
	protected int mortageValue;
	
	private boolean isMortage = false;
	
	private RectangleShape mortageRect;
	
	public Buyable(Board board, String name) {
		super(board, name);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public CaseFallOnActionPopUp onFallOn(Vector2f size, Vector2i windowSize, Vector2f pos, Game game) {
		if(owner == null)
			return new FallOnFreeProperty(game.getListener(), pos, windowSize, size, this, game);
		if(owner == board.getGame().getActualPlayer())
			return new FallOnNoActionCase(game.getListener(), pos, windowSize, size, this, game, "Vous êtes le propriétaire");
		if(isMortage)
			return new FallOnNoActionCase(game.getListener(), pos, windowSize, size, this, game, "Cette propriété est hypothéquée");
		return new OnFallOnOwnedProperty(game.getListener(), pos, windowSize, size, this, game);
	}
	
	@Override
	public void draw(RenderTarget target, RenderStates state) {
		//target.draw(sprite,state);
		target.draw(rect);
		if(isMortage)target.draw(mortageRect,state);
		
	}
	
	public void mortgage(){
		if(owner == null && isMortage == true)return;
		isMortage = true;
		owner.giveMonney(mortageValue);
		mortageRect = new RectangleShape(new Vector2f(0,Util.getDiag(rect)));
		mortageRect.setPosition(rect.getPosition());
		System.out.println();
		mortageRect.setRotation(-30);
		mortageRect.setOutlineColor(Color.BLACK);
		mortageRect.setFillColor(Color.BLACK);
		mortageRect.setOutlineThickness(1);
		
		
	}
	
	public void unMortgage(){
		if(owner == null && isMortage == false)return;
		isMortage = false;
		owner.paye(mortageValue);
	}
	
	public boolean isMortage(){
		return isMortage;
	}
	
	
	
	
	
	
	
	public abstract int getRent();
	public abstract Player getOwner();
	public abstract void setOwner(Player owner);
	public abstract int getPrice();
	

}
