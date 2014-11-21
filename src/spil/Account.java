package spil;


import java.text.NumberFormat;


public class Account {
	private NumberFormat fmt = NumberFormat.getCurrencyInstance();
	private int balance;
	private long acctNumber;
	
	
	public Account(int initial, Long account){
		
		acctNumber = account;
		balance = initial; 
	}
	

 public int deposit (int price)
{

	balance = balance + price;

	return balance;
}

//-----------------------------------------------------------------
//  Validates the transaction, then withdraws the specified amount
//  from the account. Returns the new balance.
//-----------------------------------------------------------------
 
 public int withdraw (int price)
{
	if ((price + balance) < 0)  // withdraw value exceeds balance
	{
		balance=0;
	}
	else
		balance = balance + price;

	return balance;
}

 public int getBalance ()
{
	return balance;
}

//-----------------------------------------------------------------
//  Returns the account number.
//-----------------------------------------------------------------
public long getAccountNumber ()
{
	return acctNumber;
}

//-----------------------------------------------------------------
//  Returns a one-line description of the account as a string.
//-----------------------------------------------------------------
public String toString ()
{
	return (acctNumber + "\t"+ fmt.format(balance));
}
}

