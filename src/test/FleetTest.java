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
		iCO.setLang("da", "DK");		GameController gameController = new GameController();
		GameBoard gameboard = new GameBoard(gameController);


		// opretter player
		Player player;
		player = new Player();
		player.setPlayer("John", 10000, null);

		// Test af køb af fleet 1
		gameboard.fields[19].landOnField(player);
		// postconditions
		assertEquals(6000, player.getBalance());
		
		//Test af køb af fleet nr 2.
		gameboard.fields[20].landOnField(player);
		// postconditions
		assertEquals(2000, player.getBalance());
		
		//test af betaling til ejer
		player = new Player();
		player.setPlayer("Jens", 1100, null);
		// lander på Johns felt
		gameboard.fields[19].landOnField(player);
		assertEquals(100, player.getBalance());
	}

}
