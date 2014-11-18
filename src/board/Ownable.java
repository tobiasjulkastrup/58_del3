package board;

import spil.Player;

public class Ownable extends Field {

	public Ownable(String name) {
		super(name);

	}

	private int price;
	private Player owner;

	public int getRent() {
		return price;
	}

	@Override
	public void landOnField(Player player) {

	}

}
