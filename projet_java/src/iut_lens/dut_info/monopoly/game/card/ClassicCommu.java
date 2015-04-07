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
		
		cards.add(new Card(new GiveMoneyStrategy(500000),"photosPlateau/chance","Payez un week-end de thalasso dans un h�tel 5 �toiles 500 000 �.",game)); 
		cards.add(new Card(new EarnStrategy(2000000),"photosPlateau/chance","Votre soci�t� de vente par internet fait des b�n�fices. Recevez 2 millions �",game)); 
		cards.add(new Card(new EarnStrategy(200000),"photosPlateau/chance","Beaubourg consacre une de ses expositions � vos oeurves d'art. Recevez 200 000 �.",game)); 
		cards.add(new Card(new EarnStrategy(250000),"photosPlateau/chance","Votre assurance auto vous rembourse. Recevez 250 000 �.",game)); 
		cards.add(new Card(new GiveMoneyStrategy(100000),"photosPlateau/chance","Payez une contravention de 100 000 � ou bien tirez une carte Chance.",game)); 
		cards.add(new Card(new GoToStrategy(0, false),"photosPlateau/chance","Avancez jusqu'� la case d�part.",game)); 
		cards.add(new Card(new EarnStrategy(100000),"photosPlateau/chance","Vous �tes le gagnant d'un jeu t�l�vis�. Recevez 100 000 �.",game)); 
		//cards.add(new Card(new EarnStrategy(200000),"photosPlateau/chance","Vous �tes lib�r� de prison. (Cette carte peut �tre conserv�e jusqu'� ce qu'elle soit utilis�e ou vendue",game)); 
		cards.add(new Card(new eachGiveMoneyStrategy(100000),"photosPlateau/chance","Vous louez aux autres joueurs votre villa de Cannes pour une semaine. Chacun vous verse 100 000 �.",game)); 
		cards.add(new Card(new EarnStrategy(1000000),"photosPlateau/chance","Vous louez votre jet priv�. Recevez 1 millions �.",game)); 
		//cards.add(new Card(new EarnStrategy(200000),"photosPlateau/chance","Le fisc effectue un contr�le de vos imp�ts. Allez en prison. Avancez tout droit en prison. Ne passez pas par la case d�part. Ne touchez pas 2 millions �.",game)); 
		cards.add(new Card(new GiveMoneyStrategy(1000000),"photosPlateau/chance","Vous organisez un concert � l'Olympia. Payez 1 millions �.",game)); 
		cards.add(new Card(new GoToStrategy(0, false),"photosPlateau/chance","Reculez jusqu'aux Quais de Seine pour une visite chez les Bouquinistes.",game)); 
		cards.add(new Card(new EarnStrategy(1000000),"photosPlateau/chance","Vous h�ritez de 3 millions � et vous devez payer les droits de succession. Recevez 1 millions �.",game)); 
		cards.add(new Card(new GiveMoneyStrategy(500000),"photosPlateau/chance","Vous endommagez un tableau au Mus�e d'Orsay. Payer 500 000 � de r�parations.",game)); 
		cards.add(new Card(new EarnStrategy(500000),"photosPlateau/chance","Vous b�n�ficiez d'une remise d'imp�ts. Recevez 500 000 �.",game)); 
		
		return cards;
	}

}
