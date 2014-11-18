package spil;

public class Dice {
	public int dice1, dice2, roll;

	// Opretter terninger	
	public void setDice(){
		int eyes = 6;
		dice1 = (int) ((Math.random() * (eyes)) + 1);     // 0-1
		dice2 = (int) ((Math.random() * (eyes)) + 1);     // 0-1					
	}

	public int getDice(){
		
		roll = dice1 + dice2;
		System.out.println(Game.messages.getString("duslog")+dice1+" "+Game.messages.getString("og")+dice2);	
		return roll;
	}
}
