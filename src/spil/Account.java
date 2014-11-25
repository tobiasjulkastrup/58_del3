package spil;

public class Account {
	
	private int balance;
	
	public void setAccount(int initial){
		balance = initial; 
	}
	
	public int deposit (int price){
		balance = balance + price;
		return balance;
	}

	 public int withdraw (int price){
		if ((price + balance) < 0){  // withdraw value exceeds balance
			balance=0;
		} else
			balance = balance + price;
		return balance;
	 }

	public int getBalance (){
		return balance;
	}

}

