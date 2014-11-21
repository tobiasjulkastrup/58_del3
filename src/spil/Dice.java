package spil;

public class Dice {

	// Opretter terninger	
	public int getDice(int eyesOnDice){
		int eyes = eyesOnDice;
		int dice = (int) ((Math.random() * (eyes)) + 1);     // 0-1
		return dice;				
	}

}
