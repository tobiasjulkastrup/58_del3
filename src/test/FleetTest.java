package test;

import static org.junit.Assert.*;

import org.junit.Test;

import spil.GameController;
import spil.ICO;
import spil.Player;
import board.Fleet;
import board.GameBoard;

public class FleetTest {

	@Test
	public void testLandOnField() {

		// Preconditions
		Fleet fleet;

		// opretter gameboard
		ICO iCO = new ICO();
		iCO.setLang("da", "DK");
		GameController gameController = new GameController();
		GameBoard gameboard = new GameBoard(gameController);

		// sætter fleet
		fleet = new Fleet("test fleet", 500, 1, null);

		// opretter player
		Player player;
		player = new Player();
		player.setPlayer("John", 500, null);

		// Test af fleet
		gameboard.fields[19].landOnField(player);
		
		// postconditions
		assertEquals(0, player.getBalance());

	}

}
