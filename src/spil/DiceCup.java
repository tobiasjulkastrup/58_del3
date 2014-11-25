package spil;

public class DiceCup {

	private int[] diceArray;
	private int rolls;
	
	public void setDiceCup(int diceRolls, int eyesOnDice) {
		
		diceArray = new int[diceRolls];
		rolls = diceRolls;
		
		Dice dice = new Dice();
		
		for (int i = 0; i < rolls; i++) {
			diceArray[i] = dice.getDice(eyesOnDice);
		}
		
	}
	
	public int[] getDiceCup() {
		
		return diceArray;
		
	}
	
	public int getTotalDiceCup() {
		
		int totalDiceValue = 0;
		
		for (int i = 0; i < rolls; i++) {
			totalDiceValue =+ diceArray[i];
		}
		
		return totalDiceValue;
	}
	
}
