package iut_lens.dut_info.monopoly.game.card;

import iut_lens.dut_info.monopoly.game.Game;

import java.util.LinkedList;

public class ClassicChance implements CardBuilder{

	
	
	
	
	@Override
	public LinkedList<Card> getCards(Game game) {
		LinkedList<Card> cards =new LinkedList<>();
		

		cards.add(new Card(new GoToStrategy(39, false),"photosCartes/chance4","",game));
		cards.add(new Card(new GoToStrategy(0, false),"photosCartes/chance1","",game)); 
		cards.add(new Card(new GoToStrategy(24, false),"photosCartes/chance2","",game)); 
		cards.add(new Card(new PaidMoneyStrategy(200000),"photosCartes/chance3","",game)); 
		//cards.add(new Card( ,"photosCartes/chance6","",game)); 
		cards.add(new Card(new EarnStrategy(1000000),"photosCartes/chance5","",game)); 
		cards.add(new Card(new PaidMoneyStrategy(1500000),"photosCartes/chance8","",game)); 
		cards.add(new Card(new GoToStrategy(15, false),"photosCartes/chance7","",game)); 
		cards.add(new Card(new GoToStrategy(0, false),"photosCartes/chance9","",game)); 
		//cards.add(new Card(new GoToStrategy(0, false),"photosCartes/chance10","",game)); 
		cards.add(new Card(new PaidMoneyStrategy(1000000),"photosCartes/chance11","",game)); 
		cards.add(new Card(new PaidMoneyStrategy(150000),"photosCartes/chance12","",game)); 
		cards.add(new Card(new EarnStrategy(1500000),"photosCartes/chance13","",game)); 
		cards.add(new Card(new PaidMoneyStrategy(400000),"photosCartes/chance14","",game)); 
		cards.add(new Card(new GoToStrategy(11, false),"photosCartes/chance16","",game)); 
		cards.add(new Card(new EarnStrategy(500000),"photosCartes/chance15","",game)); 
		
		return cards;

	}

}
