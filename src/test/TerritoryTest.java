package test;

import static org.junit.Assert.*;

import org.junit.Test;

import board.GameBoard;
import board.Territory; 
import spil.Player;




public class TerritoryTest {

	@Test
	public void testLandOnField() {
	
		GameBoard Gameboard = new GameBoard();
		
		
		
		
	}

	

	@Test
	public void testGetRent() {
		
		Territory Territory = new Territory("Test territory", 2000, 1000, 1);
		Territory.getRent();
		
		assertEquals(1000, Territory.getRent());
	}

}
