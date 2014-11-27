package board;

import spil.Player;

public abstract class Field {

	private String name;

	public abstract void landOnField(Player player);

	public Field(String name) {

		this.name = name;

	}

	public String getName(){

		return name;

	}

}
