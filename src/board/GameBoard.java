package board;

public class GameBoard {

	private Field[] Fields;
	private int totalFields = 21;
	private int i;

	public GameBoard() {

		Field[] Fields = new Field[totalFields];

		Fields[0] = new Territory("Tribe Encampment", 1000, 100);
		Fields[1] = new Territory("Crater", 1500, 300);
		Fields[2] = new Territory("Mountain", 2000, 500);
		Fields[3] = new Territory("Coldt Desert", 3000, 700);
		Fields[4] = new Territory("Black cave", 4000, 1000);
		Fields[5] = new Territory("The Werewall", 4300, 1300);
		Fields[6] = new Territory("Mountain village", 4750, 1600);
		Fields[7] = new Territory("South Citadell", 5000, 2000);
		Fields[8] = new Territory("Palace Gates", 5500, 2600);
		Fields[9] = new Territory("Tower", 6000, 3200);
		Fields[10] = new Territory("Castle", 8000, 4000);
		Fields[11] = new Refuge("Walled City");
		Fields[12] = new Refuge("Monastery");
		Fields[13] = new LaborCamp("Huts in the mountain", 2500);
		Fields[14] = new LaborCamp("The pit", 2500);
		Fields[15] = new Tax("Goldmine", 1, 1);
		Fields[16] = new Tax("Caravan", 1, 1);
		Fields[17] = new Fleet("Second Sail", 4000);
		Fields[18] = new Fleet("Sea Grover", 4000);
		Fields[19] = new Fleet("The buccaneers", 4000);
		Fields[20] = new Fleet("Privateer Armade", 4000);

	}

	public String toString() {

		return super.toString() + Fields[i];

	}

}
