package spil;

import boundaryToMatador.GUI;

public class GameController {

	private Player[] players;
	
	private ICO iCO;
	
	public void newGame() {
		
		int numberOfPlayers;
		
		// Opretter en GUI med field info fra fieldsForGUI.txt
		iCO = new ICO();
		iCO.setGUI();
	
		GUI.showMessage(ICO.messages.getString("firstMessageGUI")); // "Welcome. Press ok to start the game."
		numberOfPlayers = GUI.getUserInteger(ICO.messages.getString("numbersOfPlayersGUI")); // "How many players will play the game?"
		
		// Add players to the game and on the board
		
		players = new Player[numberOfPlayers];
		
		// Adds as many players as numberOfPlayers
		for (int i = 0; i < numberOfPlayers; i++) {
			setPlayers(i);
		}
		
	}
	private void setPlayers (int PlayerID) {
		players[PlayerID] = new Player();
		String playerName = (GUI.getUserString(ICO.messages.getString("inputNameGUI")+(PlayerID+1)+"?"));
		players[PlayerID].setPlayer(playerName, 30000); //"What is your name,"
		iCO.setNewPlayerGUI(players[PlayerID].getName(), players[PlayerID].getBalance());
	}	
		
}
