package spil;

public class DiceCup {

	private int[] diceArray;
	private int rolls;
	
	//setDiceCup tager et antal rolls for hvor mange terninger der skal være med i raflebægeret og antal øjne på terningen.
	public void setDiceCup(int diceRolls, int eyesOnDice) {
		
		//Laver et array til de returnerede slag fra dice.getDice()
		diceArray = new int[diceRolls];
		rolls = diceRolls;

		//Laver en instans af en terning.
		Dice dice = new Dice();

		//Kører en løkke med hvor mange terninger der er med
		for (int i = 0; i < rolls; i++) {
			//Kalder dice.getDice() med hvor mange øjne der skal være på terningen.
			diceArray[i] = dice.getDice(eyesOnDice);
		}

	}

	public int[] getDiceCup() {

		return diceArray;

	}

	public int getTotalDiceCup() {

		int totalDiceValue = 0;

		for (int i = 0; i < rolls; i++) {
			totalDiceValue = totalDiceValue + diceArray[i];
		}

		return totalDiceValue;
	}

}
