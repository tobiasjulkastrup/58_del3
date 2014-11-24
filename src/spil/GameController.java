package spil;

import boundaryToMatador.GUI;
import java.awt.Color;

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
		Color playerColor = getPlayerColor();
		players[PlayerID].setPlayer(playerName, 30000, playerColor); //"What is your name,"
		iCO.setNewPlayerGUI(players[PlayerID].getName(), players[PlayerID].getBalance(), players[PlayerID].getColor());
	}
	
	private Color getPlayerColor() {
		
		Color playerColor = null;
		
		String selectedPlayerColor = GUI.getUserSelection(
				ICO.messages.getString("whatColor"),
				ICO.messages.getString("red"), 
				ICO.messages.getString("yellow"), 
				ICO.messages.getString("green"), 
				ICO.messages.getString("white"), 
				ICO.messages.getString("black"), 
				ICO.messages.getString("blue"), 
				ICO.messages.getString("brown"), 
				ICO.messages.getString("grey")
				);
		
		if (selectedPlayerColor.equals(ICO.messages.getString("red")) == true){
			playerColor = new Color(255, 0, 0);
		} else if (selectedPlayerColor.equals(ICO.messages.getString("yellow")) == true){
			playerColor = new Color(255, 255, 0);
		} else if (selectedPlayerColor.equals(ICO.messages.getString("green")) == true){
			playerColor = new Color(0, 255, 0);
		} else if (selectedPlayerColor.equals(ICO.messages.getString("white")) == true){
			playerColor = new Color(255, 255, 255);
		} else if (selectedPlayerColor.equals(ICO.messages.getString("black")) == true){
			playerColor = new Color(0, 0, 0);
		} else if (selectedPlayerColor.equals(ICO.messages.getString("blue")) == true){
			playerColor = new Color(0, 0, 255);
		} else if (selectedPlayerColor.equals(ICO.messages.getString("brown")) == true){
			playerColor = new Color(128, 64, 0);
		} else if (selectedPlayerColor.equals(ICO.messages.getString("grey")) == true){
			playerColor = new Color(128, 128, 128);
		}
		
		return playerColor;
	}
		
}
