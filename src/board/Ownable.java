package board;

import spil.Player;

public abstract class Ownable extends Field {

	private int price;
	private Player owner;
	
	public Ownable(String name, int price) {
		super(name);
		this.price = price;

	}

	public abstract int getRent();

	@Override
	public void landOnField(Player player) {
		
		// skal tjekke om owner = null
		
		if (owner == null) {
			
			// hvis owner = null skal spilleren skal vælge om han/hun vil købe feltet
			
			
			
		}
		
		else {
			
			// hvis owner /= null skal spilleren betale lejen
			
			player.getBalance();
			player.withdraw(getRent());
			
			
		}
		

	

	}
	
	public int getPrice(){
		return price;
	}
}
