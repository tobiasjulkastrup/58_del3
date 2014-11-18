package board;

public class GameBoard {

	private field[] fields;
	private int totalFields;
	private int i;

	public GameBoard() {

		field[] fields = new field[21];

		fields[0] = new field("Tribe Encampment", 1000);
		fields[1] = new field("Crater", 1500);
		fields[2] = new field("Mountain", 2000);
		fields[3] = new field("Coldt Desert", 3000);
		fields[4] = new field("Black cave", 4000);
		fields[5] = new field("The Werewall", 4300);
		fields[6] = new field("Mountain village", 4750);
		fields[7] = new field("South Citadell", 5000);
		fields[8] = new field("Palace Gates", 5500);
		fields[9] = new field("Tower", 6000);
		fields[10] = new field("Castle", 8000);
		fields[11] = new field("Walled City", 5000);
		fields[12] = new field("Monastery", 500);
		fields[13] = new field("Huts in the mountain", 2500);
		fields[14] = new field("The pit", 2500);
		fields[15] = new field("Goldmine", 000);
		fields[16] = new field("Caravan", 4000);
		fields[17] = new field("Second Sail", 4000);
		fields[18] = new field("Sea Grover", 4000);
		fields[19] = new field("The buccaneers", 4000);
		fields[20] = new field("Privateer Armade", 4000);

	}

	public String toString() {

		return super.toString() + fields[i];

	}

}
