package board;

import spil.GameController;
import spil.ICO;

public class GameBoard {

	public Field[] fields;
	private final int TOTALFIELDS = 22;

	public GameBoard(GameController gameController) {
		
		fields = new Field[TOTALFIELDS];
		
		//fields[0] er tom da det er Starts plads på brættet
		fields[1] = new Territory(ICO.messages.getString("TribeEncampment"), 1000, 100, 1);
		fields[2] = new Territory(ICO.messages.getString("Crater"), 1500, 300, 2);
		fields[3] = new Territory(ICO.messages.getString("Mountain"), 2000, 500, 3);
		fields[4] = new Territory(ICO.messages.getString("ColdDesert"), 3000, 700, 4);
		fields[5] = new Territory(ICO.messages.getString("BlackCave"), 4000, 1000, 5);
		fields[6] = new Territory(ICO.messages.getString("TheWerewall"), 4300, 1300, 6);
		fields[7] = new Territory(ICO.messages.getString("MountainVillage"), 4750, 1600, 7);
		fields[8] = new Territory(ICO.messages.getString("SouthCitadell"), 5000, 2000, 8);
		fields[9] = new Territory(ICO.messages.getString("PalaceGates"), 5500, 2600, 9);
		fields[10] = new Territory(ICO.messages.getString("Tower"), 6000, 3200, 10);
		fields[11] = new Territory(ICO.messages.getString("Castle"), 8000, 4000, 11);
		fields[12] = new Refuge(ICO.messages.getString("WalledCity"), 5000);
		fields[13] = new Refuge(ICO.messages.getString("Monastery"), 500);
		fields[14] = new LaborCamp(ICO.messages.getString("HutsInTheMountain"), 2500, 14, gameController);
		fields[15] = new LaborCamp(ICO.messages.getString("ThePit"), 2500, 15, gameController);
		fields[16] = new Tax(ICO.messages.getString("Goldmine"), 5000, -1);
		fields[17] = new Tax(ICO.messages.getString("Caravan"), 500, 10);
		fields[18] = new Fleet(ICO.messages.getString("SecondSail"), 4000, 18, this);
		fields[19] = new Fleet(ICO.messages.getString("SeaGrover"), 4000, 19, this);
		fields[20] = new Fleet(ICO.messages.getString("TheBuccaneers"), 4000, 20, this);
		fields[21] = new Fleet(ICO.messages.getString("PrivateerArmade"), 4000,	21, this);
	}

}
