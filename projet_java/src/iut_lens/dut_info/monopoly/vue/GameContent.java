package iut_lens.dut_info.monopoly.vue;

import iut_lens.dut_info.monopoly.core.Content;
import iut_lens.dut_info.monopoly.core.Window;
import iut_lens.dut_info.monopoly.core.WindowOption;
import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.Button;
import iut_lens.dut_info.monopoly.game.ActionPopUp;
import iut_lens.dut_info.monopoly.game.CaseActionPopUp;
import iut_lens.dut_info.monopoly.game.Game;
import iut_lens.dut_info.monopoly.game.cases.action.CaseFallOnActionPopUp;

import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

public class GameContent extends Content{

	
	private Game game;
	
	private Button diceButton;
	
	private ActionPopUp popUp = null;
	
	private static final String BOARD_TEXTURE = "photosPlateau\\";
	
	private final Color[] colors  = {Color.BLUE,Color.GREEN,Color.MAGENTA,Color.RED,Color.YELLOW,Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK};
	
	private final static float X_PERCENT = 0.3f;
	
	private final static float Y_PERCENT = 0.8f;
	
	private int nbPlayers;
	
	private PlayerUI[] playersUI;
	
	private CircleShape[] pions;

	private float pionsRadius;
	
	GameContent(String[] players,WindowOption windowOption,Window window){
		super(windowOption,window);
		game = new Game(players,this);
		
		this.nbPlayers = players.length;
		
		diceButton = new Button(this,new Vector2f(200,50),"lancer");
		super.addElementNoRender(diceButton);
		
		createPlayerUI(players);
		game.init(null,null);//TODO mettre les bon builder
		
		createPions();
		
	}
	
	
	private void createPions(){
		
		
		
		pions = new CircleShape[nbPlayers];
		for(int i=0 ; i<nbPlayers ; i++){
			pions[i] = new CircleShape();
			pions[i].setFillColor(game.getPlayers()[i].getColor());
			
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(Action action) {
		if(action.getSource() == popUp)popUp = null;
		if(action.getSource() == this.diceButton)game.playTurn();
		
	}
	
	
	public void createPlayerUI( String[] playersName){
		playersUI = new PlayerUI[nbPlayers];
		
		Vector2f size = new Vector2f(super.getWindowOption().getSize().x*X_PERCENT,super.getWindowOption().getSize().y*Y_PERCENT/10f);
		
		for(int i=0 ; i<nbPlayers ; i++){
			playersUI[i] = new PlayerUI(super.getWindowOption().getSize(), size, new Vector2f(0 , size.y*i),colors[i],playersName[i],1000);
		}
	}

	@Override
	protected void onCreate() {
		//Taille et position des pions
		float radius = 20;//TODO a calculer par raport a la taille des cases
		pionsRadius = radius;
		for(int i=0 ; i<nbPlayers ; i++){
			pions[i].setRadius(radius);
			Vector2f caseSize =  game.getBoard().getCaseSize(game.getPlayers()[i].getPosition()); 
			pions[i].setPosition(new Vector2f(((float)super.getWindowOption().getSize().x * X_PERCENT) + game.getBoard().getCasePos(0).x + caseSize.x/2 - radius
					,game.getBoard().getCasePos(0).y + caseSize.y/2 - radius));
		}
		
		
		diceButton.setPositionRelative(super.getWindowOption().getSize(), 0.1f, 0.9f);
		
		
		for(int i=0 ; i<nbPlayers ; i++){
			playersUI[i].resize(super.getWindowOption().getSize(), new Vector2f(super.getWindowOption().getSize().x*X_PERCENT,super.getWindowOption().getSize().y*Y_PERCENT/10f));
		}
	}

	@Override
	public void handleEvent(Event evt) {

		if(evt.type == Event.Type.MOUSE_MOVED){
			game.onMouseMove(evt.asMouseEvent().position);
		}
		
		if(evt.type == Event.Type.MOUSE_BUTTON_PRESSED && evt.asMouseButtonEvent().button == org.jsfml.window.Mouse.Button.LEFT){
			game.onMouseClick();
		}
		if(popUp !=null)popUp.handleEvent(evt);
		
	}

	@Override
	public void update(Time tau) {
		if(popUp !=null)popUp.update(tau);
		
	}

	@Override
	public void render(RenderTarget target) {
		
		game.getBoard().render(target);
		//game.drawPlayer(target, RenderStates.DEFAULT);
		for(int i=0 ; i<nbPlayers ; i++){
			playersUI[i].render(target);
		}
		
		diceButton.render(target);
		for(int i=0 ; i<nbPlayers ; i++)
			target.draw(pions[i]);
		
		if(popUp !=null)target.draw(popUp, RenderStates.DEFAULT);
		
		
		
	}
	
	public void onPlayerMoved(){
		
		Vector2f caseSize =  game.getBoard().getCaseSize(game.getPlayers()[game.getActualPlayer().getId()].getPosition()); 
		pions[game.getActualPlayer().getId()].setPosition(new Vector2f(((float)super.getWindowOption().getSize().x * X_PERCENT) + game.getBoard().getCasePos(game.getActualPlayer().getPosition()).x + caseSize.x/2 - pionsRadius
				,game.getBoard().getCasePos(0).y + caseSize.y/2 - pionsRadius));
	}

	public void onClickOnCase(String name) {
		Vector2f pos = new Vector2f(0.5f,0.2f);
		Vector2f size = new Vector2f(400,400);
		
		popUp = new CaseActionPopUp(BOARD_TEXTURE+name, this, pos, super.getWindowOption().getSize(), size);
		
	}

	public void onFallOnCase(CaseFallOnActionPopUp popUp) {
		this.popUp = popUp;
		
	}


	public void setPlayerPlaying() {
		for(int i=0 ; i<nbPlayers ; i++){
			playersUI[i].setDefaultFillColor();
		}
		playersUI[game.getActualPlayer().getId()].setFillColor();
		
	}
	
	public void majPlayerMoney(int idPlayer){
		playersUI[idPlayer].majMoney(game.getPlayers()[idPlayer].getMoney());
	}

}
