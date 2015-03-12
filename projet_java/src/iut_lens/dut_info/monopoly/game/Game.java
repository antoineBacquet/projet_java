package iut_lens.dut_info.monopoly.game;



import iut_lens.dut_info.monopoly.game.cases.Case;
import iut_lens.dut_info.monopoly.vue.GameContent;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

public class Game {
	
	private final static float X_PERCENT = 0.2f;
	
	
	private final Color[] colors  = {Color.BLUE,Color.GREEN,Color.MAGENTA,Color.RED,Color.YELLOW,Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK};//TODO ajouter d'autre couleurs
	
	private final int START_MONEY = 1000;
	
	private GameContent content;
	
	private String[] playersName;
	
	private Player[] players;
	
	private Board board;

	private boolean gotDouble = false;
	
	private Dice[] dices = {new Dice(),new Dice()};
	
	private int actualPlayer = 0;
	
	private boolean isInTurn;
	
	
	
	public Game(String[] playersName,GameContent content) {
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
		board = new ClassiqueBoard(content,this,new Vector2f((float) (content.
				getWindow().getSize().x*(1-X_PERCENT)),(float)content.getWindow().getSize().y),
				new Vector2f((float) (content.getWindow().getSize().x*X_PERCENT),0));//TODO a bouger dans le constructeur
		board.createCase();
		

		createPlayer(playersName);
		
	}
	
	
	public void playTurn(){
		if(isInTurn)return;
		isInTurn = true;
		//on lance les d�s
		this.throwDices();
		this.gotDouble();
		
		//on bouge le joueur
		Case caseTmp = board.movePlayer(players[actualPlayer],dices[0].getNumber() + dices[1].getNumber());
		
		//on regarde l'action de la case actuel
		content.onFallOnCase(caseTmp.onFallOn());
		
	}
	
	public void endTurn(){
		isInTurn = false;
		if(gotDouble)return;
		actualPlayer++;
		actualPlayer%=players.length;
	}
	
	public void gotDouble(){
		this.gotDouble = dices[0].getNumber() == dices[1].getNumber();
		
		
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

	public void onMouseMove(Vector2i mouse) {
		board.onMouseMove(mouse);
		
	}

	public void onMouseClick() {
		board.onMouseClick();
		
	}
	
	
	//TODO ceci est un test
	public  void createPopUp(String className){
		Class<CaseFallOnActionPopUp> test = null;
		try {
			test = (Class<CaseFallOnActionPopUp>) Class.forName(className);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			CaseFallOnActionPopUp popUpTmp = test.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Vector2f getWindowSize() {
		// TODO Auto-generated method stub
		return content.getWindow().getSize();
	}
	
	

}
