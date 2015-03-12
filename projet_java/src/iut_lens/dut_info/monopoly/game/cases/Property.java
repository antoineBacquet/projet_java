package iut_lens.dut_info.monopoly.game.cases;

import iut_lens.dut_info.monopoly.core.JSONLoader;
import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.game.Board;
import iut_lens.dut_info.monopoly.game.CaseFallOnActionPopUp;
import iut_lens.dut_info.monopoly.game.Player;

import org.jsfml.system.Vector2f;

public class Property extends Case implements ActionListener{
	
	private Player owner = null;
	
	private Property[] otherProperty;
	
	private CaseFallOnActionPopUp popUp = null;
	
	private PropertyData data;

	public Property(Board board, String name) {
		super(board, name);

		data = JSONLoader.loadPropertyData(name);
		
	}
	
	

	@Override
	public CaseFallOnActionPopUp onFallOn() {
		if(owner == null)return new FallOnFreeProperty(this,new Vector2f(0.5f,0.3f),board.getGame().getWindowSize(),new Vector2f(400,600),this);
		return null;
	}

	@Override
	public void actionPerformed(Action action) {
		// TODO Auto-generated method stub
		
	}

}
