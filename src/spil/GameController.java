package spil;

import boundaryToMatador.GUI;

import java.awt.Color;

import board.GameBoard;

public class GameController {

	private Player[] players;
	private ICO iCO;
	private GameBoard gameBoard;
	private String[] loserArray;
	private int loserCount;
	private int numberOfPlayers = 0; // Holder styr p� hvor mange spillere der
	// er med
	private boolean mode = false; // Holder styr p� om spillet er f�rdigt
	public DiceCup diceCup;

	public void newGame() {

		mode = false;
		
		int currentPlayer = 1; // Holder styr p� hvis tur det er (starter ved
		// Player 1)
		int oldPlayerPosition;

		// Opretter en GUI med field info fra fieldsForGUI.txt
		iCO = new ICO();
		iCO.setGUI();

		//Laver en instans af GameBoard()
		gameBoard = new GameBoard(this);
		
		// Opretter et rafleb�ger
		diceCup = new DiceCup();

		GUI.showMessage(ICO.messages.getString("firstMessageGUI")); // "Welcome. Press ok to start the game."
		numberOfPlayers = GUI.getUserInteger(
				ICO.messages.getString("numbersOfPlayersGUI"), 2, 6); // "How many players will play the game?"

		// Add players to the game and on the board

		players = new Player[numberOfPlayers];
		loserArray = new String[numberOfPlayers - 1];
		loserCount = 0;

		// Adds as many players as numberOfPlayers
		for (int i = 0; i < numberOfPlayers; i++) {
			setPlayers(i);
			players[i].setPosition(1);
			GUI.setCar(players[i].getPosition(), players[i].getName());
		}

		while (mode == false) {
			oldPlayerPosition = players[currentPlayer - 1].getPosition(); // Gemmer
			// midlertidig en variable med spillerens tidligere position til GUI brug.

			// Laver en GUI output besked om at man skal trykke Kast
			GUI.getUserButtonPressed(
					ICO.messages.getString("pressTheTrowKey") + currentPlayer
					+ " (" + players[currentPlayer - 1].getName() + ")",
					ICO.messages.getString("Throw"));
			
			diceCup.setDiceCup(2, 6); // Laver 2 terningekast med en 6 sidet terning.

			setDiceGUI(diceCup.getDiceCup()); // S�tter terningerne i spillet ud fra v�rdierne fra diceCup slaget.

			// S�tter spillers position ud fra slagets v�rdi og den gamle position.
			players[currentPlayer - 1].setPosition(moveToField(
					diceCup.getTotalDiceCup(),
					players[currentPlayer - 1].getPosition()));

			// Kalder setPlayerPositionGUI() som s�tter player's nye position p� br�ttet
			setPlayerPositionGUI(oldPlayerPosition,
					players[currentPlayer - 1].getPosition(),
					players[currentPlayer - 1].getName());

			getFieldEffect(players[currentPlayer - 1].getPosition(),
					players[currentPlayer - 1].getBalance(), currentPlayer); // Tjekker hvad denne field position g�r

			// Kalder checkForLoser(), om currentPlayer har flere penge eller er r�get ud
			checkForLoser(currentPlayer);

			// Kalder nextPlayer() og retunere den n�ste player til currentPlayer
			currentPlayer = nextPlayer(currentPlayer, numberOfPlayers); // S�tter currentPlayer for n�ste spiller

			// Kalder checkForWinner() som tjekker for om der er flere spillere med.
			mode = checkForWinner();

		}

	}

	private void setPlayers(int PlayerID) {
		boolean nameOK = false;
		boolean nameBad = false;
		String playerName = null;

		players[PlayerID] = new Player();

		//L�kke der f�rst breakes n�r navnet ikke er brugt
		while (nameOK == false) {
			playerName = (GUI.getUserString(ICO.messages
					.getString("inputNameGUI") + (PlayerID + 1) + "?"));

			//Tjekker om navnet er taget af en anden bruger
			for (int i = 0; i < PlayerID; i++) {
				nameBad = players[i].getName().equals(playerName);
			}

			//Hvis navnet er taget udskrives en besked om at playeren skal v�lge et andet
			if (nameBad == true)
				GUI.showMessage(ICO.messages.getString("badName"));
			else
				nameOK = true; //Er navnet ikke taget �ndret while-l�kkens boolean til true og l�kkes forlades
		}

		//Kalder getPlayerColor til at bestemme hvilken farve playerens bil skal v�re.
		Color playerColor = getPlayerColor();
		//Efter navn og farve er valgt, oprettes et player objekt til p�g�ldende player.
		players[PlayerID].setPlayer(playerName, 30000, playerColor); // "What is your name,"
		//Playeren tilf�jes til br�ttet
		iCO.setNewPlayerGUI(players[PlayerID].getName(),
				players[PlayerID].getBalance(), players[PlayerID].getColor());
	}

	private Color getPlayerColor() {

		Color playerColor = null;

		//Liste output med farver spilleren kan v�lge.
		String selectedPlayerColor = GUI
				.getUserSelection(ICO.messages.getString("whatColor"),
						ICO.messages.getString("red"),
						ICO.messages.getString("yellow"),
						ICO.messages.getString("green"),
						ICO.messages.getString("white"),
						ICO.messages.getString("black"),
						ICO.messages.getString("blue"),
						ICO.messages.getString("brown"),
						ICO.messages.getString("grey"));

		// Else-if l�kke som tjekker hvilken farve der er valgt og laver et Color objekt med farven.
		if (selectedPlayerColor.equals(ICO.messages.getString("red")) == true) {
			playerColor = new Color(255, 0, 0);
		} else if (selectedPlayerColor.equals(ICO.messages.getString("yellow")) == true) {
			playerColor = new Color(255, 255, 0);
		} else if (selectedPlayerColor.equals(ICO.messages.getString("green")) == true) {
			playerColor = new Color(0, 255, 0);
		} else if (selectedPlayerColor.equals(ICO.messages.getString("white")) == true) {
			playerColor = new Color(255, 255, 255);
		} else if (selectedPlayerColor.equals(ICO.messages.getString("black")) == true) {
			playerColor = new Color(0, 0, 0);
		} else if (selectedPlayerColor.equals(ICO.messages.getString("blue")) == true) {
			playerColor = new Color(0, 0, 255);
		} else if (selectedPlayerColor.equals(ICO.messages.getString("brown")) == true) {
			playerColor = new Color(128, 64, 0);
		} else if (selectedPlayerColor.equals(ICO.messages.getString("grey")) == true) {
			playerColor = new Color(128, 128, 128);
		}

		return playerColor;
	}

	//Metode der finder n�ste player
	private int nextPlayer(int currentPlayer, int numberOfPlayers) {

		boolean nextPlayerPlaying = false;

		while (nextPlayerPlaying == false) {
			if (currentPlayer == numberOfPlayers)
				currentPlayer = 1;
			else
				currentPlayer++;

			//Tjekker om n�ste spiller stadig har penge og ellers springer over denne.
			int playerBalance = players[currentPlayer - 1].getBalance();

			if (playerBalance > 0)
				nextPlayerPlaying = true;

		}

		return currentPlayer;
	}

	private int moveToField(int currentThrowValue, int previousFieldPosition) {
		int newField = 0;
		newField = previousFieldPosition + currentThrowValue;
		if (newField > 22)
			newField = newField % 22;
		return newField;
	}

	private void setDiceGUI(int[] allDiceCupValues) {

		GUI.setDice(allDiceCupValues[0], allDiceCupValues[1]);

	}

	private void setPlayerPositionGUI(int oldPlayerPositionOnBoard,
			int newPlayerPositionOnBoard, String currentPlayerName) {
		GUI.removeCar(oldPlayerPositionOnBoard, currentPlayerName);
		GUI.setCar(newPlayerPositionOnBoard, currentPlayerName);
	}

	//Metode kalder boardet landOnField() s�tter balancen for spillerens p� GUI'en
	private void getFieldEffect(int newPlayerPositionOnBoard,
			int playerBalance, int currentPlayer) {

		if (newPlayerPositionOnBoard != 1) {
			gameBoard.fields[newPlayerPositionOnBoard - 1]
					.landOnField(players[currentPlayer - 1]);
			GUI.setBalance(players[currentPlayer - 1].getName(),
					players[currentPlayer - 1].getBalance());
		} else
			GUI.showMessage(ICO.messages.getString("passStart"));

	}
	//Metode der tjekker for om currentPlayer har flere penge og ellers tilf�jet spilleren i et loserArray
	private void checkForLoser(int currentPlayer) {
		
		int playerBalance = players[currentPlayer - 1].getBalance();

		if (playerBalance <= 0) {
			loserArray[loserCount] = players[currentPlayer - 1].getName();
			loserCount++;
			GUI.removeAllCars(players[currentPlayer - 1].getName());
			GUI.showMessage(players[currentPlayer - 1].getName()
					+ ICO.messages.getString("playerLost"));
		}

	}
	// Tjekker om der er flere eller lige s� mange tabere som spillere minus 1 (da der skal v�re en vinder)
	private boolean checkForWinner() {
		boolean winnerFound = false;

		if (loserCount >= numberOfPlayers - 1) {
			boolean winnerNameFound = false;
			String winnerName = null;

			while (winnerNameFound == false) {

				for (int i = 0; i < numberOfPlayers; i++) {
					int playerBalance = players[i].getBalance();

					if (playerBalance > 0) {
						winnerNameFound = true;
						winnerName = players[i].getName();
					}
				}

			}
			
			// Er der fundet en vinder laves der en vinder-string best�ende af vinderen 
			// og taberne i r�kkef�lge som de blev smidt ud af spiller
			String winnerMessage = loserToString(loserArray, winnerName);
			GUI.showMessage(winnerMessage);
			winnerFound = true;
		}

		return winnerFound;
	}
	
	// Sammens�tter en string med vinderen og alle taberne.
	private String loserToString(String[] loserArray, String winner) {
		String newWinnerString = ICO.messages.getString("gameIsOverMessage");
		newWinnerString = stringToNewString(newWinnerString,
				winner.toUpperCase());
		for (int i = 0; i < loserArray.length; i++) {
			newWinnerString = stringToNewString(newWinnerString, "\n"
					+ ICO.messages.getString("Nr") + Integer.toString(i + 1));
			newWinnerString = stringToNewString(newWinnerString, " "
					+ ICO.messages.getString("thatLostwas") + loserArray[i]);
		}
		return newWinnerString;
	}

	//Sammens�tter en string af to andre strings.
	private String stringToNewString(String first, String second) {
		return first + second;
	}

}
