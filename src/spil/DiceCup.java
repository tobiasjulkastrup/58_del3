package spil;

public class DiceCup {

	private int[] diceArray;
	private int rolls;
	
	//setDiceCup tager et antal rolls for hvor mange terninger der skal v�re med i rafleb�geret og antal �jne p� terningen.
	public void setDiceCup(int diceRolls, int eyesOnDice) {
		
		//Laver et array til de returnerede slag fra dice.getDice()
		diceArray = new int[diceRolls];
		rolls = diceRolls;

		//Laver en instans af en terning.
		Dice dice = new Dice();

		//K�rer en l�kke med hvor mange terninger der er med
		for (int i = 0; i < rolls; i++) {
			//Kalder dice.getDice() med hvor mange �jne der skal v�re p� terningen.
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
