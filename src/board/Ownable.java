package board;

import boundaryToMatador.GUI;
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
		// Tjekker om spilleren har råd til at købe en købbar plads på brættet.
		boolean hasMoneyEnough = false;
		
		//Hvis playeren har pengene som en grund koster ændres hasMoneyEnough til true.
		if (player.getBalance() <= getPrice())
			hasMoneyEnough = true;
		
		// hasMoneyEnough returnes true hvis der er penge og false hvis der ikke er.
		return hasMoneyEnough;
	}
	protected void payOwner(int owed){
		
		if (getOwner().getBalance() > 0){
			getOwner().deposit(owed);
		}
		else
			GUI.showMessage("Da ejeren (" +getOwner().getName()+ ") er gået konkurs, går dine penge i stedet til en heldig minister's tegnebog");
			
	}
}
