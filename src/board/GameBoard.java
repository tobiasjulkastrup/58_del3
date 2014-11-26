package board;

public class GameBoard {

	public Field[] fields;
	private final int TOTALFIELDS = 21;
//	private int i;

	public GameBoard() {
		fields = new Field[TOTALFIELDS];

		fields[0] = new Territory("Tribe Encampment", 1000, 100);
		fields[1] = new Territory("Crater", 1500, 300);
		fields[2] = new Territory("Mountain", 2000, 500);
		fields[3] = new Territory("Coldt Desert", 3000, 700);
		fields[4] = new Territory("Black cave", 4000, 1000);
		fields[5] = new Territory("The Werewall", 4300, 1300);
		fields[6] = new Territory("Mountain village", 4750, 1600);
		fields[7] = new Territory("South Citadell", 5000, 2000);
		fields[8] = new Territory("Palace Gates", 5500, 2600);
		fields[9] = new Territory("Tower", 6000, 3200);
		fields[10] = new Territory("Castle", 8000, 4000);
		fields[11] = new Refuge("Walled City", 5000);
		fields[12] = new Refuge("Monastery", 500);
		fields[13] = new LaborCamp("Huts in the mountain", 2500);
		fields[14] = new LaborCamp("The pit", 2500);
		fields[15] = new Tax("Goldmine", 1, 1);
		fields[16] = new Tax("Caravan", 1, 1);
		fields[17] = new Fleet("Second Sail", 4000);
		fields[18] = new Fleet("Sea Grover", 4000);
		fields[19] = new Fleet("The buccaneers", 4000);
		fields[20] = new Fleet("Privateer Armade", 4000);
	}

//	public String toString() {
//
//		return super.toString() + Fields[i];
//
//	}

}
