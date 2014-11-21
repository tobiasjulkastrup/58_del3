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
		
		// Opretter et iCO() opjekt og sætter sproget, sådan at beskeder kan hentes med:
		// iCO.messages.getString("nøgleord")
		ICO iCO = new ICO();
		iCO.setLang("da", "DK");
		
		GameController gameController = new GameController();
		gameController.newGame();
		

	}
		
}