package iut_lens.dut_info.monopoly.game.card;

import java.util.ArrayList;
import java.util.List;

public class ClassicChance implements CardBuilder{

	
	
	
	
	@Override
	public List<Card> getCards() {
		ArrayList<Card> cards =new ArrayList<>();
		/*cards.add(new Card(new GoToStrategy(0, false))); //alle a la case depard
		cards.add(new Card(new EarnStrategy(0))); //Recevoir de l'argent
		cards.add(new Card(new GiveMoneyStrategy(0))); //Donner de l'argent
		cards.add(new Card(new eachGiveMoneyStrategy(0))); //recevoir de tout le monde de l'argent*/
		return cards;
	}

}
