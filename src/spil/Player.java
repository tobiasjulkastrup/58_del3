package spil;

public class Player {

	private String playerName;
	private Account account;
	
	public void setPlayer (String name, int startSaldo) {
		playerName = name;
		account = new Account();
		account.setAccount(startSaldo);
	}
	
	public String getName() {
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
}