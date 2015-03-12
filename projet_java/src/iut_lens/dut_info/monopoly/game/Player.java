package iut_lens.dut_info.monopoly.game;

import iut_lens.dut_info.monopoly.core.FontManager;
import iut_lens.dut_info.monopoly.core.Util;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;

public class Player implements Drawable{
	
	
	private static int ID_COUNT = 0;
	
	private int id;
	
	protected String name = "";
	
	protected int money ;
	
	protected Color color;
	
	private Text nameText;
	
	private Text moneyText;
	
	//private Vector2f size;
	
	private Vector2f pos;
	
	private RectangleShape rect;
	
	private int positionOnBoard = 0;
	
	public Player(String name, int money, Color color, Vector2f size ) {
		this.name = name;
		this.money = money;
		this.color = color;
		
		//this.size = size;
		id = ID_COUNT++;
		pos = new Vector2f(0+3,size.y*id+3);
		
		
		rect = new RectangleShape(new Vector2f(size.x-6,size.y-6));
		rect.setPosition(pos);
		rect.setOutlineThickness(2);
		rect.setOutlineColor(color);
		
		nameText = new Text(name,FontManager.getFont("arial"),(int)size.y/2-5);
		nameText.setColor(color);
		nameText.setPosition(0,pos.y-2);
		Util.centerTextRectInX(rect, nameText);
		
		moneyText = new Text("argent:"+money,FontManager.getFont("arial"),(int)size.y/2-5);
		moneyText.setColor(color);
		moneyText.setPosition(0,pos.y+size.y/2-8);
		Util.centerTextRectInX(rect, moneyText);
		
		
		
	}

	@Override
	public void draw(RenderTarget target, RenderStates state) {
		target.draw(rect,state);
		target.draw(nameText,state);
		target.draw(moneyText,state);
		
		
	}

	public Color getColor() {
		return color;
	}

	public int getPosition() {
		return positionOnBoard;
	}

	public void setPosition(int positionOnBoard) {
		this.positionOnBoard = positionOnBoard;
		
	}

}
