package board;

import boundaryToMatador.GUI;
import spil.Player;

public class Refuge extends Field {
	
	private int bonus;

	public Refuge(String name, int bonus) {

		super(name);
		this.bonus = bonus;

	}

	@Override
	public void landOnField(Player player) {

		player.deposit(bonus);
		GUI.showMessage("Du er landet p� feltet " + getName() + "og modtager " + bonus );
		
	}

}
