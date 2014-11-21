package spil;

public class DiceCup {

	public int[] getDiceCup(int dieRolls, int eyesOnDice){
		int eyes = eyesOnDice;
		int rolls = dieRolls;
		int[] diceArray = new int[rolls];
		
		Dice dice = new Dice();
		for (int i = 0; i < rolls; i++) {
			diceArray[i] = dice.getDice(eyes);
		}
		return diceArray;
	}
}
