package board;

import boundaryToMatador.GUI;
import spil.Player;
import spil.GameController;
import spil.ICO;

public class LaborCamp extends Ownable {

	private int fieldPlace;
	private final int DICEPRICE = 100;
	private GameController gameController;

	public LaborCamp(String name, int price, int fieldPlace,
			GameController gameController) {

		super(name, price);
		this.fieldPlace = fieldPlace + 1;
		this.gameController = gameController;

	}

	@Override
	public void landOnField(Player player) {

		// Tjekker om owner = null. Hvis true køres if-sætningen, der tjekker om
		// spilleren har råd til at købe grunden og om han vil.
		if (getOwner() == null) {

			// Hvis playeren har kapital spørges playeren om han vil købe
			// arbejdslejren.
			if (player.getBalance() >= getPrice()) {
				String playerBuyString;
				boolean playerBuyBool = false;

				playerBuyString = GUI.getUserButtonPressed(
						ICO.messages.getString("LaborCamp")
						+ getName() + ICO.messages.getString("youArrivedTo") + getPrice() + " " + ICO.messages.getString("valuta") + ICO.messages.getString("doYouWantToBuy"),
						ICO.messages.getString("Yes"),
						ICO.messages.getString("No"));

				// playerBuyBool sættes fra false til true, hvis playeren svare
				// Ja
				playerBuyBool = playerBuyString.equals(ICO.messages.getString("Yes"));

				// Hvis playeren vælger ja, trækkes pengene fra playerens
				// account, han sættes som ejer af grunden og der sættes et
				// hotel på vejen, så man kan se den er købt.
				if (playerBuyBool == true) {
					player.withdraw(getPrice());
					setOwner(player);
					GUI.setHouses(fieldPlace, 3);
				}
			}

		} else {

			// hvis owner /= null skal spilleren betale lejen

			// If-løkke der tjekker om playeren er ejeren
			if (player.getName().equals(getOwner().getName()) == false) {

				int totalDicePrice = (DICEPRICE * gameController.diceCup.getTotalDiceCup());

				// laver en int playerBalanceTemp der tjekker playerens balance
				// (så der ikke kan hæves mere end han har)
				int playerBalanceTemp;
				playerBalanceTemp = player.getBalance();

				// Hvis playeren har mindre en hvad arbejdslejer gebyret er, får
				// ejeren resten af spillerens penge.
				if (playerBalanceTemp < totalDicePrice) {
					player.withdraw(playerBalanceTemp);
					GUI.showMessage(player.getName() + ICO.messages.getString("noMoreMoney") +getOwner().getName()+ " "+ICO.messages.getString("getsYourLast") +playerBalanceTemp);
				}
				// Har spilleren nok, hæves hele beløbet
				else {
					player.withdraw(totalDicePrice);
					payOwner(totalDicePrice);
					GUI.showMessage(player.getName() + ICO.messages.getString("youLandedOn") + owner.getName() + ICO.messages.getString("ownersCampAndThrew") + gameController.diceCup.getTotalDiceCup() + " " + ICO.messages.getString("eyesAndHaveToPay")+totalDicePrice);
				}

				// Den nye balance for ejeren sættes her, da den ikke automatisk
				// sættes efter endt runde.
				GUI.setBalance(getOwner().getName(), getOwner().getBalance());

			} else
				GUI.showMessage(player.getName()+ICO.messages.getString("youOwnFleet"));

		}

	}

}
