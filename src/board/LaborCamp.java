package board;

import spil.Player;

public class LaborCamp extends Ownable  {
	
	private int fieldPlace;
	
	public LaborCamp(String name, int price, int fieldPlace) {
		
		super(name, price);
		this.fieldPlace = fieldPlace+1;

	}

	@Override
	public void landOnField(Player player) {

		
	}

}
