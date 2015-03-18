package iut_lens.dut_info.monopoly.game.card;

import iut_lens.dut_info.monopoly.game.Game;

public class GiveMoneyStrategy implements CardStrategy {

	private int money;
	
	public GiveMoneyStrategy(int money) {
		super();
		this.money = money;
	}



	@Override
	public void onDraw(Game game) {
		// TODO Auto-generated method stub
		game.withdrawMoneyActualPlayer(money);
	}

}
