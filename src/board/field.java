package board;
import spil.Player;

public abstract class field {

	private String name;
	public abstract void landOnField(Player player);

	public field(String name) {

		this.name = name;

	}

}
