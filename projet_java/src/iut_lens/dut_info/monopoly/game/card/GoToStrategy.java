package iut_lens.dut_info.monopoly.game.card;

import iut_lens.dut_info.monopoly.game.Game;

public class GoToStrategy implements CardStrategy {

	
	
	private int caseId;
	private boolean isPayDay;
	
	
	public GoToStrategy(int caseId, boolean isPayDay) {
		this.caseId = caseId;
		this.isPayDay = isPayDay;
	}
	
	@Override
	public void onDraw(Game game) {
		game.moveActualPlayerTo(caseId, this.isPayDay);

	}

}
