package board;

import boundaryToMatador.GUI;
import spil.ICO;
import spil.Player;

public class Territory extends Ownable {

	private int rent;
	private int fieldPlace;

	public Territory(String name, int price, int rent, int fieldPlace) {

		super(name, price);
		this.rent = rent;
		this.fieldPlace = fieldPlace + 1;

	}

	@Override
	public void landOnField(Player player) {

		// Tjekker om owner = null. Hvis true k�res if-s�tningen, der tjekker om
		// spilleren har r�d til at k�be grunden og om han vil.
		if (getOwner() == null) {

			// Hvis playeren har kapital sp�rges playeren om han vil k�be
			// grunden.
			if (player.getBalance() >= getPrice()) {
				String playerBuyString;
				boolean playerBuyBool = false;

				playerBuyString = GUI.getUserButtonPressed(
						player.getName() +
						ICO.messages.getString("theRoad") + getName()
						+ ICO.messages.getString("roadForSale")
						+ getPrice() + " "
						+ ICO.messages.getString("valuta")
						+ ICO.messages.getString("doYouWantToBuy"),
						ICO.messages.getString("Yes"),
						ICO.messages.getString("No"));

				// playerBuyBool s�ttes fra false til true, hvis playeren svare
				// Ja
				playerBuyBool = playerBuyString.equals(ICO.messages
						.getString("Yes"));

				// Hvis playeren v�lger ja, tr�kkes pengene fra playerens
				// account, han s�ttes som ejer af grunden og der s�ttes et
				// hotel p� vejen, s� man kan se den er k�bt.
				if (playerBuyBool == true) {
					player.withdraw(getPrice());
					setOwner(player);
					GUI.setHotel(fieldPlace, true);
				}
			}

		} else {

			// hvis owner /= null skal spilleren betale lejen

			// If-l�kke der tjekker om playeren er ejeren
			if (player.getName().equals(getOwner().getName()) == false) {

				// laver en int playerBalanceTemp der tjekker playerens balance
				// (s� der ikke kan h�ves mere end han har)
				int playerBalanceTemp;
				playerBalanceTemp = player.getBalance();

				// Hvis playeren har mindre en hvad lejen er, f�r ejeren resten
				// af spillerens penge.
				if (playerBalanceTemp < getRent()) {
					player.withdraw(playerBalanceTemp);
					GUI.showMessage(player.getName()
							+ ICO.messages.getString("noMoreMoney")
							+ getOwner().getName() + " "
							+ ICO.messages.getString("getsYourLast")
							+ playerBalanceTemp);
					payOwner(playerBalanceTemp);
				}
				// Har spilleren nok, h�ves hele bel�bet
				else {
					player.withdraw(getRent());
					GUI.showMessage(player.getName()
							+ ICO.messages.getString("youLandedOn")
							+ owner.getName()
							+ ICO.messages.getString("ownersTerritory")
							+ getName()
							+ ICO.messages.getString("andHaveToPay")
							+ getRent());
					payOwner(getRent());
				}

				// Den nye balance for ejeren s�ttes her, da den ikke automatisk
				// s�ttes efter endt runde.
				GUI.setBalance(getOwner().getName(), getOwner().getBalance());

			} else
				GUI.showMessage(player.getName()
						+ ICO.messages.getString("yourOwnTerritory"));
		}

	}

	public int getRent() {

		return rent;

	}

}
