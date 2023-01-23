package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("Alice", new Money(1000000, SEK));
	}


	//testing removeTimedPayment and addTimedPayment from Account class
	@Test
	public void testAddRemoveTimedPayment() {
		testAccount.addTimedPayment("1", 5, 10, new Money(1000, SEK), SweBank, "Alice");
		assertTrue(testAccount.timedPaymentExists("1"));
		testAccount.removeTimedPayment("1");
		assertFalse(testAccount.timedPaymentExists("1"));
	}


	//Testing TimedPayments.When we are calling tick(),'next' value should decrement by 1 and when it will be 0 payment is going to proceed.
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		testAccount.addTimedPayment("1", 2, 2, new Money(1000, SEK), SweBank, "Alice");
		System.out.println(testAccount.getBalance().getAmount());
		testAccount.tick();
		testAccount.tick();
		testAccount.tick();

		assertEquals((10000000 - 1000), testAccount.getBalance().getAmount(), 0);
	}



	//testing withdraw method from Account class.Check if calculations are correct.
	@Test
	public void testAddWithdraw() {
		testAccount.withdraw(new Money(1000, SEK));
		assertEquals(10000000-1000, testAccount.getBalance().getAmount(), 0);;
	}

	//testing getBalance method from Account class. Checking if it returns correct info
	@Test
	public void testGetBalance() {
		assertTrue(new Money(10000000, SEK).equals(testAccount.getBalance()));
	}
}
