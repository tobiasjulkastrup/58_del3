package spil;

import java.awt.Color;

public class Player {

	private String playerName;
	private Account account;
	private Color playerColor;
	private int playerPosition;
	
	
	public void setPlayer (String name, int startSaldo, Color playerColorFromGUI ){
		playerName = name;
		playerColor = playerColorFromGUI;
		//playerPosition=position; 
		account = new Account();
		account.setAccount(startSaldo);
	}
	
	public String getName(){
		return playerName;
	}
	
	public int getBalance(){
		return account.getBalance();
	}
	
	public int withdraw(int price){
		return account.withdraw(price);
	}
	
	public int deposit(int price){
		return account.deposit(price);
	}
	
	public Color getColor(){
		return playerColor;
	}
	
	public void setPosition(int newPlayerPosition){
		playerPosition = newPlayerPosition;
	}
	
	public int getPosition(){
		return playerPosition;
	}
	
}