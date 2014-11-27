package board;

import spil.Player;

public abstract class Ownable extends Field {

	private int price;
	protected Player owner;

	public Ownable(String name, int price) {
		super(name);
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setOwner(Player owner){
		this.owner = owner;
	}

	public Player getOwner(){
		return owner;
	}
	
	protected boolean checkForCapital(Player player){
		// Tjekker om spilleren har r�d til at k�be en k�bbar plads p� br�ttet.
		boolean hasMoneyEnough = false;
		
		//Hvis playeren har pengene som en grund koster �ndres hasMoneyEnough til true.
		if (player.getBalance() <= getPrice())
			hasMoneyEnough = true;
		
		// hasMoneyEnough returnes true hvis der er penge og false hvis der ikke er.
		return hasMoneyEnough;
	}
}
