package spil;

import boundaryToMatador.GUI;

public class GameController {

	public void newGame() {
		
		int numbersOfPlayers;
		
		// Opretter en GUI med field info fra fieldsForGUI.txt
		ICO iCO = new ICO();
		iCO.setGUI();
	
		GUI.showMessage(ICO.messages.getString("firstMessageGUI")); // "Welcome. Press ok to start the game."
		numberOfPlayers = GUI.getUserInteger(ICO.messages.getString("numbersOfPlayersGUI")); // "How many players will play the game?"
		
		// Add players to the game and on the board
		Player player = new Player();
		
		// Sents total players to Player()
		player.totalPlayers(numberOfPlayers);
		
		// Adds as many players as numberOfPlayers
		for (int i = 0; i < numberOfPlayers; i++) {
			player.newPlayer(GUI.getUserString(ICO.messages.getString("inputNameGUI")+(i+1)+"?")); //"What is your name, Player 
		}
	}
}
