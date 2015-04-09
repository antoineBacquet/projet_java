package iut_lens.dut_info.monopoly.game.card;

import iut_lens.dut_info.monopoly.game.Game;

import java.util.LinkedList;

public class ClassicChance implements CardBuilder{

	
	
	
	
	@Override
	public LinkedList<Card> getCards(Game game) {
		LinkedList<Card> cards =new LinkedList<>();
		

		cards.add(new Card(new GoToStrategy(39, false),"photosPlateau/chance",
				"Vous allez visiter les monuments de Paris. Rendez-vous à la Tour Eiffel.",game));
		cards.add(new Card(new GoToStrategy(0, true),"photosPlateau/chance",
				"Avancez jusqu'à la case départ.",game)); 
		cards.add(new Card(new GoToStrategy(24, false),"photosPlateau/chance",
				"Vous allez à un concert. Rendez-vous au Palais Omnisport de Paris Bercy. Si vous passez par la case départ recevez 2 millions €.",game)); 
		cards.add(new Card(new PaidMoneyStrategy(200000),"photosPlateau/chance",
				"Vous faites construire une piscine sur le toit de votre appartement à Montmartre payer 200 000 €.",game)); 
		//cards.add(new Card( ,"photosPlateau/chance","Vous êtes libéré de prison. (Cette carte peut être conservée jusqu'à ce qu'elle soit utilisée ou vendue",game)); 
		cards.add(new Card(new EarnStrategy(1000000),"photosPlateau/chance",
				"Vous gagnez au loto. Recevez 1 millions €.",game)); 
		cards.add(new Card(new PaidMoneyStrategy(1500000),"photosPlateau/chance",
				"Payer pour frais de scolarité en école privée 1.5 millions €.",game)); 
		cards.add(new Card(new GoToStrategy(15, false),"photosPlateau/chance",
				"Rendez-vous à la gare Saint-Lazare. Si vous passez par la case départ recevez 2 millions €.",game)); 
		cards.add(new Card(new GoToStrategy(0, false),"photosPlateau/chance",
				"La circulation  à Paris est difficile! Reculez de 3 cases.",game)); 
		//cards.add(new Card(new GoToStrategy(0, false),"photosPlateau/chance","Vous n'avez pas payé votre taxe d'habitation. Allez en prison. Avancez tout droit en prison. Ne passez pas par la case départ. Ne touchez pas 2 millions €.",game)); 
		cards.add(new Card(new PaidMoneyStrategy(1000000),"photosPlateau/chance",
				"Vous faites redécorer vos propriétés par les meilleurs designers. Pour chaque appartement payer 250 000 €. Pour chaque hôtel payer 1 millions €.",game)); 
		cards.add(new Card(new PaidMoneyStrategy(150000),"photosPlateau/chance","Vous avez une amende car vous utilisez votre téléphone portable en conduisant. Payez 150 000 €.",game)); 
		cards.add(new Card(new EarnStrategy(1500000),"photosPlateau/chance","Vous vendez vos actions à profit. Recevez 1.5 millions €.",game)); 
		cards.add(new Card(new PaidMoneyStrategy(400000),"photosPlateau/chance","La taxe d'habitation augmente. Payez 400 000 € par appartement et 1.15 millions par hôtel.",game)); 
		cards.add(new Card(new GoToStrategy(11, false),"photosPlateau/chance","Rendez-vous au Pont Alexandre III. Si vous passez par la case départ recevez 2 millions €.",game)); 
		cards.add(new Card(new EarnStrategy(500000),"photosPlateau/chance","Vous organisez un tournoi de football au Stade de France. La vente des tickets vous rapporte 500 000 €.",game)); 
		
		return cards;

	}

}
