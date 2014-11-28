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

		// Tjekker om owner = null. Hvis true k�res if-s�tningen, der tjekker om
		// spilleren har r�d til at k�be grunden og om han vil.
		if (getOwner() == null) {

			// Hvis playeren har kapital sp�rges playeren om han vil k�be
			// arbejdslejren.
			if (player.getBalance() >= getPrice()) {
				String playerBuyString;
				boolean playerBuyBool = false;

				playerBuyString = GUI.getUserButtonPressed(
						ICO.messages.getString("LaborCamp")
						+ getName() + ICO.messages.getString("youArrivedTo") + getPrice() + " " + ICO.messages.getString("valuta") + ICO.messages.getString("doYouWantToBuy"),
						ICO.messages.getString("Yes"),
						ICO.messages.getString("No"));

				// playerBuyBool s�ttes fra false til true, hvis playeren svare
				// Ja
				playerBuyBool = playerBuyString.equals(ICO.messages.getString("Yes"));

				// Hvis playeren v�lger ja, tr�kkes pengene fra playerens
				// account, han s�ttes som ejer af grunden og der s�ttes et
				// hotel p� vejen, s� man kan se den er k�bt.
				if (playerBuyBool == true) {
					player.withdraw(getPrice());
					setOwner(player);
					GUI.setHouses(fieldPlace, 3);
				}
			}

		} else {

			// hvis owner /= null skal spilleren betale lejen

			// If-l�kke der tjekker om playeren er ejeren
			if (player.getName().equals(getOwner().getName()) == false) {

				int totalDicePrice = (DICEPRICE * gameController.diceCup.getTotalDiceCup());

				// laver en int playerBalanceTemp der tjekker playerens balance
				// (s� der ikke kan h�ves mere end han har)
				int playerBalanceTemp;
				playerBalanceTemp = player.getBalance();

				// Hvis playeren har mindre en hvad arbejdslejer gebyret er, f�r
				// ejeren resten af spillerens penge.
				if (playerBalanceTemp < totalDicePrice) {
					player.withdraw(playerBalanceTemp);
					GUI.showMessage(player.getName() + ICO.messages.getString("noMoreMoney") +getOwner().getName()+ " "+ICO.messages.getString("getsYourLast") +playerBalanceTemp);
				}
				// Har spilleren nok, h�ves hele bel�bet
				else {
					player.withdraw(totalDicePrice);
					payOwner(totalDicePrice);
					GUI.showMessage(player.getName() + ICO.messages.getString("youLandedOn") + owner.getName() + ICO.messages.getString("ownersCampAndThrew") + gameController.diceCup.getTotalDiceCup() + " " + ICO.messages.getString("eyesAndHaveToPay")+totalDicePrice);
				}

				// Den nye balance for ejeren s�ttes her, da den ikke automatisk
				// s�ttes efter endt runde.
				GUI.setBalance(getOwner().getName(), getOwner().getBalance());

			} else
				GUI.showMessage(player.getName()+ICO.messages.getString("youOwnFleet"));

		}

	}

}
