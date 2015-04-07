package iut_lens.dut_info.monopoly.game.cases;

import iut_lens.dut_info.monopoly.core.Util;
import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.game.Board;
import iut_lens.dut_info.monopoly.game.Game;
import iut_lens.dut_info.monopoly.game.cases.action.CaseFallOnActionPopUp;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

//TODO changer pour faire en sorte qu'une case poss�de carte (ou pas)
//TODO impl�menter toute les sous classes #hf
public abstract class Case implements Drawable,ActionListener{
	
	
	
	
	private static enum State{NORMAL,HOVER};
	
	private State state = State.NORMAL;
	
	private final static Color DEFAULT_COLOR = Color.BLACK;
	private final static Color HOVER_COLOR = new Color(1,1,1,50);
	
	protected final String name;
	
	//private Vector2f size;
	
	private RectangleShape rect;
	protected Board board;

	private Vector2f pos;

	private Vector2f size;
	
	
	
	public Case(Board board, String name) {
		this.board = board;
		
		this.name = name;
		
		rect = new RectangleShape();
		rect.setOutlineColor(DEFAULT_COLOR);
		rect.setOutlineThickness(2);
		rect.setFillColor(Color.TRANSPARENT);
		
	}
	
	public void onMouseMove(Vector2i mouse){
		if(state == State.NORMAL && Util.intersects(mouse, rect)){
			rect.setFillColor(HOVER_COLOR);
			state = State.HOVER;
		}
		else if (state == State.HOVER && !Util.intersects(mouse, rect) ){
			rect.setFillColor(Color.TRANSPARENT);
			state = State.NORMAL;
		}
	}
	
	
	public void onMouseClick(){
		if(state == State.HOVER){
			board.onClickOnCase(name);
			
		}
	}
	
	
	public void setSize(Vector2f size){
		this.size = size;
		rect.setSize(new Vector2f(size.x-4,size.y-4));
	}

	@Override
	public void draw(RenderTarget target, RenderStates state) {
		//target.draw(sprite,state);
		target.draw(rect);
		
	}
	
	
	
	protected void setColor(Color color) {
		this.rect.setOutlineColor(color);
		
	}
	//TODO a coder
	public void setPos(Vector2f pos) {
		this.pos = pos;
		rect.setPosition(new Vector2f(pos.x+2,pos.y+2));
		
	}

	public abstract CaseFallOnActionPopUp onFallOn(Vector2f size, Vector2i windowSize, Vector2f pos, Game game);

	public String getName() {
		return name;
	}

	public Vector2f getPos() {
		return pos;
	}

	public Vector2f getSize() {
		return this.size;
	}
	

}
