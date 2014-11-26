package board;

import boundaryToMatador.GUI;
import spil.Player;

public class Refuge extends Field {

public Refuge(String name, int bonus) {
		super(name);
	
	}

private int bonus;

@Override
public void landOnField(Player player) {
	
	
	
	
	player.deposit(bonus);
	GUI.showMessage("Du er landet på feltet " + getName() + "og modtager " + bonus );
}
	
}
