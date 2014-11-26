package board;

import spil.Player;

public class Fleet extends Ownable {

	private int RENT_1 = 500;
	private int RENT_2 = 1000;
	private int RENT_3 = 2000;
	private int RENT_4 = 4000;

	public Fleet(String name, int price) {
		
		super(name, price);
		
	}
	
	@Override
	public void landOnField(Player player) {
		
		
		
	}

	public int getRent() {
		// TODO Auto-generated method stub
		return 0;
	}

}
