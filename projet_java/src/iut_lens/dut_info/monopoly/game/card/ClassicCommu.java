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
		
		cards.add(new Card(new PaidMoneyStrategy(500000),"photosCartes/caisse6","",game)); 
		cards.add(new Card(new EarnStrategy(2000000),"photosCartes/caisse15","",game)); 
		cards.add(new Card(new EarnStrategy(200000),"photosCartes/caisse14","",game)); 
		cards.add(new Card(new EarnStrategy(250000),"photosCartes/caisse13","",game)); 
		cards.add(new Card(new PaidMoneyStrategy(100000),"photosCartes/caisse11","",game)); 
		cards.add(new Card(new GoToStrategy(0, false),"photosCartes/caisse12","",game)); 
		cards.add(new Card(new EarnStrategy(100000),"photosCartes/caisse10","",game)); 
		//cards.add(new Card(new EarnStrategy(200000),"photosCartes/chance9","",game)); 
		cards.add(new Card(new eachGiveMoneyStrategy(100000),"photosCartes/caisse8","",game)); 
		cards.add(new Card(new EarnStrategy(1000000),"photosCartes/caisse7","",game)); 
		//cards.add(new Card(new EarnStrategy(200000),"photosCartes/chance6","",game)); 
		cards.add(new Card(new PaidMoneyStrategy(1000000),"photosCartes/caisse5","",game)); 
		cards.add(new Card(new GoToStrategy(1, false),"photosCartes/caisse3","",game)); 
		cards.add(new Card(new EarnStrategy(1000000),"photosCartes/caisse4","",game)); 
		cards.add(new Card(new PaidMoneyStrategy(500000),"photosCartes/caisse1","",game)); 
		cards.add(new Card(new EarnStrategy(500000),"photosCartes/caisse2","",game)); 
		
		return cards;
	}

}
