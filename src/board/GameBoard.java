package board;

public class GameBoard {

	private Field[] Fields;
	private int totalFields = 21;
	private int i;

	public GameBoard() {

		Field[] Fields = new Field[totalFields];

		Fields[0] = new Territory("Tribe Encampment");
		Fields[1] = new Territory("Crater");
		Fields[2] = new Territory("Mountain");
		Fields[3] = new Territory("Coldt Desert");
		Fields[4] = new Territory("Black cave");
		Fields[5] = new Territory("The Werewall");
		Fields[6] = new Territory("Mountain village");
		Fields[7] = new Territory("South Citadell");
		Fields[8] = new Territory("Palace Gates");
		Fields[9] = new Territory("Tower");
		Fields[10] = new Territory("Castle");
		Fields[11] = new Refuge("Walled City");
		Fields[12] = new Refuge("Monastery");
		Fields[13] = new LaborCamp("Huts in the mountain");
		Fields[14] = new LaborCamp("The pit");
		Fields[15] = new Tax("Goldmine");
		Fields[16] = new Tax("Caravan");
		Fields[17] = new Fleet("Second Sail");
		Fields[18] = new Fleet("Sea Grover");
		Fields[19] = new Fleet("The buccaneers");
		Fields[20] = new Fleet("Privateer Armade");

	}

	public String toString() {

		return super.toString() + Fields[i];

	}

}
