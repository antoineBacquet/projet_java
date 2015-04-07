package iut_lens.dut_info.monopoly.game.card;

import iut_lens.dut_info.monopoly.game.Game;

import java.util.ArrayList;
import java.util.List;

public class ClassicCommu implements CardBuilder {

	@Override
	public List<Card> getCards(Game game) {
		ArrayList<Card> cards = new ArrayList<>();	
		/*cards.add(new Card(new GoToStrategy(0, false))); //alle a la case depard
		cards.add(new Card(new EarnStrategy(0))); //Recevoir de l'argent
		cards.add(new Card(new GiveMoneyStrategy(0))); //Donner de l'argent
		cards.add(new Card(new eachGiveMoneyStrategy(0))); //recevoir de tout le monde de l'argent*/
		
		cards.add(new Card(new GiveMoneyStrategy(500000),"photosPlateau/chance","Payez un week-end de thalasso dans un hôtel 5 étoiles 500 000 €.",game)); 
		cards.add(new Card(new EarnStrategy(2000000),"photosPlateau/chance","Votre société de vente par internet fait des bénéfices. Recevez 2 millions €",game)); 
		cards.add(new Card(new EarnStrategy(200000),"photosPlateau/chance","Beaubourg consacre une de ses expositions à vos oeurves d'art. Recevez 200 000 €.",game)); 
		cards.add(new Card(new EarnStrategy(250000),"photosPlateau/chance","Votre assurance auto vous rembourse. Recevez 250 000 €.",game)); 
		cards.add(new Card(new GiveMoneyStrategy(100000),"photosPlateau/chance","Payez une contravention de 100 000 € ou bien tirez une carte Chance.",game)); 
		cards.add(new Card(new GoToStrategy(0, false),"photosPlateau/chance","Avancez jusqu'à la case départ.",game)); 
		cards.add(new Card(new EarnStrategy(100000),"photosPlateau/chance","Vous êtes le gagnant d'un jeu télévisé. Recevez 100 000 €.",game)); 
		//cards.add(new Card(new EarnStrategy(200000),"photosPlateau/chance","Vous êtes libéré de prison. (Cette carte peut être conservée jusqu'à ce qu'elle soit utilisée ou vendue",game)); 
		cards.add(new Card(new eachGiveMoneyStrategy(100000),"photosPlateau/chance","Vous louez aux autres joueurs votre villa de Cannes pour une semaine. Chacun vous verse 100 000 €.",game)); 
		cards.add(new Card(new EarnStrategy(1000000),"photosPlateau/chance","Vous louez votre jet privé. Recevez 1 millions €.",game)); 
		//cards.add(new Card(new EarnStrategy(200000),"photosPlateau/chance","Le fisc effectue un contrôle de vos impôts. Allez en prison. Avancez tout droit en prison. Ne passez pas par la case départ. Ne touchez pas 2 millions €.",game)); 
		cards.add(new Card(new GiveMoneyStrategy(1000000),"photosPlateau/chance","Vous organisez un concert à l'Olympia. Payez 1 millions €.",game)); 
		cards.add(new Card(new GoToStrategy(0, false),"photosPlateau/chance","Reculez jusqu'aux Quais de Seine pour une visite chez les Bouquinistes.",game)); 
		cards.add(new Card(new EarnStrategy(1000000),"photosPlateau/chance","Vous héritez de 3 millions € et vous devez payer les droits de succession. Recevez 1 millions €.",game)); 
		cards.add(new Card(new GiveMoneyStrategy(500000),"photosPlateau/chance","Vous endommagez un tableau au Musée d'Orsay. Payer 500 000 € de réparations.",game)); 
		cards.add(new Card(new EarnStrategy(500000),"photosPlateau/chance","Vous bénéficiez d'une remise d'impôts. Recevez 500 000 €.",game)); 
		
		return cards;
	}

}
