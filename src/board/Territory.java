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

		// Tjekker om owner = null. Hvis true køres if-sætningen, der tjekker om spilleren har råd til at købe grunden og om han vil.
		if (owner == null) {

			// Boolean der sættes til false og ændres til true hvis playeren har kapital til at købe grunden
			boolean capitalAvaliable = false;
			capitalAvaliable = checkForCapital(player);

			//Hvis playeren har kapital spørges playeren om han vil købe grunden.
			if (capitalAvaliable = true){
				String playerBuyString;
				boolean playerBuyBool = false;

				playerBuyString = GUI.getUserButtonPressed(
						"Vejen '" +getName()+ "', som du står på er til salg for: " +getPrice()+ " " + "kr. " + "Vil du købe den?", 
						"Ja", 
						"Nej"
						);

				//playerBuyBool sættes fra false til true, hvis playeren svare Ja
				playerBuyBool = playerBuyString.equals("Ja");

				//Hvis playeren vælger ja, trækkes pengene fra playerens account, han sættes som ejer af grunden og der sættes et hotel på vejen, så man kan se den er købt.
				if (playerBuyBool == true){
					player.withdraw(getPrice());
					setOwner(player);
					GUI.setHotel(fieldPlace, true);
				}
			}


		} else {

			// hvis owner /= null skal spilleren betale lejen

			//laver en int playerBalanceTemp der tjekker playerens balance (så der ikke kan hæves mere end han har)
			int playerBalanceTemp;
			playerBalanceTemp = player.getBalance();

			//Hvis playeren har mindre en hvad lejen er, får ejeren resten af spillerens penge.
			if (playerBalanceTemp < getRent()){
				player.withdraw(playerBalanceTemp);
				GUI.showMessage(player.getName() + "du har ikke flere penge og " +getOwner().getName()+ " får dine resterende " +playerBalanceTemp);
				getOwner().deposit(playerBalanceTemp);
			} 
			//Har spilleren nok, hæves hele beløbet
			else {
				player.withdraw(getRent());
				getOwner().deposit(getRent());
			}

			//Den nye balance for ejeren sættes her, da den ikke automatisk sættes efter endt runde.
			GUI.setBalance(getOwner().getName(), getOwner().getBalance());

		}

	}

	public int getRent() {

		return rent;

	}

}
