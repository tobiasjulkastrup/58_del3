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
			// Boolean der sættes til false og ændres til true hvis playeren har kapital til at købe grunden
			boolean capitalAvaliable = false;
			capitalAvaliable = checkForCapital(player);

			//Hvis playeren har kapital spørges playeren om han vil købe grunden.
			if (capitalAvaliable = true){
				String playerBuyString;
				boolean playerBuyBool = false;

				playerBuyString = GUI.getUserButtonPressed(
						"Flåden '" +getName()+ "', som du står ved er til salg for: " +getPrice()+ " " + "kr. " + "Vil du købe den?", 
						"Ja", 
						"Nej"
						);

				//playerBuyBool sættes fra false til true, hvis playeren svare Ja
				playerBuyBool = playerBuyString.equals("Ja");

				//Hvis playeren vælger ja, trækkes pengene fra playerens account, han sættes som ejer af grunden og der sættes et hotel på vejen, så man kan se den er købt.
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

				//Hvis playeren har mindre en hvad der skal betales, får ejeren resten af spillerens penge.
				if (playerBalanceTemp < totalPay){
					player.withdraw(playerBalanceTemp);
					GUI.showMessage(player.getName() + "du har ikke flere penge og " +getOwner().getName()+ " får dine resterende " +playerBalanceTemp);
					getOwner().deposit(playerBalanceTemp);
				} 
				//Har spilleren nok, hæves hele beløbet
				else {
					player.withdraw(totalPay);
					getOwner().deposit(totalPay);
				}

				//Den nye balance for ejeren sættes her, da den ikke automatisk sættes efter endt runde.
				GUI.setBalance(getOwner().getName(), getOwner().getBalance());
			}

		}

	}

}