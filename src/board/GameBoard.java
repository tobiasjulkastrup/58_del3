package board;

public class GameBoard {

	public Field[] fields;
	private final int TOTALFIELDS = 22;

	public GameBoard() {
		fields = new Field[TOTALFIELDS];

		fields[1] = new Territory("Tribe Encampment", 1000, 100, 1);
		fields[2] = new Territory("Crater", 1500, 300, 2);
		fields[3] = new Territory("Mountain", 2000, 500, 3);
		fields[4] = new Territory("Coldt Desert", 3000, 700, 4);
		fields[5] = new Territory("Black cave", 4000, 1000, 5);
		fields[6] = new Territory("The Werewall", 4300, 1300, 6);
		fields[7] = new Territory("Mountain village", 4750, 1600, 7);
		fields[8] = new Territory("South Citadell", 5000, 2000, 8);
		fields[9] = new Territory("Palace Gates", 5500, 2600, 9);
		fields[10] = new Territory("Tower", 6000, 3200, 10);
		fields[11] = new Territory("Castle", 8000, 4000, 11);
		fields[12] = new Refuge("Walled City", 5000);
		fields[13] = new Refuge("Monastery", 500);
		fields[14] = new LaborCamp("Huts in the mountain", 2500);
		fields[15] = new LaborCamp("The pit", 2500);
		fields[16] = new Tax("Goldmine", 1, 1);
		fields[17] = new Tax("Caravan", 1, 1);
		fields[18] = new Fleet("Second Sail", 4000);
		fields[19] = new Fleet("Sea Grover", 4000);
		fields[20] = new Fleet("The buccaneers", 4000);
		fields[21] = new Fleet("Privateer Armade", 4000);
	}

}
