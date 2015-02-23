package iut_lens.dut_info.monopoly.vue;

import iut_lens.dut_info.monopoly.core.Content;
import iut_lens.dut_info.monopoly.core.Util;
import iut_lens.dut_info.monopoly.core.element.Action;
import iut_lens.dut_info.monopoly.core.element.Button;
import iut_lens.dut_info.monopoly.core.element.Selector;
import iut_lens.dut_info.monopoly.core.element.TextField;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;



public class GameCreationContent extends Content{
	
	private final String[] tabNbJoueur = {"1","2","3","4","5","6","7","8","9","10"};
	private final String[] tabNbBot = {"0","1","2","3","4","5","6","7","8","9"};
	
	private Selector nbJoueurSelector;
	private Selector nbBotSelector;
	
	private Button cancelButton;
	private Button startGameButton;
	
	private TextField[] pseudos =  new TextField[0];
	public GameCreationContent() {
		super();
		
		nbJoueurSelector = new Selector(this,tabNbJoueur,new Vector2f(200,40),new Vector2f(0,0),0,"nb joueurs");
		super.addElementNoRender(nbJoueurSelector);
		
		nbBotSelector = new Selector(this,tabNbBot,new Vector2f(200,40),new Vector2f(0,0),0,"nb bot");
		super.addElementNoRender(nbBotSelector);
		
		cancelButton = new Button(this, new Vector2f(200,50), "retour");
		super.addElementNoRender(cancelButton);
		startGameButton = new Button(this, new Vector2f(200,50), "lancer");
		super.addElementNoRender(startGameButton);
	}
	
	@Override
	public void actionPerformed(Action action) {
		
		
		if(action.getSource() == nbJoueurSelector){
			nbBotSelector.setOption(Util.cutTable(tabNbBot, 0, tabNbBot.length - nbJoueurSelector.getChoix()));
			createTextFieldSpeudo(nbJoueurSelector.getChoix()+1);
		}
		
		if(action.getSource() == nbBotSelector){
			nbJoueurSelector.setOption(Util.cutTable(tabNbJoueur, 0, tabNbJoueur.length - nbBotSelector.getChoix()));
		}
		
		if(action.getSource() == startGameButton){
			String[] tmp = {"1","2"};
			super.window.changeContent(new GameContent(tmp));
		}
		
	}
	

	
	public void createTextFieldSpeudo(int nb){
		if(pseudos.length == 0){
			pseudos = new TextField[nb];
			for(int i=0 ;i<pseudos.length ; i++)
				pseudos[i] = new TextField(this,new Vector2f(200,20),"joueur num :" +(i+1));
			setPseudoPos();
		}
		
		else{
			if(nb>pseudos.length){
				TextField[] tmp = new TextField[nb];
				for(int i=0 ; i<pseudos.length ; i++)
					tmp[i] = pseudos[i];
				for (int i = pseudos.length; i < nb; i++) 
					tmp[i] = new TextField(this,new Vector2f(200,20),"joueur num :" +(i+1));
				
				pseudos = tmp;

				setPseudoPos();
			}
			else{
				TextField[] tmp = new TextField[nb];
				for(int i=0 ; i<nb ; i++)
					tmp[i] = pseudos[i];
				
				pseudos = tmp;

				setPseudoPos();
			}
		}
	}
	
	public void setPseudoPos(){
		for(int i=0 ;i<pseudos.length ; i++)
			pseudos[i].setPositionRelative(super.window.getSize(), 0.2f, (float)(0.2+(i*0.05)));
	}

	@Override
	protected void onCreate() {
		nbJoueurSelector.setPositionRelative(super.window.getSize(), 0.2f, 0.1f);
		nbBotSelector.setPositionRelative(super.window.getSize(), 0.8f, 0.1f);
		
		cancelButton.setPositionRelative(super.window.getSize(), 0.2f, 0.9f);
		startGameButton.setPositionRelative(super.window.getSize(), 0.8f, 0.9f);
	}

	@Override
	public void handleEvent(Event evt) {
		for(int i=0 ;i<pseudos.length ; i++)
			pseudos[i].handleEvent(evt);
		
		
	}

	@Override
	public void update(Time tau) {
		for(int i=0 ;i<pseudos.length ; i++)
			pseudos[i].update(tau);
		
	}

	@Override
	public void render(RenderTarget target) {
		for(int i=0 ;i<pseudos.length ; i++)
			pseudos[i].render(target);
		
		startGameButton.render(target);
		
		cancelButton.render(target);
		
		nbJoueurSelector.render(target);
		
		nbBotSelector.render(target);
		
	}

}
