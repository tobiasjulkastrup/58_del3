package board;

import boundaryToMatador.GUI;
import spil.Player;
import spil.ICO;

public class Fleet extends Ownable {

	private int RENT_1 = 500;
	private int RENT_2 = 1000;
	private int RENT_3 = 2000;
	private int RENT_4 = 4000;
	private int fieldPlace;
	private GameBoard gameBoard;

	public Fleet(String name, int price, int fieldPlace, GameBoard gameBoard) {

		super(name, price);
		this.fieldPlace = fieldPlace + 1;
		this.gameBoard = gameBoard;

	}

	@Override
	public void landOnField(Player player) {

		if (owner == null) {

			// Hvis playeren har kapital sp�rges playeren om han vil k�be
			// grunden.
			if (player.getBalance() >= getPrice()) {
				String playerBuyString;
				boolean playerBuyBool = false;

				playerBuyString = GUI.getUserButtonPressed(
						player.getName()
						+ ICO.messages.getString("theFleet") + getName()
						+ ICO.messages.getString("fleetIsForSale")
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
					GUI.setHouses(fieldPlace, 1);

				}
			}
		} else {

			// If-l�kke der tjekker om playeren er ejeren
			if (player.getName().equals(getOwner().getName()) == false) {
				int totalPay = 0;
				int checkedFleetNumb = fieldPlace - 1;
				int ownersTotalFleets = 1;

				for (int i = 0; i < 3; i++) {
					if (checkedFleetNumb == 21)
						checkedFleetNumb = 18;
					else
						checkedFleetNumb++;

					boolean ownerOwnsFleet = false;

					if (null != ((Fleet) gameBoard.fields[checkedFleetNumb])
							.getOwner()) {
						ownerOwnsFleet = ((Fleet) gameBoard.fields[checkedFleetNumb])
								.getOwner().getName()
								.equals(getOwner().getName());
					}

					if (ownerOwnsFleet == true)
						ownersTotalFleets++;
				}

				if (ownersTotalFleets == 1)
					totalPay = RENT_1;
				else if (ownersTotalFleets == 2)
					totalPay = RENT_2;
				else if (ownersTotalFleets == 3)
					totalPay = RENT_3;
				else if (ownersTotalFleets == 4)
					totalPay = RENT_4;

				int playerBalanceTemp;
				playerBalanceTemp = player.getBalance();

				// Hvis playeren har mindre en hvad der skal betales, f�r ejeren
				// resten af spillerens penge.
				if (playerBalanceTemp < totalPay) {
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
					player.withdraw(totalPay);
					payOwner(totalPay);
					GUI.showMessage(
							player.getName()
							+ ICO.messages.getString("youLandedOn")
							+ owner.getName()
							+ ICO.messages.getString("ownersFieldWhoOwns")
							+ ownersTotalFleets + " "
							+ ICO.messages.getString("ownersFieldWhoOwns")
							+ totalPay);
				}

				// Den nye balance for ejeren s�ttes her, da den ikke automatisk
				// s�ttes efter endt runde.
				GUI.setBalance(getOwner().getName(), getOwner().getBalance());

			} else
				GUI.showMessage(player.getName()
						+ ICO.messages.getString("yourOwnFleet"));

		}

	}

}