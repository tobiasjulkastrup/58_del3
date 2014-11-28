package test;

import static org.junit.Assert.*;


import org.junit.Test;

import spil.Account;

public class AccountTest {


	//
	@Test

	public void testDeposit() {

		// preconditions

		// sætter balancen til 1000
		Account account;
		account = new Account();
		account.setAccount(1000);

		// test
		account.deposit(500);
		// postcondition
		assertEquals(1500, account.getBalance());
	}

	@Test
	public void testWithdraw() {
		// preconditions

		// sætter balancen til 1000
		Account account;
		account = new Account();
		account.setAccount(1000);

		// test
		account.withdraw(500);
		// postcondition
		assertEquals(500, account.getBalance());

	}
}

