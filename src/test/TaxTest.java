package test;

import static org.junit.Assert.*;

import org.junit.Test;

import board.Tax;
import spil.ICO;
import spil.Player;
import board.GameBoard;
import spil.GameController;
public class TaxTest {

	@Test
	public void testLandOnField() {
		//Preconditions
		@SuppressWarnings("unused")
		Tax tax;
		//opretter gameboard
		ICO iCO = new ICO();
		iCO.setLang("da", "DK");
		GameController gameController = new GameController();
		GameBoard gameboard = new GameBoard(gameController);
		// sætter tax
		tax = new Tax(null, 500, 1);
		// opretter player
		Player player;
		player= new Player();
		player.setPlayer("John", 1000, null);		
		
		//Test for fast taxrate
		gameboard.fields[17].landOnField(player);
		//postconditions
		assertEquals(500, player.getBalance());
		
		//Test for 10%
		gameboard.fields[17].landOnField(player);
		//post conditions
		assertEquals(450, player.getBalance());
	}

//	@Test
//	public void testTax() {
//		fail("Not yet implemented");
//	}

}
