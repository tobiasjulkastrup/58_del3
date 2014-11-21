package spil;

public class Player {
	java.util.Scanner input = new java.util.Scanner(System.in);
	int totalPlayers;
	public void totalPlayers(int numberOfPlayers){
		totalPlayers=numberOfPlayers;
	}
	
	public String newPlayer (String name) {
		String[] PlayerName = new String[totalPlayers];	
		for (int i=0; i<=totalPlayers; i++){
			System.out.println("spiller"+(i+1)+" indtast navn");
			
			PlayerName[i]=input.nextLine();
			}		
			return PlayerName.toString(); //returnerer string
	}
}