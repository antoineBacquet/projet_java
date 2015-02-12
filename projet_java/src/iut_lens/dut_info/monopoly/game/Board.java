package iut_lens.dut_info.monopoly.game;

import iut_lens.dut_info.monopoly.core.Content;
import iut_lens.dut_info.monopoly.core.SousContent;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;


public abstract class Board extends SousContent{
	
	
	private Case[] cases;
	
	private Texture boardTexture;
	protected Sprite boardSprite;
	protected RectangleShape rect; //TODO a enlever plus tard
	
	public Board (Content content, Vector2f size, Vector2f pos,Texture texture){
		super(content,size,pos);
		this.boardTexture = texture;
		this.boardSprite = new Sprite();
		boardSprite.setTexture(boardTexture);
		
		float tmp = size.x>size.y?size.y:size.x;
		rect = new RectangleShape(size);
		rect.setOutlineColor(Color.BLACK);
		rect.setOutlineThickness(2);
		
		boardSprite.setScale(new Vector2f(tmp/boardTexture.getSize().x,tmp/boardTexture.getSize().y));
		
		
	}
	
	
	
	public abstract void createCase();
	
	
	

}
