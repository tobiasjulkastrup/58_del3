package test;

import static org.junit.Assert.*;

import org.junit.Test;

import board.GameBoard;
import board.Territory;
import spil.ICO;
import spil.Player;
import spil.GameController;

public class TerritoryTest {

	@Test
	public void testLandOnField() {

		// Preconditions
		@SuppressWarnings("unused")
		Territory Territory;

		// Opretter gameboard
		ICO iCO = new ICO();
		iCO.setLang("da", "DK");
		GameController gameController = new GameController();
		GameBoard gameboard = new GameBoard(gameController);

		// Sætter tax
		new Territory("Test territory", 2000, 1000, 1);

		// Opretter player
		Player player;
		player = new Player();
		player.setPlayer("Mads", 2000, null);

		// Test ved køb af feltet
		gameboard.fields[2].landOnField(player);

		// Postconditions
		assertEquals(500, player.getBalance());

	}

	@Test
	public void testGetRent() {

		// Precondition
		Territory Territory = new Territory("Test territory", 2000, 1000, 1);

		// Test
		Territory.getRent();

		// Postcondition
		assertEquals(1000, Territory.getRent());
	}

}
