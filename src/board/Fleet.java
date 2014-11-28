package board;

import boundaryToMatador.GUI;
import spil.Player;

public class Fleet extends Ownable {

	private int RENT_1 = 500;
	private int RENT_2 = 1000;
	private int RENT_3 = 2000;
	private int RENT_4 = 4000;
	private int fieldPlace;
	private int fleetNumb;
	private GameBoard gameBoard;

	public Fleet(String name, int price, int fieldPlace, int fleetNumb, GameBoard gameBoard) {

		super(name, price);
		this.fieldPlace = fieldPlace+1;
		this.fleetNumb = fleetNumb;
		this.gameBoard = gameBoard;

	}

	@Override
	public void landOnField(Player player) {

		if (owner == null) {

			//Hvis playeren har kapital spørges playeren om han vil købe grunden.
			if (player.getBalance() >= getPrice()){
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
					GUI.setHouses(fieldPlace, 1);
					
				}
			}
		} else {
				
				//If-løkke der tjekker om playeren er ejeren
				if (player.getName().equals(getOwner().getName()) == false) {
					int totalPay = 0;
					int checkedFleetNumb=fieldPlace-1;
					int ownersTotalFleets = 1;
					
					for (int i = 0; i < 3; i++) {
						if (checkedFleetNumb == 21)
							checkedFleetNumb = 18;
						else
							checkedFleetNumb++;
						
						boolean ownerOwnsFleet = false;
						
						if (null != ((Fleet)gameBoard.fields[checkedFleetNumb]).getOwner()){
							ownerOwnsFleet = ((Fleet)gameBoard.fields[checkedFleetNumb]).getOwner().getName().equals(getOwner().getName());
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

					//Hvis playeren har mindre en hvad der skal betales, får ejeren resten af spillerens penge.
					if (playerBalanceTemp < totalPay){
						player.withdraw(playerBalanceTemp);
						GUI.showMessage(player.getName() + "du har ikke flere penge og " +getOwner().getName()+ " får dine resterende " +playerBalanceTemp);
						payOwner(playerBalanceTemp);
					} 
					//Har spilleren nok, hæves hele beløbet
					else {
						player.withdraw(totalPay);
						payOwner(totalPay);
						GUI.showMessage(player.getName()+", du er landet på "+owner.getName()+"'s felt, som totalt ejer "+ownersTotalFleets+" flåder og du skal derfor betale "+totalPay);
					}

					//Den nye balance for ejeren sættes her, da den ikke automatisk sættes efter endt runde.
					GUI.setBalance(getOwner().getName(), getOwner().getBalance());
					
				} else
					GUI.showMessage(player.getName()+", du er stoppet ved din egen flåde");
				
			}

		}

	}