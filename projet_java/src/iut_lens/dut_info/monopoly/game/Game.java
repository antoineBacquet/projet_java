package iut_lens.dut_info.monopoly.game;



import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.game.card.Card;
import iut_lens.dut_info.monopoly.game.card.CardBuilder;
import iut_lens.dut_info.monopoly.game.cases.Case;
import iut_lens.dut_info.monopoly.game.cases.Property;
import iut_lens.dut_info.monopoly.vue.GameContent;

import java.util.List;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

public class Game {
	
	private final static float X_PERCENT = 0.3f;


	private static final int PAYDAY = 2_000_000;
	
	
	private final Color[] colors  = {Color.BLUE,Color.GREEN,Color.MAGENTA,Color.RED,Color.YELLOW,Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK};//TODO ajouter d'autre couleurs
	
	private final int START_MONEY = 1_500_000;
	
	private GameContent content;
	
	private String[] playersName;
	
	private Player[] players;
	
	private Board board;

	private boolean gotDouble = false;
	
	private Dice[] dices = {new Dice(),new Dice()};
	
	private int actualPlayer = 0;
	
	private boolean isInTurn;
	
	private List<Card> chancesCard;
	
	private List<Card> caissesCard;
	
	
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
	
	
	public void init(CardBuilder chanceBuilder, CardBuilder caissesBuilder){
		board = new ClassiqueBoard(content,this,new Vector2f((float) (content.
				getWindow().getSize().x*(1-X_PERCENT)),(float)content.getWindow().getSize().y),
				new Vector2f((float) (content.getWindow().getSize().x*X_PERCENT),0));//TODO a bouger dans le constructeur
		board.createCase();
		
		//TODO a decomenter une fois que ce sera coder
		//chancesCard = chanceBuilder.getCards();
		//caissesCard = caissesBuilder.getCards();

		createPlayer(playersName);
		for(int i=0 ; i<players.length ; i++)
			content.majPlayerMoney(i);
		
		
		onPlayerChange();
	}
	
	
	public void playTurn(){
		if(isInTurn)return;
		isInTurn = true;
		
		
		//on lance les d�s
		int diceNumber = this.throwDices();
		this.gotDouble();
		
		diceNumber = 1;
		
		//on bouge le joueur
		Case caseTmp = board.movePlayer(players[actualPlayer],diceNumber); // TODO a remettre apres dices[0].getNumber() + dices[1].getNumber()
		content.onPlayerMoved();
		//on regarde l'action de la case actuel
		content.onFallOnCase(caseTmp.onFallOn(new Vector2f(400,600),board.getGame().getWindowSize(),new Vector2f(0.5f,0.5f), this));
		
	}
	
	public void onPlayerChange(){
		content.setPlayerPlaying();
	}
	
	public void endTurn(){
		isInTurn = false;
		if(gotDouble)return;
		actualPlayer++;
		actualPlayer%=players.length;
		onPlayerChange();
	}
	
	public void gotDouble(){
		this.gotDouble = dices[0].getNumber() == dices[1].getNumber();
		
		
	}
	
	public int throwDices(){
		dices[0].throwDice();
		dices[1].throwDice();
		return dices[0].getNumber() + dices[1].getNumber(); 
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
	
	public void buyProperty(Property property){
		if(players[actualPlayer].getMoney()<property.getPrice()){
			//TODO coder quand il n'y a pas assez d'argent
		}
		else{
			property.setOwner(players[actualPlayer]);
			players[actualPlayer].paye(property.getPrice());
			content.majPlayerMoney(actualPlayer);
			endTurn();
		}
	}

	public Vector2i getWindowSize() {
		return content.getWindowOption().getSize();
	}

	//TODO a coder
	public void moveActualPlayer(int caseId, boolean isPayDay) {
		int playerPos = players[actualPlayer].getPosition();
		
		if(isPayDay && playerPos+caseId>board.getNbCase()){
			players[actualPlayer].giveMonney(PAYDAY);
		}
	}
		

	public ActionListener getListener() {
		return content;
	}

	public void earnActualPlayer(int money) {
		// TODO Auto-generated method stub
		
	}

	public void withdrawMoneyActualPlayer(int money) {
		// TODO Auto-generated method stub
		// verifie que le joueur peut donner
		
	}

	public void eachGiveActualPlayer(int money) {
		// TODO Auto-generated method stub
		// verifie que le joueur peut donner
	}

	public void actualPlayerRentPlayer(Player owner, int rent) {
		if(players[actualPlayer].getMoney()<rent){
			//TODO coder quand il n'y a pas assez d'argent
		}
		else{
			players[actualPlayer].paye(rent);
			owner.giveMonney(rent);
			endTurn();
		}
		
		
	}
	
	public void comunityChest(){
		
	}
	
	public Player[] getPlayers(){
		return this.players;
	}

	public Player getActualPlayer() {
		return players[actualPlayer];
		
	}
	
	

}
