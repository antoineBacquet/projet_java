package iut_lens.dut_info.monopoly.game;



import iut_lens.dut_info.monopoly.core.element.ActionListener;
import iut_lens.dut_info.monopoly.core.element.Button;
import iut_lens.dut_info.monopoly.game.card.Card;
import iut_lens.dut_info.monopoly.game.card.CardBuilder;
import iut_lens.dut_info.monopoly.game.cases.Buyable;
import iut_lens.dut_info.monopoly.game.cases.Case;
import iut_lens.dut_info.monopoly.game.cases.Property;
import iut_lens.dut_info.monopoly.vue.GameContent;

import java.util.Collections;
import java.util.LinkedList;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

public class Game {
	
	private final static float X_PERCENT = 0.3f;


	private static final int PAYDAY = 2_000_000;
	
	
	private final Color[] colors  = {Color.BLUE,Color.GREEN,Color.MAGENTA,Color.RED,Color.YELLOW,Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK};//TODO ajouter d'autre couleurs
	
	private final int START_MONEY = 15_000_000;
	
	private GameContent content;
	
	private String[] playersName;
	
	private Player[] players;
	
	private Board board;

	private boolean gotDouble = false;
	
	private Dice[] dices = {new Dice(),new Dice()};
	
	private int actualPlayer = 0;
	
	private boolean isInTurn;
	
	private LinkedList<Card> chancesCard;
	
	private LinkedList<Card> caissesCard;
	
	
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
		chancesCard = chanceBuilder.getCards(this);
		Collections.shuffle(chancesCard);
		caissesCard = caissesBuilder.getCards(this);
		Collections.shuffle(caissesCard);
		
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
		if(players[actualPlayer].getPosition() + diceNumber > board.getNbCase()){
			players[actualPlayer].giveMonney(PAYDAY);
			content.majPlayerMoney(players[actualPlayer].getId());
		}
		Case caseTmp = board.movePlayer(players[actualPlayer],diceNumber); // TODO a remettre apres dices[0].getNumber() + dices[1].getNumber()
		content.onPlayerMoved();
		//on regarde l'action de la case actuel
		content.onFallOnCase(caseTmp.onFallOn(new Vector2f(600,600),board.getGame().getWindowSize(),new Vector2f(0.5f,0.5f), this));
		
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

	public ActionListener getListener() {
		return content;
	}
	
	public Board getBoard(){
		return board;
	}

	public void onMouseMove(Vector2i mouse) {
		board.onMouseMove(mouse);
		
	}

	public void onMouseClick() {
		board.onMouseClick(getListener(),new Vector2f(600,600),board.getGame().getWindowSize(),new Vector2f(0.5f,0.5f), this);
		
	}
	
	public void buyProperty(Buyable property){
		if(players[actualPlayer].getMoney()<property.getPrice()){
			System.out.println("Game :: buyProperty(Buyable) -> Erreur pas assez d'argent");
			content.setPopUp(new NotEnoughtMoney(getListener(),new Vector2f(0.5f,0.5f),board.getGame().getWindowSize(),new Vector2f(600,600),"/attention" ,this));
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
	
	
		public void moveActualPlayer(int nbCase, boolean isPayDay) {
			int playerPos = players[actualPlayer].getPosition();
			
			if(isPayDay && playerPos+nbCase>board.getNbCase()){
				players[actualPlayer].giveMonney(PAYDAY);
			}
			Case caseTmp = board.movePlayer(players[actualPlayer],nbCase);
			content.onPlayerMoved();
			//on regarde l'action de la case actuel
			content.onFallOnCase(caseTmp.onFallOn(new Vector2f(600,600),board.getGame().getWindowSize(),new Vector2f(0.5f,0.5f), this));
		}

	
	public void moveActualPlayerTo(int caseId, boolean isPayDay) {
		int playerPos = players[actualPlayer].getPosition();
		
		if(isPayDay && playerPos>caseId){
			players[actualPlayer].giveMonney(PAYDAY);
		}
		Case caseTmp = board.movePlayerTo(players[actualPlayer],caseId);
		content.onPlayerMoved();
		//on regarde l'action de la case actuel
		content.onFallOnCase(caseTmp.onFallOn(new Vector2f(600,600),board.getGame().getWindowSize(),new Vector2f(0.5f,0.5f), this));
	}

	public void earnActualPlayer(int money) {
		players[actualPlayer].giveMonney(money);
		content.majPlayerMoney(actualPlayer);
		endTurn();
	}

	public void actualPlayerPaid(int money) {
		
		if(players[actualPlayer].getMoney()<money){
			System.out.println("Game :: earnActualPlayer(int) -> Erreur pas assez d'argent");
			//TODO coder quand il n'y a pas assez d'argent
			endTurn();
		}
		else{
			players[actualPlayer].paye(money);
			content.majPlayerMoney(actualPlayer);
			endTurn();
		}
		
	}

	public void eachGiveActualPlayer(int money) {
		// TODO Auto-generated method stub
		// verifie que le joueur peut donner
	}

	public void actualPlayerRentPlayer(Player owner, int rent) {
		if(players[actualPlayer].getMoney()<rent){
			//TODO coder quand il n'y a pas assez d'argent
			System.out.println("Game :: actualPlayerRentPlayer(Player,int) -> Erreur pas assez d'argent");
			endTurn();
		}
		else{
			players[actualPlayer].paye(rent);
			owner.giveMonney(rent);
			content.majPlayerMoney(actualPlayer);
			content.majPlayerMoney(owner.getId());
			endTurn();
		}
		
		
	}
	
	public void drawChance(){
		Card tmp = this.chancesCard.getFirst();
		this.chancesCard.removeFirst();
		this.chancesCard.addLast(tmp);
		content.setPopUp(tmp.onDraw(content, new Vector2f(0.5f,0.5f), board.getGame().getWindowSize(), new Vector2f(600,400)));
	}
	
	public void drawComunityChest(){
		Card tmp = this.caissesCard.getFirst();
		this.caissesCard.removeFirst();
		this.caissesCard.addLast(tmp);
		content.setPopUp(tmp.onDraw(content, new Vector2f(0.5f,0.5f), board.getGame().getWindowSize(), new Vector2f(600,400)));
		
		
		
	}
	
	public Player[] getPlayers(){
		return this.players;
	}

	public Player getActualPlayer() {
		return players[actualPlayer];
		
	}

	public int getDicesValue() {
		return dices[0].getNumber() + dices[1].getNumber();
	}

	public boolean isInTurn() {
		return isInTurn;
	}
	
	//TODO a coder
	public void mortageProperty(Buyable buyable) {
		buyable.mortgage();
		content.majPlayerMoney(actualPlayer);
		
	}
	
	//TODO a coder
	public void unMortageProperty(Buyable buyable) {
		buyable.unMortgage();
		content.majPlayerMoney(actualPlayer);
		
	}
	
	public void removeHouse(Property property) {
		property.getOwner().giveMonney((int) (property.getHousePrice()*0.5));
		property.removeHouse();
	}
	
	
	public void addHouse(Property property) {
		if(property.getOwner().getMoney()< property.getHousePrice()){
			content.setPopUp(new NotEnoughtMoney(getListener(),new Vector2f(0.5f,0.5f),board.getGame().getWindowSize(),new Vector2f(600,600),"/attention" ,this));
		}
		else{
			property.getOwner().paye(property.getHousePrice());
			property.addHouse();
			content.majPlayerMoney(property.getOwner().getId());
		}
		
	}
	

}
