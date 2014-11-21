package spil;

public class StartGame {
	
	public static void main (String[] args)
	{
		// Deklaration af reference og laver et game() objekt
		StartGame game = new StartGame();
		// Kalder metoden og starter et nyt spil.
		game.go();
	}

	private void go() {
		
		GameController gameController = new GameController();
		gameController.newGame();
		
		//DiceCup test
//		DiceCup diceCup = new DiceCup();
//		int[] dice;
//		dice = diceCup.getDiceCup(2, 6);
//		System.out.println(""+dice[0]+" "+dice[1]);

	}
		
}