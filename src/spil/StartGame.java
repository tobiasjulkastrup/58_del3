package spil;

public class StartGame {
	
	public static void main (String[] args)
	{
		// Deklarere en reference og laver et game() objekt
		StartGame game = new StartGame();
		// Kalder metoden og starter et nyt spil.
		game.go();
	}

	private void go() {
		
		// Opretter et Lang() opjekt og sætter sproget, sådan at beskeder kan hentes med Lang.messages.getString("nøgleord")
		Lang lang = new Lang();
		lang.setLang();
		
		System.out.println(Lang.messages.getString("test"));
		
	}
		
}