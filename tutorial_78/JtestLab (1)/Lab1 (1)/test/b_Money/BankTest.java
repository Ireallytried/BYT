package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	//testing getName from Bank class. Should return correct name.
	@Test
	public void testGetName() {
		assertEquals("SweBank", SweBank.getName());
	}

	//testing getCurrency from Bank class. Should return correct currency.
	@Test
	public void testGetCurrency() {
		assertEquals(SEK, SweBank.getCurrency());
	}

	// before fixing failed because of AccountDoesNotExistException
	//testing openAccount method from Bank class. Trying to open an account and later on check if it exists.
	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		Nordea.openAccount("Alex");
		assertNotNull(Nordea.getBalance("Alex"));
	}


	// before fixing failed because of AccountDoesNotExistException
	//testing deposit method from Bank class. Checking if amount of Money is as supposed to be for certain user
	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		SweBank.deposit("Bob", new Money(1000, SEK));
		assertEquals(Integer.valueOf(1000),SweBank.getBalance("Bob"));
	}


	// before fixing failed because of java.lang.AssertionError
	//testing withdraw method from Bank class. Should be able to withdraw certain amount of money, checking if calculations of certain user are correct
	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		SweBank.withdraw("Bob", new Money(1000, SEK));
		assertEquals(Integer.valueOf(-1000),SweBank.getBalance("Bob"));;
	}
	//testing getBalance method from Bank class.Should return balance of the certain user
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		assertEquals(0, SweBank.getBalance("Bob"), 0);
	}

	// before fixing failed because of java.lang.AssertionError
	//testing transfer method from Bank class.Should be able to make transfer from one account to another, through one bank and through different ones
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		SweBank.deposit("Bob", new Money(600, SEK));
		SweBank.transfer("Bob", "Ulrika", new Money(400, SEK));
		assertEquals(200, SweBank.getBalance("Bob"), 0);
		assertEquals(400, SweBank.getBalance("Ulrika"), 0);
		//another bank
		SweBank.transfer("Bob", Nordea, "Bob", new Money(200, SEK));
		assertEquals(Integer.valueOf(0),SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(200),Nordea.getBalance("Bob"));
	}
	//before fixing failed because of java.lang.AssertionError
	// testing timed payment, amounts should change after certaing amount of ticks.
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika", new Money(1000, SEK));
		Nordea.deposit("Bob", new Money(100, SEK));
		SweBank.addTimedPayment("Ulrika", "payment1", 1, 1, new Money(100, SEK), Nordea, "Bob");
		assertEquals( 1000, SweBank.getBalance("Ulrika").intValue());
		assertEquals( 100, Nordea.getBalance("Bob").intValue());
		SweBank.tick();
		assertEquals( 1000, SweBank.getBalance("Ulrika").intValue());
		assertEquals( 100, Nordea.getBalance("Bob").intValue());
		SweBank.tick();
		assertEquals( 900, SweBank.getBalance("Ulrika").intValue());
		assertEquals(200, Nordea.getBalance("Bob").intValue());
	}
}
