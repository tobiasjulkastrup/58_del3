package test;

import static org.junit.Assert.*;

import org.junit.Test;

import spil.Player;
import board.Fleet;
import board.GameBoard;

public class FleetTest {

	@Test
	public void testLandOnField() {

		// Preconditions
		Fleet fleet;

		// opretter gameboard
		GameBoard gameboard = new GameBoard(null);

		// sætter fleet
		fleet = new Fleet("test fleet", 500, 1, null);

		// opretter player
		Player player;
		player = new Player();
		player.setPlayer("John", 500, null);

		// Test af fleet
		gameboard.fields[19].landOnField(player);
		
		// postconditions
		assertEquals(500, player.getBalance());

	}

}
