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
		
		// Opretter et iCO() opjekt og s�tter sproget, s�dan at beskeder kan hentes med:
		// iCO.messages.getString("n�gleord")
		ICO iCO = new ICO();
		iCO.setLang("da", "DK");
		
		GameController gameController = new GameController();
		gameController.newGame();
		

	}
		
}