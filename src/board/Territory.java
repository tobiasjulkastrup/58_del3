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

		// Tjekker om owner = null. Hvis true køres if-sætningen, der tjekker om
		// spilleren har råd til at købe grunden og om han vil.
		if (getOwner() == null) {

			// Hvis playeren har kapital spørges playeren om han vil købe
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

				// playerBuyBool sættes fra false til true, hvis playeren svare
				// Ja
				playerBuyBool = playerBuyString.equals(ICO.messages
						.getString("Yes"));

				// Hvis playeren vælger ja, trækkes pengene fra playerens
				// account, han sættes som ejer af grunden og der sættes et
				// hotel på vejen, så man kan se den er købt.
				if (playerBuyBool == true) {
					player.withdraw(getPrice());
					setOwner(player);
					GUI.setHotel(fieldPlace, true);
				}
			}

		} else {

			// hvis owner /= null skal spilleren betale lejen

			// If-løkke der tjekker om playeren er ejeren
			if (player.getName().equals(getOwner().getName()) == false) {

				// laver en int playerBalanceTemp der tjekker playerens balance
				// (så der ikke kan hæves mere end han har)
				int playerBalanceTemp;
				playerBalanceTemp = player.getBalance();

				// Hvis playeren har mindre en hvad lejen er, får ejeren resten
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
				// Har spilleren nok, hæves hele beløbet
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

				// Den nye balance for ejeren sættes her, da den ikke automatisk
				// sættes efter endt runde.
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
