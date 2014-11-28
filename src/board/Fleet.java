package board;

import boundaryToMatador.GUI;
import spil.Player;
import spil.GameController;
import board.FleetOwner;

public class Fleet extends Ownable {

	private int RENT_1 = 500;
	private int RENT_2 = 1000;
	private int RENT_3 = 2000;
	private int RENT_4 = 4000;
	private int fieldPlace;
	private int fleetNumb;

	public Fleet(String name, int price, int fieldPlace, int fleetNumb) {

		super(name, price);
		this.fieldPlace = fieldPlace+1;
		this.fleetNumb = fleetNumb;

	}

	@Override
	public void landOnField(Player player) {

		if (owner == null) {
			// Boolean der s�ttes til false og �ndres til true hvis playeren har kapital til at k�be grunden
			boolean capitalAvaliable = false;
			capitalAvaliable = checkForCapital(player);

			//Hvis playeren har kapital sp�rges playeren om han vil k�be grunden.
			if (capitalAvaliable = true){
				String playerBuyString;
				boolean playerBuyBool = false;

				playerBuyString = GUI.getUserButtonPressed(
						"Fl�den '" +getName()+ "', som du st�r ved er til salg for: " +getPrice()+ " " + "kr. " + "Vil du k�be den?", 
						"Ja", 
						"Nej"
						);

				//playerBuyBool s�ttes fra false til true, hvis playeren svare Ja
				playerBuyBool = playerBuyString.equals("Ja");

				//Hvis playeren v�lger ja, tr�kkes pengene fra playerens account, han s�ttes som ejer af grunden og der s�ttes et hotel p� vejen, s� man kan se den er k�bt.
				if (playerBuyBool == true){
					player.withdraw(getPrice());
					setOwner(player);
					GUI.setHouses(fieldPlace+1, 1);
					FleetOwner.this.setFleetOwner(fleetNumb, player.getName());
					
				}
			} else {
				
				int totalPay = 0;
				int checkedFleetNumb=fleetNumb;
				int ownersTotalFleets = 1;
				
				for (int i = 0; i < 3; i++) {
					if (checkedFleetNumb == 4)
						checkedFleetNumb = 1;
					else
						checkedFleetNumb++;
					
					boolean ownerOwnsFleet = false;
					String checkedFleetOwner;
					ownerOwnsFleet = FleetOwner.this.getFleetOwner(checkedFleetNumb).equals(getOwner());
					
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

				//Hvis playeren har mindre en hvad der skal betales, f�r ejeren resten af spillerens penge.
				if (playerBalanceTemp < totalPay){
					player.withdraw(playerBalanceTemp);
					GUI.showMessage(player.getName() + "du har ikke flere penge og " +getOwner().getName()+ " f�r dine resterende " +playerBalanceTemp);
					getOwner().deposit(playerBalanceTemp);
				} 
				//Har spilleren nok, h�ves hele bel�bet
				else {
					player.withdraw(totalPay);
					getOwner().deposit(totalPay);
				}

				//Den nye balance for ejeren s�ttes her, da den ikke automatisk s�ttes efter endt runde.
				GUI.setBalance(getOwner().getName(), getOwner().getBalance());
			}

		}

	}

}