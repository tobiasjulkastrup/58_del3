package board;

import boundaryToMatador.GUI;
import spil.Player;

public class LaborCamp extends Ownable  {
	
	private int fieldPlace;
	@SuppressWarnings("unused")
	private final int DICEPRICE = 100;
	
	public LaborCamp(String name, int price, int fieldPlace) {
		
		super(name, price);
		this.fieldPlace = fieldPlace+1;

	}

	@Override
	public void landOnField(Player player) {

		// Tjekker om owner = null. Hvis true køres if-sætningen, der tjekker om spilleren har råd til at købe grunden og om han vil.
		if (owner == null) {

			//Hvis playeren har kapital spørges playeren om han vil købe arbejdslejren.
			if (player.getBalance() >= getPrice()){
				String playerBuyString;
				boolean playerBuyBool = false;

				playerBuyString = GUI.getUserButtonPressed(
						"Arbejdslejren '" +getName()+ "', som du er ankommet til, er til salg for: " +getPrice()+ " " + "kr. " + "Vil du købe den?", 
						"Ja", 
						"Nej"
						);

				//playerBuyBool sættes fra false til true, hvis playeren svare Ja
				playerBuyBool = playerBuyString.equals("Ja");

				//Hvis playeren vælger ja, trækkes pengene fra playerens account, han sættes som ejer af grunden og der sættes et hotel på vejen, så man kan se den er købt.
				if (playerBuyBool == true){
					player.withdraw(getPrice());
					setOwner(player);
					GUI.setHouses(fieldPlace, 3);
				}
			}


		} else {

			// hvis owner /= null skal spilleren betale lejen

			//If-løkke der tjekker om playeren er ejeren
			if (player.getName().equals(getOwner().getName()) == false) {
				
				int totalDicePrice = 100;
//				int totalDicePrice = DICEPRICE * 
				
				//laver en int playerBalanceTemp der tjekker playerens balance (så der ikke kan hæves mere end han har)
				int playerBalanceTemp;
				playerBalanceTemp = player.getBalance();

				//Hvis playeren har mindre en hvad arbejdslejer gebyret er, får ejeren resten af spillerens penge.
				if (playerBalanceTemp < totalDicePrice){
					player.withdraw(playerBalanceTemp);
					GUI.showMessage(player.getName() + "du har ikke flere penge og " +getOwner().getName()+ " får dine resterende " +playerBalanceTemp);
					payOwner(playerBalanceTemp);
				} 
				//Har spilleren nok, hæves hele beløbet
				else {
					player.withdraw(totalDicePrice);
					payOwner(totalDicePrice);
				}

				//Den nye balance for ejeren sættes her, da den ikke automatisk sættes efter endt runde.
				GUI.setBalance(getOwner().getName(), getOwner().getBalance());
				
			}
		
		}

	}

}
