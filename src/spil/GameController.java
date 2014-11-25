package spil;

import boundaryToMatador.GUI;
import java.awt.Color;

public class GameController {

	private Player[] players;
	private ICO iCO;
	
	public void newGame() {
		
		int numberOfPlayers; // Holder styr på hvor mange spillere der er med
		boolean mode = false; // Holder styr på om spillet er færdigt
		int currentPlayer = 1; // Holder styr på hvis tur det er (starter ved Player 1)
		int currentPlayerPosition;
		int oldPlayerPosition;
		
		// Opretter en GUI med field info fra fieldsForGUI.txt
		iCO = new ICO();
		iCO.setGUI();
		
		DiceCup diceCup = new DiceCup();
	
		GUI.showMessage(ICO.messages.getString("firstMessageGUI")); // "Welcome. Press ok to start the game."
		numberOfPlayers = GUI.getUserInteger(ICO.messages.getString("numbersOfPlayersGUI")); // "How many players will play the game?"
		
		// Add players to the game and on the board
		
		players = new Player[numberOfPlayers];
		
		// Adds as many players as numberOfPlayers
		for (int i = 0; i < numberOfPlayers; i++) {
			setPlayers(i);
			players[i].setPosition(1);
			GUI.setCar(players[i].getPosition(), players[i].getName());
		}
		
		while (mode == false){
			oldPlayerPosition = players[currentPlayer-1].getPosition(); // Gemmer midlertidig en variable med spillerens tidligere position til GUI brug.
			
			GUI.getUserButtonPressed("Tryk på kast for at slå med terningerne Player " +currentPlayer, "Kast");
			diceCup.setDiceCup(2, 6); //Laver 2 terningekast med en 6 sidet terning.
			
			setDiceGUI(diceCup.getDiceCup()); //Sætter terningerne i spillet ud fra værdierne fra diceCup slaget.
			
			//Sætter spillers position ud fra slagets værdi og den gamle position.
			players[currentPlayer-1].setPosition(moveToField(diceCup.getTotalDiceCup(), players[currentPlayer-1].getPosition()));
			
			setPlayerPositionGUI(oldPlayerPosition, players[currentPlayer-1].getPosition(), players[currentPlayer-1].getName());
			
			//getFieldEffect(players[currentPlayer].getPosition()); // Tjekker hvad denne field position gør
			
			currentPlayer = nextPlayer(currentPlayer, numberOfPlayers); //Sætter currentPlayer for næste spiller
			
			mode = checkForWinner();
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
	
	private int nextPlayer(int currentPlayer, int numberOfPlayers) {
		if (currentPlayer == numberOfPlayers)
			currentPlayer = 1;
		else
			currentPlayer++;
		return currentPlayer;
	}

	private int moveToField(int currentThrowValue, int previousFieldPosition) { //IKKE LAVET
		int newField=0;
		newField=previousFieldPosition+currentThrowValue;
		if (newField>21)
			newField=newField%21;
		System.out.println(newField);
		return newField;
	}

	private void setDiceGUI(int[] allDiceCupValues) {
		
		GUI.setDice(allDiceCupValues[0], allDiceCupValues[1]);
		
	}

	private void setPlayerPositionGUI(int oldPlayerPositionOnBoard, int newPlayerPositionOnBoard, String currentPlayerName) {
		GUI.removeCar(oldPlayerPositionOnBoard, currentPlayerName);
		GUI.setCar(newPlayerPositionOnBoard, currentPlayerName);
	}

	private void getFieldEffect(int newPlayerPositionOnBoard) { //IKKE LAVET
		// Alt kode mht til field skal her ind.
	}

	private boolean checkForWinner() { //Ikke Lavet
		boolean winnerFound = false;
		
		return winnerFound;
	}
}
