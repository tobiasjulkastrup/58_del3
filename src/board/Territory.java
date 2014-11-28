package board;

import boundaryToMatador.GUI;
import spil.Player;

public class Territory extends Ownable {

	private int rent;
	private int fieldPlace;
	private Player player;

	public Territory(String name, int price, int rent, int fieldPlace) {

		super(name, price);
		this.rent = rent;
		this.fieldPlace = fieldPlace+1;

	}

	@Override
	public void landOnField(Player player) {

		this.player = player;

		// Tjekker om owner = null. Hvis true k�res if-s�tningen, der tjekker om spilleren har r�d til at k�be grunden og om han vil.
		if (owner == null) {

			// Boolean der s�ttes til false og �ndres til true hvis playeren har kapital til at k�be grunden
			boolean capitalAvaliable = false;
			capitalAvaliable = checkForCapital(player);

			//Hvis playeren har kapital sp�rges playeren om han vil k�be grunden.
			if (capitalAvaliable = true){
				String playerBuyString;
				boolean playerBuyBool = false;

				playerBuyString = GUI.getUserButtonPressed(
						"Vejen '" +getName()+ "', som du st�r p� er til salg for: " +getPrice()+ " " + "kr. " + "Vil du k�be den?", 
						"Ja", 
						"Nej"
						);

				//playerBuyBool s�ttes fra false til true, hvis playeren svare Ja
				playerBuyBool = playerBuyString.equals("Ja");

				//Hvis playeren v�lger ja, tr�kkes pengene fra playerens account, han s�ttes som ejer af grunden og der s�ttes et hotel p� vejen, s� man kan se den er k�bt.
				if (playerBuyBool == true){
					player.withdraw(getPrice());
					setOwner(player);
					GUI.setHotel(fieldPlace, true);
				}
			}


		} else {

			// hvis owner /= null skal spilleren betale lejen

			//laver en int playerBalanceTemp der tjekker playerens balance (s� der ikke kan h�ves mere end han har)
			int playerBalanceTemp;
			playerBalanceTemp = player.getBalance();

			//Hvis playeren har mindre en hvad lejen er, f�r ejeren resten af spillerens penge.
			if (playerBalanceTemp < getRent()){
				player.withdraw(playerBalanceTemp);
				GUI.showMessage(player.getName() + "du har ikke flere penge og " +getOwner().getName()+ " f�r dine resterende " +playerBalanceTemp);
				getOwner().deposit(playerBalanceTemp);
			} 
			//Har spilleren nok, h�ves hele bel�bet
			else {
				player.withdraw(getRent());
				getOwner().deposit(getRent());
			}

			//Den nye balance for ejeren s�ttes her, da den ikke automatisk s�ttes efter endt runde.
			GUI.setBalance(getOwner().getName(), getOwner().getBalance());

		}

	}

	public int getRent() {

		return rent;

	}

}
