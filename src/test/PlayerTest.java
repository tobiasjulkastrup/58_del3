package test;

import static org.junit.Assert.assertEquals;
import java.awt.Color;

import org.junit.Test;

import spil.Player;

public class PlayerTest {

//	@Test
//	public void testSetPlayer() {
//		
//		Player player;
//		player =  new Player();
//		Color playerColor;
//		
//		player.setPlayer("John", 500, Color.black);
//		
//		assertEquals(expected, player.);
		
//	}

	@Test
	public void testGetName() {
		// preconditions
		Player player;
		player =  new Player();
		player.getName();
		// test
		player.setPlayer("John", 0, null);
		//postconditions
		assertEquals("John", player.getName());

	}

	@Test
	public void testGetColor() {
		// precondtions
		Player player;
		player =  new Player();
		// test
		player.setPlayer(null, 0, Color.BLUE);
		// postconditions		
		assertEquals(Color.BLUE, player.getColor());

	}

}
