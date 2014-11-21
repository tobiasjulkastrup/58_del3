package spil;

import boundaryToMatador.GUI;

public class StartGame {
	
	public static void main (String[] args)
	{
		// Deklarere en reference og laver et game() objekt
		StartGame game = new StartGame();
		// Kalder metoden og starter et nyt spil.
		game.go();
	}

	private void go() {
		
		// Opretter et Lang() opjekt og sætter sproget, sådan at beskeder kan hentes med:
		// Lang.messages.getString("nøgleord")
		Lang lang = new Lang();
		lang.setLang();
		
		//DiceCup test
//		DiceCup diceCup = new DiceCup();
//		int[] dice;
//		dice = diceCup.getDiceCup(2, 6);
//		System.out.println(""+dice[0]+" "+dice[1]);
		
		System.out.println("GUI will start in 3.. 2.. 1..");
		GUI.create("fieldsForGUI.txt");
		// Add players to the game and on the board
		GUI.showMessage("Welcome. Press ok to start the game.");
		

	}
		
}