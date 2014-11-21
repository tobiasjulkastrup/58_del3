package spil;

public class Player {

	int totalPlayers;
	
	public void totalPlayers(int numberOfPlayers){
		totalPlayers = numberOfPlayers;
	}
	
	public String newPlayer (String name) {
		String[] PlayerName = new String[totalPlayers];	
		for (int i=0; i<=totalPlayers; i++){		
			PlayerName[i] = name;
			}		
			return PlayerName.toString(); //returnerer string
	}
}