package spil;

import boundaryToMatador.GUI;

public class GameController {

	public void newGame() {
		
		int numbersOfPlayers;
		
		//Opretter en GUI med field info fra fieldsForGUI.txt
		ICO iCO = new ICO();
		iCO.setGUI();
		
		// Opretter et Lang() opjekt og s�tter sproget, s�dan at beskeder kan hentes med:
		// Lang.messages.getString("n�gleord")
		iCO.setLang();
	
		GUI.showMessage("Welcome. Press ok to start the game.");
		numbersOfPlayers = GUI.getUserInteger("Hvor mange vil i spille?");
		
		// Add players to the game and on the board
		Player player = new Player();
		for (int i = 0; i < numbersOfPlayers; i++) {
			player.newPlayer(GUI.getUserString("Hvad er dit navn, Player "+(i+1)));
		}
	}
}
