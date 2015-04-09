package iut_lens.dut_info.monopoly.game.card;

import iut_lens.dut_info.monopoly.game.Game;

import java.util.LinkedList;

public class ClassicCommu implements CardBuilder {

	@Override
	public LinkedList<Card> getCards(Game game) {
		LinkedList<Card> cards = new LinkedList<>();	
		/*cards.add(new Card(new GoToStrategy(0, false))); //alle a la case depard
		cards.add(new Card(new EarnStrategy(0))); //Recevoir de l'argent
		cards.add(new Card(new GiveMoneyStrategy(0))); //Donner de l'argent
		cards.add(new Card(new eachGiveMoneyStrategy(0))); //recevoir de tout le monde de l'argent*/
		
		cards.add(new Card(new PaidMoneyStrategy(500000),"photosCartes/chance16","",game)); 
		cards.add(new Card(new EarnStrategy(2000000),"photosCartes/chance15","",game)); 
		cards.add(new Card(new EarnStrategy(200000),"photosCartes/chance14","",game)); 
		cards.add(new Card(new EarnStrategy(250000),"photosCartes/chance13","",game)); 
		cards.add(new Card(new PaidMoneyStrategy(100000),"photosCartes/chance11","",game)); 
		cards.add(new Card(new GoToStrategy(0, false),"photosCartes/chance12","",game)); 
		cards.add(new Card(new EarnStrategy(100000),"photosCartes/chance10","",game)); 
		//cards.add(new Card(new EarnStrategy(200000),"photosCartes/chance9","",game)); 
		cards.add(new Card(new eachGiveMoneyStrategy(100000),"photosCartes/chance8","",game)); 
		cards.add(new Card(new EarnStrategy(1000000),"photosCartes/chance7","",game)); 
		//cards.add(new Card(new EarnStrategy(200000),"photosCartes/chance6","",game)); 
		cards.add(new Card(new PaidMoneyStrategy(1000000),"photosCartes/chance5","",game)); 
		cards.add(new Card(new GoToStrategy(1, false),"photosCartes/chance3","",game)); 
		cards.add(new Card(new EarnStrategy(1000000),"photosCartes/chance4","",game)); 
		cards.add(new Card(new PaidMoneyStrategy(500000),"photosCartes/chance1","",game)); 
		cards.add(new Card(new EarnStrategy(500000),"photosCartes/chance2","",game)); 
		
		return cards;
	}

}
