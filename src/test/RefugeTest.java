package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import board.GameBoard;
import board.Refuge;
import board.Territory;
import spil.Player;
import spil.GameController;


public class RefugeTest {

	@Test
	public void testLandOnField() {
		
		//preconditions
		Refuge Refuge;
		
		GameBoard gameboard = new GameBoard(null);
		
		new Refuge("test refuge", 5000);

		// opretter player
				Player player;
				player= new Player();
				player.setPlayer("John", 1000, null);	
				
				// Test af at lande på Refuge med bonus 500
				gameboard.fields[12].landOnField(player);

				// Postconditions
				assertEquals(6000, player.getBalance());	
	}

//	@Test
//	public void testRefuge() {
//		fail("Not yet implemented");
//	}

}
