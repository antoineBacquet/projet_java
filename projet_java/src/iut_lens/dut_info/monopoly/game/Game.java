package iut_lens.dut_info.monopoly.game;

import iut_lens.dut_info.monopoly.core.Content;

import org.jsfml.system.Vector2f;

public class Game {
	
	
	private Player[] players;
	
	Board board;

	private Content content;
	
	
	public Game(Player[] players,Content content) {
		this.content = content;
		this.players = players;
		
		
		
		
		
	}
	
	
	public void init(){
		board = new ClassiqueBoard(content,new Vector2f((float) (content.
				getWindow().getSize().x*0.6),(float)content.getWindow().getSize().y*0.8f),
				new Vector2f((float) (content.getWindow().getSize().x*0.4),0));//TODO a bouger dans le constructeur
		board.createCase();
		
	}
	
	public Board getBoard(){
		return board;
	}
	
	

}
