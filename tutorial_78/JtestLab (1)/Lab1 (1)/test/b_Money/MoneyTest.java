package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	//testing getAmount method from Money class.Should return amount specified before.
	@Test
	public void testGetAmount() {

		assertEquals(10000, SEK100.getAmount().intValue());
	}
	//testing getCurrency method from Money class.Should return amount of specific money.
	@Test
	public void testGetCurrency() {
		assertEquals(SEK, SEK200.getCurrency());;
	}
	//testing toString method from Money class.Check if returns correct name and amount for specified money
	@Test
	public void testToString() {
		assertEquals("10000 SEK", SEK100.toString());
	}

	//testing universalValue method from Money class.Checking if calculations are correct.
	@Test
	public void testGlobalValue() {
		assertEquals((int) (10000 * 0.15), SEK100.universalValue(), 0);
	}
	//testing equalsMoney method from Money class.Checking if two values of Money are equal.
	@Test
	public void testEqualsMoney() {
		Money MON = new Money(2000, EUR);
		assertTrue(MON.equals(EUR20));
	}

	//testing Add method from Money class.Should be able to add one amount of money to another, checking calculations.
	@Test
	public void testAdd() {
		Money add = EUR10.add(SEK100);
		int res = (int)((1000) + (10000 * 0.15 / 1.5));
		assertEquals(res, add.getAmount(), 0);;
	}

	//testing Sub method from Money class.Should be able to subtract one amount of money from another, checking calculations.
	@Test
	public void testSub() {
		Money subbed = SEK200.sub(SEK100);
		int res = (int) (20000 - 10000 * 0.15 / 0.15);
		assertEquals(res, subbed.getAmount(), 0);;
	}

	//testing isZero method from Money class.Check if money is zero
	@Test
	public void testIsZero() {
		assertTrue(EUR0.isZero());;
	}

	//testing Negate method from Money class.Should be able to negate specified amount of money
	@Test
	public void testNegate() {
		assertEquals(-10000, SEK100.negate().getAmount(), 0);;
	}

	//testing compareTo method from Money class. Should be able to compare different amount of money and provide needed output(1,-1,0)
	@Test
	public void testCompareTo() {
		assertEquals(-1, SEK0.compareTo(SEK200));
	}
}
