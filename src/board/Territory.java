package board;

import spil.Player;

public class Territory extends Ownable {

	private int rent;

	public Territory(String name, int price, int rent) {

		super(name, price);
		this.rent = rent;

	}
	
	@Override
	public void landOnField(Player player) {

		// skal tjekke om owner = null
		if (owner == null) {

			// hvis owner = null skal spilleren skal vælge om han/hun vil købe feltet
			player.withdraw(getPrice());

		} else {

			// hvis owner /= null skal spilleren betale lejen
			player.getBalance();
			player.withdraw(getRent());

		}
		
	}
	
	public int getRent() {
		
		return rent;
		
	}

}
