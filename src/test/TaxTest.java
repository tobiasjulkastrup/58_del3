package test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import board.Tax;
import spil.Player;
import board.GameBoard;

public class TaxTest {

	@Test
	public void testLandOnField() {
		//Preconditions
		Tax tax;
		GameBoard gameboard;
		gameboard= new GameBoard();
		tax= new Tax(null, 500, 1);
		Player player;
		player= new Player();
		player.setPlayer("John", 1000, null);		
		//Test for fast taxrate
		gameboard.fields[17].landOnField(player);
		//postconditions
		assertEquals(500, player.getBalance());
		
		//Test for 10%
		gameboard.fields[17].landOnField(player);
		assertEquals(450, player.getBalance());
		
		//fail("Not yet implemented");
	}

//	@Test
//	public void testTax() {
//		fail("Not yet implemented");
//	}

}
