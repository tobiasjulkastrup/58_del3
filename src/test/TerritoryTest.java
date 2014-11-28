package test;

import static org.junit.Assert.*;

import org.junit.Test;

import board.GameBoard;
import board.Territory; 
import spil.Player;
import spil.GameController;




public class TerritoryTest {

	@Test
	public void testLandOnField() {
	
		GameBoard Gameboard = new GameBoard(null);
		
		
		
		
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
