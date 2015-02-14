package iut_lens.dut_info.monopoly.game;



import iut_lens.dut_info.monopoly.core.Content;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Vector2f;

public class Game {
	
	private final static float X_PERCENT = 0.3f;
	
	
	private final Color[] colors  = {Color.BLUE,Color.GREEN,Color.MAGENTA,Color.RED,Color.YELLOW,Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK};//TODO ajouter d'autre couleurs
	
	private final int START_MONEY = 1000;
	
	private Content content;
	
	private String[] playersName;
	
	private Player[] players;
	
	private Board board;

	private boolean gotDouble = false;
	
	private Dice[] dices = {new Dice(),new Dice()};
	
	
	
	public Game(String[] playersName,Content content) {
		this.content = content;
		this.playersName = playersName;		
	}
	
	private void createPlayer(String[] playersName){
		players = new Player[playersName.length];
		Vector2f playerSize = new Vector2f((float) (content.getWindow().getSize().x*X_PERCENT),(float)(content.getWindow().getSize().y*0.8f)/10);
		
		for(int i=0 ; i<playersName.length ; i++){
			players[i] = new Player(playersName[i], START_MONEY,colors[i],playerSize);
		}
	}
	
	
	public void init(){
		board = new ClassiqueBoard(content,new Vector2f((float) (content.
				getWindow().getSize().x*(1-X_PERCENT)),(float)content.getWindow().getSize().y),
				new Vector2f((float) (content.getWindow().getSize().x*X_PERCENT),0));//TODO a bouger dans le constructeur
		board.createCase();
		

		createPlayer(playersName);
		
	}
	
	
	public void throwDices(){
		dices[0].throwDice();
		dices[1].throwDice();
	}
	
	
	public void drawPlayer(RenderTarget target, RenderStates state) {
		
		for(Player p:players)
			target.draw(p,state);
	}
	
	public Board getBoard(){
		return board;
	}
	
	

}
