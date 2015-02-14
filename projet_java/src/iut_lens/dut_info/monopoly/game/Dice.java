package iut_lens.dut_info.monopoly.game;

import java.util.Random;

public class Dice {
	
	Random random = new Random();
	
	private int number = 1;
	
	public void throwDice(){
		number = random.nextInt(5)+1;
	}
	
	public int getNumber(){
		return number;
	}

}
